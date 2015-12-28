package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseUser;
import divers.People;

/**
 * Servlet implementation class for Servlet: Login
 * 
 */
public class Login extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String logon = request.getParameter("logon");
		HttpSession session = request.getSession();
		if (logon.equals("")) {
			session.setAttribute("logon", logon);
			response.sendRedirect("subscribe.jsp");
		} else {
			if (logon.equalsIgnoreCase("anonymous")) {
				session.setAttribute("logon", logon);
				session.setAttribute("idUser", String.valueOf("2"));
				session.setAttribute("author", "Anonymous");
				session.setAttribute("logged", String.valueOf(true));
				response.sendRedirect("papers.jsp");
			} else {
				ArrayList users = (ArrayList) getServletContext().getAttribute(
						"users");
				boolean fiched = false;
				for (int i = 0; fiched == false && i < users.size(); ++i) {
					People gens = ((People) (users.get(i)));
					String mail = gens.getMail();
					
					if (mail.equals(logon)) {
						fiched = true;
						String author = gens.getFirstName();
						if (author == null || author.equals("")) {
							author = gens.getMail();
						} else {
							String homepage = gens.getHomepage();
							if (homepage != null && !homepage.equals("")) {
								if (!homepage.startsWith("http://")) {
									homepage = "http://" + homepage;
								}
								author = "<a href=\"" + homepage + "\">"
										+ author + "</a>";
							}
						}
						session.setAttribute("author", author);
						int idUser = new DataBaseUser().getIDByMail(mail);
						session.setAttribute("idUser", String.valueOf(idUser));
					}
				}

				if (fiched) {
					session.setAttribute("logon", logon);
					session.setAttribute("logged", String.valueOf(true));
					response.sendRedirect("papers.jsp");
				} else {
					session.setAttribute("logon", "");
					response.sendRedirect("subscribe.jsp");
				}
			}
		}
	}
}