package Kontrolatzailea;

import java.sql.Date;

public class JaiEgunak {

	private int jaiEgunKod;
	private Date jaiEguna;
	private String zergatia;
	
	public JaiEgunak(int jaiEgunKod, Date jaiEguna, String zergatia) {
		this.jaiEgunKod=jaiEgunKod;
		this.jaiEguna = jaiEguna;
		this.zergatia = zergatia;
	}

	public int getJaiEgunKod() {
		return jaiEgunKod;
	}


	public void setJaiEgunKod(int jaiEgunKod) {
		this.jaiEgunKod = jaiEgunKod;
	}


	public Date getJaiEguna() {
		return jaiEguna;
	}

	public void setJaiEguna(Date eguna) {
		this.jaiEguna = jaiEguna;
	}

	public String getZergatia() {
		return zergatia;
	}

	public void setZergatia(String zergatia) {
		this.zergatia = zergatia;
	}


	@Override
	public String toString() {
		return "JaiEgunak [jaiEgunKod=" + jaiEgunKod + ", jaiEguna=" + jaiEguna + ", zergatia=" + zergatia + "]";
	}


	
}
