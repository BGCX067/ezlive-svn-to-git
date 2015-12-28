package divers;

public class Country {
	private int id;

	private String nom;

	public Country(int id, String nom) {
		this.nom = nom;
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return nom;
	}
}
