package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBaseNews;
import divers.News;

public class Redirection extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	private DataBaseNews bd;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		bd = new DataBaseNews();
		int idNews = Integer.parseInt(request.getParameter("href"));
		ArrayList news = (ArrayList) getServletContext().getAttribute("news");
		ArrayList lastNews = (ArrayList) getServletContext().getAttribute(
				"lastNews");
		ArrayList mostClicked = (ArrayList) getServletContext().getAttribute(
				"mostClicked");
		boolean ok = false;
		News niouze = null;
		for (int i = 0; ok == false && i < news.size(); ++i) {
			News n = (News) news.get(i);
			if (n.getId() == idNews) {
				ok = true;
				niouze = n;
			}
		}
		String url = "error404.jsp";
		if (niouze != null) {
			niouze.addHit();
			int id = niouze.getId();
			ok = false;
			for (int i = 0; ok == false && i < lastNews.size(); ++i) {
				niouze = (News) lastNews.get(i);
				if (id == niouze.getId()) {
					ok = true;
					url = niouze.getUrl();
					if (!url.startsWith("http://")) {
						url = "http://" + url;
					}
					niouze.addHit();
				}
			}
			ok = false;
			for (int i = 0; ok == false && i < mostClicked.size(); ++i) {
				niouze = (News) mostClicked.get(i);
				if (id == niouze.getId()) {
					ok = true;
					url = niouze.getUrl();
					if (!url.startsWith("http://")) {
						url = "http://" + url;
					}
					niouze.addHit();
				}
			}
			bd.majHit(id, niouze.getHits());
		}
		response.sendRedirect(url);
	}
}