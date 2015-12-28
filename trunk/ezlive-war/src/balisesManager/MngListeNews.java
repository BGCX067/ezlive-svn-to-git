package balisesManager;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.News;

public class MngListeNews extends TagSupport {
	private static final long serialVersionUID = 1L;

	private static final int LIMIT = 20;

	private ArrayList news;

	private int ind;

	private static int STEP = 50;

	private int debut;

	public int doStartTag() throws JspException {
		ind = Integer.parseInt((String) pageContext.getSession().getAttribute(
				"debutAfficNews"));
		news = (ArrayList) pageContext.getServletContext().getAttribute("news");
		debut = ind;
	
		if (news == null) {
			return SKIP_BODY;
		}
		News niouze = (News) news.get(debut);
		traiterLigne();
		traiter(niouze);
		return EVAL_BODY_INCLUDE;
	}

	private void traiterLigne() {
		String parite = "paire";
		if (ind % 2 == 1) {
			parite = "im" + parite;
		}
		pageContext.setAttribute("typeLigne", parite);
	}

	public int doAfterBody() throws JspException {
		++ind;
		traiterLigne();
		if ((ind < debut + STEP) && (ind < news.size())) {
			News niouze = (News) news.get(ind);
			traiter(niouze);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	private void traiter(News niouze) {
		pageContext.setAttribute("id", String.valueOf(ind));
		pageContext.setAttribute("idNews", String.valueOf(niouze.getId()));
		pageContext.setAttribute("reference", niouze.getReference());
		String comment = niouze.getComment();
		if (comment.length() >= LIMIT) {
			comment = comment.substring(0, LIMIT) + " ...";
		}
		pageContext.setAttribute("comment", comment);
	}
}
