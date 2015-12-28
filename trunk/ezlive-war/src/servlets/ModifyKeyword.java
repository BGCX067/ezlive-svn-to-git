package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseKeyWord;

public class ModifyKeyword extends javax.servlet.http.HttpServlet implements
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
			String id = (String) request.getSession().getAttribute("idEditKeyword");
			String word = (String) request.getParameter("word");
			new DataBaseKeyWord().maj(id, word);
			reinitialiserEdition(request);
		}
		response.sendRedirect("index.jsp");
	}

	private void cancel(HttpServletRequest request) {
		request.getSession().setAttribute("idEditKeyword", null);
	}

	private void reinitialiserEdition(HttpServletRequest request) {
		request.getSession().setAttribute("idEditKeyword", null);
		getServletContext().setAttribute("keywords", null);
	}
}