package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseKeyWord;
import database.DataBaseNews;

public class NbNewsKeyword extends TagSupport {
	private static final long serialVersionUID = 1L;

	private int keyword;

	private String type;

	private String classement;

	public int doStartTag() throws JspException {
		type = pageContext.getRequest().getParameter("refType");
		if (type == null
				|| ((!type.equals("All")) && (!type.equals("Announcement")))) {
			type = "All";
		}
		classement = pageContext.getRequest().getParameter("orderby");
		if (classement == null
				|| ((!classement.equals("date")) && (!classement.equals("hits")))) {
			classement = "date";
		}
		String tmp = pageContext.getRequest().getParameter("kwd");
		if (tmp != null) {
			pageContext.setAttribute("keyword", new DataBaseKeyWord()
					.getWord(tmp));
			int nb = 1;
			if (tmp != null) {
				try {
					nb = Integer.parseInt(tmp);
				} catch (NumberFormatException e) {
					nb = 1;
				}
			}
			keyword = nb;
			ArrayList tab = new DataBaseNews().tabKeyword(keyword, type,
					classement);
			pageContext.setAttribute("tmpNews", tab);
			pageContext.setAttribute("nbNews", String.valueOf(tab.size()));
		}
		return EVAL_BODY_INCLUDE;
	}
}
