/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class ContactManagementComponent implements Serializable {

    
//public ArrayList<ContactManagementComponent> subComponent = new ArrayList<>();    

/*public static int number = 0;
protected String Name;
protected String MobileNo;
protected String Email;*/

public void add(ContactManagementComponent child){
throw new UnsupportedOperationException();
}

public ContactManagementComponent get (int index){
throw new UnsupportedOperationException();

}

public void remove (int index){
throw new UnsupportedOperationException();

}

public int size(){
throw new UnsupportedOperationException();

}

public String getName() {
    throw new UnsupportedOperationException();
    }

public void setName(){
throw new UnsupportedOperationException();
}

public String getMobileNo(){
throw new UnsupportedOperationException();
}

public void setMobileNo(){
throw new UnsupportedOperationException();
}


public String getEmail(){
throw new UnsupportedOperationException();
}

public void setEmail(){
throw new UnsupportedOperationException();
}

public boolean MobileNoChecker(String MobileNo){
throw new UnsupportedOperationException();
}

/*public ArrayList<ContactManagementComponent> getList() {
    return subComponent;
}
/*public ContactDescriptionBehavior getDescriptonBehavior(){
throw new UnsupportedOperationException();
} */

public Iterator<ContactManagementComponent> createIterator(){
    throw new UnsupportedOperationException();
}


public String printSearchResult(){
        throw new UnsupportedOperationException();
    }

    public String matchName(String str){
        throw new UnsupportedOperationException();
    }

}