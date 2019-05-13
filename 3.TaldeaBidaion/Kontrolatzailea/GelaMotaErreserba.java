package Kontrolatzailea;

public class GelaMotaErreserba {
	private int gelaMotaKod, erreserbaKod, kantitatea;

	public GelaMotaErreserba(int gelaMotaKod, int erreserbaKod, int kantitatea) {
		this.gelaMotaKod = gelaMotaKod;
		this.erreserbaKod = erreserbaKod;
		this.kantitatea = kantitatea;
	}

	public GelaMotaErreserba(int gelaMotaKod, int kantitatea) {
		this.gelaMotaKod = gelaMotaKod;
		this.kantitatea = kantitatea;
	}
	
	public int getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	public int getGelaMotaKod() {
		return gelaMotaKod;
	}

	public void setGelaMotaKod(int gelaMotaKod) {
		this.gelaMotaKod = gelaMotaKod;
	}

	public int getErreserbaKod() {
		return erreserbaKod;
	}

	public void setErreserbaKod(int erreserbaKod) {
		this.erreserbaKod = erreserbaKod;
	}

	@Override
	public String toString() {
		return "GelaMotaErreserba [gelaMotaKod=" + gelaMotaKod + ", erreserbaKod=" + erreserbaKod + ", kantitatea="
				+ kantitatea + "]";
	}




}

