public class Pen extends Item
{
    public String color;
    public double tipSize;
    
    public Pen(String name, double price,String description, 
    int stock,int id,String color,double tipSize){
        super(name,price,description,stock,id);
        this.color=color;
        this.tipSize=tipSize;
    }
    public String getDetails(){
       String details= "Colour:" + color + "\nTip Size: " + tipSize +"mm\n";
       return details;
    }
    
}