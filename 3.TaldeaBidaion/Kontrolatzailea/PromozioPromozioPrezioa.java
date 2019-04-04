package Kontrolatzailea;

public class PromozioPromozioPrezioa {

	private int promozioKod;
	private int promozioPrezioKod;

	public PromozioPromozioPrezioa(int promozioKod, int promozioPrezioKod) {
		this.promozioKod = promozioKod;
		this.promozioPrezioKod = promozioPrezioKod;
	}

	public int getPromozioKod() {
		return promozioKod;
	}

	public void setPromozioKod(int promozioKod) {
		this.promozioKod = promozioKod;
	}

	public int getPromozioPrezioKod() {
		return promozioPrezioKod;
	}

	public void setPromozioPrezioKod(int promozioPrezioKod) {
		this.promozioPrezioKod = promozioPrezioKod;
	}

	@Override
	public String toString() {
		return "PomozioPrezioa [promozioKod=" + promozioKod + ", promozioPrezioKod=" + promozioPrezioKod + "]";
	}

}
