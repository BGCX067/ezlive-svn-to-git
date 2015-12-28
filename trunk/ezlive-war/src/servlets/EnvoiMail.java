package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: EnvoiMail
 * 
 */
public class EnvoiMail extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	private final static String MAILER_VERSION = "Java";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String adr = (String) request.getSession().getAttribute("email");
		envoyerMailSMTP(adr, false);
	}

	public static void envoyerMailSMTP(String adr, boolean debug) {
		try {
			Properties prop = System.getProperties();
			prop.put("klups.mail.net", "localhost");
			Session session = Session.getDefaultInstance(prop, null);
			Message message = new MimeMessage(session);
			// Modification de l'expéditeur du message
			message.setFrom(new InternetAddress("klupslocal@klups.mail.net"));

			InternetAddress internetAddresse = new InternetAddress(adr);

			message.setRecipient(Message.RecipientType.TO, internetAddresse);
			// Modification des autres propriétés du message
			message.setSubject("Subscription to SAT-Live!");
			message.setText("Hello");
			message.setHeader("X-Mailer", MAILER_VERSION);
			message.setSentDate(new Date());
			session.setDebug(debug);
			// envoie du message
			Transport.send(message);
		}// try
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
