package contactmanagementsoftware;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonController implements ActionListener {

	MUI mui;
	
	ButtonController() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker invoker = new Invoker();
		Command command = null;

		mui = MUI.getInstance();
		
		if(e.getSource() == mui.getjButton1()) {
			command = new AddCommand();
		}

		else if(e.getSource() == mui.getjButton2()) {
			command = new DeleteCommand();
		}

		else if(e.getSource() == mui.getjButton3()) {
			command = new SearchCommand();
		}

		else if(e.getSource() == mui.getjButton4()) {
			command = new ExitCommand();
		}

		else if(e.getSource() == mui.getjButton5()) {
			command = new EditCommand();
		}

		else if(e.getSource() == mui.getjButton6()) {
			command = new VFDCommand();
		}

		else if(e.getSource() == mui.getjButton7()) {
			command = new ReadFromFileCommand();
		}

		//Command for save as file
		else if(e.getSource() == mui.getjButton8()) {
			command = new SaveCommand();
		}

		else if(e.getSource() == mui.getjButton9()) {
			command = new BackToMainMenuCommand();
		}

		else if(e.getSource() == mui.getjButton10()) {
			command = new AddContactCommand();
		}

		else if(e.getSource() == mui.getjButton11()) {
			command = new CancelCommand();
		}

		invoker.setCommand(command);
		invoker.buttonWasPressed();

	}

}

class Invoker {

	Command command;

	public Invoker() {}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void buttonWasPressed() {
		command.execute();
	}
}