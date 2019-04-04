package Eredua;

public class GelaMota {

	private String mota;
	private double m2Gela;
	private String oheMota;
	private int altzariKopuru;
	private double prezioa;

	public GelaMota(String mota, double m2Gela, String oheMota, int altzariKopuru, double prezioa) {
		this.mota = mota;
		this.m2Gela = m2Gela;
		this.oheMota = oheMota;
		this.altzariKopuru = altzariKopuru;
		this.prezioa = prezioa;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public double getM2Gela() {
		return m2Gela;
	}

	public void setM2Gela(double m2Gela) {
		this.m2Gela = m2Gela;
	}

	public String getOheMota() {
		return oheMota;
	}

	public void setOheMota(String oheMota) {
		this.oheMota = oheMota;
	}

	public int getAltzariKopuru() {
		return altzariKopuru;
	}

	public void setAltzariKopuru(int altzariKopuru) {
		this.altzariKopuru = altzariKopuru;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "GelaMota [mota=" + mota + ", m2Gela=" + m2Gela + ", oheMota=" + oheMota + ", altzariKopuru="
				+ altzariKopuru + ", prezioa=" + prezioa + "]";
	}

}
