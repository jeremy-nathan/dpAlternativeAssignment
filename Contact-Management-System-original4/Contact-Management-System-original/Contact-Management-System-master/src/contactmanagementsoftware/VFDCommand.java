package contactmanagementsoftware;

import javax.swing.JOptionPane;

//Button 6
public class VFDCommand implements Command {
	
	ViewFullDetail vfd;

	public VFDCommand(ViewFullDetail vfd) {
		this.vfd = vfd;
	}
	
	@Override
	public void execute() {
		vfd.viewFullDetail();
	}

}

class ViewFullDetail {
	
	MUI mui;
	
	public void viewFullDetail() {
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