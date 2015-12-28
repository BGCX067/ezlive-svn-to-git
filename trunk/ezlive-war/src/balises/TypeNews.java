package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Reftype;

public class TypeNews extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String selected;

	private int idType;

	private ArrayList types;

	public int doStartTag() throws JspException {
		types = (ArrayList) pageContext.getServletContext().getAttribute(
				"reftypes");
		idType = 0;
		traiterType();
		return EVAL_BODY_INCLUDE;
	}

	private void traiterType() {
		String type = ((Reftype) types.get(idType)).getNom();
		pageContext.setAttribute("idType", String.valueOf(idType + 1));
		pageContext.setAttribute("type", type);
		traiterSelection(type);
	}

	public int doAfterBody() throws JspException {
		++idType;
		if (idType >= types.size()) {
			return SKIP_BODY;
		}
		traiterType();
		return EVAL_BODY_AGAIN;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	private void traiterSelection(String type) {
		if (type.equals(selected)) {
			pageContext.setAttribute("selected", "selected=\"selected\"");
		} else {
			pageContext.setAttribute("selected", "");
		}
	}
}
