package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseEvent;
import divers.MngEvent;

public class AddEvent extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		traiterNouveauEvent(request);
		reinitialiserEvent();
		response.sendRedirect("admin.jsp");
	}

	private void traiterNouveauEvent(HttpServletRequest request) {
		String name = request.getParameter("name");
		String url = request.getParameter("url");
		if (!url.startsWith("http://")) {
			url = "http://" + url;
		}
		String date = request.getParameter("date");
		new DataBaseEvent().ajout(new MngEvent(0, name, url, date));
	}

	private void reinitialiserEvent() {
		getServletContext().setAttribute("events", null);
		getServletContext().setAttribute("allEvents", null);
	}
}