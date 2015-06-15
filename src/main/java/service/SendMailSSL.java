package service;


 
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMailSSL {
	
	private String destinataire;
	private String sujet;
	private String message;
	private String date;
	
	public SendMailSSL(String destinataire, String sujet, String message) {
		super();
		this.destinataire = destinataire;
		this.sujet = sujet;
		this.message = message;
	}
	public SendMailSSL(String destinataire, String sujet, String message,String date) {
		super();
		this.destinataire = destinataire;
		this.sujet = sujet;
		this.message = message;
		this.date = date;
	}

	public void send() {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("ettarbaoui.ayoub","067031455Ettarbaouiayoub");
				}
			});
 
		try {
 
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("ettarbaoui.ayoub@gmail.com"));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("ettarbaoui.a@gmail.com"));
			msg.setSubject(destinataire);
			msg.setContent("<div style='width: 50%'><h3 style='padding: 10px 30px;background:#3c8dbc;color:#fff'>Renseignement sur votre dossier</h3><br>"
					+ "<p style='color:#3D94C7;'>Date de modification :</p><p>"
					+ date
					+ "</p><p style='color:#3D94C7;'>Nouvel etat :</p><p>"
					+ message
					+ "</p></div>"
					, "text/html; charset=utf-8");
 
			Transport.send(msg);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}