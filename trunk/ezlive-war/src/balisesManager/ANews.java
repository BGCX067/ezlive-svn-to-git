package balisesManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseNews;
import divers.News;

public class ANews extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		String id = (String) pageContext.getSession().getAttribute("idEditNews");
		News niouze = new DataBaseNews().getNewsById(id);
		if (niouze == null) {
			return SKIP_BODY;
		}
		pageContext.setAttribute("title", niouze.getReference());
		pageContext.setAttribute("url", niouze.getUrl());
		pageContext.setAttribute("comment", niouze.getComment());
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}
}