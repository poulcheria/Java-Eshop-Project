import java.io.*;
public abstract class Item
{
    public  String name;
    public  double price;
    public  String description;
    public  int stock;
    public  int id;
    
    public Item(String name,double price, String description, int stock, int id)
    {
        this.name=name;
        this.price=price;
        this.description=description;
        this.stock=stock;
        this.id=id;
        
        
    }
    public String getBasicInfo(){
        String txt ="Name:"+ name + "\nPrice:" +price+" euro"+"\nDescription:"
        +description+"\nStock:"+stock+"\nID:"+id; 
        System.out.println("\n"+txt+"\n");
       return txt;
   
    }
    public abstract String getDetails();
        
    
    public String toString(){
        
    return this.getBasicInfo()+"\n" +this.getDetails()+"\n" ;
}
   
}
