import java.util.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.NumberFormat;
import java.util.Scanner;
public class Eshop
{
    public ArrayList<Item> itemsList;   //λίστα αντικειμένων
    public ArrayList<Buyer> buyersList; //λίστα αγοραστών
    public Owner owner; 
    public String name;
    
    public Eshop(String name, Owner owner)      //contructor κλάσης Eshop
    {
        this.name=name;
        this.owner=owner;
        this.itemsList= new ArrayList<Item>();
        this.buyersList= new ArrayList<Buyer>();
}


public void addItem(Item antikeimeno) throws EshopException 
{
    if(this.itemsList.contains(antikeimeno)){   //ελέγχω αν το αντικελιμενο που θέλω να προσθέσω υπάρχει ήδη στη λίστα 
         throw new EshopException("Item already exists"); //χρησιμοποιώ κλάση εξαίρεσης αν το αντικείμενο υπα΄ρχει ήδη στη λίστα
        }
        else{                   //αν δεν υπάρχει το προσθέτω στη λίστα
            this.itemsList.add(antikeimeno);
        }
}

public Item getItemByld() throws EshopException {
       Scanner identity = new Scanner(System.in);
       System.out.println("enter id:");
       int ident= identity.nextInt();
       int size=this.itemsList.size();//μεταβλητή size ίση με το μέγεθος της λίστας
       int j;
       for(j=0;j<size;j++){   //ελέγχω αν το ident που παίρνω απο το input ισούται με το id κάποιου αντικείμενου της itemList μου
        if(ident==this.itemsList.get(j).id){
            break;
        }
       
    }return this.itemsList.get(j);
}

public void removeItem(Item antikeimeno) {
       this.itemsList.remove(antikeimeno); // αφαιρώ ένα αντικείμενο απο τη λίστα
       System.out.println("Item" + antikeimeno +"has been removed from the Eshop"); 
}

public void addBuyer(Buyer newbuyer) throws EshopException 
 {
    
        if(this.buyersList.contains(newbuyer)){//ελέγχω αν η λίστα μου περίεχει ήδη τον buyer που θελω να προσθέσω
           throw new EshopException("Buyer already exists"); 
        }
        else{//αν δεν υπάρχει τον προσθέτω στη λίστα
            this.buyersList.add(newbuyer);
}   
}
public void removeBuyer(Buyer removebuyer) {//αφαιρώ ένα buyer από τη λίστα
    buyersList.remove(removebuyer);
    System.out.println("Buyer" + removebuyer.name + "has been removed from the Eshop");
}
public  void updateItemStock(Item itemupdate,int newstock)
{
    itemupdate.stock=newstock;//κάνω update στο stock συγκεκριμένου αντικέιμένου
}
public  void showCategories()//εκτυπωνω τις κατηγορίες
{
    System.out.println("\nCategories:\nPen\nPencil\nPapper\nNotebook\n");
   
}
public void showProductsInCategory()
{
    Scanner categ = new Scanner(System.in);
    System.out.println("for category Pen press 1 for Pencil press 2 for Notebook press 3 and for Papper press 4");
    int Buyercateg= categ.nextInt();//παίρνω iput από τον χρήστη ζητώντας του ποιά κατηγορία θελει να δει
    int i;   
    int j;
    if(Buyercateg==1)
    {
       for(i=0;i<3;i++){
            System.out.println(this.itemsList.get(i).name);  

       }//Εμφανίζω τη λίστα με τα προιόντα κατηγορίας Pen
       
       Scanner pen = new Scanner(System.in);
       System.out.println("would you like to see product info? If yes press 1 If no press 2");
       int peninfo= pen.nextInt();//παίρνω input για τον αν ο χρήστης θελει περαιτέρω πληροφορίες για τα προιόντα
       
       if(peninfo==1){
           for(j=0;j<3;j++){
           showProduct(this.itemsList.get(j));//Εμφάνιση περαιτέρων πληροφοριών
        }
        }
        else if (peninfo==2){
            showCategories();    //εάν δε θέλει επιστρέφω στις κατηγορίες
        }
    }
    else if (Buyercateg==2)
    {
       for(i=3;i<6;i++){
            System.out.println(this.itemsList.get(i).name);
       }
        
       Scanner pencil = new Scanner(System.in);
       System.out.println("would you like to see product info? If yes press 1 If no press 2");
       int pencilinfo= pencil.nextInt();    //παίρνω input για τον αν ο χρήστης θελει περαιτέρω πληροφορίες για τα προιόντα
       
       if(pencilinfo==1){
           for(j=3;j<6;j++){
           showProduct(this.itemsList.get(j));
        }
        }
        else if (pencilinfo==2){
            showCategories();    //εάν δε θέλει επιστρέφω στις κατηγορίες
        }
    }
    else if (Buyercateg==3)
    {
       for(i=6;i<9;i++){
            System.out.println(this.itemsList.get(i).name);
       }
        
       Scanner papper = new Scanner(System.in);
       System.out.println("would you like to see product info? If yes press 1 If no press 2");
       int papperinfo= papper.nextInt();    //παίρνω input για τον αν ο χρήστης θελει περαιτέρω πληροφορίες για τα προιόντα
       
       if(papperinfo==1){
           for(j=6;j<9;j++){
           showProduct(this.itemsList.get(j));
        }
        }
        else if (papperinfo==2){
            showCategories();   //εάν δε θέλει επιστρέφω στις κατηγορίες
        }
    }
    else if (Buyercateg==4)
    {
       for(i=9;i<12;i++){
            System.out.println(this.itemsList.get(i).name);
        }
        
       Scanner notebook = new Scanner(System.in);
       System.out.println("would you like to see product info? If yes press 1 If no press 2");
       int notebookinfo= notebook.nextInt();    //παίρνω input για τον αν ο χρήστης θελει περαιτέρω πληροφορίες για τα προιόντα
       
       if(notebookinfo==1){
           for(j=9;j<12;j++){
           showProduct(this.itemsList.get(j));
        }
        }
        else if (notebookinfo==2){
            showCategories();   //εάν δε θέλει επιστρέφω στις κατηγορίες
        }
    }
}
public void showProduct(Item iteminfo)
{
    iteminfo.toString();    //εμφανίζω τις πληροφορίες του προιόντος
}

public void checkStatus(Buyer somebuyer)
{
    
    int size=buyersList.size();
   
        System.out.println("\n"+buyersList.get(size-1).name);  //εμφανίζω τον buyer
        System.out.println("your bonus is: "+buyersList.get(size-1).bonus);    //εμφανίζω το bonus του buyer
        System.out.println("and your Category is: "+buyersList.get(size-1).buyerCategory);    //εμφανίζω την κατηγορία του buyer
    
}
}