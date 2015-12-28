package balisesManager;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Country;
import divers.People;

public class MngListePeople extends TagSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList users = new ArrayList();

	private int ind;

	private static int STEP = 50;

	private int debut;

	public int doStartTag() throws JspException {
		ind = Integer.parseInt((String) pageContext.getSession().getAttribute(
				"debutAfficUsers"));
		debut = ind;
		users = (ArrayList) pageContext.getServletContext().getAttribute(
				"users");
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
		if ((ind < debut + STEP) && (ind < users.size())) {
			People gens = (People) users.get(ind);
			traiter(gens);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}

	private void traiter(People gens) {
		pageContext.setAttribute("id", String.valueOf(ind));
		pageContext.setAttribute("idPeople", String.valueOf(gens.getId()));
		String name = gens.getFirstName();
		pageContext.setAttribute("name", name);
		pageContext.setAttribute("mail", gens.getMail());
		String affiliation = gens.getAffiliation();
		if (affiliation != null) {
			affiliation = affiliation.replaceAll("&[^#]", "&amp;");
		}
		pageContext.setAttribute("affiliation", affiliation);

		if (gens.getPays() != 0) {
			String pays = ((Country) ((ArrayList) pageContext
					.getServletContext().getAttribute("countries")).get(gens
					.getPays() - 1)).getNom();
			pageContext.setAttribute("pays", pays);
		} else {
			pageContext.setAttribute("pays", "");
		}
	}
}
