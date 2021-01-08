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

	static MUI mui;

	@Override
	public void execute() {

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

//Button 2
class DeleteCommand implements Command {

	MUI mui;

	@Override
	public void execute() {

		mui = MUI.getInstance();
		int index = mui.getJList1().getSelectedIndex();
		if(index<0){
			JOptionPane.showMessageDialog(mui, "Select a category!");
			return;	
		}

		int tindex = mui.getJXTable1().getSelectedRow();
		if(tindex < 0){
			JOptionPane.showMessageDialog(mui, "Select an entry!");
			return;
		}
		int n = JOptionPane.showConfirmDialog(
				mui,
				"Are you sure you want to delete this?",
				"Confirm",
				JOptionPane.YES_NO_OPTION);
		if(n==0){
			mui.getA().get(index).remove(tindex);
			JOptionPane.showMessageDialog(mui, "Successfully Deleted");
			mui.setUpTableData(); 
		}

	}

}

//Button 3
class SearchCommand implements Command {

	MUI mui;
	Search search = new Search();

	@Override
	public void execute() {
		search.search();
	}
	
}

//Button 4
class ExitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}

}

//Button 5
class EditCommand implements Command {

	MUI mui;

	@Override
	public void execute() {

		mui = MUI.getInstance();
		int index = mui.getJList1().getSelectedIndex();
		if(index<0){
			JOptionPane.showMessageDialog(mui, "Select a category!");
			return;
		}
		int tindex = mui.getJXTable1().getSelectedRow();
		if(tindex < 0){
			JOptionPane.showMessageDialog(mui, "Select an entry!");
			return;
		}

		//        num = tindex;
		//        flag = false;
		//        dflag = false;
		//        x = index;
		mui.setNum(tindex);
		mui.setFlag(false);
		mui.setDFlag(false);
		mui.setX(index);
		mui.setDescription();
		mui.getJPanel1().setVisible(false);
		mui.getJPanel3().setVisible(true);

	}

}

//Button 6
class VFDCommand implements Command {

	MUI mui;

	@Override
	public void execute() {
		mui = MUI.getInstance();

		int index = mui.getJList1().getSelectedIndex();
		if(index<0){
			JOptionPane.showMessageDialog(mui, "Select a category!");
			return;
		}
		int tindex = mui.getJXTable1().getSelectedRow();
		if(tindex < 0){
			JOptionPane.showMessageDialog(mui, "Select an entry!");
			return;
		}
		mui.setNum(tindex);
		mui.setFlag(false);
		mui.setX(index);
		mui.getJPanel1().setVisible(false);
		mui.getJPanel3().setVisible(true);
		mui.setDFlag(true);
		mui.setDescription();
	}

}

//Button 7
class ReadFromFileCommand implements Command {

	MUI mui;
	@Override
	public void execute() {

		mui = MUI.getInstance();
		ArrayList<ArrayList<Acquaintances>> temp;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int result = fileChooser.showOpenDialog(mui);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: "+selectedFile.getName());
			try {
				temp = (ArrayList<ArrayList<Acquaintances>>)SerializationUtil.deserialize(selectedFile);
			}
			catch (ClassNotFoundException | IOException ex) {
				JOptionPane.showMessageDialog(mui, "Error");
				System.out.println("Error: "+ex);
				return;
			}
		}
		else{
			return;
		}
		try{
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < temp.get(i).size(); j++){
					mui.getA().get(i).add(temp.get(i).get(j));
				}
			}
		}
		catch(Exception ex){

		}
		mui.setUpTableData();

	}

}

//Button 8
class SaveCommand implements Command {

	MUI mui;

	@Override
	public void execute() {

		mui = MUI.getInstance();
		String s = (String)JOptionPane.showInputDialog(
				mui,
				"Enter file name: (*.ser)",
				"Input",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"output.ser");
		if(s==null)
			return;
		if(!s.endsWith(".ser")){
			JOptionPane.showMessageDialog(mui, "File name should end with .ser");
			return;
		}
		File[] fileList = (new File(".")).listFiles((File pathname) -> pathname.getName().endsWith(".ser"));
		boolean flag = false;
		for(File f : fileList){
			if(f.getName().matches(s)){
				flag = true;
			}
		}
		if(flag){
			int q = JOptionPane.showConfirmDialog(mui, s + " already exists:\nAre you sure you want to overwrite?");
			if(q!=0)
				return;
		}
		try {
			SerializationUtil.serialize(mui.getA(), s);
		} catch (IOException ex) {
			return;
		}
		JOptionPane.showMessageDialog(mui, s + " saved successfully");

	}

}

//Button 9
class BackToMainMenuCommand implements Command {

	MUI mui;

	@Override
	public void execute() {
		mui = MUI.getInstance();
		mui.getJPanel2().setVisible(false);
		mui.getJPanel1().setVisible(true);
	}

}

//Button 10
class AddContactCommand implements Command {

	AddContact addContact = new AddContact();

	@Override
	public void execute() {
		addContact.add();
	}

}

//Button 11
class CancelCommand implements Command {

	MUI mui;

	@Override
	public void execute() {
		mui = MUI.getInstance();
		mui.getJPanel1().setVisible(true);
		mui.getJPanel3().setVisible(false);
	}

}