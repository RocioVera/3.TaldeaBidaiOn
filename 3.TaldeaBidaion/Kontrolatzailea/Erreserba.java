package Kontrolatzailea;

import java.sql.Date;

public class Erreserba {

	private Date sartzeData, irtetzeData;
	private int ostatuId, pertsonaKopuru, erreserbaGelaKop;
	private double prezioTotala;
	private String bezeroNan, pentsioMota;

	public Erreserba(int ostatuId, String bezeroNan, Date sartzeData, Date irtetzeData, int pertsonaKopuru,
			double prezioTotala, int erreserbaGelaKop, String pentsioMota, String oheMota, int oheKop,
			String tarifaDenboraldia) {
		this.ostatuId = ostatuId;
		this.bezeroNan = bezeroNan;
		this.sartzeData = sartzeData;
		this.irtetzeData = irtetzeData;
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

	public void setBezeroNan(String bezeroNan) {
		this.bezeroNan = bezeroNan;
	}

	public Date getSartzeData() {
		return sartzeData;
	}

	public void setSartzeData(Date sartzeData) {
		this.sartzeData = sartzeData;
	}

	public Date getIrtetzeData() {
		return irtetzeData;
	}

	public void setIrtetzeData(Date irtetzeData) {
		this.irtetzeData = irtetzeData;
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
		return "Erreserba [ostatuId=" + ostatuId + ", bezeroNan=" + bezeroNan + ", sartzeData=" + sartzeData
				+ ", irtetzeData=" + irtetzeData + ", pertsonaKopuru=" + pertsonaKopuru + ", prezioTotala="
				+ prezioTotala + ", erreserbaGelaKop=" + erreserbaGelaKop + ", pentsioMota=" + pentsioMota;
	}

}
