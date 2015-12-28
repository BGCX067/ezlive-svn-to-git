package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import divers.News;

public class DataBaseNews extends DataBase {
	private static final String INSERT_INTO_NEWS = "INSERT INTO news (news_title, news_url, news_comment, news_submitter, news_date, news_type, news_hits) VALUES";

	private static final String DELETE = "DELETE FROM news WHERE news_id='";;

	public void ajout(Object o) {
		News niouze = (News) o;
		String requete = INSERT_INTO_NEWS + "('" + niouze.getReference()
				+ "','" + niouze.getUrl() + "','" + niouze.getComment() + "','"
				+ niouze.getAuthor() + "','" + niouze.getDate() + "','"
				+ niouze.getType() + "','" + 0 + "')";
		open();
		requeteMaj(requete);
		close();
	}

	public void suppression(String[] niouzes) {
		if (niouzes.length == 0)
			return;
		else {
			String requete = "";
			for (int i = niouzes.length - 1; i >= 0; --i) {
				requete = DELETE + niouzes[i] + "';";
				open();
				requeteMaj(requete);
				close();
			}
		}
	}

	private ArrayList traiterNews(String requete) {
		ResultSet res = execQuery(requete);
		try {
			ArrayList resultat = new ArrayList();
			while (res.next()) {
				News niouze = new News(res.getInt(1), res.getString(2), res
						.getString(3), res.getString(4), res.getInt(5), res
						.getString(6), res.getInt(7), res.getInt(8));
				resultat.add(niouze);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}

	public ArrayList tabNews() {
		open();
		String requete = "SELECT * FROM news ORDER BY news_date DESC";
		ArrayList tab = traiterNews(requete);
		close();
		return tab;
	}

	public ArrayList newsTypes(int type, String order) {
		open();
		String requete = "SELECT * FROM news WHERE news_type = '" + type + "' "
				+ order;
		ArrayList tab = traiterNews(requete);
		close();
		return tab;
	}

	public ArrayList tabMostClicked() {
		open();
		String requete = "SELECT * FROM news ORDER BY news_hits DESC LIMIT 10";
		ArrayList tab = traiterNews(requete);
		close();
		return tab;
	}

	public int nbNews() {
		String requete = "SELECT count(news_id) FROM news";
		int resultat = 0;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				resultat = res.getInt(1);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return resultat;
	}

	public ArrayList tabLastNews() {
		open();
		String requete = "SELECT * FROM news ORDER BY news_date DESC LIMIT 10";
		ArrayList tab = traiterNews(requete);
		close();
		return tab;
	}

	public void majHit(int idNews, int hits) {
		String requete = "UPDATE news SET news_hits = " + hits
				+ " WHERE news_id = " + idNews;
		open();
		requeteMaj(requete);
		close();
	}

	public ArrayList tabKeyword(int keyword, String type, String classement) {
		String requete = "SELECT news.* FROM news, news_keyword WHERE news.news_id=news_keyword.news_id AND keyword_id="
				+ keyword;
		if (type.equals("Announcement")) {
			requete += " AND news_type=4";
		}
		requete += " ORDER BY news_" + classement;
		open();
		ArrayList tab = traiterNews(requete);
		close();
		return tab;
	}

	public int getLastId() {
		String requete = "SELECT news_id FROM `news` order by news_id DESC limit 1";
		int resultat = 0;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				resultat = res.getInt(1);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return resultat;
	}

	public News getNewsById(String id) {
		String requete = "SELECT * FROM news WHERE news_id=" + id;
		News niouze = null;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				niouze = new News(res.getString(2), res.getString(3), res
						.getString(4), res.getInt(5), res.getString(6), res
						.getInt(7));
			}
			close();
			return niouze;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return null;
	}

	public void maj(String id, String titre, String url, String comment) {
		String requete = "UPDATE news SET news_title = '" + titre
				+ "', news_url = '" + url + "', news_comment = '" + comment
				+ "' WHERE news_id = " + id;
		open();
		requeteMaj(requete);
		close();
	}

	public ArrayList getNewsFrom(String date) {
		String requete = "SELECT * FROM news WHERE news_date > '" + date + "'";
		open();
		ArrayList tab = traiterNews(requete);
		close();
		return tab;
	}
}
