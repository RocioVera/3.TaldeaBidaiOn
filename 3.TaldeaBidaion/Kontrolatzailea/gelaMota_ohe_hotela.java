package Kontrolatzailea;

public class gelaMota_ohe_hotela {
	private int gela_kodea,ohe_kopuru, sinplea, bikoitza, umeak;
	private double prezioa;

	public gelaMota_ohe_hotela(int gela_kodea, int ohe_kopuru, int sinplea, int bikoitza, int umeak, double prezioa) {
		this.gela_kodea = gela_kodea;
		this.ohe_kopuru = ohe_kopuru;
		this.sinplea = sinplea;
		this.bikoitza = bikoitza;
		this.umeak = umeak;
		this.prezioa = prezioa;
	}

	public gelaMota_ohe_hotela() {
	}

	public int getGela_kodea() {
		return gela_kodea;
	}

	public void setGela_kodea(int gela_kodea) {
		this.gela_kodea = gela_kodea;
	}

	public int getOhe_kopuru() {
		return ohe_kopuru;
	}

	public void setOhe_kopuru(int ohe_kopuru) {
		this.ohe_kopuru = ohe_kopuru;
	}

	public int getSinplea() {
		return sinplea;
	}

	public void setSinplea(int sinplea) {
		this.sinplea = sinplea;
	}

	public int getBikoitza() {
		return bikoitza;
	}

	public void setBikoitza(int bikoitza) {
		this.bikoitza = bikoitza;
	}

	public int getUmeak() {
		return umeak;
	}

	public void setUmeak(int umeak) {
		this.umeak = umeak;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "gelaMota_ohe_hotela [gela_kodea=" + gela_kodea + ", ohe_kopuru=" + ohe_kopuru + ", sinplea=" + sinplea
				+ ", bikoitza=" + bikoitza + ", umeak=" + umeak + ", prezioa=" + prezioa + "]";
	}
	
}
