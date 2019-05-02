package Kontrolatzailea;

public class Etxea extends Ostatua {

	protected int komunKop;
	protected double m2;

	public Etxea(String izena, String herria, String helbidea, String ostatuMota, int postKod,
			int gelaKop, int erreserbaKop, int komunKop, int ostatuKod, double m2) {
		super(izena, herria, helbidea, ostatuMota, ostatuKod, postKod, gelaKop, erreserbaKop);
		this.komunKop = komunKop;
		this.m2 = m2;
	}

	public int getKomunKop() {
		return komunKop;
	}

	public void setKomunKop(int komunKop) {
		this.komunKop = komunKop;
	}

	public double getM2() {
		return m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	
	@Override
	public String toString() {
		return super.toString() + "Etxea [komunKop=" + komunKop + ", m2=" + m2 + "]";
	}

}
