package balises;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Date;

public class MyDate extends TagSupport {

	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		String[] tab = new Date().toString().split(" ");
		String year = tab[5];
		String month = traiterMois(tab[1]);
		String day = tab[2];
		String date = year + "-" + month + "-" + day;
		pageContext.getSession().setAttribute("date", date);
		return EVAL_BODY_INCLUDE;
	}

	private String traiterMois(String mois2) {
		String mois = "01";
		if (mois2.equals("Feb")) {
			mois = "02";
		} else if (mois2.equals("Mar")) {
			mois = "03";
		} else if (mois2.equals("Apr")) {
			mois = "04";
		} else if (mois2.equals("May")) {
			mois = "05";
		} else if (mois2.equals("Jun")) {
			mois = "06";
		} else if (mois2.equals("Jul")) {
			mois = "07";
		} else if (mois2.equals("Aug")) {
			mois = "08";
		} else if (mois2.equals("Sep")) {
			mois = "09";
		} else if (mois2.equals("Oct")) {
			mois = "10";
		} else if (mois2.equals("Nov")) {
			mois = "11";
		} else if (mois2.equals("Dec")) {
			mois = "12";
		}
		return mois;
	}
}
