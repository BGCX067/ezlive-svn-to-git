package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseKeyWord;

public class AddKeyword extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traiterNouveauKeyword(request);
		reinitialiserKeywords();
		response.sendRedirect("admin.jsp");
	}

	private void traiterNouveauKeyword(HttpServletRequest request) {
		String word = request.getParameter("word");
		new DataBaseKeyWord().ajout(word);
	}

	private void reinitialiserKeywords() {
		getServletContext().setAttribute("keywords", null);
	}
}