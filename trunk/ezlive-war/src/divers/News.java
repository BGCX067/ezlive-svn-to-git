package divers;

import database.DataBaseNews;

public class News {
	private int type;

	private int author;

	private String date;

	private String reference;

	private String comment;

	private String url;

	private int hits;

	private int id;

	public int getId() {
		return id;
	}

	public int getHits() {
		return hits;
	}

	public News(int id, String reference, String url, String comment,
			int author, String date, int type) {
		this.url = url;
		this.date = date;
		this.author = author;
		this.reference = reference;
		this.comment = comment;
		this.hits = 0;
		this.id = id;
	}

	public News(int id, String reference, String url, String comment,
			int author, String date, int type, int hits) {
		this.url = url;
		this.date = date;
		this.author = author;
		this.reference = reference;
		this.comment = comment;
		this.hits = hits;
		this.id = id;
	}

	public News(String reference, String url, String comment, int author,
			String date, int type) {
		id = new DataBaseNews().getLastId();
		this.url = url;
		this.date = date;
		this.author = author;
		this.reference = reference;
		this.comment = comment;
		this.hits = 0;
	}

	public News(String reference, String url, String comment, int author,
			String date, int type, int hits) {
		this.url = url;
		this.date = date;
		this.author = author;
		this.reference = reference;
		this.comment = comment;
		this.hits = hits;
	}

	public int getAuthor() {
		return author;
	}

	public String getComment() {
		return comment;
	}

	public String getReference() {
		return reference;
	}

	public String getDate() {
		return date;
	}

	public int getType() {
		return type;
	}

	public String getUrl() {
		return url;
	}

	public void addHit() {
		++hits;
	}
}
