package Eredua;

import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Erreserba {

	private int ostatuId;
	private String bezeroNan;
	private Date sartzeData;
	private Date irtetzeData;
	private int pertsonaKopuru;
	private double prezioTotala;
	private int erreserbaGelaKop;
	private String pentsioMota;
	private String oheMota;
	private int oheKop;
	private String tarifaDenboraldia;

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
		this.oheMota = oheMota;
		this.oheKop = oheKop;
		this.tarifaDenboraldia = tarifaDenboraldia;
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

	public String getOheMota() {
		return oheMota;
	}

	public void setOheMota(String oheMota) {
		this.oheMota = oheMota;
	}

	public int getOheKop() {
		return oheKop;
	}

	public void setOheKop(int oheKop) {
		this.oheKop = oheKop;
	}

	public String getTarifaDenboraldia() {
		return tarifaDenboraldia;
	}

	public void setTarifaDenboraldia(String tarifaDenboraldia) {
		this.tarifaDenboraldia = tarifaDenboraldia;
	}

	@Override
	public String toString() {
		return "Erreserba [ostatuId=" + ostatuId + ", bezeroNan=" + bezeroNan + ", sartzeData=" + sartzeData
				+ ", irtetzeData=" + irtetzeData + ", pertsonaKopuru=" + pertsonaKopuru + ", prezioTotala="
				+ prezioTotala + ", erreserbaGelaKop=" + erreserbaGelaKop + ", pentsioMota=" + pentsioMota
				+ ", oheMota=" + oheMota + ", oheKop=" + oheKop + ", tarifaDenboraldia=" + tarifaDenboraldia + "]";
	}

}
