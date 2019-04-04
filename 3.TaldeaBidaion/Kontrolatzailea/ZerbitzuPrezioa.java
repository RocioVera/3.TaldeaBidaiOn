package Kontrolatzailea;

public class ZerbitzuPrezioa {

	private int prezioKod;
	private int prezioa;

	public ZerbitzuPrezioa(int prezioKod, int prezioa) {
		this.prezioKod = prezioKod;
		this.prezioa = prezioa;
	}

	public int getPrezioKod() {
		return prezioKod;
	}

	public void setPrezioKod(int prezioKod) {
		this.prezioKod = prezioKod;
	}

	public int getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(int prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "ZerbitzuPrezioa [prezioKod=" + prezioKod + ", prezioa=" + prezioa + "]";
	}

}
