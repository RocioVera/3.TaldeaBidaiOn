package Kontrolatzailea;

public class ZerbitzuGehigarriak {

	private String izena;

	public ZerbitzuGehigarriak(int kod_zerbitzuak, String izena) {
		this.izena = izena;
	} 
	
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	@Override
	public String toString() {
		return "zerbitzuGehigarriak izena=" + izena + "]";
	}

}
