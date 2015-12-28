package balisesManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseKeyWord;
import divers.Keyword;

public class AKeyword extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		String id = (String) pageContext.getSession().getAttribute("idEditKeyword");
		Keyword key = new DataBaseKeyWord().getKeywordById(id);
		if (key == null) {
			return SKIP_BODY;
		}
		pageContext.setAttribute("word", key.getNom());
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}
}
