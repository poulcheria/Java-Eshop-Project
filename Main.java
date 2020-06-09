import java.util.*; 
import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.NumberFormat;

public class Main{
   public static void main(String[]args)
    
{   Owner lakis=new Owner(true,"Lakis","lakisoglukoulhs@gmail.com"); 
    //ορίζω Owner για να τον εισάγω στο EShop
    
    Eshop eShop= new Eshop("Εshop Name" , lakis);
    //δημιουργω Object Eshop
    ShoppingCart Cartnew = new ShoppingCart();
    //δημιουργω object ShoppingCart  
    Menu themenu= new Menu(eShop,lakis,Cartnew);
    //δημιουργώ Object Menu
    
    Item FirstPen = new Pen("Blue Pen",2.3,"best quality",10,110,"Blue",2.1);
    Item SecondPen = new Pen("Black Pen",2.5,"best quality",10,111,"Black",2.2);
    Item ThirdPen = new Pen("Red Pen",3.2,"best quality",10,112,"Red",2.3);
    Item FirstPencil = new Pencil("Hard Pencil" ,1.5,"great quality",10,210,2.9,Type.H);
    Item SecondPencil = new Pencil("Medium Pencil" ,1.3,"great quality",10,211,3.2,Type.HB);
    Item ThirdPencil = new Pencil("Soft Pencil" ,1.9,"great quality",10,212,3.7,Type.B);
    Item FirstNotebook= new Notebook("Τhree-subject" , 3,"very good quality",10,310,3);
    Item SecondNotebook= new Notebook("Four-subject" , 4,"very good quality",10,311,4);
    Item ThirdNotebook= new Notebook("Five-subject" , 4.8,"very good quality",10,312,5);
    Item FirstPapper = new Papper("Papper One" , 1.2,"Small Size",10,410,250,300);
    Item SecondPapper = new Papper("Papper Two" , 1.5,"Medium Size",10,411,400,500);
    Item ThirdPapper = new Papper("Papper Three" , 1.2,"Big Size",10,412,800,1000); 
    
    //Δημιουργώ αντικείμενα που θα προστεθουν ως αντικείμενα του Eshop
    
   try{
    eShop.addItem(FirstPen);
    eShop.addItem(SecondPen);
    eShop.addItem(ThirdPen);
    eShop.addItem(FirstPencil);
    eShop.addItem(SecondPencil);
    eShop.addItem(ThirdPencil);
    eShop.addItem(FirstNotebook);
    eShop.addItem(SecondNotebook);
    eShop.addItem(ThirdNotebook);
    eShop.addItem(FirstPapper);
    eShop.addItem(SecondPapper);
    eShop.addItem(ThirdPapper); /* προσθετω το αντικείμενα στην itemList του Eshop */
}
    catch(EshopException ex){
         
        } 

    
    ItemOrdered Pen2 = new ItemOrdered(SecondPen,2);
    ItemOrdered Pencil3 = new ItemOrdered(ThirdPencil,3);
    ItemOrdered Notebook1= new ItemOrdered(FirstNotebook,2);
    
    /*Ορίζω την ποσοτητα του Item και το Item για το καλαθι του
    1ου buyer μεσω της ItemOrdered κλασης*/
 
    
    Buyer Buyer1= new Buyer(80,"BRONZE",Cartnew,"Giwrgos","Giwrgospapakostas137@gmail.com");//οριζω πρωτο ηδη υπάρχοντα Buyer
    try{
    eShop.addBuyer(Buyer1);
    }
    catch(EshopException ex){
         
        } 
    //στοιχεία 1ου buyer
    
    
    try{
    Buyer1.placeOrder(Pen2);
    Buyer1.placeOrder(Pencil3);
    Buyer1.placeOrder(Notebook1);//προσθετω τα τυπου ItemOrdered αντικειμενα στο καλαθι του 1ου Buyer
     }
     catch(EshopException ex){
         
        }
   
        
   
    try{
        themenu.Login();
    }
     catch(EshopException ex){
         
        }
    return;
}
}