package divers;

public class NewsKeyword {
	private int news_id;

	private int keyword_id;

	public NewsKeyword(int news_id, int keyword_id) {
		this.news_id = news_id;
		this.keyword_id = keyword_id;
	}

	public int getKeyword_id() {
		return keyword_id;
	}

	public int getNews_id() {
		return news_id;
	}

	public String toString() {
		return "news_id " + news_id + " keyword_id " + keyword_id;
	}
}