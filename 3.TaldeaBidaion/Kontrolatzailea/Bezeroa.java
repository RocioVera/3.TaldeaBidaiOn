package Kontrolatzailea;

import java.sql.Date;

public class Bezeroa extends Pertsona {

	private int erreserba_kop;

	public Bezeroa(String nan, String izena, String abizenak, Date jaiotzeData, String pasahitza, int erreserba_kop) {
		super(nan, izena, abizenak, jaiotzeData, pasahitza);
		this.erreserba_kop = erreserba_kop;
	}

	public int getErreserba_kop() {
		return erreserba_kop;
	}

	public void setErreserba_kop(int erreserba_kop) {
		this.erreserba_kop = erreserba_kop;
	}

	@Override
	public String toString() {
		return super.toString()+" Bezeroa [erreserba_kop=" + erreserba_kop + "]";
	}

	

}
