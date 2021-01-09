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
public class NullIterator implements Iterator<ContactManagementComponent> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public ContactManagementComponent next() {
        return null;
    }
}
