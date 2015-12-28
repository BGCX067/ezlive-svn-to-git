package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseNews;
import database.DataBaseReftypes;

public class NbNewsType extends TagSupport {
	private static final long serialVersionUID = 1L;

	private int type;

	private String classement;

	private static final String ORDER = " ORDER BY ";

	private static final String DESC = " DESC";

	private static final String CHECKED = "checked=\"checked\"";

	public void setType(String type) {

		this.type = new DataBaseReftypes().getId(type);
	}

	public int doStartTag() throws JspException {
		traiterReftypes();
		traiterClassement();
		ArrayList news = new DataBaseNews().newsTypes(type, ORDER + "news_"
				+ classement + DESC);
		pageContext.setAttribute("tmpNews", news);
		pageContext.setAttribute("nbNews", Integer.valueOf(news.size()));
		return EVAL_BODY_INCLUDE;
	}

	private void traiterClassement() {
		classement = (String) pageContext.getRequest().getParameter("orderBy");
		if (classement == null) {
			classement = "hits";
		}
		if (classement.equals("hits")) {
			pageContext.setAttribute("checkedHits", CHECKED);
			pageContext.setAttribute("checkedDate", "");
		} else {
			pageContext.setAttribute("checkedDate", CHECKED);
			pageContext.setAttribute("checkedHits", "");
		}
	}

	private void traiterReftypes() {
		String refType = (String) pageContext.getRequest().getParameter(
				"refType");
		type = new DataBaseReftypes().getId(refType);
		pageContext.setAttribute("refType", refType);
	}
}
