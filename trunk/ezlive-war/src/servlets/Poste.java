package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseKeyWord;
import database.DataBaseNews;
import database.DataBaseRefKeywords;
import divers.News;
import divers.NewsKeyword;

public class Poste extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DataBaseNews bd;

	public void init() throws ServletException {
		bd = new DataBaseNews();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ajouterNews(session, request);
		response.sendRedirect("index.jsp");
	}

	private void ajouterNews(HttpSession session, HttpServletRequest request) {

		ArrayList lastNews = (ArrayList) getServletContext().getAttribute(
				"lastNews");
		ArrayList news = (ArrayList) getServletContext().getAttribute("news");
		News niouze = traiterNews(session);

		news.add(0, niouze);
		lastNews.add(0, niouze);
		bd.ajout(niouze);
		if (lastNews.size() > 10) {
			lastNews.remove(lastNews.size() - 1);
		}

		getServletContext().setAttribute("lastNews", lastNews);
		getServletContext().setAttribute("news", news);

		int nb = Integer.parseInt((String) getServletContext().getAttribute(
				"nbNews"));
		getServletContext().setAttribute("nbNews", String.valueOf(nb + 1));
		int idNews = 1 + nb;
		ArrayList refKeyzGlobal = (ArrayList) getServletContext().getAttribute(
				"newsKeyword");
		ArrayList refKeys = (ArrayList) session.getAttribute("newsKeyword");
		DataBaseRefKeywords bdNkw = new DataBaseRefKeywords();
		DataBaseKeyWord bd = new DataBaseKeyWord();

		for (int i = 0; i < refKeys.size(); ++i) {
			NewsKeyword nkw = new NewsKeyword(idNews, bd.getId((String) refKeys
					.get(i)));
			refKeyzGlobal.add(nkw);
			bdNkw.ajout(nkw);
		}

		getServletContext().setAttribute("newsKeyword", refKeyzGlobal);
		nettoyerSession(session);
	}

	private News traiterNews(HttpSession session) {
		String date = (String) session.getAttribute("date");
		int type = 0;
		if (session.getAttribute("type") != null) {
			type = (int) Integer
					.parseInt((String) session.getAttribute("type"));
		}
		int author = Integer.parseInt((String) session.getAttribute("idUser"));
		String reference = (String) session.getAttribute("reference");
		String url = (String) session.getAttribute("url");
		String comment = (String) session.getAttribute("comment");
		return new News(reference, url, comment.replaceAll(
				"<script.+?</script>", " ").replaceAll("'", "\'"), author,
				date, type);
	}

	private void nettoyerSession(HttpSession session) {
		session.removeAttribute("refNews");
		session.removeAttribute("date");
		session.removeAttribute("type");
		session.removeAttribute("author");
		session.removeAttribute("reference");
		session.removeAttribute("url");
		session.removeAttribute("comment");
		session.removeAttribute("preview");
		session.removeAttribute("newsKeyword");
	}
}