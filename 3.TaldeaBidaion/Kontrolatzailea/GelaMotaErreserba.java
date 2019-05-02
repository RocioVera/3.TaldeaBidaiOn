package Kontrolatzailea;

public class GelaMotaErreserba {
	private int gelaMotaKod, erreserbaKod;

	public GelaMotaErreserba(int gelaMotaKod, int erreserbaKod) {
		this.gelaMotaKod = gelaMotaKod;
		this.erreserbaKod = erreserbaKod;
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
		return "GelaMotaHotela [gelaMotaKod=" + gelaMotaKod + ", erreserbaKod=" + erreserbaKod + "]";
	}



}

