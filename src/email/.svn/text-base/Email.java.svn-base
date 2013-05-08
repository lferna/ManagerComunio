package email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import usuario.UsuarioVO;

public class Email {

	private Session session = null;
	
	public void enviarEmail(UsuarioVO usuario){
		this.configurarSession();
		this.mensajeEmail(usuario);
	}
	
	private void configurarSession(){
		Properties props = new Properties();

		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port","587");

		// Nombre del usuario
		props.setProperty("mail.smtp.user", "lfernapalacio@gmail.com");

		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");
		
		session = Session.getDefaultInstance(props);
		session.setDebug(true);		
		
	}
	
	private void mensajeEmail(UsuarioVO usuario){
		try {
		MimeMessage message = new MimeMessage(session);
		
		// Quien envia el correo
		message.setFrom(new InternetAddress("lfernapalacio@gmail.com"));

		// A quien va dirigido
		message.addRecipient(Message.RecipientType.TO, 
							new InternetAddress(usuario.getEmail()));
		
		message.setSubject("Bienvenido a Manager Comunio");
		message.setText("<p>Bienvenido a <a href='http://www.managercomunio'>Manager Comunio</a></p>" +
						"<p>Muchas gracias por registrarte. Sus datos en la página son:<br/>"+
						"Login: " + usuario.getIdUsuario()+"<br/>"+
						"Password: "+usuario.getHash()+
						"</p>","ISO-8859-1","html");
		
		this.enviarEmail(message);
		
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
	
	private void enviarEmail(MimeMessage message){
		try {
			Transport t = session.getTransport("smtp");
			t.connect("<aqui el email>","<aqui la password>");
			t.sendMessage(message,message.getAllRecipients());
			t.close();
		} catch (NoSuchProviderException e) {			
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
}
