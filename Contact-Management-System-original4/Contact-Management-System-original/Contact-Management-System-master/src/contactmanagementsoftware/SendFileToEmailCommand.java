/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
//Button 12
public class SendFileToEmailCommand implements Command {

	SendFileToEmailReceiver sendFile;

	public SendFileToEmailCommand(SendFileToEmailReceiver sendFile) {
		this.sendFile = sendFile;
	}

	@Override
	public void execute() {
		sendFile.initComponents();
	}

}

class SendFileToEmailReceiver {

	MUI mui;

	public void initComponents() {

		mui = MUI.getInstance();

		String s = (String)JOptionPane.showInputDialog(
				mui,
				"Enter your email",
				"Input",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,null);
		
		if(!s.contains("@") || s.equals(null)){
			JOptionPane.showMessageDialog(mui, "Enter a valid email");
			return;
		}
		else sendEmail(s);

	}

	public void sendEmail(String to) {

		System.out.println("Email Service Start...");

		//use gmail account only because I use gmail smtp.
		//to use this feature, go to your settings in google account > security > 
		//Less secure app access > ON (off it after you're done!)
		String from = "put your email here"; //change to your own email 
		String password = "put your password here"; //change to your own password

		//Get the session object  
		Properties props = System.getProperties(); 
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
				"javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465"); 
		System.out.println("Info: Properties initialized");

		Session session = Session.getDefaultInstance(props,    
				new javax.mail.Authenticator() {    
			protected PasswordAuthentication getPasswordAuthentication() {    
				return new PasswordAuthentication(from,password);  
			}    
		});    
		System.out.println("Info: Session initialized");

		System.out.println("Info: Composing mail...");
		//compose the message  
		try { 
			MimeMessage message = new MimeMessage(session);  
			message.setFrom(new InternetAddress(from));  
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
			message.setSubject("Your file is ready");

			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			MUI mui = MUI.getInstance();

			// Add attachment
			MimeBodyPart attachPart = new MimeBodyPart();
			
			String path = "./Contact-Management-System-original4/"
					+ "Contact-Management-System-original/"
					+ "Contact-Management-System-master/";
			String filename = new Date().getTime() + "_output.ser";
			messageBodyPart.setText("Here is your saved file: "+filename);
			
			SerializationUtil.serialize(mui.getA(), path+filename);
			attachPart.attachFile(new File(path+filename));

			// Set text message part
			multipart.addBodyPart(attachPart);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message  
			Transport.send(message);  
			System.out.println("Info: Email sent successfully to "+to); 

			JOptionPane.showMessageDialog(mui, "Successfuly sent email to "+to);

		}
		catch (MessagingException mex) {mex.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}  
	} 

}