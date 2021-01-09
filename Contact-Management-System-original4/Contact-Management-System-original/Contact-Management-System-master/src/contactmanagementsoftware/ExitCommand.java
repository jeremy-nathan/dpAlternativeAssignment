package contactmanagementsoftware;

//Button 4
public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}

}