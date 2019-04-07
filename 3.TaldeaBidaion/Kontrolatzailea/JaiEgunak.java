package Kontrolatzailea;

import java.sql.Date;

public class JaiEgunak {

	private Date jaiEguna;
	private String zergatia;
	
	public JaiEgunak(Date jaiEguna, String zergatia) {
		super();
		this.jaiEguna = jaiEguna;
		this.zergatia = zergatia;
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
		return "Erreserba_jaiEgunak eguna=" + jaiEguna + ", zergatia=" + zergatia + "]";
	}

	
}
