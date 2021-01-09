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
public class DirectoryComponent extends ContactManagementComponent implements Serializable{

 ArrayList<ContactManagementComponent> subComponent = new ArrayList<>();
 String name;

    public DirectoryComponent(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
 
 

@Override
public void add(ContactManagementComponent child){
subComponent.add(child);

}

@Override
public ContactManagementComponent get(int index){
return subComponent.get(index);

}

public void remove(int index){
subComponent.remove(index);

}

@Override
public int size(){
return subComponent.size();

}

@Override
public Iterator<ContactManagementComponent> createIterator(){
    return new ContactsIterator (subComponent.iterator());
}

public String printSearchResult(){
     String s = "";
        s.concat(getName() + "<br>");
        System.out.println("AcList " + s);
        return s;
}

public String matchName(String str) {
        int matchFound = 0;
        String s = "";

        Iterator<ContactManagementComponent> iterator = subComponent.iterator();
        while (iterator.hasNext()) {
            ContactManagementComponent component = iterator.next();
            if ((matchFound == 0)&&(component.matchName(str) != "")) {
                s = s.concat(getName() + "<br>");
                matchFound = 1;
            }
            s = s.concat(component.matchName(str));
        }

        return s;
    }



}