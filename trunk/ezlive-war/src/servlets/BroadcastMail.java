package servlets;

import java.io.IOException;
import java.util.ArrayList;
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

public class BroadcastMail extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private final static String MAILER_VERSION = "Java";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String content = (String) request.getAttribute("content");
		String[] dest = (((String) request.getAttribute("destinataires"))
				.split(", "));
		ArrayList destinataires = new ArrayList();
		for (int i = 0; i < dest.length; ++i) {
			destinataires.add(dest[i].trim());
		}
		envoiMailCollectif(content, destinataires);
		response.sendRedirect("admin.jsp");
	}

	private void envoiMailCollectif(String content, ArrayList destinataires) {
		for (int i = 0; i < destinataires.size(); ++i) {
			enoyerMail(content, (String) destinataires.get(i));
		}
	}

	private void enoyerMail(String content, String dest) {
		try {
			Properties prop = System.getProperties();
			prop.put("mail.klups.net", "localhost");

			Session session = Session.getDefaultInstance(prop, null);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("klupslocal@localhost"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					dest));
			message.setSubject("SAT-Live news letter ! ");
			message.setText(content);
			message.setHeader("X-Mailer", MAILER_VERSION);
			message.setSentDate(new Date());

			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}