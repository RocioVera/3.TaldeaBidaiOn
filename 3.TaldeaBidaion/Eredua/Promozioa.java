package Eredua;

public class Promozioa {

	private String bezeroNan;

	public Promozioa(String bezeroNan) {
		this.bezeroNan = bezeroNan;
	}

	public String getBezeroNan() {
		return bezeroNan;
	}

	public void setBezeroNan(String bezeroNan) {
		this.bezeroNan = bezeroNan;
	}

	@Override
	public String toString() {
		return "Promozioa [bezeroNan=" + bezeroNan + "]";
	};

}
