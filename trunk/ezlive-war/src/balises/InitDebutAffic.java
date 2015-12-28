package balises;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class InitDebutAffic extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		if (pageContext.getSession().getAttribute("debutAffic") == null) {
			pageContext.getSession().setAttribute("debutAffic",
					String.valueOf(0));
		}
		if (pageContext.getSession().getAttribute("debutAfficNews") == null) {
			pageContext.getSession().setAttribute("debutAfficNews",
					String.valueOf(0));
		}
		if (pageContext.getSession().getAttribute("debutAfficUsers") == null) {
			pageContext.getSession().setAttribute("debutAfficUsers",
					String.valueOf(0));
		}
		return SKIP_BODY;
	}
}
