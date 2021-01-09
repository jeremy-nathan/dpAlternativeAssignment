package contactmanagementsoftware;

import java.util.ArrayList;

import javax.swing.JOptionPane;

//Button3
public class SearchCommand implements Command {

	Search search;

	public SearchCommand(Search search) {
		this.search = search;
	}
	
	@Override
	public void execute() {
		search.search();
	}
	
}

class Search {
	
	MUI mui;
	
	public void search() {
		mui = MUI.getInstance();

		String s = (String)JOptionPane.showInputDialog(
				mui,
				"Enter name: ",
				"Input",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		if(s==null)
			return;
		mui.getJPanel1().setVisible(false);
		mui.getJPanel2().setVisible(true);
		mui.setStr(s);
		//	        str = s;
		mui.getDetails().setContentType( "text/html" );
		runn();
	}
	
	public void runn(){
            String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
        SearchClient search = new SearchClient(mui.getA());
        s = s.concat(search.printNameSearch(mui.getStr()));
       
        if(s.matches("<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>")){
            s  = "<html>No result found</html>";
        }
        else{
            s = s.concat("</html>");
        }
        mui.getDetails().setText(s);
        
	}
}
