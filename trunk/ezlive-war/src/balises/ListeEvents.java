package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.Event;

public class ListeEvents extends TagSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList events;

	private int idEvent;

	public int doStartTag() throws JspException {
		events = (ArrayList) pageContext.getServletContext().getAttribute(
				"events");
		idEvent = 0;
		if (events == null) {
			return SKIP_BODY;
		}
		traiterEvent();
		return EVAL_BODY_INCLUDE;
	}

	private void traiterEvent() {
		String nom = ((Event) events.get(idEvent)).getNom();
		String url = ((Event) events.get(idEvent)).getUrl();
		if (url != null && !url.equals("")) {
			nom = "<a href=\"" + url + "\">" + nom + "</a>";
		}
		pageContext.setAttribute("name", nom);
		pageContext.setAttribute("deadline", String.valueOf(((Event) events
				.get(idEvent)).getDeadline()));
	}

	public int doAfterBody() throws JspException {
		++idEvent;
		if (idEvent == events.size()) {
			return SKIP_BODY;
		}
		traiterEvent();
		return EVAL_BODY_AGAIN;
	}
}
