package contactmanagementsoftware;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {

	ButtonController() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker invoker = new Invoker();
		Command command = null;

		if(e.getActionCommand().equals("Add")) {
			command = new AddCommand();
		}

		else if(e.getActionCommand().equals("Delete")) {
			command = new DeleteCommand();
		}

		else if(e.getActionCommand().equals("Search")) {
			command = new SearchCommand();
		}

		else if(e.getActionCommand().equals("Exit")) {
			command = new ExitCommand();
		}

		else if(e.getActionCommand().equals("Edit")) {
			command = new EditCommand();
		}

		else if(e.getActionCommand().equals("View full detail")) {
			command = new VFDCommand();
		}

		else if(e.getActionCommand().equals("Read from file")) {
			command = new ReadFromFileCommand();
		}

		//Command for save as file
		else if(e.getActionCommand().equals("Save as file")) {
			command = new SaveCommand();
		}

		else if(e.getActionCommand().equals("Back to main menu")) {
			command = new BackToMainMenuCommand();
		}

		else if(e.getActionCommand().equals("Add contact")) {
			command = new AddContactCommand();
		}

		else if(e.getActionCommand().equals("Cancel")) {
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