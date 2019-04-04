package Eredua;

public class Etxea extends Ostatua {

	private int komunKop;
	private int m2;
	private int etxeKod;

	public Etxea(String izena, String herria, String helbidea, int postKod, String ostatuMota, int gelaKop,
			int erreserbaKop, int komunKop, int m2, int etxeKod) {
		super(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop);
		this.komunKop = komunKop;
		this.m2 = m2;
		this.etxeKod = etxeKod;
	}

	public int getKomunKop() {
		return komunKop;
	}

	public void setKomunKop(int komunKop) {
		this.komunKop = komunKop;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getEtxeKod() {
		return etxeKod;
	}

	public void setEtxeKod(int etxeKod) {
		this.etxeKod = etxeKod;
	}

	@Override
	public String toString() {
		return super.toString() + "Etxea [komunKop=" + komunKop + ", m2=" + m2 + ", etxeKod=" + etxeKod + "]";
	}

}
