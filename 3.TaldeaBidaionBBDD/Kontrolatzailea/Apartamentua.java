package Kontrolatzailea;

public class Apartamentua extends Etxea {

	private int solairua;

	public Apartamentua(String izena, String herria, String helbidea, int postKod, String ostatuMota, int gelaKop,
			int erreserbaKop, int komunKop, double m2, int etxeKod, int solairua) {
		super(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop, komunKop, m2, etxeKod);
		this.solairua = solairua;
	}

	public int getSolairua() {
		return solairua;
	}

	public void setSolairua(int solairua) {
		this.solairua = solairua;
	}


	@Override
	public String toString() {
		return super.toString()+". Apartamentua [solairua=" + solairua + "]";
	}


}
