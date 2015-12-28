package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import divers.Keyword;

public class DataBaseKeyWord extends DataBase {
	private static final String INSERT_INTO_KEYWORD = "INSERT INTO keyword (keyword_word) VALUES('";

	private static final String DELETE = "DELETE FROM keyword WHERE keyword_id = '";

	public void ajout(Object o) {
		ArrayList tab = (ArrayList) o;
		String requete = "";
		for (int i = 0; i < tab.size(); ++i) {
			requete = INSERT_INTO_KEYWORD + tab.get(i) + "');";
			open();
			requeteMaj(requete);
			close();
		}
	}

	public void ajout(String word) {
		String requete = INSERT_INTO_KEYWORD + word + "');";
		open();
		requeteMaj(requete);
		close();
	}

	public boolean isInBase(String key) {
		boolean resultat = false;
		open();
		ResultSet res = execQuery("SELECT * FROM keyword WHERE keyword_word = '"
				+ key + "';");
		try {
			if (res.next()) {
				resultat = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return resultat;
	}

	public ArrayList tabKeyword() {
		ArrayList resultat = new ArrayList();
		open();
		String requete = "SELECT keyword_id, UPPER(keyword_word) FROM keyword ORDER BY UPPER(keyword_word)";
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				Keyword word = new Keyword(res.getInt(1), res.getString(2));
				resultat.add(word);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return resultat;
	}

	public int getId(String word) {
		int resultat = 0;
		open();
		String requete = "SELECT keyword_id FROM keyword where keyword_word='"
				+ word + "'";
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

	public String getWord(String tmp) {
		int id = Integer.parseInt(tmp);
		String requete = "SELECT keyword_word FROM keyword where keyword_id="
				+ id;
		String resultat = "";
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				resultat = res.getString(1);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return resultat;
	}

	public int getLastId() {
		String requete = "SELECT keyword_id FROM keyword ORDER BY keyword_id DESC LIMIT 1";
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
		return 0;
	}

	public void suppression(String[] listeIds) {
		if (listeIds.length == 0)
			return;
		else {
			String requete = "";
			for (int i = listeIds.length - 1; i >= 0; --i) {
				requete = DELETE + listeIds[i] + "';";
				open();
				requeteMaj(requete);
				close();
			}
		}
	}

	public Keyword getKeywordById(String id) {
		String requete = "SELECT * FROM keyword WHERE keyword_id=" + id;
		Keyword key = null;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				key = new Keyword(res.getString(2));
			}
			close();
			return key;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return null;
	}

	public void maj(String id, String word) {
		String requete = "UPDATE keyword SET keyword_word = '" + word
				+ "' WHERE keyword_id = " + id;
		open();
		requeteMaj(requete);
		close();
	}
}
