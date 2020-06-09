
public class Owner extends User
{
    public static boolean isAdmin;
    
    public Owner (boolean isAdmin , String name , String email){
    super(name,email);
    this.isAdmin=isAdmin;
    
    
    }
    
    
    
}