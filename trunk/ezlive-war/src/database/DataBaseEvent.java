package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import divers.Event;
import divers.MngEvent;

public class DataBaseEvent extends DataBase<MngEvent> {

	private static final String DELETE = "DELETE FROM event WHERE event_id = '";

	public void ajout(MngEvent event) {
		String requete = "INSERT INTO event";
		requete += "(event_name, event_url, event_date)";
		requete += " VALUES ('" + event.getNom() + "','" + event.getUrl()
				+ "','" + event.getDate() + "')";
		open();
		requeteMaj(requete);
		close();
	}

	public List<MngEvent> allEvents() {
		open();
		String requete = "SELECT * FROM event ORDER by event_date";
		ResultSet res = execQuery(requete);
		try {
			List resultat = new ArrayList<MngEvent>();
			while (res.next()) {
				MngEvent event = new MngEvent(res.getInt(1), res.getString(2),
						res.getString(3), res.getString(4));
				resultat.add(event);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return Collections.emptyList();
	}

	public List<Event> tabEvents() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(new Date());
		open();
		String requete = "SELECT event_name, event_url, DATEDIFF(event_date,\""
				+ date + "\")";
		requete += "AS decompte FROM event where event_date > \"" + date + "\" ORDER by event_date";
		ResultSet res = execQuery(requete);
		try {
			List<Event> resultat = new ArrayList<Event>();
			while (res.next()) {
				Event event = new Event(res.getString(1), res.getString(2), res
						.getInt(3));
				resultat.add(event);
			}
			close();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return Collections.emptyList();
	}

	public int getLastId() {
		String requete = "SELECT event_id FROM event ORDER BY event_id DESC LIMIT 1";
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

	public MngEvent getEventById(String id) {
		String requete = "SELECT * FROM event WHERE event_id = " + id;
		MngEvent event = null;
		open();
		ResultSet res = execQuery(requete);
		try {
			while (res.next()) {
				event = new MngEvent(res.getInt(1), res.getString(2), res
						.getString(3), res.getString(4));
			}
			close();
			return event;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
		return null;
	}

	public void maj(String id, String nom, String url, String date) {
		String requete = "UPDATE event SET event_name = '" + nom
				+ "', event_url = '" + url + "', event_date = '" + date
				+ "' WHERE event_id = " + id;
		open();
		requeteMaj(requete);
		close();
	}
}
