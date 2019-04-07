package Kontrolatzailea;

public class ZerbitzuGehigarriakOstatu {

	private int kodZerbitzuak, ostatuId;

	public ZerbitzuGehigarriakOstatu(int kodZerbitzuak, int ostatuId) {
		super();
		this.kodZerbitzuak = kodZerbitzuak;
		this.ostatuId = ostatuId;
	}

	public int getKodZerbitzuak() {
		return kodZerbitzuak;
	}

	public void setKodZerbitzuak(int kodZerbitzuak) {
		this.kodZerbitzuak = kodZerbitzuak;
	}

	public int getOstatuId() {
		return ostatuId;
	}

	public void setOstatuId(int ostatuId) {
		this.ostatuId = ostatuId;
	}

	@Override
	public String toString() {
		return "ZerbitzuGehigarriakOstatu [kodZerbitzuak=" + kodZerbitzuak + ", ostatuId=" + ostatuId + "]";
	}

}
