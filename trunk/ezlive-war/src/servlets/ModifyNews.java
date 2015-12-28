package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseNews;

public class ModifyNews extends javax.servlet.http.HttpServlet implements
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
			String id = (String) request.getSession().getAttribute("idEditNews");
			String titre = (String) request.getParameter("title");
			String url = (String) request.getParameter("url");
			String comment = (String) request.getParameter("comment");
			titre = titre.replace("'", "''");
			comment = comment.replaceAll("'", "''");
			new DataBaseNews().maj(id, titre, url, comment);
			reinitialiserNews(request);
		}
		response.sendRedirect("index.jsp");
	}

	private void cancel(HttpServletRequest request) {
		request.getSession().setAttribute("idEditNews", null);
	}

	private void reinitialiserNews(HttpServletRequest request) {
		request.getSession().setAttribute("idEditNews", null);
		getServletContext().setAttribute("news", null);
		getServletContext().setAttribute("lastNews", null);
	}

}
