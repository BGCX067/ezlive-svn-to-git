package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NextNews extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	private static final int STEP = 10;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int nb = STEP;
		nb += Integer.parseInt((String) request.getSession().getAttribute(
				"debutAffic"));
		int taille = ((ArrayList) getServletContext().getAttribute("news"))
				.size();
		if (nb >= taille) {
			nb = 0;
		}
		request.getSession().setAttribute("debutAffic", String.valueOf(nb));
		response.sendRedirect("satnews.jsp");
	}
}