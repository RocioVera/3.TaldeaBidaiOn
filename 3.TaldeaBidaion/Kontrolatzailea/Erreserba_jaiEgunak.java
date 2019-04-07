package Kontrolatzailea;

import java.sql.Date;

public class Erreserba_jaiEgunak {

	private int erreserbaKod, jaiEgunakKod;
	private Date eguna;
	private String tarifaDenboraldia;
	
	public Erreserba_jaiEgunak(int erreserbaKod, int jaiEgunakKod, Date eguna, String tarifaDenboraldia) {
		super();
		this.erreserbaKod = erreserbaKod;
		this.jaiEgunakKod = jaiEgunakKod;
		this.eguna = eguna;
		this.tarifaDenboraldia = tarifaDenboraldia;
	}

	public int getErreserbaKod() {
		return erreserbaKod;
	}

	public void setErreserbaKod(int erreserbaKod) {
		this.erreserbaKod = erreserbaKod;
	}

	public int getJaiEgunakKod() {
		return jaiEgunakKod;
	}

	public void setJaiEgunakKod(int jaiEgunakKod) {
		this.jaiEgunakKod = jaiEgunakKod;
	}

	public Date getEguna() {
		return eguna;
	}

	public void setEguna(Date eguna) {
		this.eguna = eguna;
	}

	public String getTarifaDenboraldia() {
		return tarifaDenboraldia;
	}

	public void setTarifaDenboraldia(String tarifaDenboraldia) {
		this.tarifaDenboraldia = tarifaDenboraldia;
	}

	@Override
	public String toString() {
		return "Erreserba_jaiEgunak [erreserbaKod=" + erreserbaKod + ", jaiEgunakKod=" + jaiEgunakKod + ", eguna="
				+ eguna + ", tarifaDenboraldia=" + tarifaDenboraldia + "]";
	}

	
}
