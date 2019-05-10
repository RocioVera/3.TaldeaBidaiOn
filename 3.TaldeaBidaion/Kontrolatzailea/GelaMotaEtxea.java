package Kontrolatzailea;

public class GelaMotaEtxea {

	private int etxeKod, kantitatea, gelaKod;
	private String gelaMota;

	public GelaMotaEtxea(int etxeKod, String gelaMota, int kantitatea) {
		this.etxeKod = etxeKod;
		this.gelaMota = gelaMota;
		this.kantitatea = kantitatea;
	}

	public int getEtxeKod() {
		return etxeKod;
	}

	public void setgelaKod(int gelaKod) {
		this.gelaKod = gelaKod;
	}
	
	public int getgelaKod() {
		return gelaKod;
	}

	public void setEtxeKod(int etxeKod) {
		this.etxeKod = etxeKod;
	}

	public String getGelaMota() {
		return gelaMota;
	}

	public void setGelaMota(String gelaMota) {
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
