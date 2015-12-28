package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseEvent;

public class ModifyEvent extends javax.servlet.http.HttpServlet implements
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
			String id = (String) request.getSession().getAttribute("idEditEvent");
			String nom = (String) request.getParameter("name");
			String url = (String) request.getParameter("url");
			String date = (String) request.getParameter("date");
			nom = nom.replaceAll("'", "''");
			new DataBaseEvent().maj(id, nom, url, date);
			reinitialiserEvent(request);
		}
		response.sendRedirect("index.jsp");
	}

	private void cancel(HttpServletRequest request) {
		request.getSession().setAttribute("idEditEvent", null);
	}

	private void reinitialiserEvent(HttpServletRequest request) {
		request.getSession().setAttribute("idEditEvent", null);
		getServletContext().setAttribute("allEvents", null);
		getServletContext().setAttribute("events", null);
	}
}