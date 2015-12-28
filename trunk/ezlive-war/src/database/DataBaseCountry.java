package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import divers.Country;

public class DataBaseCountry extends DataBase<Country> {

	public void ajout(Country o) {
	}

	public List<Country> tabPays() {
		open();
		String requete = "SELECT * FROM country";
		ResultSet res = execQuery(requete);
		try {
			List<Country> resultat = new ArrayList<Country>();
			while (res.next()) {
				Country pays = new Country(res.getInt(1), res.getString(2));
				resultat.add(pays);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return Collections.emptyList();
	}

	public String getCountryById(int id) {
		String requete = "SELECT * FROM country WHERE country_id = " + id;
		String pays = null;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				pays = res.getString(2);
			}
			close();
			return pays;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return null;
	}
}
