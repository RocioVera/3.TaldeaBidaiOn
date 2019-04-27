package Kontrolatzailea;

import java.sql.Date;

public class Langilea extends Pertsona {

	private int ostatu_id;

	public Langilea(String nan, String izena, String abizenak, Date jaiotzeData, String pasahitza, int ostatu_id) {
		super(nan, izena, abizenak, jaiotzeData, pasahitza);
		this.ostatu_id = ostatu_id;
	}

	public int getOstatu_id() {
		return ostatu_id;
	}

	public void setOstatu_id(int ostatu_id) {
		this.ostatu_id = ostatu_id;
	}

	@Override
	public String toString() {
		return super.toString() + " Langilea [ostatu_id=" + ostatu_id + "]";
	}


	

}
