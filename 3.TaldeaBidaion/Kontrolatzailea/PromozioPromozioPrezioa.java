package Kontrolatzailea;

public class PromozioPromozioPrezioa {

	private int promozioKod;

	public PromozioPromozioPrezioa(int promozioKod, int promozioPrezioKod) {
		this.promozioKod = promozioKod;
	}

	public int getPromozioKod() {
		return promozioKod;
	}

	public void setPromozioKod(int promozioKod) {
		this.promozioKod = promozioKod;
	}

	@Override
	public String toString() {
		return "PomozioPrezioa [promozioKod=" + promozioKod + "]";
	}

}
