package Kontrolatzailea;

public class Hotela extends Ostatua {

	private int izarKop;
	private int hotelKod;

	public Hotela(String izena, String herria, String helbidea, int postKod, String ostatuMota, int gelaKop,
			int erreserbaKop, int izarKop, int hotelKod) {
		super(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop);
		this.izarKop = izarKop;
		this.hotelKod = hotelKod;
	}

	public int getIzarKop() {
		return izarKop;
	}

	public void setIzarKop(int izarKop) {
		this.izarKop = izarKop;
	}

	public int getHotelKod() {
		return hotelKod;
		
	}

	public void setHotelKod(int hotelKop) {
		this.hotelKod = hotelKop;
	}

	@Override
	public String toString() {
		return super.toString() + "Hotela [izarKop=" + izarKop + ", hotelKod=" + hotelKod + "]";
	}

}
