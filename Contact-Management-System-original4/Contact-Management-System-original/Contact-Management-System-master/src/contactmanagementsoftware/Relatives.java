package contactmanagementsoftware;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Relatives extends Acquaintances implements Serializable{
    private String BDate;
    private String LDate;
    public static int numberRel = 0;
    private static Scanner reader = new Scanner(System.in);
    
    Relatives(){
        numberRel++;
    }
    
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
    
    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getLDate() {
        return LDate;
    }

    public void setLDate(String LDate) {
        this.LDate = LDate;
    }
    
    public String printSearchResult(){
        String s = "";
        s = s.concat(super.printSearchResult());
        s = s.concat("Relatives Birthday: " + getBDate() + "<br>");
        s = s.concat("Last met date: " + getLDate() + "<br>");

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
        setBDate(one);
    }
    
    @Override
    public boolean hasTwo() {
        return true;
    }
    
    @Override
    public void setTwo(String two) {
        setLDate(two);
    }
    
    @Override
    public boolean hasThree() {
        return false;
    }
    
    @Override
    public void setThree(String three) {
        System.out.println("Not implemented");
    } 
    //end tambah */
}
