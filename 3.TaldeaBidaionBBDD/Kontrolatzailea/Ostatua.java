package Kontrolatzailea;

public class Ostatua {

	protected String izena, herria, helbidea, ostatuMota;
	protected int postKod, gelaKop, erreserbaKop, ostatu_id;

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

	public Ostatua(String izena, int ostatu_id) {
		this.izena = izena;
		this.ostatu_id = ostatu_id;
	}

	public String getIzena() {
		return izena;
	}

	public int getOstatu_id() {
		return ostatu_id;
	}

	public void setOstatu_id(int ostatu_id) {
		this.ostatu_id = ostatu_id;
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
		return "Ostatua izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", postKod=" + postKod
				+ ", ostatuMota=" + ostatuMota + ", gelaKop=" + gelaKop + ", erreserbaKop=" + erreserbaKop + "]";
	}

}
