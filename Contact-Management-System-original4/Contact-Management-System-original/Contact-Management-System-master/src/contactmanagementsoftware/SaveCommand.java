package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

//Button8
public class SaveCommand implements Command {
	
	Save save;
	
	public SaveCommand(Save save) {
		this.save = save;
	}

	@Override
	public void execute() {
		save.saveDetails();
	}

}

class Save {
	
	MUI mui;
	
	public void saveDetails() {
		
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
