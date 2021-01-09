package contactmanagementsoftware;


import java.util.Iterator;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


public class ContactsIterator implements Iterator<ContactManagementComponent> {
//   public class ContactsIterator implements Iterator{
        
    Stack<Iterator> stack = new Stack();

    //
	public ContactsIterator(Iterator<ContactManagementComponent> iterator) {
       //     public ContactsIterator(Iterator iterator) {
		stack.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	@Override
	public ContactManagementComponent next() {
		if (hasNext()) {
			Iterator<ContactManagementComponent> iterator = stack.peek();
			ContactManagementComponent component = iterator.next();

			if (component instanceof DirectoryComponent) {
				stack.push(((DirectoryComponent) component).createIterator());
			}
			return component;
		} else {
			return null;
		}
	}
}
