package Kontrolatzailea;

public class GelaMotaApartamentua {

	private int gelaMotaKod, apartamentuKod, kantitatea;

	public GelaMotaApartamentua(int gelaMotaKod, int apartamentuKod, int kantitatea) {
		this.gelaMotaKod = gelaMotaKod;
		this.apartamentuKod = apartamentuKod;
		this.kantitatea = kantitatea;
	}

	public int getGelaMotaKod() {
		return gelaMotaKod;
	}

	public void setGelaMotaKod(int gelaMotaKod) {
		this.gelaMotaKod = gelaMotaKod;
	}

	public int getApartamentuKod() {
		return apartamentuKod;
	}

	public void setApartamentuKod(int apartamentuKod) {
		this.apartamentuKod = apartamentuKod;
	}

	public int getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	@Override
	public String toString() {
		return "GelaMotaApartamentua [gelaMotaKod=" + gelaMotaKod + ", apartamentuKod=" + apartamentuKod
				+ ", kantitatea=" + kantitatea + "]";
	}

}
