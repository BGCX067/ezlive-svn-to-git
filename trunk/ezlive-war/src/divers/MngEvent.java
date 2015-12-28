package divers;

public class MngEvent {
	private String nom;

	private String url;

	private int id;

	private String date;

	public String getUrl() {
		return url;
	}

	public String getDate() {
		return date;
	}

	public String getNom() {
		return nom;
	}

	public MngEvent(int id, String nom, String url, String date) {
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.date = date;
	}

	public int getId() {
		return id;
	}
}
