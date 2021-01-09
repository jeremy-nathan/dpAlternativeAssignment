package contactmanagementsoftware;

import javax.swing.JOptionPane;

//Button 2
public class DeleteCommand implements Command {
	
	Delete del;
	
	public DeleteCommand(Delete del) {
		this.del = del;
	}

	@Override
	public void execute() {
		del.delete();
	}

}

class Delete {
	
	MUI mui;

	public void delete() {

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