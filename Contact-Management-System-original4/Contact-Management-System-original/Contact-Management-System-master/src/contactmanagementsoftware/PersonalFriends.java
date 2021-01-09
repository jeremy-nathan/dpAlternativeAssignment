package contactmanagementsoftware;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class PersonalFriends extends Acquaintances implements Serializable{
    private String AContext;
    private String ADate;
    private String Events;
    private static Scanner reader = new Scanner(System.in);
    public static int numberPerF = 0;
    String abc;
    
    PersonalFriends(){
        numberPerF++;
    }
   
    /*
    @Override
    void hook2(){
        //do something with getabc()
    }
    
    String getABC() {
        return abc;
    }
    
    void setABC(String abc) {
        this.abc = abc;
    } */
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String Name) {
        super.setName(Name); 
    }

    @Override
    public String getMobileNo() {
        return super.getMobileNo();
    }

    @Override
    public void setMobileNo(String MobileNo) {
        super.setMobileNo(MobileNo);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
   public void setEmail(String Email) {
        super.setEmail(Email);
    }
    
    public String getAContext() {
        return AContext;
    }

    public void setAContext(String AContext) {
        Scanner reader = new Scanner(System.in);
        if(!AContext.isEmpty())
            this.AContext = AContext;
        else{
            System.out.println("Enter at least one character");
            setAContext(reader.nextLine());
        }
    }

    public String getADate() {
        return ADate;
    }

    public void setADate(String ADate) {
        this.ADate = ADate;
    }

    public String getEvents() {
        return Events;
    }

    public void setEvents(String Events) {
        Scanner reader = new Scanner(System.in);
        if(!Events.isEmpty())
            this.Events = Events;
        else{
            System.out.println("Enter at least one character");
            setEvents(reader.nextLine());
        }
    }
    
    public String printSearchResult(){
        String s = "";
        s = s.concat(super.printSearchResult());
        s = s.concat("Specific events: " + getEvents() + "<br>");
        s = s.concat("First Acquaintance context: " + getAContext() + "<br>");
        s = s.concat("First Acquaintance date: " + getADate() + "<br><br>");

        return s;
    }
    
    public String matchName(String str){
        String s = "";
        if (getName().matches(str)){
            s = s.concat(printSearchResult());
        }
        
        return s;
    }
    
    /*
    //ditambah
    @Override
    public boolean hasOne() {
        return true;
    }
    
    @Override
    public void setOne(String one) {
        setEvents(one);
    }
    
    @Override
    public boolean hasTwo() {
        return true;
    }
    
    @Override
    public void setTwo(String two) {
        setAContext(two);
    }
    
    @Override
    public boolean hasThree() {
        return true;
    }
    
    @Override
    public void setThree(String three) {
        setADate(three);
    } 
    //end tambah */
}
