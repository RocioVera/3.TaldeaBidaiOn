package Kontrolatzailea;

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

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getHerria() {
		return herria;
	}

	public void setHerria(String herria) {
		this.herria = herria;
	}

	public String getHelbidea() {
		return helbidea;
	}

	public void setHelbidea(String helbidea) {
		this.helbidea = helbidea;
	}

	public int getPostKod() {
		return postKod;
	}

	public void setPostKod(int postKod) {
		this.postKod = postKod;
	}

	public String getOstatuMota() {
		return ostatuMota;
	}

	public void setOstatuMota(String ostatuMota) {
		this.ostatuMota = ostatuMota;
	}

	public int getGelaKop() {
		return gelaKop;
	}

	public void setGelaKop(int gelaKop) {
		this.gelaKop = gelaKop;
	}

	public int getErreserbaKop() {
		return erreserbaKop;
	}

	public void setErreserbaKop(int erreserbaKop) {
		this.erreserbaKop = erreserbaKop;
	}

	@Override
	public String toString() {
		return "Ostatua [izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", postKod=" + postKod
				+ ", ostatuMota=" + ostatuMota + ", gelaKop=" + gelaKop + ", erreserbaKop=" + erreserbaKop + "]";
	}

}
