package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import divers.NewsKeyword;

public class DataBaseRefKeywords extends DataBase {

	private static final String INSERT_INTO_REF_KEYWORDS = "INSERT INTO news_keyword (news_id, keyword_id) VALUES('";

	public void ajout(Object o) {
		NewsKeyword newsKw = (NewsKeyword) o;
		String requete = INSERT_INTO_REF_KEYWORDS + newsKw.getNews_id()
				+ "', '" + newsKw.getKeyword_id() + "');";
		open();
		requeteMaj(requete);
		close();
	}

	public ArrayList tabNewsKeyword() {
		ArrayList resultat = new ArrayList();
		open();
		String requete = "SELECT * FROM news_keyword";
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				NewsKeyword ref = new NewsKeyword(res.getInt(1), res.getInt(2));
				resultat.add(ref);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return resultat;

	}
}
