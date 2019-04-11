package Kontrolatzailea;

public class Oheak {
	private String oheMota;
	private int oheKopuru;
	
	public Oheak(String oheMota, int oheKopuru) {
		this.oheMota = oheMota;
		this.oheKopuru = oheKopuru;
	}

	public String getOheMota() {
		return oheMota;
	}

	public void setOheMota(String oheMota) {
		this.oheMota = oheMota;
	}

	public int getOheKopuru() {
		return oheKopuru;
	}

	public void setOheKopuru(int oheKopuru) {
		this.oheKopuru = oheKopuru;
	}

	@Override
	public String toString() {
		return "Oheak [oheMota=" + oheMota + ", oheKopuru=" + oheKopuru + "]";
	}
	
}
