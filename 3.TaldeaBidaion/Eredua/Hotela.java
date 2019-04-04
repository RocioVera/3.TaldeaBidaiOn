package Eredua;

public class Hotela extends Ostatua {

	private int izarKop;
	private int hotelKop;

	public Hotela(String izena, String herria, String helbidea, int postKod, String ostatuMota, int gelaKop,
			int erreserbaKop, int izarKop, int hotelKop) {
		super(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop);
		this.izarKop = izarKop;
		this.hotelKop = hotelKop;
	}

	public int getIzarKop() {
		return izarKop;
	}

	public void setIzarKop(int izarKop) {
		this.izarKop = izarKop;
	}

	public int getHotelKop() {
		return hotelKop;
	}

	public void setHotelKop(int hotelKop) {
		this.hotelKop = hotelKop;
	}

	@Override
	public String toString() {
		return super.toString() + "Hotela [izarKop=" + izarKop + ", hotelKop=" + hotelKop + "]";
	}

}
