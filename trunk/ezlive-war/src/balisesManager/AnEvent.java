package balisesManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseEvent;
import divers.MngEvent;

public class AnEvent extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		String id = (String) pageContext.getSession().getAttribute("idEditEvent");
		MngEvent event = new DataBaseEvent().getEventById(id);
		pageContext.setAttribute("name", event.getNom());
		pageContext.setAttribute("url", event.getUrl());
		pageContext.setAttribute("date", event.getDate());
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}
}
