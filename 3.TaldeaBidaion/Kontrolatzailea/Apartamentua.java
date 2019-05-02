package Kontrolatzailea;

public class Apartamentua extends Etxea {

	private int solairua;

	public Apartamentua(String izena, String herria, String helbidea, String ostatuMota, int postKod, int gelaKop,
			int erreserbaKop, int komunKop, int ostatuKod, double m2, int solairua) {
		super(izena, herria, helbidea, ostatuMota, postKod, gelaKop, erreserbaKop, komunKop, ostatuKod, m2);
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
