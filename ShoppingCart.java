import java.util.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.NumberFormat;
public class ShoppingCart
{
    public ArrayList<ItemOrdered> orderList;
    public double totalPrice=0;
    public double fullPrice;
    public double courierCost;
    
    public ShoppingCart(){
        this.orderList= new ArrayList<ItemOrdered>();
         }
  public void  addItemOrdered(ItemOrdered newitem) throws EshopException    
  { 
      int i;
      int size=orderList.size();    //μηκος λίστας
      boolean flag = false;     //μεταβλητη flag που γινεται true όταν υπάρχει ήδη το item στη λιστα
       
      for(i=0;i<size;i++){
            if(newitem.item.name==this.orderList.get(i).item.name)//ελέγχω αν υπάρχει το αντικείμενο στη λίστα μέσω της μεταβλητής name
            {
              this.orderList.get(i).quantity+=1;        //αν υπάρχει αλλαζω το quantity στο ήδη υπάρχον αντικείμενο της λίστας
              flag = true;
              break;
            }
        }
        
       if(flag == false && newitem.item.stock>=newitem.quantity){ /*η περίπτωση του να μην υπαρχει το αντικείμενο ήδη στη λίστα
           και η απαιτούμενη ποσότη να είναι μικρότερη ή ίση του stock*/
       this.orderList.add(newitem);//προσθέτω το αντικείμενο
       
       this.totalPrice = this.totalPrice +(this.orderList.get(this.orderList.size()-1).item.price * newitem.quantity);//αλλάζω τη συνολική τιμή
       this.orderList.get(this.orderList.size()-1).item.stock-=1;   //ενημερώνω το stock
       
       System.out.println("Item added to Cart! there are:"+newitem.quantity
       +" of "+ this.orderList.get(this.orderList.size()-1).item.name +"\n");
        }
      
        else if(newitem.item.stock<newitem.quantity||newitem.item.stock<=0)/*Χρησιμοποιώ την κλάση εξαιρεσης EshopException 
    σε περιπτωση που δοθεί ποσότητα που υπερβαίνει το stock*/ 
     {   
         throw new EshopException("\nThe item has been sold or your request of quantity was invalid."+ "\nThere are"+newitem.item.stock+"left\n");
    }
}
    //Remove Item from cart
  public void removeItemOrdered(ItemOrdered removeitem)
   { 
       //this.orderList.remove(removeitem);//αφαιρώ το αντικείμενο από το καλάθι
       removeitem.item.stock+=1; // ενημερώνω το stock
       System.out.println("\nItem" + removeitem  +" has been removed from Cart\n"); 
       this.orderList.remove(removeitem);//αφαιρώ το αντικείμενο από το καλάθι
    } 

  
  public void changeItemOrderedQuantity(Eshop eshop,ItemOrdered newitem,int newstock)
  {
    int i;
    int size=orderList.size();  //μεγεθος λίστας
     if (orderList.contains(newitem))   // ελέγχω αν το newitem υπάρχει ήδη στην λίστα
       {
        
        for(i=0;i<size;i++){
            if(this.orderList.get(i)== newitem)
            {
              this.orderList.get(i).quantity=newitem.quantity;// ενημερώνω το quantity
              eshop.updateItemStock(this.orderList.get(i).item,newstock); // ενημερώνω το stock
              break;
            }
        }
    }  
}
     //  Returns the contents of the cart 
  public void showcart(Buyer somebuyer){
     int size=this.orderList.size();
     if(size==0)
         {
             System.out.println("\nYour Cart is empty");//αν το καλάθι είναι άδειο
            }
     for(int i=0;i<size;i++)
     {
         
            System.out.println(this.orderList.get(i).item.name); //εμφανίζω τη λίστα
        
        }
     calculateCourierCost(somebuyer);
     System.out.println("\nCourier cost is:" + courierCost+"euros" );// εκτυπώνω το courier cost
    }

   //Clear cart
   public void ClearCart()
   {
    orderList.clear();  // καθαρίζω τη λιστα
    System.out.println("\nCart is clear");
   }

   public void checkout(Buyer buyer)  
   { 
     showcart(buyer);// καλώ την showcart
     System.out.println("\nWould you like to proceed with your order.Write 1 if so\n");
     int action;
     int Total=(int)totalPrice; //μετατρέπω σε int το double
     Scanner scanIn = new Scanner(System.in);   //παιρνω input απο τον χρήστη για το αν θέλει να συνεχίσει
     action= scanIn.nextInt();
     scanIn.close();  
    if(action==1)
     { buyer.awardBonus();  //καλώ την awardBonus
       calculateNet(buyer);
       orderList.clear();//καθαρίζω το καλάθι
     } 
    }

    
   public void calculateNet(Buyer otherbuyer)
    { 
     calculateCourierCost(otherbuyer);  
     fullPrice=totalPrice+courierCost;  // υπολογίζω το συνολικό κόστος
     System.out.println("\nThe whole value of your order is: " +fullPrice+ " euros/n");
    }
     
    
   public void calculateCourierCost(Buyer somebuyer)    // υπολογίζω την κατηγορία του buyer μου
   { 
    if(somebuyer.buyerCategory=="GOLDEN")
    { courierCost=0;
     
    }
     
     else if(somebuyer.buyerCategory=="SILVER")
     { courierCost= (totalPrice*0.02)/2;

     }

     else
    {
     courierCost=totalPrice*0.02;
    
      if (courierCost<3)
       { courierCost=3;
        
        }
    }
  
  }
}

