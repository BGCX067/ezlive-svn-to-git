package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseKeyWord;
import divers.Keyword;

public class Preview extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("preview", traiterPreview(session, request));
		response.sendRedirect("papers.jsp");
	}

	private String traiterPreview(HttpSession session,
			HttpServletRequest request) {
		ArrayList keys = new ArrayList();
		keys.addAll(traiterOldKeywords(session, request));
		keys.addAll(traiterNouveauxKeywords(session, request));

		for (int i = 0; i < keys.size(); ++i) {
			System.out.println("-" + ((String) keys.get(i)) + "-");
		}

		String res = "";
		res += traiterReference((String) request.getParameter("reference"),
				(String) request.getParameter("url"), session);
		session.setAttribute("newsKeyword", keys);
		String type = (String) request.getParameter("typeNews");
		res += "<p>Type: " + type + "</p>";
		session.setAttribute("type", type);
		String comment = (String) request.getParameter("comment");
		session.setAttribute("comment", comment);
		res += "<div>Comment: "
				+ comment.replaceAll("\n", "</div><div>").replaceAll(
						"<div>\r</div>", "") + "</div>";
		session
				.setAttribute(
						"suite",
						", and then <input class=\"bouton\"	type=\"submit\" value=\"go to the next step\">");
		return res;
	}

	private ArrayList traiterOldKeywords(HttpSession session,
			HttpServletRequest request) {
		String[] keys = request.getParameterValues("listeKeywords");
		ArrayList keyz = new ArrayList();
		for (int i = 0; keys != null && i < keys.length; ++i) {
			keyz.add(keys[i]);
		}
		return keyz;
	}

	private ArrayList traiterNouveauxKeywords(HttpSession session,
			HttpServletRequest request) {
		String[] newKeywords = ((String) request.getParameter("newKeywords"))
				.split(";");
		ArrayList newKeys = new ArrayList();
		ArrayList keywords = (ArrayList) getServletContext().getAttribute(
				"keywords");
		ArrayList existants = new ArrayList();
		for (int i = 0; i < keywords.size(); ++i) {
			existants.add(((Keyword) keywords.get(i)).getNom());
		}

		for (int i = 0; i < newKeywords.length; ++i) {
			String key = newKeywords[i].trim();
			if (!key.equals("") && (!contains(key, existants))) {
				newKeys.add(key);
				existants.add(key);
			}
		}
		// dans newKeys on a les nouveaux mots à ajouter en base
		DataBaseKeyWord bd = new DataBaseKeyWord();
		bd.ajout(newKeys);
		getServletContext().setAttribute("keywords", bd.tabKeyword());
		return newKeys;
	}

	private boolean contains(String key, ArrayList existants) {
		boolean ok = false;
		for (int i = 0; ok == false && i < existants.size(); ++i) {
			String mot = (String) existants.get(i);
			ok = mot.equals(key);
		}
		return ok;
	}

	private String traiterReference(String reference, String url,
			HttpSession session) {
		String res = "<p>Title: ";
		session.setAttribute("url", url);
		session.setAttribute("reference", reference);
		String titre;
		if (reference.equals("")) {
			titre = "No Title ...";
			session.setAttribute("reference", titre);
		} else {
			titre = reference;
		}
		if (url.equals("")) {
			res += titre;
		} else {
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
			res += "<a href=\"" + url + "\">";
			res += titre + "</a>";
		}
		res += "</p>";
		return res;
	}
}
