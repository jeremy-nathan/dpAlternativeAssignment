package contactmanagementsoftware;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactManagementSoftware implements Serializable{

    private static MUI mg;
  /*  private static ArrayList<ArrayList<Acquaintances>> a = new ArrayList<>();
    private static ArrayList<Acquaintances> perF1 = new ArrayList<>();
    private static ArrayList<Acquaintances> rel1 = new ArrayList<>();
    private static ArrayList<Acquaintances> proF1 = new ArrayList<>();
    private static ArrayList<Acquaintances> ca1 = new ArrayList<>(); */
    
    
    private static ContactManagementComponent contactsMainDirectory = new DirectoryComponent("");
    
    private static ContactManagementComponent personalFriends = new DirectoryComponent(" I. Personal Friends");
    private static ContactManagementComponent relatives = new DirectoryComponent("II. Relatives");
    private static ContactManagementComponent professionalFriends = new DirectoryComponent("III. Professional Friends");
    private static ContactManagementComponent casualAcquaintance = new DirectoryComponent("IV. Casual Acquaintance");
    
    
    public static void main(String[] args) {
     /*   mg = new MUI();
        a.add(perF1);
        a.add(rel1);
        a.add(proF1);
        a.add(ca1);
        mg.setMg(mg);
      //  mg.setA(a);
        mg.setVisible(true); */
     
     mg = MUI.getInstance();
    // mg = MUI.getMUI();
     mg.initMUI();
     
     contactsMainDirectory.add(personalFriends);
     contactsMainDirectory.add(relatives);
     contactsMainDirectory.add(professionalFriends);
     contactsMainDirectory.add(casualAcquaintance);
     
     mg.setMg(mg);
     
     mg.setA(contactsMainDirectory);
     mg.setVisible(true);
        
    }
}