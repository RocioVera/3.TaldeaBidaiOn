package Kontrolatzailea;


public class ErreserbaOheak {
	private int erreserbaKod, oheId;

	public ErreserbaOheak(int erreserbaKod, int oheId) {
		super();
		this.erreserbaKod = erreserbaKod;
		this.oheId = oheId;
	}

	public int getErreserbaKod() {
		return erreserbaKod;
	}

	public void setErreserbaKod(int erreserbaKod) {
		this.erreserbaKod = erreserbaKod;
	}

	public int getOheId() {
		return oheId;
	}

	public void setOheId(int oheId) {
		this.oheId = oheId;
	}

	@Override
	public String toString() {
		return "erreserbaOheak [erreserbaKod=" + erreserbaKod + ", oheId=" + oheId + "]";
	}
	
}
