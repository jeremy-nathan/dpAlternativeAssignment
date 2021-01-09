package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

//Done by evefaustina
//improvement: some method (the 2 last one are put in the add class instead, reduce decouple with mui

//Button 1
public class AddCommand implements Command {

	Add add;
	
	public AddCommand(Add add) {
		this.add = add;
	}

	@Override
	public void execute() {
		add.add();
	}

}

class Add {
	
	MUI mui;
	
	public Add() {}
	
	public void add() {
		mui = MUI.getInstance();
		JList jlist1 = mui.getJList1();
		JPanel jPanel1 = mui.getJPanel1();
		JPanel jPanel3 = mui.getJPanel3();

		int index = jlist1.getSelectedIndex();

		if (index < 0) {
			JOptionPane.showMessageDialog(mui, "Select a category!");
			return;
		}
		
		jPanel1.setVisible(false);
		jPanel3.setVisible(true);
		mui.setX(index);
		mui.setFlag(true);
		mui.setDFlag(false);
		mui.setDescription();
	}
}