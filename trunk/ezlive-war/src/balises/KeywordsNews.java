package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Keyword;
import divers.NewsKeyword;

public class KeywordsNews extends TagSupport {

	private static final long serialVersionUID = 1L;

	private int idNews;

	private int nb;

	private ArrayList keys;

	private ArrayList AllKeywords;

	public int doStartTag() throws JspException {
		stockerKeywords();
		nb = 0;
		keys = new ArrayList();
		String realId = (String) pageContext.getAttribute("realIdNews");
		idNews = Integer.parseInt(realId);
		traiterKeys((ArrayList) pageContext.getServletContext().getAttribute(
				"newsKeyword"));
		traiterKeywords();
		return EVAL_BODY_INCLUDE;
	}

	private void stockerKeywords() {
		AllKeywords = (ArrayList) pageContext.getServletContext().getAttribute(
				"keywords");
	}

	private String getKeyword(int id) {
		String resultat = "";
		for (int i = 0; i < AllKeywords.size(); ++i) {
			Keyword kwd = (Keyword) AllKeywords.get(i);
			if (id == kwd.getId()) {
				resultat = kwd.getNom();
				break;
			}
		}
		return resultat;
	}

	private void traiterKeywords() {
		if (keys != null && !keys.isEmpty()) {
			int myId = Integer.parseInt((String) keys.get(nb));
			pageContext.setAttribute("keyword", getKeyword(myId));
			pageContext.setAttribute("idKeyword", String.valueOf(myId));
		}
	}

	private void traiterKeys(ArrayList allNewsKeywords) {
		for (int i = 0; i < allNewsKeywords.size(); ++i) {
			NewsKeyword nkwd = (NewsKeyword) allNewsKeywords.get(i);
			if (nkwd.getNews_id() == idNews) {
				keys.add(String.valueOf(nkwd.getKeyword_id()));
			}
		}
	}

	public int doAfterBody() throws JspException {
		++nb;
		if (nb >= keys.size()) {
			return SKIP_BODY;
		}
		idNews = Integer.parseInt((String) pageContext
				.getAttribute("realIdNews"));
		traiterKeywords();
		return EVAL_BODY_AGAIN;
	}
}
