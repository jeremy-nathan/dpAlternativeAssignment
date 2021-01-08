package contactmanagementsoftware.Receiver;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.CasualAcquaintances;
import contactmanagementsoftware.MUI;
import contactmanagementsoftware.PersonalFriends;
import contactmanagementsoftware.ProfessionalFriends;
import contactmanagementsoftware.Relatives;

public class Search {
	
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
		
		ArrayList<ArrayList<Acquaintances>> a = mui.getA();
		String str = mui.getStr();
		
		String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
		int j = 0;
		for(int i = 0; i < a.get(0).size(); i++){
			if(a.get(0).get(i).getName().matches(str)){
				j++;
				PersonalFriends perF = (PersonalFriends)a.get(0).get(i);
				if(j==1){
					s = s.concat("<br>I. Personal Friends<br>");
				}
				s = s.concat(j + ". Name: " + perF.getName() + "<br>");
				s = s.concat("Mobile No: " + perF.getMobileNo() + "<br>");
				s = s.concat("Email: " + perF.getEmail() + "<br>");
				s = s.concat("Specific events: " + perF.getEvents() + "<br>");
				s = s.concat("First Acquaintance context: " + perF.getAContext() + "<br>");
				s = s.concat("First Acquaintance date: " + perF.getADate() + "<br>");
			}
		}
		j = 0;
		for(int i = 0; i < a.get(1).size(); i++){
			if(a.get(1).get(i).getName().matches(str)){
				j++;
				Relatives rel = (Relatives)a.get(1).get(i);
				if(j==1){
					s = s.concat("<br>II. Relatives<br>");
				}
				s = s.concat(j + ". Name: " + rel.getName() + "<br>");
				s = s.concat("Mobile No: " + rel.getMobileNo() + "<br>");
				s = s.concat("Email: " + rel.getEmail() + "<br>");
				s = s.concat("Relatives Birthday: " + rel.getBDate() + "<br>");
				s = s.concat("Last met date: " + rel.getLDate() + "<br>");
			}
		}
		j = 0;
		for(int i = 0; i < a.get(2).size(); i++){
			if(a.get(2).get(i).getName().matches(str)){
				j++;
				ProfessionalFriends proF = (ProfessionalFriends)a.get(2).get(i);
				if(j==1){
					s = s.concat("<br>III. Professional Friends<br>");
				}
				s = s.concat(j + ". Name: " + proF.getName() + "<br>");
				s = s.concat("Mobile No: " + proF.getMobileNo() + "<br>");
				s = s.concat("Email: " + proF.getEmail() + "<br>");
				s = s.concat("Common Interests: " + proF.getCommonInterests() + "<br>");
			}
		}
		j = 0;
		for(int i = 0; i < a.get(3).size(); i++){
			if(a.get(3).get(i).getName().matches(str)){
				j++;
				CasualAcquaintances ca = (CasualAcquaintances)a.get(3).get(i);
				if(j==1){
					s = s.concat("<br>IV. Casual Acquaintances<br>");
				}
				s = s.concat(j + ". Name: " + ca.getName() + "<br>");
				s = s.concat("Mobile No: " + ca.getMobileNo() + "<br>");
				s = s.concat("Email: " + ca.getEmail() + "<br>");
				s = s.concat("First met location & time: " + ca.getWhenWhere() + "<br>");
				s = s.concat("First met circumstances: " + ca.getCircumstances() + "<br>");
				s = s.concat("Other useful information: " + ca.getOtherInfo() + "<br>");
			}
		}
		if(s.matches("<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>")){
			s  = "<html>No result found</html>";
		}
		else{
			s = s.concat("</html>");
		}
		mui.getDetails().setText(s);
	}
}