package Kontrolatzailea;

public class GelaMotaEtxea {

	private int etxeKod, gelaMota, kantitatea;

	public GelaMotaEtxea(int etxeKod, int gelaMota, int kantitatea) {
		this.etxeKod = etxeKod;
		this.gelaMota = gelaMota;
		this.kantitatea = kantitatea;
	}

	public int getEtxeKod() {
		return etxeKod;
	}

	public void setEtxeKod(int etxeKod) {
		this.etxeKod = etxeKod;
	}

	public int getGelaMota() {
		return gelaMota;
	}

	public void setGelaMota(int gelaMota) {
		this.gelaMota = gelaMota;
	}

	public int getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	@Override
	public String toString() {
		return "gelaMotaEtxea [etxeKod=" + etxeKod + ", gelaMota=" + gelaMota + ", kantitatea=" + kantitatea + "]";
	}

}
