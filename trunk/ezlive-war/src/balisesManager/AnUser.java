package balisesManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseCountry;
import database.DataBaseUser;
import divers.People;

public class AnUser extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		String id = (String) pageContext.getSession().getAttribute("idEditUser");
		People user = new DataBaseUser().getUserById(id);
		pageContext.setAttribute("name", user.getFirstName());
		pageContext.setAttribute("mail", user.getMail());
		pageContext.setAttribute("homepage", user.getHomepage());
		pageContext.setAttribute("affiliation", user.getAffiliation());
		String pays = new DataBaseCountry().getCountryById(user.getPays());
		pageContext.setAttribute("country", pays);
		String display = "";
		if (user.getDisplay().equals("true")) {
			display = "checked=\"checked\"";
		}
		pageContext.setAttribute("display", display);
		String info = "";
		if (user.getInfo().equals("true")) {
			info = "checked=\"checked\"";
		}
		pageContext.setAttribute("info", info);
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}
}
