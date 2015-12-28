package balisesManager;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.MngEvent;

public class MngListeEvents extends TagSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList events;

	private int idNews;

	public int doStartTag() throws JspException {
		events = (ArrayList) pageContext.getServletContext().getAttribute(
				"allEvents");
		idNews = 0;
		traiterLigne();
		traiterEvent();
		return EVAL_BODY_INCLUDE;
	}

	private void traiterEvent() {
		MngEvent event = (MngEvent) events.get(idNews);
		pageContext.setAttribute("idEvent", String.valueOf(event.getId()));
		pageContext.setAttribute("name", event.getNom());
		pageContext.setAttribute("url", event.getUrl());
		pageContext.setAttribute("date", event.getDate());
	}

	private void traiterLigne() {
		String parite = "paire";
		if (idNews % 2 == 1) {
			parite = "im" + parite;
		}
		pageContext.setAttribute("typeLigne", parite);
	}

	public int doAfterBody() throws JspException {
		++idNews;
		int retour = EVAL_BODY_AGAIN;
		if (idNews == events.size() - 1) {
			retour = SKIP_BODY;
		}
		traiterLigne();
		traiterEvent();
		return retour;
	}
}
