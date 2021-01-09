package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//Button 7
public class ReadFromFileCommand implements Command {

	ReadFromFile rff;
	
	public ReadFromFileCommand(ReadFromFile rff) {
		this.rff = rff;
	}
	
	@Override
	public void execute() {
		rff.readFromFile();
	}

}

class ReadFromFile {
	
	MUI mui;
	
	public void readFromFile() {
		mui = MUI.getInstance();
		ContactManagementComponent temp;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		int result = fileChooser.showOpenDialog(mui);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: "+selectedFile.getName());
			try {
				temp = (ContactManagementComponent)SerializationUtil.deserialize(selectedFile);
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