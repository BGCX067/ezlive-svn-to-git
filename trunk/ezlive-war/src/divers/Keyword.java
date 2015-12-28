package divers;

import database.DataBaseKeyWord;

public class Keyword {
	private int id;

	private String nom;

	public Keyword(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Keyword(String word) {
		nom=word;
		id=new DataBaseKeyWord().getLastId();
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
}
