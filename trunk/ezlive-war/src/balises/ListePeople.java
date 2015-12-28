package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Country;
import divers.People;

public class ListePeople extends TagSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList users = new ArrayList();

	private int ind;

	public int doStartTag() throws JspException {
		ind = 0;
		users = (ArrayList) pageContext.getServletContext().getAttribute(
				"users2display");
		if (users == null) {
			return SKIP_BODY;
		}
		People gens = (People) users.get(ind);
		pageContext.setAttribute("typeLigne", "paire");
		traiter(gens);
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		++ind;
		if (ind % 2 == 1) {
			pageContext.setAttribute("typeLigne", "impaire");
		} else {
			pageContext.setAttribute("typeLigne", "paire");
		}
		if (ind < users.size()) {
			People gens = (People) users.get(ind);
			traiter(gens);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	private void traiter(People gens) {
		String name = gens.getFirstName();
		if (name == null || name.equals("")) {
			name = "Not provided";
		}
		String homepage = gens.getHomepage();
		if (homepage != null) {
			name = "<a href=\"" + homepage.replaceAll(" ", "_") + "\">" + name
					+ "</a>";
		}
		pageContext.setAttribute("pplname", name);
		pageContext.setAttribute("pplmail", gens.getMail().replaceAll("@",
				" AT "));
		String affiliation = gens.getAffiliation();
		if (affiliation != null) {
			affiliation = affiliation.replaceAll("&[^#]", "&amp;");
		}
		pageContext.setAttribute("pplaffiliation", affiliation);

		if (gens.getPays() != 0) {
			String pays = ((Country) ((ArrayList) pageContext
					.getServletContext().getAttribute("countries")).get(gens
					.getPays() - 1)).getNom();
			pageContext.setAttribute("pplcountry", pays);
		} else {
			pageContext.setAttribute("pplcountry", "");
		}
	}
}
