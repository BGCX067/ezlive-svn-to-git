package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseUser;
import divers.People;

public class AddUser extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traiterNouveauUser(request);
		reinitialiserUsers();
		response.sendRedirect("admin.jsp");
	}

	private void traiterNouveauUser(HttpServletRequest request) {
		String nom = request.getParameter("name");
		String mail = request.getParameter("mail");
		String url = request.getParameter("url");
		String affiliation = request.getParameter("affiliation");
		int pays = Integer.parseInt(request.getParameter("pays"));
		String display = request.getParameter("display");
		if (display.equals("on")) {
			display = "true";
		}
		String info = request.getParameter("info");
		if (info.equals("on")) {
			info = "true";
		}
		new DataBaseUser().ajout(new People(nom, mail, url, affiliation, pays,
				info, display));
	}

	private void reinitialiserUsers() {
		getServletContext().setAttribute("users", null);
		getServletContext().setAttribute("users2display", null);
	}
}