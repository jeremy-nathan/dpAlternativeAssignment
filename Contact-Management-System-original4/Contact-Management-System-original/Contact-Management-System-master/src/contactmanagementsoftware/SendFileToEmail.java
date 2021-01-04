package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class SendFileToEmail {

	String to;
	Object attachment;

	public SendFileToEmail(String to, Object attachment) {
		// TODO Auto-generated constructor stub
		this.to = to;
		this.attachment = attachment;
	}

	public void sendEmail() {
		System.out.println("Email Service Start...");

		//use gmail account only because I use gmail smtp.
		//to use this feature, go to your settings in google account > security > 
		//Less secure app access > ON (off it after you're done!)
		String from = "vonne.lavonne@gmail.com"; //change to your own email 
		String password = "mikikurenai98"; //change to your own password

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
			message.setSubject("This is your file");
			
			// Create the message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("Dua kali lima, lima kali babi");

			// Create a multipart message
			Multipart multipart = new MimeMultipart();

			// Add attachment
			MimeBodyPart attachPart = new MimeBodyPart();
			String filename = "./Contact-Management-System-original4/"
					+ "Contact-Management-System-original/"
					+ "Contact-Management-System-master/" +
					new Date().getTime() + "_output.ser";
			SerializationUtil.serialize(attachment, filename);
			attachPart.attachFile(new File(filename));
			
			// Set text message part
			multipart.addBodyPart(attachPart);
			multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart);

			// Send message  
			Transport.send(message);  
			System.out.println("Info: Email sent successfully to "+to);  

		}
		catch (MessagingException mex) {mex.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}  
	}
}
