package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMailinfos extends DataBase {

	public void ajout(Object o) {

	}

	public String getLastDate() {
		String requete = "SELECT mailinfos_date FROM mailinfos ORDER BY mailinfos_date DESC LIMIT 1";
		String date = null;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				date = res.getString(1);
			}
			close();
			return date;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return date;
	}

}
