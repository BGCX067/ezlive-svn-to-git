package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseUser;
import divers.News;

public class ListeNews extends TagSupport {
	private static final long serialVersionUID = 1L;

	private static int STEP = 10;

	private int debut;

	private ArrayList news = new ArrayList();

	private int ind;

	public int doStartTag() throws JspException {
		ind = Integer.parseInt((String) pageContext.getSession().getAttribute(
				"debutAffic"));
		debut = ind;
		news = (ArrayList) pageContext.getServletContext().getAttribute("news");
		News niouze = (News) news.get(ind);
		traiterNews(niouze);
		return EVAL_BODY_INCLUDE;
	}

	private void traiterNews(News niouze) {
		
		String url = niouze.getUrl();
		String reference = niouze.getReference();
		pageContext.setAttribute("realIdNews", String.valueOf(niouze.getId()));
		pageContext.setAttribute("idNews", Integer.valueOf(ind));
		pageContext.setAttribute("date", niouze.getDate());
		pageContext.setAttribute("type", String.valueOf(niouze.getType()));
		pageContext.setAttribute("url", url);
		if (!url.equals("")) {
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
			reference = "<a href=\"Redirection?href=" + niouze.getId() + "\">" + reference + "</a>";
		}
		pageContext.setAttribute("reference", reference);
		pageContext.setAttribute("comment", niouze.getComment());
		pageContext.setAttribute("author", new DataBaseUser()
				.getAuthorByID(niouze.getAuthor()));
		pageContext.setAttribute("hits", String.valueOf(niouze.getHits()));
	}

	public int doAfterBody() throws JspException {
		++ind;
		if ((ind < debut+STEP) && (ind < news.size())) {
			News niouze = (News) news.get(ind);
			traiterNews(niouze);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}
}
