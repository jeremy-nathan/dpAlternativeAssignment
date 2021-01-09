package contactmanagementsoftware;

//Button 11
public class CancelCommand implements Command {

	Cancel cancel;

	public CancelCommand(Cancel cancel) {
		this.cancel = cancel;
	}
	
	@Override
	public void execute() {
		cancel.cancel();
	}

}

class Cancel {
	
	MUI mui;
	
	public void cancel() {
		mui = MUI.getInstance();
		mui.getJPanel1().setVisible(true);
		mui.getJPanel3().setVisible(false);
	}
}