 public class Notebook extends Item
{
    public int sections;
    
    public Notebook(String name, double price, 
    String description, int stock, int id,int sections){
        super(name,price,description,stock,id);
        this.sections=sections;
}
public String getDetails(){
        String y= "Sections:" +sections+"\n";
        return y;
}

}