package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class ProfessionalFriends extends Acquaintances implements Serializable{
    
    private String CommonInterests;
    public static int numberProF = 0;
    
    ProfessionalFriends(){
        numberProF++;
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

    public String getCommonInterests() {
        return CommonInterests;
    }

    public void setCommonInterests(String CommonInterests) {
        Scanner reader = new Scanner(System.in);
        if(!CommonInterests.isEmpty())
            this.CommonInterests = CommonInterests;
        else{
            System.out.println("Enter at least one character");
            setCommonInterests(reader.nextLine());
        }
    }
    
    
    public String printSearchResult(){
        String s = "";
        s = s.concat(super.printSearchResult());
        s = s.concat("Common Interests: " + getCommonInterests() + "<br><br>");

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
        setCommonInterests(one);
    }
    
    @Override
    public boolean hasTwo() {
        return false;
    }
    
    @Override
    public void setTwo(String two) {
        System.out.println("Not implemented");
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
