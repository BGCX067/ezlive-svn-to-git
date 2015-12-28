package balises;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import divers.News;

public class MostClicked extends TagSupport {
	private static final long serialVersionUID = 1L;

	private ArrayList mostCLicked = new ArrayList();

	private int ind;

	public int doStartTag() throws JspException {
		ind = 0;
		mostCLicked = (ArrayList) pageContext.getServletContext().getAttribute(
				"mostClicked");
		News niouze = (News) mostCLicked.get(ind);
		traiterNews(niouze);
		return EVAL_BODY_INCLUDE;
	}

	private void traiterNews(News niouze) {
		String url = niouze.getUrl();
		String reference = niouze.getReference();
		if (!url.equals("")) {
			if (!url.startsWith("http://")) {
				url = "http://" + url;
			}
			reference = "<a href=\"Redirection?href=" + niouze.getId() + "\">" + reference + "</a>";
		}
		pageContext.setAttribute("reference", reference);
		pageContext.setAttribute("hits", String.valueOf(niouze.getHits()));
	}

	public int doAfterBody() throws JspException {
		++ind;
		if (ind < mostCLicked.size()) {
			News niouze = (News) mostCLicked.get(ind);
			traiterNews(niouze);
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}
	}
}
