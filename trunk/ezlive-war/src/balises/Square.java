package balises;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Square extends TagSupport {

	private static final long serialVersionUID = 1L;

	private int square, from, to, number;

	public int getNumber() {
		return number;
	}

	public int getSquare() {
		return square;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public int doStartTag() throws JspException {
		try {
			number = from;
			square = number * number;
			
			pageContext.setAttribute("number", Integer.valueOf(number));
			pageContext.setAttribute("square", Integer.valueOf(square));
		} catch (Exception e) {
			System.err.println("Erreur dans le do start tag");
		}
		return EVAL_BODY_INCLUDE;
	}

	public int doAfterBody() throws JspException {
		if (number < to) {
			++number;
			square = number * number;
			pageContext.setAttribute("number", Integer.valueOf(number));
			pageContext.setAttribute("square", Integer.valueOf(square));
			return EVAL_BODY_AGAIN;
		}
		return SKIP_BODY;
	}
}
