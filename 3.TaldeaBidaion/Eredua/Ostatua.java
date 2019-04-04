package Eredua;

public class Ostatua {

	protected String izena;
	protected String herria;
	protected String helbidea;
	protected int postKod;
	protected String ostatuMota;
	protected int gelaKop;
	protected int erreserbaKop;

	protected Ostatua(String izena, String herria, String helbidea, int postKod, String ostatuMota, int gelaKop,
			int erreserbaKop) {
		this.izena = izena;
		this.herria = herria;
		this.helbidea = helbidea;
		this.postKod = postKod;
		this.ostatuMota = ostatuMota;
		this.gelaKop = gelaKop;
		this.erreserbaKop = erreserbaKop;
	}

	protected String getIzena() {
		return izena;
	}

	protected void setIzena(String izena) {
		this.izena = izena;
	}

	protected String getHerria() {
		return herria;
	}

	protected void setHerria(String herria) {
		this.herria = herria;
	}

	protected String getHelbidea() {
		return helbidea;
	}

	protected void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	protected int getPostKod() {
		return postKod;
	}

	protected void setPostKod(int postKod) {
		this.postKod = postKod;
	}

	protected String getOstatuMota() {
		return ostatuMota;
	}

	protected void setOstatuMota(String ostatuMota) {
		this.ostatuMota = ostatuMota;
	}

	protected int getGelaKop() {
		return gelaKop;
	}

	protected void setGelaKop(int gelaKop) {
		this.gelaKop = gelaKop;
	}

	protected int getErreserbaKop() {
		return erreserbaKop;
	}

	protected void setErreserbaKop(int erreserbaKop) {
		this.erreserbaKop = erreserbaKop;
	}

	@Override
	public String toString() {
		return "Ostatua [izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", postKod=" + postKod
				+ ", ostatuMota=" + ostatuMota + ", gelaKop=" + gelaKop + ", erreserbaKop=" + erreserbaKop + "]";
	}

}
