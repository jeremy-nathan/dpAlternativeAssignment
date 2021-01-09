package contactmanagementsoftware;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//Button 10
public class AddContactCommand implements Command {

	AddContact addContact;
	
	public AddContactCommand(AddContact addContact) {
		this.addContact = addContact;
	}

	@Override
	public void execute() {
		addContact.add();
	}

}

class AddContact {
	
	MUI mui;
	public AddContact() {
	}

	public void add() {

		mui = MUI.getInstance();
		mui.setDFlag(true);
		JList jlist1 = mui.getJList1();
		
		ArrayList<ArrayList<Acquaintances>> a = mui.getA();
		int x = jlist1.getSelectedIndex();
		int num = mui.getNum();
		boolean flag = mui.getFlag();
		
		JTextField name = mui.getNameTxt();
		JTextField mobile = mui.getMobile();
		JTextField email = mui.getEmail();
		JTextArea one = mui.getOne();
		JTextArea two = mui.getTwo();
		JTextArea three = mui.getThree();
		
		String Name = name.getText();
		if(Name.isEmpty()){
			JOptionPane.showMessageDialog(mui, "Enter a name");
			return;
		}
		
		String Mobile = mobile.getText();
		if(!MobileNoChecker(Mobile)){
			JOptionPane.showMessageDialog(mui, "Enter a valid mobile number (6-15 digits)");
			return;
		}
		
		String Email = email.getText();
		if(!Email.contains("@")){
			JOptionPane.showMessageDialog(mui, "Enter a valid email");
			return;
		}
		
		String One,Two,Three;
		
		switch(x){
		case 0: //perF
			One = one.getText();
			if(One.isEmpty() || One.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			Two = two.getText();
			if(Two.isEmpty() || Two.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			Three = three.getText();
			if(!validDate(Three)){
				return;
			}
			if(Three.isEmpty() || Three.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			PersonalFriends perF;
			if(flag) {
				perF = new PersonalFriends();
			}	
			else {
				perF = (PersonalFriends)a.get(x).get(num);
			}
			perF.setName(Name);
			perF.setMobileNo(Mobile);
			perF.setEmail(Email);
			perF.setEvents(One);
			perF.setAContext(Two);
			perF.setADate(Three);
			if(flag) 
				a.get(x).add(perF);
			//this.a.get(x).add(perF);
			break;
		case 1: //rel
			One = one.getText();
			if(One.isEmpty() || One.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			if(!validDate(One)){
				return;
			}
			Two = two.getText();
			if(Two.isEmpty() || Two.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			if(!validDate(Two)){
				return;
			}
			Relatives rel;
			if(flag)
				rel = new Relatives();
			else
				rel = (Relatives)a.get(x).get(num);
			rel.setName(Name);
			rel.setMobileNo(Mobile);
			rel.setEmail(Email);
			rel.setBDate(One);
			rel.setLDate(Two);
			if(flag)
				a.get(x).add(rel);
			break;
		case 2: //proF
			One = one.getText();
			if(One.isEmpty() || One.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			ProfessionalFriends proF;
			if(flag)
				proF = new ProfessionalFriends();
			else
				proF = (ProfessionalFriends)a.get(x).get(num);
			proF.setName(Name);
			proF.setMobileNo(Mobile);
			proF.setEmail(Email);
			proF.setCommonInterests(One);
			if(flag)
				a.get(x).add(proF);
			break;
		case 3: //ca
			One = one.getText();
			if(One.isEmpty() || One.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			Two = two.getText();
			if(Two.isEmpty() || Two.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			Three = three.getText();
			if(Three.isEmpty() || Three.length() > 300){
				JOptionPane.showMessageDialog(mui, "Enter a valid value ( 1 to 300 chars)");
				return;
			}
			CasualAcquaintances ca;
			if(flag)
				ca = new CasualAcquaintances();
			else
				ca = (CasualAcquaintances)a.get(x).get(num);
			ca.setName(Name);
			ca.setMobileNo(Mobile);
			ca.setEmail(Email);
			ca.setWhenWhere(One);
			ca.setCircumstances(Two);
			ca.setOtherInfo(Three);
			if(flag)
				a.get(x).add(ca);
			break;
		default:
			break;
		}
		mui.getJPanel1().setVisible(true);
		mui.getJPanel3().setVisible(false);
		mui.setUpTableData();
		
	}

	public boolean validDate(String Date){

		mui = MUI.getInstance();

		String pattern = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(Date);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if(!m.find()){
			JOptionPane.showMessageDialog(mui, "Enter a valid date");
			return false;
		}
		else
			return true;
	}

	public boolean MobileNoChecker(String str){
		int x;
		if(str.isEmpty() || str.length() < 6 || str.length() > 15)
			return false;
		for(int j = 0 ; j < str.length() ; j++)
		{
			x = (int)str.charAt(j);
			if( x < 48 || x > 57 )
				return false;    
		}
		return true;
	}

}

