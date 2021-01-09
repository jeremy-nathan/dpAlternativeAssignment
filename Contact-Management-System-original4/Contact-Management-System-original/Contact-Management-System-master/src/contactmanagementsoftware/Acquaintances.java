package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;

public abstract class Acquaintances extends ContactManagementComponent implements Serializable{
    private String Name;
    private String MobileNo;
    private String Email;
    public static int number = 0;
    
    Acquaintances(){
        number++;
    }
    
    //ditambah
   /* final void createAcquaintances(String name, String MobileNo, String Email){
        setName(name);
        setMobileNo(MobileNo);
        setEmail(Email);
        hook1();
        hook2();
        hook3();
    } */
    //end tambah
    
  /*  public void hook1(){
        hasOne();
    }
    
    void hook2(){
        hasTwo();
    }
    void hook3(){
        hasThree();
       
    } */
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Scanner reader = new Scanner(System.in);
        if(!name.isEmpty())
          this.Name = name;
        else{
            System.out.println("Enter atleast one character");
            setName(reader.nextLine());
        }
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public String getEmail() {
        return Email;
    }
    
    public boolean MobileNoChecker(String str)
    {
        int x;
        for(int j = 0 ; j < str.length() ; j++)
        {
            x = (int)str.charAt(j);
            if( x < 48 || x > 57 )
            return false;    
        }
        return true;
    }
    
    
    public void setMobileNo(String MobileNo){
        Scanner reader = new Scanner(System.in);
        if(MobileNoChecker(MobileNo) && MobileNo.length()>=6 && MobileNo.length()<=15)
            this.MobileNo = MobileNo;
        else{
            System.out.print("Enter a valid Mobile No of length between 6 and 15 (inclusive): ");
            setMobileNo(reader.next());
        }
    }
    
    public void setEmail(String Email){
        Scanner reader = new Scanner(System.in);
        if(Email.contains("@"))
            this.Email = Email;
        else{
            System.out.print("Enter a valid Email: ");
            this.setEmail(reader.next());
        }
    }
    
    public String printSearchResult(){
        String s = "";
         s = s.concat("Name: " + getName() + "<br>");
         s = s.concat("Mobile No: " + getMobileNo() + "<br>");
         s = s.concat("Email: " + getEmail() + "<br>");
        return s;
    }
    
    public Iterator<ContactManagementComponent> createIterator() {
        return new NullIterator();
    }
    
    //ditambah
 /*   public abstract boolean hasOne();
    public abstract void setOne(String one);
    public abstract boolean hasTwo();
    public abstract void setTwo(String two);
    public abstract boolean hasThree();
    public abstract void setThree(String three); */
    //end tambah
}
