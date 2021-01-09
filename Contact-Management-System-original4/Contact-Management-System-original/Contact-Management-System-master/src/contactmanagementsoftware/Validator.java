/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

/**
 *
 * @author User
 */
abstract class Validator {
    
//    public final void checkAll() {
//        checkNull(str);
//        checkValid(str);
//    }
    
    public final boolean isValid(String str){
        if(!checkNull(str)){
            return checkValid(str);
        } else{
            return false;
        }
    }


 public boolean checkNull(String str){
        return str.equalsIgnoreCase("");
    }

    public abstract boolean checkValid(String str);
}
