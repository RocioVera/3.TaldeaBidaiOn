package Kontrolatzailea;

import java.sql.Date;

public class Erreserba {

	private int ostatuId, pertsonaKopuru, erreserbaGelaKop, erreserbaKod;
	private double prezioTotala;
	private String bezeroNan, pentsioMota;

	public Erreserba(int ostatuId, String bezeroNan, int pertsonaKopuru,
			double prezioTotala, int erreserbaGelaKop, String pentsioMota) {
		this.ostatuId = ostatuId;
		this.bezeroNan = bezeroNan;
		this.pertsonaKopuru = pertsonaKopuru;
		this.prezioTotala = prezioTotala;
		this.erreserbaGelaKop = erreserbaGelaKop;
		this.pentsioMota = pentsioMota;
	}
	
	public int getOstatuId() {
		return ostatuId;
	}

	public void setOstatuId(int ostatuId) {
		this.ostatuId = ostatuId;
	}

	public String getBezeroNan() {
		return bezeroNan;
	}
	
	public int getErreserbaKod() {
		return erreserbaKod;
	}

	public void setErreserbaKod(int erreserbaKod) {
		this.erreserbaKod = erreserbaKod;
	}
	public void setBezeroNan(String bezeroNan) {
		this.bezeroNan = bezeroNan;
	}

	public int getPertsonaKopuru() {
		return pertsonaKopuru;
	}

	public void setPertsonaKopuru(int pertsonaKopuru) {
		this.pertsonaKopuru = pertsonaKopuru;
	}

	public double getPrezioTotala() {
		return prezioTotala;
	}

	public void setPrezioTotala(double prezioTotala) {
		this.prezioTotala = prezioTotala;
	}

	public int getErreserbaGelaKop() {
		return erreserbaGelaKop;
	}

	public void setErreserbaGelaKop(int erreserbaGelaKop) {
		this.erreserbaGelaKop = erreserbaGelaKop;
	}

	public String getPentsioMota() {
		return pentsioMota;
	}

	public void setPentsioMota(String pentsioMota) {
		this.pentsioMota = pentsioMota;
	}


	@Override
	public String toString() {
		return "Erreserba [ostatuId=" + ostatuId + ", bezeroNan=" + bezeroNan + ", pertsonaKopuru=" + pertsonaKopuru + ", prezioTotala="
				+ prezioTotala + ", erreserbaGelaKop=" + erreserbaGelaKop + ", pentsioMota=" + pentsioMota;
	}

}
