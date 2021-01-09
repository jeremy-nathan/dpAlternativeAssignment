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
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class validDateChecker extends Validator{
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public boolean checkValid(String str) {
        boolean valid = false;

        try {
            sdf.parse(str);
            sdf.setLenient(false);
            valid = true;

        } catch (ParseException e) {
            e.printStackTrace();
            valid = false;
        }

        return valid;
    }
}
