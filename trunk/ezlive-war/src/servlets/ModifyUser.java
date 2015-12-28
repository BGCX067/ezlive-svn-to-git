package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseUser;

public class ModifyUser extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String btn = request.getParameter("btn");
		if (btn.equalsIgnoreCase("cancel")) {
			cancel(request);
		} else {
			String id = (String) request.getSession().getAttribute("idEditUser");
			String nom = (String) request.getParameter("name");
			String mail = (String) request.getParameter("mail");
			String homepage = (String) request.getParameter("homepage");
			String affiliation = (String) request.getParameter("affiliation");
			String country = (String) request.getParameter("pays");
			String display = (String) request.getParameter("display");
			String info = (String) request.getParameter("info");
			nom = nom.replace("'", "''");
			affiliation = affiliation.replaceAll("'", "''");
			new DataBaseUser().maj(id, nom, mail, affiliation, homepage,
					country, display, info);
			reinitialiserUsers(request);
		}
		response.sendRedirect("index.jsp");
	}

	private void cancel(HttpServletRequest request) {
		request.getSession().setAttribute("idEditUser", null);
	}

	private void reinitialiserUsers(HttpServletRequest request) {
		request.getSession().setAttribute("idEditUser", null);
		getServletContext().setAttribute("users", null);
		getServletContext().setAttribute("users2display", null);
	}

}
