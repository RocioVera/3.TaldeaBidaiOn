package Eredua;

import java.sql.Date;

public class Bezeroa {

	private String nan;
	private String izena;
	private String abizena;
	private Date jaiotzeData;
	private String promozioKod;

	public Bezeroa(String nan, String izena, String abizena, Date jaiotzeData, String promozioKod) {
		this.nan = nan;
		this.izena = izena;
		this.abizena = abizena;
		this.jaiotzeData = jaiotzeData;
		this.promozioKod = promozioKod;
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

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public Date getJaiotzeData() {
		return jaiotzeData;
	}

	public void setJaiotzeData(Date jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
	}

	public String getPromozioKod() {
		return promozioKod;
	}

	public void setPromozioKod(String promozioKod) {
		this.promozioKod = promozioKod;
	}

	@Override
	public String toString() {
		return "Bezeroa [nan=" + nan + ", izena=" + izena + ", abizena=" + abizena + ", jaiotzeData=" + jaiotzeData
				+ ", promozioKod=" + promozioKod + "]";
	}

}
