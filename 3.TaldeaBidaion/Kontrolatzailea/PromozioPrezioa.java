package Kontrolatzailea;

public class PromozioPrezioa {

	private int prezioKod, promozioKod;

	public PromozioPrezioa(int prezioKod, int promozioKod) {
		this.prezioKod = prezioKod;
		this.promozioKod = promozioKod;
	}

	public int getPrezioKod() {
		return prezioKod;
	}

	public void setPrezioKod(int prezioKod) {
		this.prezioKod = prezioKod;
	}

	public int getPromozioKod() {
		return promozioKod;
	}

	public void setPromozioKod(int promozioKod) {
		this.promozioKod = promozioKod;
	}

	@Override
	public String toString() {
		return "PromozioPrezioa [prezioKod=" + prezioKod + ", promozioKod=" + promozioKod + "]";
	}

}
