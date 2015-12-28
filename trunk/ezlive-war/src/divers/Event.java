package divers;

public class Event {
	private String nom;

	private String url;

	private int deadline;

	public Event(String nom, String url, int deadline) {
		this.nom = nom;
		this.url = url;
		this.deadline = deadline;
	}

	public String getUrl() {
		return url;
	}

	public int getDeadline() {
		return deadline;
	}

	public String getNom() {
		return nom;
	}
}
