package Kontrolatzailea;

public class ZerbitzuGehigarriak {

	private int kod_zerbitzuak;
	private String izena;

	public ZerbitzuGehigarriak(int kod_zerbitzuak, String izena) {
		this.kod_zerbitzuak = kod_zerbitzuak;
		this.izena = izena;
	}

	public int getKod_zerbitzuak() {
		return kod_zerbitzuak;
	}

	public void setKod_zerbitzuak(int kod_zerbitzuak) {
		this.kod_zerbitzuak = kod_zerbitzuak;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	@Override
	public String toString() {
		return "zerbitzuGehigarriak [kod_zerbitzuak=" + kod_zerbitzuak + ", izena=" + izena + "]";
	}

}
