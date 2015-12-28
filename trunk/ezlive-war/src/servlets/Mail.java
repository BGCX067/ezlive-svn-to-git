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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mail extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final static String MAILER_VERSION = "Java";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		envoyerMailSMTP((String) request.getSession().getAttribute("email"));
	}

	public static void envoyerMailSMTP(String mail) {
		try {
			Properties prop = System.getProperties();
			prop.put("mail.klups.net", "localhost");
			Session session = Session.getDefaultInstance(prop, null);

			Message message = new MimeMessage(session);
			// Modification de l'expéditeur du message
			message.setFrom(new InternetAddress("klupslocal@localhost"));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					mail));
			// Modification des autres propriétés du message
			message.setSubject("SAT-Live subscription");
			String mess = "Congratulations !\nYou have successfully subscribed to <a href=\"www.satlive.org\"</a>.In order to complete this, please click this link : <a href=\"www.satlive.org\">Validation link</a>";
			message.setText(mess);
			message.setHeader("X-Mailer", MAILER_VERSION);
			message.setSentDate(new Date());
			
			// envoie du message
			Transport.send(message);
		}// try
		catch (Exception e) {
			e.printStackTrace();
		}// catch
	}// envoyerMailSMTP()
}// class Mail
