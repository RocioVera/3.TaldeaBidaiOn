package Kontrolatzailea;

public class Hotela extends Ostatua {

	private int izarKop;

	
	public Hotela(String izena, String herria, String helbidea, String ostatuMota, int ostatuKod, int postKod,
			int gelaKop, int erreserbaKop, int izarKop) {
		super(izena, herria, helbidea, ostatuMota, ostatuKod, postKod, gelaKop, erreserbaKop);
		this.izarKop = izarKop;
	}

	public int getIzarKop() {
		return izarKop;
	}

	public void setIzarKop(int izarKop) {
		this.izarKop = izarKop;
	}



	@Override
	public String toString() {
		return super.toString() + "Hotela [izarKop=" + izarKop + "]";
	}

}
