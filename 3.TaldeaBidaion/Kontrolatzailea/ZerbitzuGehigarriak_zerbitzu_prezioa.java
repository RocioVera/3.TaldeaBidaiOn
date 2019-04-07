package Kontrolatzailea;

public class ZerbitzuGehigarriak_zerbitzu_prezioa {

	private int kodZerbitzua,kodPrezioa;

	public ZerbitzuGehigarriak_zerbitzu_prezioa(int kodZerbitzua, int kodPrezioa) {
		this.kodZerbitzua = kodZerbitzua;
		this.kodPrezioa = kodPrezioa;
	}

	public int getKodZerbitzua() {
		return kodZerbitzua;
	}

	public void setKodZerbitzua(int kodZerbitzua) {
		this.kodZerbitzua = kodZerbitzua;
	}

	public int getKodPrezioa() {
		return kodPrezioa;
	}

	public void setKodPrezioa(int kodPrezioa) {
		this.kodPrezioa = kodPrezioa;
	}

	@Override
	public String toString() {
		return "zerbitzuGehigarriak_zerbitzu_prezioa [kodZerbitzua=" + kodZerbitzua + ", kodPrezioa=" + kodPrezioa
				+ "]";
	}

}
