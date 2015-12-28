package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class NbPeople extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		ArrayList inscrits = ((ArrayList) pageContext.getServletContext()
				.getAttribute("users2display"));
		int nbInscrits = 0;
		if (inscrits != null) {
			nbInscrits = inscrits.size();
		}
		pageContext.setAttribute("nbPeople", Integer.valueOf(nbInscrits));
		return EVAL_BODY_INCLUDE;
	}
}
