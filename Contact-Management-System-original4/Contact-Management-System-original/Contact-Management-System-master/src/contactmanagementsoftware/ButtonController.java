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
			Add add = new Add();
			command = new AddCommand(add);
		}

		else if(e.getSource() == mui.getjButton2()) {
			Delete del = new Delete();
			command = new DeleteCommand(del);
		}

		else if(e.getSource() == mui.getjButton3()) {
			Search search = new Search();
			command = new SearchCommand(search);
		}

		else if(e.getSource() == mui.getjButton4()) {
			command = new ExitCommand();
		}

		else if(e.getSource() == mui.getjButton5()) {
			Edit edit = new Edit();
			command = new EditCommand(edit);
		}

		else if(e.getSource() == mui.getjButton6()) {
			ViewFullDetail vfd = new ViewFullDetail();
			command = new VFDCommand(vfd);
		}

		else if(e.getSource() == mui.getjButton7()) {
			ReadFromFile rff = new ReadFromFile();
			command = new ReadFromFileCommand(rff);
		}

		//Command for save as file
		else if(e.getSource() == mui.getjButton8()) {
			Save save = new Save();
			command = new SaveCommand(save);
		}

		else if(e.getSource() == mui.getjButton9()) {
			BackToMainMenu btmm = new BackToMainMenu();
			command = new BackToMainMenuCommand(btmm);
		}

		else if(e.getSource() == mui.getjButton10()) {
			AddContact addContact = new AddContact();
			command = new AddContactCommand(addContact);
		}

		else if(e.getSource() == mui.getjButton11()) {
			Cancel cancel = new Cancel();
			command = new CancelCommand(cancel);
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