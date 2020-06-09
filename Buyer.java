public class Buyer extends User
{
   public int bonus=0;
   public String buyerCategory="BRONZE";
   public ShoppingCart shoppingCart;
   public boolean order=false ;
   
   public Buyer(int bonus,String buyerCategory,ShoppingCart shoppingCart,
   String name,String email)
   {
   super(name,email);
   this.bonus=bonus;
   this.buyerCategory=buyerCategory;
   this.shoppingCart=shoppingCart;
}
public  void awardBonus(){
    double newpoint=shoppingCart.totalPrice*0.1;
    int point=(int)newpoint;
    if (order==true){
        bonus=bonus+point;
        setbuyerCategory();
}    
}  
public void setbuyerCategory(){
   
    if (bonus>=100 && bonus<200)
   {
       buyerCategory = "SILVER";
    }
       else if(bonus>=200){
           buyerCategory= "GOLD";
        }
}
public void placeOrder(ItemOrdered itemincart)throws EshopException{
      
    this.shoppingCart.addItemOrdered(itemincart);
    boolean order=true ;
}
}
