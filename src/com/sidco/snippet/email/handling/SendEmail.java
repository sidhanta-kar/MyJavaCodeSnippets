/**
 * 
 */
package com.sidco.snippet.email.handling;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sidco.snippet.email.bean.Mail;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class SendEmail {

	/**
	 * 
	 */
	public SendEmail() {
		super();
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		SendEmail sendMail = new SendEmail();
		sendMail.useSmtp();

	}

	public void useExchange() throws Exception {
		String[] to = {"sidhanta.kar@capgemini.com"};
		String[] cc = {"sidhanta.kar@capgemini.com"};
		String[] bcc = {"sidhanta.kar@capgemini.com"};
		String host = "IN-HYD-DAGND1.corp.capgemini.com";
		int port = 25;
		String from = "sidhanta.kar@capgemini.com";
		String pass = "India123";
		boolean useTls = false;
		String subject = "Test Mail";
		String body = "<h1>This is message body</h1>";
		
		ArrayList<File> attachments = new ArrayList<File>();
		attachments.add(new File("D:/Files/A.eix"));
		attachments.add(new File("D:/Files/b.tix"));
		Mail mailObj = new Mail(to, cc, bcc, useTls, host, port, from, pass, subject, body, attachments);
		this.sendMail(mailObj);
	}

	public void useEYExchange() throws Exception {
		String[] to = {"sidhanta.kar@in.ey.com"};
		String[] cc = {};
		String[] bcc = {};
		String host = "outlook-xi.ey.net";//"INBANRMPEXM004.ey.net";
		int port = 25;
		String from = "sidhanta.kar@in.ey.com";
		String pass = "Password02";
		boolean useTls = true;
		String subject = "Test Mail";
		String body = "<h1>This is message body</h1>";
		
		ArrayList<File> attachments = new ArrayList<File>();
		attachments.add(new File("D:/Files/A.eix"));
		attachments.add(new File("D:/Files/b.tix"));
		Mail mailObj = new Mail(to, cc, bcc, useTls, host, port, from, pass, subject, body, attachments);
		this.sendMail(mailObj);
	}

	public void useSmtp() throws Exception {
		String[] to = {"sidhanta.kar@gmail.com"};
		String[] cc = {};//{"sidhu343@gmail.com"};
		String[] bcc = {};//{"sidhu343@gmail.com"};
		String host = "smtp.gmail.com";
		int port = 587;
		String from = "sidhu343@gmail.com";
		String pass = "jazz3232";
		boolean useTls = true;
		String subject = "Test Mail";
		String body = ""
				+ "<body>"
				+ "<div itemscope itemtype=\"http://schema.org/EventReservation\">"
				+ "<meta itemprop=\"reservationNumber\" content=\"IO12345\"/>"
				+ "<div itemprop=\"underName\" itemscope itemtype=\"http://schema.org/Person\">"
				+ "<meta itemprop=\"name\" content=\"John Smith\"/>"
				+ "</div>"
				+ "<div itemprop=\"reservationFor\" itemscope itemtype=\"http://schema.org/Event\">"
				+ "<meta itemprop=\"name\" content=\"Google I/O 2013\"/>"
				+ "<time itemprop=\"startDate\" datetime=\"2013-05-15T08:30:00-08:00\"/>"
				+ "<div itemprop=\"location\" itemscope itemtype=\"http://schema.org/Place\">"
				+ "<meta itemprop=\"name\" content=\"Moscone Center\"/>"
				+ "<div itemprop=\"address\" itemscope itemtype=\"http://schema.org/PostalAddress\">"
				+ "<meta itemprop=\"streetAddress\" content=\"800 Howard St.\"/>"
				+ "<meta itemprop=\"addressLocality\" content=\"San Francisco\"/>"
				+ "<meta itemprop=\"addressRegion\" content=\"CA\"/>"
				+ "<meta itemprop=\"postalCode\" content=\"94103\"/>"
				+ "<meta itemprop=\"addressCountry\" content=\"US\"/>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<p>"
				+ "Dear John, thanks for booking your Google I/O ticket with us."
				+ "</p>"
				+ "<p>"
				+ "BOOKING DETAILS<br/>"
				+ "Reservation number: IO12345<br/>"
				+ "Order for: John Smith<br/>"
				+ "Event: Google I/O 2013<br/>"
				+ "Start time: May 15th 2013 8:00am PST<br/>"
				+ "Venue: Moscone Center, 800 Howard St., San Francisco, CA 94103<br/>"
				+ "</p>"
				+ "</body>"
				+ "";

		ArrayList<File> attachments = new ArrayList<File>();
		//attachments.add(new File(""));
		Mail mailObj = new Mail(to, cc, bcc, useTls, host, port, from, pass, subject, body, attachments);
		this.sendMail(mailObj);
	}

	public void sendMail(Mail mailObj) throws AddressException, MessagingException {
		System.out.println("Sending E-Mail");


		Properties props = System.getProperties();
		if (mailObj.isUseTls()) {
			props.put("mail.smtp.starttls.enable", "true");
		}
		props.put("mail.smtp.host", mailObj.getHost());
		props.put("mail.smtp.port", mailObj.getPort());
		props.put("mail.smtp.user", mailObj.getFrom());
		props.put("mail.smtp.password", mailObj.getPass());
		props.put("mail.smtp.auth", "true");

		System.out.println("Getting Session");

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(mailObj.getFrom()));

		System.out.println("Creating Send to List");

		InternetAddress[] toAddress = new InternetAddress[mailObj.getTo().length];
		InternetAddress[] ccAddress = new InternetAddress[mailObj.getCc().length];
		InternetAddress[] bccAddress = new InternetAddress[mailObj.getBcc().length];

		// To get the array of addresses
		for( int i=0; i < mailObj.getTo().length; i++ ) { 
			toAddress[i] = new InternetAddress(mailObj.getTo()[i]);
		}
		message.addRecipients(Message.RecipientType.TO, toAddress);
		

		for( int i=0; i < mailObj.getCc().length; i++ ) { 
			ccAddress[i] = new InternetAddress(mailObj.getCc()[i]);
		}
		message.addRecipients(Message.RecipientType.CC, ccAddress);
		

		for( int i=0; i < mailObj.getBcc().length; i++ ) {
			bccAddress[i] = new InternetAddress(mailObj.getBcc()[i]);
		}
		message.addRecipients(Message.RecipientType.BCC, bccAddress);

		System.out.println("Creating Mail");
		
        // Create a multipart message
        Multipart multipart = new MimeMultipart();

        // Create the message body part 
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(mailObj.getBody(), "text/html");
                
        // Set message body part 
        multipart.addBodyPart(messageBodyPart);

        if(mailObj.getAttachments() != null) {
        	for(File attachment:mailObj.getAttachments()) { 
            	// Adding Attachment
            	MimeBodyPart messageAttachmentPart = new MimeBodyPart();
            	DataSource source = new FileDataSource(attachment);
            	messageAttachmentPart.setDataHandler(new DataHandler(source));
            	messageAttachmentPart.setFileName(attachment.getName());

            	// Set message attachment part 
            	multipart.addBodyPart(messageAttachmentPart);
            }
        }
        
        // Set Subject: header field
        message.setSubject(mailObj.getSubject());
        // Send the complete message parts
        message.setContent(multipart);


		System.out.println("Sending...");
		Transport transport = session.getTransport("smtp");
		transport.connect(mailObj.getHost(), mailObj.getFrom(), mailObj.getPass());
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
		System.out.println("E-Mail Sent");
	}

}

