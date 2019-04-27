package Kontrolatzailea;

import java.sql.Date;

public abstract class Pertsona {

	protected String nan, izena, abizenak, pasahitza;
	protected Date jaiotzeData;

	public Pertsona(String nan, String izena, String abizenak, Date jaiotzeData, String pasahitza) {
		this.nan = nan;
		this.izena = izena;
		this.abizenak = abizenak;
		this.jaiotzeData = jaiotzeData;
		this.pasahitza = pasahitza;
	}

	public String getNan() {
		return nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizenak() {
		return abizenak;
	}

	public void setAbizena(String abizenak) {
		this.abizenak = abizenak;
	}

	public Date getJaiotzeData() {
		return jaiotzeData;
	}

	public void setJaiotzeData(Date jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	@Override
	public String toString() {
		return "Bezeroa [nan=" + nan + ", izena=" + izena + ", abizena=" + abizenak + ", jaiotzeData=" + jaiotzeData
				+ ", promozioKod=" + pasahitza + "]";
	}

}
