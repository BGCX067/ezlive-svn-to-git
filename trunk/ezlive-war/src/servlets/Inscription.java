package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseUser;
import divers.People;

/**
 * Servlet implementation class for Servlet: Inscription
 * 
 */
public class Inscription extends HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private DataBaseUser bd;

	public void init() throws ServletException {
		bd = new DataBaseUser();
	}

	public Inscription() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean error = false;
		HttpSession session = request.getSession();
		traiterName(session, request.getParameter("name"));
		error |= traiterEmail(session, request.getParameter("email"));
		error |= traiterHomepage(session, request.getParameter("homepage"));
		traiterAffiliation(session, request.getParameter("affiliation"));
		traiterPays(session, request.getParameter("pays"));
		traiterInfo(session, request.getParameter("info"));
		traiterDisplay(session, request.getParameter("display"));

		if (error) {
			session.setAttribute("actionForm", "subscribe.jsp");
			session.setAttribute("valueBtn", "Correct");
		} else {
			ArrayList inscrits = (ArrayList) getServletContext().getAttribute(
					"users");
			ArrayList inscrits2display = (ArrayList) getServletContext()
					.getAttribute("users2display");
			People gens = new People(
					(request.getParameter("name").equals("")) ? null : request
							.getParameter("name"), request
							.getParameter("email"), request
							.getParameter("homepage"), request
							.getParameter("affiliation"), Integer.valueOf(
							request.getParameter("pays")).intValue(), request
							.getParameter("info"), request
							.getParameter("display"));
			bd.ajout(gens);
			inscrits.add(gens);
			getServletContext().setAttribute("users", inscrits);
			if (request.getParameter("display") != null) {
				inscrits2display.add(gens);
				getServletContext().setAttribute("users2display",
						inscrits2display);
			}
			request.getRequestDispatcher("Mail").include(request, response);
			session.setAttribute("actionForm", "accountMail.jsp");
			session.setAttribute("valueBtn", "Continue");
		}
		response.sendRedirect("subscribeVerif.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private boolean estMailValide(final String mail) {
		return mail.matches("\\w[\\w_-]*(\\.[\\w_-]+)*@\\w+(\\.[\\w_-]+)*")
				&& !existe(mail);
	}

	private boolean existe(String mail) {
		ArrayList users = (ArrayList) getServletContext().getAttribute("users");
		boolean ok = false;
		for (int i = 0; ok == false && i < users.size(); ++i) {
			People gens = (People) users.get(i);
			if (gens.getMail().equals(mail)) {
				ok = true;
			}
		}
		return ok;
	}

	private boolean estURLValide(final String url) {
		return url
				.matches("(http:\\/\\/)?[\\w-_]+(\\.[\\w-_]+)*(\\/[\\w-_]+)*(\\/~[\\w-_]+)?(\\/[\\w-_]+)*(\\.[a-zA-Z]+)?(\\/)?");
	}

	private void traiterAffiliation(HttpSession session, String affiliation) {
		session.setAttribute("affiliation", affiliation);
		if (affiliation == "") {
			session.setAttribute("resAffiliation",
					"You have entered no affiliation");
		} else {
			session.setAttribute("resAffiliation", "Your affiliation : "
					+ affiliation);
		}
	}

	private void traiterDisplay(HttpSession session, String display) {
		String negation = "";
		if (display == null) {
			negation = "not ";
		}
		session
				.setAttribute(
						"resDisplay",
						"You have "
								+ negation
								+ "choosen to display your informations on the \"People interested in SAT\" of the site");

	}

	private boolean traiterEmail(HttpSession session, String email) {
		boolean error = false;
		session.setAttribute("classEmail", "error");
		session.setAttribute("email", email);
		if (email == "") {
			session.setAttribute("resEmail", "Please enter your email");
			error = true;
		} else if (estMailValide(email)) {
			session.setAttribute("classEmail", "");
			session.setAttribute("resEmail", "Your email : " + email);
		} else {
			session.setAttribute("resEmail", "Your email : " + email
					+ " seems to be invalid");
			session.setAttribute("email", "");
			error = true;
		}
		return error;
	}

	private boolean traiterHomepage(HttpSession session, String homepage) {
		boolean error = false;
		session.setAttribute("classHomepage", "");
		session.setAttribute("homepage", "");
		if (estURLValide(homepage)) {
			if (!homepage.startsWith("http://")) {
				homepage = "http://" + homepage;
			}
			session.setAttribute("resHomepage", "Your homepage : " + homepage);
			session.setAttribute("homepage", homepage);
		} else {
			if (!homepage.equals("")) {
				session.setAttribute("classHomepage", "error");
				session.setAttribute("resHomepage",
						"The URL of your homepage : " + homepage
								+ " seems to be invalid");
				error = true;
			} else {
				session.setAttribute("resHomepage",
						"You have entered no homepage");
			}
		}
		return error;
	}

	private void traiterInfo(HttpSession session, String info) {
		String negation = "";
		if (info == null) {
			negation = "not ";
		}
		session
				.setAttribute(
						"resInfo",
						"You have "
								+ negation
								+ "choosen to receive an email when new papers are added on the site");
	}

	private void traiterName(HttpSession session, String name) {
		session.setAttribute("name", name);
		session.setAttribute("className", "");
		if (name == "") {
			session.setAttribute("resName", "You have not provided your name");
		} else {
			if (name.contains(">") || name.contains("<")) {
				session.setAttribute("className", "error");
				session.setAttribute("resName", "Your name : "
						+ name.replaceAll(">", "").replaceAll("<", "")
						+ "seems not to be valid");
			}
			session.setAttribute("resName", "Your name : " + name);
		}
	}

	private void traiterPays(HttpSession session, String pays) {
		session.setAttribute("country", pays);
		ArrayList countries = (ArrayList) getServletContext().getAttribute(
				"countries");
		session.setAttribute("resPays", "Your country : "
				+ countries.get(Integer.parseInt(pays)));
	}
}