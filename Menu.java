import java.util.Scanner;
public class Menu
{   
    public  Owner lakis;
    public  Eshop eShop;
    public  ShoppingCart Cart;
    public Menu(Eshop eShop,Owner lakis,ShoppingCart Cart){
    this.lakis=lakis;
    this.eShop=eShop;
    this.Cart=Cart;
    }
    
    public  void Login() throws EshopException{
        Scanner owner_buyer = new Scanner(System.in);
        System.out.println("Hello, please type your email:\n");
        String Usertype= owner_buyer.nextLine();
        int i;
        for(i=0;i<this.eShop.buyersList.size();i++){
            if(Usertype.equals(this.eShop.buyersList.get(i).email))
            {
              BuyersinterfaceCategories();
              break;
            }
        }
        
        if(Usertype.equals("lakisoglukoulhs@gmail.com"))
        {
            this.lakis.isAdmin=true;  
            System.out.println("Hello Lakis welcome to your Eshop. Admin is: "+ this.lakis.isAdmin+".\n");
            Ownersinterface();
        }
        else
        {
            this.lakis.isAdmin=false;
            Scanner newbuyer = new Scanner(System.in);
            System.out.println("Couldn't recognize email would you like to sing up to "+ eShop.name+"?\nIf yes press 1, if no press 2\n");
            int singup= newbuyer.nextInt();
            if(singup==1)
            {
                Scanner newbuyername = new Scanner(System.in);
                Scanner newbuyeremail = new Scanner(System.in);
                System.out.println("please add your name and email\n");
                String nbname= newbuyername.nextLine();
                String nbemail= newbuyeremail.nextLine();
                ShoppingCart newCart= new ShoppingCart();
                Buyer addthisbuyer= new Buyer(0,"BRONZE",newCart,nbname,nbemail);
                this.eShop.addBuyer(addthisbuyer);
                
                try{
                    BuyersinterfaceCategories();
                }
                    catch(EshopException ex){
         
                    }  
            }
            else
            {
              Login();  //going back
            }
        }

    }
    public void BuyersinterfaceCategories()throws EshopException
    {
      int buyersize=this.eShop.buyersList.size();
      this.eShop.checkStatus(this.eShop.buyersList.get(buyersize-1));
      this.eShop.showCategories();
      this.eShop.showProductsInCategory();
      Scanner add = new Scanner(System.in);
      System.out.println("Would you like to add an item to your Cart? If yes press 1.If no press 2\n");
      int additem= add.nextInt();         
     if(additem==1)
     {
      Scanner name = new Scanner(System.in);
      Scanner quantity = new Scanner(System.in);
      System.out.println("Please add the name of the item and the quantity you want\n");
      String thename=name.nextLine();
      
      int thequantity= quantity.nextInt();
      
      int j;
       for(j=0;j<this.eShop.itemsList.size();j++){ 
           
                if(thename.equals(this.eShop.itemsList.get(j).name))
                {
                     ItemOrdered itemtobeordered=new ItemOrdered(this.eShop.itemsList.get(j),thequantity);
                     this.eShop.buyersList.get(buyersize-1).placeOrder(itemtobeordered);
                     break;
                }
                
            }
         BuyersinterfaceCart();
    }
    else
    {
        this.eShop.showProductsInCategory();
        BuyersinterfaceCart();
    }
}
public void BuyersinterfaceCart()throws EshopException
{
    int buyersize=this.eShop.buyersList.size();
    Scanner cart = new Scanner(System.in);
    System.out.println("\nWould you like to see your Cart? If yes press 1.If no press 2\n");
    int seecart= cart.nextInt();
    if(seecart==1)
    {
        this.Cart.showcart(this.eShop.buyersList.get(buyersize-1));
        Scanner choise = new Scanner(System.in);
        System.out.println("If you like to remove an item from the cart press 1.\nIf you want to change the quantity of an item press 2.\nIf you want to clear the Cart press 3\n and press 4 for checkout\n");
        int cartChoise= choise.nextInt();
        if(cartChoise==1){
        Scanner removeitem = new Scanner(System.in);
        System.out.println("\nPlease add the name of the item you want to remove\n");
        String remove= removeitem.nextLine();
        int size=Cart.orderList.size();//μεταβλητή size ίση με το μέγεθος της λίστας
        int l;
            for(l=0;l<size;l++){  
                if(remove.equals(Cart.orderList.get(l).item.name)){
                    Cart.removeItemOrdered(Cart.orderList.get(l));
                    break;
                }
                else
                {
                   System.out.println("item is not in Cart");
                }
            }
            BuyersinterfaceDisconnect();
        }
        else if(cartChoise==2)
        {
        Scanner changequantityitem = new Scanner(System.in);
        System.out.println("Please add the name of the item you want to change the quantity");
        String newquantityitem=changequantityitem.nextLine();
        int size=eShop.itemsList.size();//μεταβλητή size ίση με το μέγεθος της λίστας
        int l;
            for(l=0;l<size;l++){  
                if(newquantityitem==Cart.orderList.get(l).item.name){   //Βρίσκω το item τυπου ItemOrdered μεσω του ονόματος και αλλάζω το quantity του
                    break;
                }
            }
            Scanner changequantity = new Scanner(System.in);
            System.out.println("Please add the quantity of the item you want.");
            int newquantity=changequantity.nextInt();
            this.Cart.orderList.get(l).quantity=newquantity;
            int changedstock=this.Cart.orderList.get(l).item.stock-this.Cart.orderList.get(l).quantity;
            this.Cart.changeItemOrderedQuantity(this.eShop,this.Cart.orderList.get(l),changedstock);
            BuyersinterfaceDisconnect();
        }
        else if (cartChoise==3)
        {
          Cart.ClearCart();//clear cart
          BuyersinterfaceDisconnect();
        }
        else if (cartChoise==4)
        {
           Cart.checkout(this.eShop.buyersList.get(buyersize-1)); 
           BuyersinterfaceDisconnect();
        }
    }
    else
    {
        BuyersinterfaceCategories(); //going back
    }
}
public void BuyersinterfaceCheckout()throws EshopException   
{
    Scanner checkout = new Scanner(System.in);
    System.out.println("Would you like to Checout?If yes press 1.If no press 2");
    int check= checkout.nextInt();
    if(check==1)
    {
       int buyersize=this.eShop.buyersList.size();
       Cart.checkout(this.eShop.buyersList.get(buyersize-1)); 
       BuyersinterfaceDisconnect();
    }
    else if(check==2)
    {
       BuyersinterfaceCategories();//going back
    }
}
public void  BuyersinterfaceDisconnect() throws EshopException 
    {
        Scanner disconnect = new Scanner(System.in);
        System.out.println("If you want to disconnect?If yes press 1.If you want to leave programm press 2.\nIf you want to view products again press 3");
        int dis= disconnect.nextInt();
        if(dis==1)
        {
            Login();   //disconnect
           
        }
        else if(dis==2)
        {
             LeaveProgram (); //leave programm
        }
        else
        {
           BuyersinterfaceCategories(); //going back
        }
}
public void Ownersinterface()throws EshopException {
        Scanner stockUpdate = new Scanner(System.in);
        System.out.println("Would you like to update stock of an item?\nIf yes press 1, if no press 2\n");
        int updatestock= stockUpdate.nextInt();
        if(updatestock==1)
        {   
            Scanner itemname = new Scanner(System.in);
            Scanner stock = new Scanner(System.in);
            System.out.println("Please add the name of the item  and the stock you want\n");
            String theitemname=itemname.nextLine();
            int thestock= stock.nextInt();
      
            int j;
            for(j=0;j<this.eShop.itemsList.size();j++){ 
           
                if(theitemname.equals(this.eShop.itemsList.get(j).name))
                {
                     eShop.updateItemStock(this.eShop.itemsList.get(j),thestock);
                     System.out.println("Stock has been updated");
                     break;
                }
                
            }
        }
        else if(updatestock==2)
        {
          OwnersinterfaceBuyers();  
        }
        OwnersinterfaceDisconnect();
    }
            
 public void OwnersinterfaceBuyers()throws EshopException {
            Scanner buyerslist = new Scanner(System.in);
            System.out.println("Would you like to see the list of buyers?\nIf yes press 1, if no press 2\n");
            int listbuyer=buyerslist.nextInt();
            if(listbuyer==1)
            {
                int i;
                for(i=0;i<this.eShop.buyersList.size();i++)
                {
                    System.out.println(this.eShop.buyersList.get(i).name);
                }
                System.out.println("Would you like to remove a buyer?\n if yes press 1 if no press 2\n");
                Scanner removethisbuyer = new Scanner(System.in);
                int removebuyer=removethisbuyer.nextInt();
                if(removebuyer==1)
                {
                    Scanner removebuy = new Scanner(System.in);
                    System.out.println("Please add the name of the buyer you wabt to remove");
                    String removename=removebuy.nextLine();
          
                    int j;
                    for(j=0;j<this.eShop.buyersList.size();j++){ 
           
                        if(removename.equals(this.eShop.buyersList.get(j).name))
                        {
                            this.eShop.removeBuyer(this.eShop.buyersList.get(j));
                            System.out.println("Buyer has been reoved");
                            break;
                    }
                }
            }
                else if(removebuyer==2)
                {
                   OwnersinterfaceDisconnect();
                }
                
            }
            else{
                OwnersinterfaceDisconnect();
            }
            
        }
     public void  OwnersinterfaceDisconnect() throws EshopException 
    {
        Scanner owndisconnect = new Scanner(System.in);
        System.out.println("If you want to disconnect press 1.If you want to leave programm press 2.\nIf you want to edit more of your Eshop press 3");
        int owndis= owndisconnect.nextInt();
        if(owndis==1)
        {
            Login(); //disconnect
            
        }
        else if(owndis==2)
        {
            LeaveProgram();//leave programm
        }
        else
        {
           Ownersinterface(); //going back
        }
} 
 public void LeaveProgram() {
        Scanner leaveprog = new Scanner(System.in);
        System.out.println("Would you like to close the programm?If yes press 1.If no press 2");
        int leave= leaveprog.nextInt();
        if(leave==1)
        {
            System.exit(0);   //leave programm
        }
        else
        {
           try{
           Login(); //going back
        }
        catch(EshopException ex){
         
        }
        }
        }
        
        
}
    



