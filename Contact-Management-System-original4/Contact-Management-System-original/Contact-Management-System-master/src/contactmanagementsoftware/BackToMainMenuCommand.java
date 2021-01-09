package contactmanagementsoftware;

//Button 9
public class BackToMainMenuCommand implements Command {

	BackToMainMenu btmm;
	
	public BackToMainMenuCommand(BackToMainMenu btmm) {
		this.btmm = btmm;
	}

	@Override
	public void execute() {
		btmm.goBack();
	}
}

class BackToMainMenu {
	
	MUI mui;
	
	public void goBack() {
		mui = MUI.getInstance();
		mui.getJPanel2().setVisible(false);
		mui.getJPanel1().setVisible(true);
	}
}