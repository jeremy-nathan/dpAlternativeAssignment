package contactmanagementsoftware;

import javax.swing.JOptionPane;

//Button 5
public class EditCommand implements Command {

	Edit edit;
	
	public EditCommand(Edit edit) {
		this.edit = edit;
	}
	
	@Override
	public void execute() {
		edit.edit();
	}

}

class Edit {
	
	MUI mui;
	
	public void edit() {
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