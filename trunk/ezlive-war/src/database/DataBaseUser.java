package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import divers.People;

public class DataBaseUser extends DataBase {
	private static final String INSERT_INTO_USER = "INSERT INTO user (user_name, user_mail, user_homepage, user_affiliation, user_country, user_info, user_display) VALUES";

	private static final String DELETE = "DELETE FROM user WHERE user_id = '";

	public void ajout(Object o) {
		People gens = (People) o;
		String requete = INSERT_INTO_USER + "('" + gens.getFirstName() + "','"
				+ gens.getMail() + "','" + gens.getHomepage() + "','"
				+ gens.getAffiliation() + "','" + gens.getPays() + "','"
				+ gens.getInfo() + "','" + gens.getDisplay() + "')";
		open();
		requeteMaj(requete);
		close();
	}

	public String getAuthorByID(int id) {
		if (id == 0) {
			return "Deleted user";
		}
		open();
		ResultSet res = execQuery("SELECT user_name, user_mail, user_homepage FROM user WHERE user_id = "
				+ id);
		try {
			String resultat = "";
			while (res.next()) {
				resultat = res.getString(1);
				if (resultat == null || resultat.equals("")) {
					resultat = res.getString(2);
				}
				String url = res.getString(3);
				if (url != null && !url.equals("")) {
					if (!url.startsWith("http://")) {
						url = "http://" + url;
					}
					resultat = "<a href=\"" + url + "\">" + resultat + "</a>";
				}
			}

			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return "";
	}

	public void suppression(String[] userSup) {
		if (userSup.length == 0)
			return;
		else {
			String requete = "";
			for (int i = userSup.length - 1; i >= 0; --i) {
				requete = DELETE + userSup[i] + "';";
				open();
				requeteMaj(requete);
				close();
			}
		}
	}

	public int getIDByMail(String mail) {
		open();
		ResultSet res = execQuery("SELECT user_id FROM user WHERE user_mail = '"
				+ mail + "'");
		try {
			int resultat = 0;
			/**
			 * on suppose que le dernier mail identique est le bon
			 */
			while (res.next()) {
				resultat = res.getInt(1);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return 2;
	}

	private ArrayList traiterUsers(String requete) {
		ResultSet res = execQuery(requete);
		try {
			ArrayList resultat = new ArrayList();
			while (res.next()) {
				People gens = new People(res.getInt(1), res.getString(2), res
						.getString(3), res.getString(4), res.getString(5), res
						.getInt(6), res.getString(7), res.getString(8));
				resultat.add(gens);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList();
	}

	public ArrayList tabUser() {
		open();
		String requete = "SELECT * FROM user ORDER BY user_name";
		ArrayList tab = traiterUsers(requete);
		close();
		return tab;
	}

	public ArrayList tabUser2Display() {
		open();
		String requete = "SELECT * FROM user WHERE user_display='true' ORDER BY user_name";
		ArrayList tab = traiterUsers(requete);
		close();
		return tab;
	}

	public int getLastId() {
		String requete = "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1";
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

	public void maj(String id, String nom, String mail, String affiliation,
			String homepage, String country, String display, String info) {
		String requete = "UPDATE user SET user_name = '" + nom
				+ "', user_mail = '" + mail + "', user_affiliation = '"
				+ affiliation + "', user_homepage = '" + homepage
				+ "', user_country = '" + country + "', user_display = '"
				+ display + "', user_info = '" + info + "' WHERE user_id = "
				+ id;
		open();
		requeteMaj(requete);
		close();
	}

	public People getUserById(String id) {
		String requete = "SELECT * FROM user WHERE user_id = '" + id + "'";
		People user = null;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				user = new People(res.getString(2), res.getString(3), res
						.getString(4), res.getString(5), res.getInt(6), res
						.getString(7), res.getString(8));
			}
			close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return null;
	}

	public ArrayList getMailingList() {
		String requete = "SELECT user_mail FROM user WHERE user_info = 'true'";
		ArrayList mails = new ArrayList();
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				mails.add(res.getString(1));
			}
			close();
			return mails;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return mails;
	}
}
