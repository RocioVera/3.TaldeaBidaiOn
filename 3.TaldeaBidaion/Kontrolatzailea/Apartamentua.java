package Kontrolatzailea;

public class Apartamentua extends Ostatua {

	private int solairua;
	private int apartamentuKod;
	private int etxeKod;

	public Apartamentua(String izena, String herria, String helbidea, int postKod, String ostatuMota, int gelaKop,
			int erreserbaKop, int solairua, int apartamentuKod, int etxeKod) {
		super(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop);
		this.solairua = solairua;
		this.apartamentuKod = apartamentuKod;
		this.etxeKod = etxeKod;
	}

	public int getSolairua() {
		return solairua;
	}

	public void setSolairua(int solairua) {
		this.solairua = solairua;
	}

	public int getApartamentuKod() {
		return apartamentuKod;
	}

	public void setApartamentuKod(int apartamentuKod) {
		this.apartamentuKod = apartamentuKod;
	}

	public int getEtxeKod() {
		return etxeKod;
	}

	public void setEtxeKod(int etxeKod) {
		this.etxeKod = etxeKod;
	}

	@Override
	public String toString() {
		return super.toString() + "Apartamentua [solairua=" + solairua + ", apartamentuKod=" + apartamentuKod
				+ ", etxeKod=" + etxeKod + "]";
	}

}
