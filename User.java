import java.io.*;
public abstract class User
{
   
    public static String name;
    public static String email;
    
    public User (String name, String email)
    {
        this.name=name;
        this.email=email;
    }
}