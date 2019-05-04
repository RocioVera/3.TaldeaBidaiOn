package Kontrolatzailea;

public class HartutakoOstatuarenZerbitzuak {

	private String izena;
	private int kodZerbitzua;
	private double prezioa;

	public HartutakoOstatuarenZerbitzuak(int kodZerbitzua, String izena, double prezioa) {
		this.izena = izena;
		this.kodZerbitzua = kodZerbitzua;
		this.prezioa = prezioa;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getKodZerbitzua() {
		return kodZerbitzua;
	}

	public void setKodZerbitzua(int kodZerbitzua) {
		this.kodZerbitzua = kodZerbitzua;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}

	@Override
	public String toString() {
		return "HartutakoOstatuarenZerbitzuak [izena=" + izena + ", kodZerbitzua=" + kodZerbitzua + ", prezioa="
				+ prezioa + "]";
	}

}
