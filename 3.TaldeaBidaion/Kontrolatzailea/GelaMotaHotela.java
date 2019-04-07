package Kontrolatzailea;

public class GelaMotaHotela {

	private int gelaMotaKod, hotelaKod, kantitatea;

	public GelaMotaHotela(int gelaMotaKod, int hotelaKod, int kantitatea) {
		this.gelaMotaKod = gelaMotaKod;
		this.hotelaKod = hotelaKod;
		this.kantitatea = kantitatea;
	}

	public int getGelaMotaKod() {
		return gelaMotaKod;
	}

	public void setGelaMotaKod(int gelaMotaKod) {
		this.gelaMotaKod = gelaMotaKod;
	}

	public int getHotelaKod() {
		return hotelaKod;
	}

	public void setHotelaKod(int hotelaKod) {
		this.hotelaKod = hotelaKod;
	}

	public int getKantitatea() {
		return kantitatea;
	}

	public void setKantitatea(int kantitatea) {
		this.kantitatea = kantitatea;
	}

	@Override
	public String toString() {
		return "GelaMotaHotela [gelaMotaKod=" + gelaMotaKod + ", hotelaKod=" + hotelaKod + ", kantitatea=" + kantitatea
				+ "]";
	}

}
