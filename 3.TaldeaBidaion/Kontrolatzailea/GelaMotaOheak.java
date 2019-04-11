package Kontrolatzailea;

public class GelaMotaOheak {

	private int gelaMota_gelaKod, oheId;

	public GelaMotaOheak(int gelaMota_gelaKod, int oheId) {
		this.gelaMota_gelaKod = gelaMota_gelaKod;
		this.oheId = oheId;
	}

	public int getGelaMota_gelaKod() {
		return gelaMota_gelaKod;
	}

	public void setGelaMota_gelaKod(int gelaMota_gelaKod) {
		this.gelaMota_gelaKod = gelaMota_gelaKod;
	}

	public int getOheId() {
		return oheId;
	}

	public void setOheId(int oheId) {
		this.oheId = oheId;
	}

	@Override
	public String toString() {
		return "GelaMotaOheak [gelaMota_gelaKod=" + gelaMota_gelaKod + ", oheId=" + oheId + "]";
	}


}
