package Kontrolatzailea;

import java.util.Date;

public class Promozioa {
	private String bezeroNan, zergatia;
	private double prezioa; 
	private int promozioKod;
	private Date iraungitzeData;
	
	public Promozioa(String bezeroNan, String zergatia, double prezioa, int promozioKod, Date iraungitzeData) {
		this.bezeroNan = bezeroNan;
		this.zergatia = zergatia;
		this.prezioa = prezioa;
		this.promozioKod = promozioKod;
		this.iraungitzeData = iraungitzeData;
	}
	public Promozioa(int promozioKod, String zergatia, double prezioa, Date iraungitzeData) {
		this.zergatia = zergatia;
		this.prezioa = prezioa;
		this.promozioKod = promozioKod;
		this.iraungitzeData = iraungitzeData;
	}


	public String getBezeroNan() {
		return bezeroNan;
	}

	public void setBezeroNan(String bezeroNan) {
		this.bezeroNan = bezeroNan;
	}

	public String getZergatia() {
		return zergatia;
	}

	public void setZergatia(String zergatia) {
		this.zergatia = zergatia;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	public int getPromozioKod() {
		return promozioKod;
	}

	public void setPromozioKod(int promozioKod) {
		this.promozioKod = promozioKod;
	}

	public Date getIraungitzeData() {
		return iraungitzeData;
	}

	public void setIraungitzeData(Date iraungitzeData) {
		this.iraungitzeData = iraungitzeData;
	}
	
	@Override
	public String toString() {
		return "Promozioa [bezeroNan=" + bezeroNan + ", zergatia=" + zergatia + ", prezioa=" + prezioa
				+ ", promozioKod=" + promozioKod + ", iraungitzeData=" + iraungitzeData + "]";
	}

}
