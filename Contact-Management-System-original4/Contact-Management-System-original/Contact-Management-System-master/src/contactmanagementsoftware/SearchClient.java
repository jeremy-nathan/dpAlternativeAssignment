/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.util.Iterator;

/**
 *
 * @author user
 */
public class SearchClient {
    ContactManagementComponent allTypesAcquaintanceContact;

    public SearchClient(ContactManagementComponent allTypesAcquaintanceContact) {
        this.allTypesAcquaintanceContact = allTypesAcquaintanceContact;
    }

    public String printNameSearch(String str) {
        Iterator iterator = allTypesAcquaintanceContact.createIterator();
        int index = 0;
        String s = "";
        while (iterator.hasNext()) {
            ContactManagementComponent contactManagementComponent = (ContactManagementComponent) iterator.next();

            if (contactManagementComponent instanceof DirectoryComponent) {
                Iterator list = contactManagementComponent.createIterator();
                String name = contactManagementComponent.getName();
                int matchName = 0;
                while (list.hasNext()) {
                    ContactManagementComponent acquaintanceContact = (ContactManagementComponent) list.next();

                    if (acquaintanceContact.getName().equals(str)) {
                        if (matchName == 0) {
                            index++;
                          //  s = s.concat(". <br>");
                            s = s.concat(name + "<br><br>");
                        }
                        s = s.concat(acquaintanceContact.printSearchResult());
                        matchName = 1;
                    }
                }
            }
            
        }
        return s;
    }
}
