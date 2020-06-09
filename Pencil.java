public class Pencil extends Item
{
    public double tipSize;
    public Type type;
    
    public Pencil(String name, double price, 
    String description, int stock, int id,double tipSize, Type type){
        super(name,price,description,stock,id);
        this.tipSize=tipSize;
        this.type=type;
    }
    public String getDetails(){
        String y= "Tip Size:"+tipSize+"\nType:"+type+"\n"  ;
        return y;
    }
    
}