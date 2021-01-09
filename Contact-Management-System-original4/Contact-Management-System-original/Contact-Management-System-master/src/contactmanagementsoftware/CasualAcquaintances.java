package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class CasualAcquaintances extends Acquaintances implements Serializable{
    private String WhenWhere;
    private String Circumstances;
    private String OtherInfo;
    public static int numberCA = 0;
    
    CasualAcquaintances(){
        numberCA++;
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
    
    public String getWhenWhere() {
        return WhenWhere;
    }

    public void setWhenWhere(String WhenWhere) {
        Scanner reader = new Scanner(System.in);
        if(!WhenWhere.isEmpty())
            this.WhenWhere = WhenWhere;
        else{
            System.out.println("Enter atleast one character");
            setWhenWhere(reader.nextLine());
        }
    }

    public String getCircumstances() {
        return Circumstances;
    }

    public void setCircumstances(String Circumstances) {
        Scanner reader = new Scanner(System.in);
        if(!Circumstances.isEmpty())
            this.Circumstances = Circumstances;
        else{
            System.out.println("Enter atleast one character");
            setCircumstances(reader.nextLine());
        }
    }

    public String getOtherInfo() {
        return OtherInfo;
    }

    public void setOtherInfo(String OtherInfo) {
        Scanner reader = new Scanner(System.in);
        if(!OtherInfo.isEmpty())
            this.OtherInfo = OtherInfo;
        else{
            System.out.println("Enter atleast one character");
            setOtherInfo(reader.nextLine());
        }
    }
    
    public String printSearchResult(){
        String s = "";
        s = s.concat(super.printSearchResult());
        s = s.concat("First met location & time: " + getWhenWhere() + "<br>");
        s = s.concat("First met circumstances: " + getCircumstances() + "<br>");
         s = s.concat("Other useful information: " + getOtherInfo() + "<br>");

        return s;
    }
    
    public String matchName(String str){
        String s = "";
        if (getName().matches(str)){
            s = s.concat(printSearchResult());
        }
        
        return s;
    }
    
    //ditambah
    /*
    @Override
        public boolean hasOne() {
        return true;
        }
    
    @Override
    public void setOne(String one) {
    setWhenWhere(one);
    }
    
    @Override
    public boolean hasTwo() {
    return true;
    }
    
    @Override
    public void setTwo(String two) {
    setCircumstances(two);
    }
    
    @Override
    public boolean hasThree() {
    return true;
    }
    
    @Override
    public void setThree(String three) {
    setOtherInfo(three);
    } 
    //end tambah */
}
