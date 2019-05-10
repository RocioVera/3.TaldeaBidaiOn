package Kontrolatzailea;

public class Ostatua {

	protected String izena, herria, helbidea, ostatuMota;
	protected int ostatuKod, postKod, gelaKop, erreserbaKop;

	public Ostatua(String izena, String herria, String helbidea, String ostatuMota, int ostatuKod, int postKod,
			int gelaKop, int erreserbaKop) {
		this.izena = izena;
		this.herria = herria;
		this.helbidea = helbidea;
		this.ostatuMota = ostatuMota;
		this.ostatuKod = ostatuKod;
		this.postKod = postKod;
		this.gelaKop = gelaKop;
		this.erreserbaKop = erreserbaKop;
	}

	public int getOstatuKod() {
		return ostatuKod;
	}

	public void setOstatuKod(int ostatuKod) {
		this.ostatuKod = ostatuKod;
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
		return "Ostatua izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", postKod=" + postKod
				+ ", ostatuMota=" + ostatuMota + ", gelaKop=" + gelaKop + ", erreserbaKop=" + erreserbaKop + "]";
	}

}
