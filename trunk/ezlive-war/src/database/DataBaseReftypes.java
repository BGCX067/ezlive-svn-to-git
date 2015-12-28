package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import divers.Reftype;

public class DataBaseReftypes extends DataBase {

	public void ajout(Object o) {
	}

	public ArrayList tabReftype() {
		ArrayList resultat = new ArrayList();
		String requete = "SELECT * FROM reftypes";
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				Reftype ref = new Reftype(res.getInt(1), res.getString(2));
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

	public int getId(String type) {
		int resultat = 0;
		String requete = "SELECT reftype_id FROM reftypes WHERE reftype_name='"
				+ type + "'";
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
}
