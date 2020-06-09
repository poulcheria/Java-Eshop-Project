public class Papper extends Item
{
    public int weight;
    public int pages;
    

public Papper(String name, double price, 
    String description, int stock, int id,int weight, int pages){
        super(name,price,description,stock,id);
        this.weight=weight;
        this.pages=pages;
}
   public String getDetails(){
        String y= "Weight:" +weight+"gr\n" + "Pages:" +pages+"\n";
        return y;     
    }
    
}