package divers;

import java.io.Serializable;

import database.DataBaseUser;

public class People implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String firstName;

	private String mail;

	private String homepage;

	private String affiliation;

	private int pays;

	private String info;

	private String display;

	public People(int id, String firstName, String mail, String homepage,
			String affiliation, int pays, String info, String display) {
		this.id = id;
		if (firstName == null) {
			this.firstName = "";
		} else {
			this.firstName = firstName;
		}
		this.mail = mail;
		this.homepage = homepage;
		this.affiliation = affiliation;
		this.pays = pays;
		if (info == null) {
			this.info = "false";
		} else {
			this.info = info;
		}
		if (display == null) {
			this.display = "false";
		} else {
			this.display = display;
		}
	}

	public People(String firstName, String mail, String homepage,
			String affiliation, int pays, String info, String display) {
		id = new DataBaseUser().getLastId();
		if (firstName == null) {
			this.firstName = "";
		} else {
			this.firstName = firstName;
		}
		this.mail = mail;
		this.homepage = homepage;
		this.affiliation = affiliation;
		this.pays = pays;
		if (info == null) {
			this.info = "false";
		} else {
			this.info = info;
		}
		if (display == null) {
			this.display = "false";
		} else {
			this.display = display;
		}
	}

	public String getAffiliation() {
		return affiliation;
	}

	public String getDisplay() {
		return display;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getInfo() {
		return info;
	}

	public String getMail() {
		return mail;
	}

	public int getPays() {
		return pays;
	}

	public String toString() {
		return firstName + "|" + mail + "|" + homepage + "|" + affiliation
				+ "|" + pays + "|" + info + "|" + display;
	}

	public int getId() {
		return id;
	}

}
