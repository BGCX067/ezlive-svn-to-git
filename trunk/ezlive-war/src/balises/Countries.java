package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Country;

public class Countries extends TagSupport {

	private static final long serialVersionUID = 1L;

	private ArrayList pays;

	private int idPays;

	private String selected = "Afghanistan";

	public int doStartTag() throws JspException {
		idPays = 0;
		pays = (ArrayList) pageContext.getServletContext().getAttribute(
				"countries");
		pageContext.setAttribute("id", Integer.valueOf(idPays));
		pageContext.setAttribute("pays", ((Country) pays.get(idPays)).getNom());
		traiterSelection();
		return EVAL_BODY_INCLUDE;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	private void traiterSelection() {
		if (selected.equals(pays.get(idPays))) {
			pageContext.setAttribute("selected", "selected=\"selected\"");
		} else {
			pageContext.setAttribute("selected", "");
		}
	}

	public int doAfterBody() throws JspException {
		++idPays;
		int retour = EVAL_BODY_AGAIN;
		if (idPays == pays.size()) {
			return SKIP_BODY;
		}
		pageContext.setAttribute("id", Integer.valueOf(idPays));
		pageContext.setAttribute("pays", ((Country) pays.get(idPays)).getNom());
		traiterSelection();
		return retour;
	}

}
