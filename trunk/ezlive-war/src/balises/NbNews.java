package balises;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseNews;

public class NbNews extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		pageContext.setAttribute("nbNews", Integer.valueOf(new DataBaseNews()
				.nbNews()));
		return EVAL_BODY_INCLUDE;
	}
}
