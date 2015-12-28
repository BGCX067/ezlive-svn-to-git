package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Keyword;

public class Keywords extends TagSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList keywords;

	private int idKeyword;

	public int doStartTag() throws JspException {
		keywords = (ArrayList) pageContext.getServletContext().getAttribute(
				"keywords");
		idKeyword = 0;
		pageContext.setAttribute("id", String.valueOf(((Keyword) keywords
				.get(idKeyword)).getId()));
		pageContext.setAttribute("keyword", ((Keyword) keywords.get(idKeyword))
				.getNom());
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		++idKeyword;
		int retour = EVAL_BODY_AGAIN;
		if (idKeyword == keywords.size() - 1) {
			retour = SKIP_BODY;
		}
		pageContext.setAttribute("id", String.valueOf(((Keyword) keywords
				.get(idKeyword)).getId()));
		pageContext.setAttribute("keyword", ((Keyword) keywords.get(idKeyword))
				.getNom());
		return retour;
	}
}
