package Kontrolatzailea;

public class Promozioa {
	private String bezeroNan, zergatia;
	private double prezioa; 
	private int promozioKod;
	
	public Promozioa(int promozioKod, String zergatia, double prezioa) {
		this.zergatia = zergatia;
		this.prezioa = prezioa;
		this.promozioKod = promozioKod;
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

	@Override
	public String toString() {
		return "Promozioa [zergatia=" + zergatia + ", prezioa=" + prezioa + ", promozioKod=" + promozioKod + "]";
	}



}
