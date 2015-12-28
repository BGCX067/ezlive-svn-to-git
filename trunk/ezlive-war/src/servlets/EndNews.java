package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EndNews extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private static final int STEP = 10;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int taille = ((ArrayList) getServletContext().getAttribute("news"))
				.size();
		int nb = taille - (taille % STEP);
		request.getSession().setAttribute("debutAffic", String.valueOf(nb));
		response.sendRedirect("satnews.jsp");
	}
}