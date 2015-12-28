package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MngPreviousNews extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private static final int STEP = 50;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int nb = Integer.parseInt((String) request.getSession().getAttribute(
				"debutAfficNews"));
		nb -= STEP;
		int taille = ((ArrayList) getServletContext().getAttribute("news"))
				.size();
		if (nb < 0) {
			nb = taille - (taille % STEP);
		}
		request.getSession().setAttribute("debutAfficNews", String.valueOf(nb));
		response.sendRedirect("index.jsp");
	}
}