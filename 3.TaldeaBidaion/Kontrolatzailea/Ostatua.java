package Kontrolatzailea;

public class Ostatua implements Comparable<Ostatua> {

	protected String izena, herria, helbidea, ostatuMota;
	protected int ostatuKod, postKod, gelaKop, erreserbaKop, ordenZbk;
	private static int zbkMota = 1;
	private double prezioa;

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
		this.ordenZbk = erreserbaKop;
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

	public int getZbkMota() {
		return zbkMota;
	}

	public void setZbkMota(int zbkMota) {
		Ostatua.zbkMota = zbkMota;
	}

	public double getPrezioa() {
		return prezioa;
	}

	public void setPrezioa(double prezioa) {
		this.prezioa = prezioa;
	}
	

	public int getOrdenZbk() {
		return ordenZbk;
	}

	public void setOrdenZbk(int ordenZbk) {
		this.ordenZbk = ordenZbk;
	}

	@Override
	public String toString() {
		return "Ostatua izena=" + izena + ", herria=" + herria + ", helbidea=" + helbidea + ", postKod=" + postKod
				+ ", ostatuMota=" + ostatuMota + ", gelaKop=" + gelaKop + ", erreserbaKop=" + erreserbaKop + "]";
	}

	@Override
	public int compareTo(Ostatua o) {
		if (zbkMota == 1) {
			if (ordenZbk > o.ordenZbk) {
				return -1;
			}
			if (ordenZbk < o.ordenZbk) {
				return 1;
			}
		} else if (zbkMota == 2) {
			ordenZbk = this.izena.compareTo(o.izena);
			if (ordenZbk > 0) {
				return 1;
			} else if (ordenZbk < 0) {
				return -1;
			}
		} else if (zbkMota == 3) {
			if (prezioa < o.prezioa) {
				return -1;
			}
			if (prezioa > o.prezioa) {
				return 1;
			}
		} else if (zbkMota == 4 && ostatuMota.equals("H")) {
			if (ordenZbk > o.ordenZbk) {
				return -1;
			}
			if (ordenZbk < o.ordenZbk) {
				return 1;
			}
		}
		return 0;
	}
}
