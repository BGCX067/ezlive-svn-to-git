package balisesManager;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Keyword;

public class MngListeKeywords extends TagSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList keywords;

	private int idKeyword;

	public int doStartTag() throws JspException {
		keywords = (ArrayList) pageContext.getServletContext().getAttribute(
				"keywords");
		idKeyword = 0;
		traiterLigne();
		traiterKeyword();
		return EVAL_BODY_INCLUDE;
	}

	private void traiterKeyword() {
		pageContext.setAttribute("idKey", String.valueOf(((Keyword) keywords
				.get(idKeyword)).getId()));
		pageContext.setAttribute("keyword", ((Keyword) keywords.get(idKeyword))
				.getNom());
	}

	private void traiterLigne() {
		String parite = "paire";
		if (idKeyword % 2 == 1) {
			parite = "im" + parite;
		}
		pageContext.setAttribute("typeLigne", parite);
	}

	public int doAfterBody() throws JspException {
		++idKeyword;
		int retour = EVAL_BODY_AGAIN;
		if (idKeyword == keywords.size() - 1) {
			retour = SKIP_BODY;
		}
		traiterLigne();
		traiterKeyword();
		return retour;
	}
}
