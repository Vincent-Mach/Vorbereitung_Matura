package model;

import java.io.Serializable;

public class Unterricht implements Serializable {

	public int wochentag;
	public int einheit;
	public String klasse;
	public String fach;

	public Unterricht(int wochentag, int einheit, String klasse, String fach) {
		super();
		this.wochentag = wochentag;
		this.einheit = einheit;
		this.klasse = klasse;
		this.fach = fach;
	}

	public int getWochentag() {
		return wochentag;
	}

	public int getEinheit() {
		return einheit;
	}

	public String getKlasse() {
		return klasse;
	}

	public String getFach() {
		return fach;
	}

	public void setWochentag(int wochentag) {
		this.wochentag = wochentag;
	}

	public void setEinheit(int einheit) {
		this.einheit = einheit;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	@Override
	public String toString() {
		return "Unterricht [wochentag=" + wochentag + ", einheit=" + einheit
				+ ", klasse=" + klasse + ", fach=" + fach + "]";
	}
}
