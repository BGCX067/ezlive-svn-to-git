package balisesManager;

import java.util.ArrayList;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import database.DataBaseMailinfos;
import database.DataBaseNews;
import database.DataBaseUser;
import divers.News;

public class PrepareMail extends TagSupport {
	private static final long serialVersionUID = 1L;

	public int doStartTag() throws JspException {
		construireMail();
		return EVAL_BODY_INCLUDE;
	}

	private void construireMail() {
		String date = new DataBaseMailinfos().getLastDate();
		pageContext.setAttribute("date", date);
		preparerContenu(date);
		preparerUsers();
	}

	private void preparerUsers() {
		String liste = "";
		ArrayList mails = new DataBaseUser().getMailingList();
		for (int i = 1; i < mails.size(); ++i) {
			liste += (String) mails.get(i);
			if(i < mails.size() - 1) {
				liste += ", ";
			}
		}
		pageContext.setAttribute("mailingList", liste);
	}

	private void preparerContenu(String date) {
		String contenu = "";
		ArrayList newNews = new DataBaseNews().getNewsFrom(date);
		for (int i = 0; i < newNews.size(); ++i) {
			News niouze = (News) newNews.get(i);
			String titre = niouze.getReference();
			String dieses = addDieses(titre);
			contenu += dieses + "\n";
			contenu += "# " + titre + " #\n";
			contenu += dieses + "\n";
			contenu += "\nAdded by " + niouze.getAuthor() + " on "
					+ niouze.getDate() + "\n";
			contenu += niouze.getComment() + "\n\n\n";
		}
		pageContext.setAttribute("content", contenu);
	}

	private String addDieses(String titre) {
		String diese = "#";
		String resultat = "####";
		for (int i = 0; i < titre.length(); ++i) {
			resultat += diese;
		}
		return resultat;
	}

	public int doAfterBody() throws JspException {
		return SKIP_BODY;
	}
}
