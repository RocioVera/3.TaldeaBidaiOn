package Kontrolatzailea;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

public class MetodoakLeihoAldaketaTest {
	private Ostatua ostatua = Mockito.mock(Ostatua.class);
	private Erreserba erreserba = Mockito.mock(Erreserba.class);
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String stringsartzeData = "2019-01-01", stringirtetzeData = "2019-01-02", pentsioMota = "osoa", nan = "12345678Z";
	private Date sartzeData = null, irtetzeData = null;
	private double prezioTot=100.5;
	private int logelaTot = 5, pertsonaKop = 10;
	
	@Test
	//Leiho1 sortu.
	public void lehenengoLeihoaTesta() {
		MetodoakLeihoAldaketa.lehenengoLeihoa();
	}
	
	@Test
	//Leiho2 sortu.
	public void bigarrenLeihoaTesta() {
		MetodoakLeihoAldaketa.bigarrenLeihoa();
	}
	
	@Test
	//Leiho3 sortu.
	public void hirugarrenLeihoaHotelakTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);

		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.hirugarrenLeihoaHotelak(ostatua, sartzeData, irtetzeData);
	}
	
	@Test
	//Leiho3 sortu.
	public void hirugarrenLeihoaEtxeakTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);

		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.hirugarrenLeihoaEtxeak(ostatua, prezioTot, sartzeData, irtetzeData);
	}
	

	@Test
	//Leiho4 sortu.
	public void laugarrenLeihoaTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);
		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.laugarrenLeihoa(ostatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop);
	}
	
	@Test
	//Leiho5 sortu.
	public void bostgarrenLeihoaTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);
		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.bostgarrenLeihoa(ostatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop, pentsioMota, null);
	}
	
	@Test
	//Leiho6 sortu.
	public void seigarrenLeihoaTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);
		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.seigarrenLeihoa(ostatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop, pentsioMota, null);
	}

	@Test
	//Leiho7 sortu.
	public void zazpigarrenLeihoaTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);
		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.zazpigarrenLeihoa(ostatua, prezioTot, sartzeData, irtetzeData, nan, logelaTot, pertsonaKop, pentsioMota, null);
	}
	
	@Test
	//Leiho8 sortu.
	public void zortzigarrenLeihoaTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);
		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.zortzigarrenLeihoa(ostatua, prezioTot, sartzeData, irtetzeData, nan, logelaTot, pertsonaKop, pentsioMota, null);
	}
	

	@Test
	//Leiho9 sortu.
	public void hamargarrenLeihoaTesta() {
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);
		} catch (ParseException e) {
			e.getMessage();
		}
		MetodoakLeihoAldaketa.hamargarrenLeihoa(ostatua, sartzeData, irtetzeData, erreserba, null);
	}
	
	//Amaieran tiketa imprimatzen dagoen bitartean itxaron behar den denbora.
	@Test
	public void Leiho_segunduakTesta() {
		MetodoakLeihoAldaketa.Leiho_segunduak();
	}
	
}
