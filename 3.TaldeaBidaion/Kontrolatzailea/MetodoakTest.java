package Kontrolatzailea;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.mockito.Mockito;

public class MetodoakTest {

	// Leiho2AukeratuOstatu
	@Test
	public void prezioTotalaGauekinTesta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringData = "2019-01-01";
		String stringData2 = "2019-01-02";
		Date data = null, data2 = null;
		try {
			data = sdf.parse(stringData);
			data2 = sdf.parse(stringData2);

		} catch (ParseException e) {
			e.getMessage();
		}

//		assertEquals(Metodoak.prezioTotalaGauekin(data, data2, 150), 150.0); // 0
	}

	@Test
	public void gehiEgunBatTesta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringData = "2019-01-01", stringDataErantzuna = "2019-01-02";
		Date data = null, dataErantzuna = null;
		try {
			data = sdf.parse(stringData);
			dataErantzuna = sdf.parse(stringDataErantzuna);

		} catch (ParseException e) {
			e.getMessage();
		}

		assertEquals(Metodoak.gehiEgunBat(data), dataErantzuna); // 0
	}

	// galdetu
	@Test
	public void ostatuakSortuTesta() {
		ArrayList<Hotela> arrayHotela = Mockito.mock(ArrayList.class);
		ArrayList<Etxea> arrayEtxea = Mockito.mock(ArrayList.class);
		ArrayList<Apartamentua> arrayApartamentua = Mockito.mock(ArrayList.class);

		Metodoak.ostatuakSortu(arrayHotela, arrayEtxea, arrayApartamentua);
	}

	@Test
	public void nanLetraTesta() {
		String nan = "12345678Z";
		assertEquals(Metodoak.nanLetra(nan), "Z");
	}

	// txarto
	@Test
	public void zifratuHitzaTesta() {
		String hitza = "kaixo";
		assertEquals(Metodoak.nanLetra(hitza), "017c2cdcef481181a26cdb88ca081994");
	}

	// Tiket-a fitxategian idatzi.
	@Test
	public void fitxIdatziTesta() {
		Ostatua hartutakoOstatua = Mockito.mock(Ostatua.class);
		Erreserba erreserba = Mockito.mock(Erreserba.class);
		Double prezioTot = 50.2;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringsartzeData = "2019-01-01";
		String stringirtetzeData = "2019-01-02";
		Date sartzeData = null, irtetzeData = null;
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);

		} catch (ParseException e) {
			e.getMessage();
		}

	//	Metodoak.fitxIdatzi(hartutakoOstatua, sartzeData, irtetzeData, prezioTot, erreserba); // errorea ematen du

	}

	// Zenbat diru sartzen duen jakiteko egiteko - froga
	@Test
	public void diruaSartuTesta() {
		System.out.println(Metodoak.diruaSartu(0, 0));

//		assertEquals(Metodoak.diruaSartu(0, 0.0), 0.0); // 0
		assertEquals(Metodoak.diruaSartu(1, 0), 200.0);
		assertEquals(Metodoak.diruaSartu(2, 200), 300); // 200+100
		assertEquals(Metodoak.diruaSartu(3, 300), 350); // 300+50
		assertEquals(Metodoak.diruaSartu(4, 350), 370); // 350+20
		assertEquals(Metodoak.diruaSartu(5, 370), 380); // 370+10
		assertEquals(Metodoak.diruaSartu(6, 380), 385); // 380+5
		assertEquals(Metodoak.diruaSartu(7, 385), 387);// 385+2
		assertEquals(Metodoak.diruaSartu(8, 387), 388); // 387+1
		assertEquals(Metodoak.diruaSartu(9, 388), 388.5); // 387.5+0.5
		assertEquals(Metodoak.diruaSartu(10, 388.5), 388.7); // 388.5+0.2
		assertEquals(Metodoak.diruaSartu(11, 388.7), 388.8); // 388.7+0.1
		assertEquals(Metodoak.diruaSartu(12, 388.8), 388.85); // 388.80+0.05
		assertEquals(Metodoak.diruaSartu(13, 388.85), 388.87); // 388.85+0.02
		assertEquals(Metodoak.diruaSartu(14, 388.87), 388.88); // 388.87+0.01
	}

	// Jakiteko zenbat diru sartu duen gero bueltak emateko ala ez - froga
	@Test
	public void diruFaltaBueltakMetodoaTesta() {
		assertEquals(Metodoak.diruFaltaBueltakMetodoa(0, 6, 2.5), 3.5);
	}

	// Arrayan sartzeko zenbat kantitate txanpon bakoitza eta bueltatu txanpona / billete- froga
	@Test
	public void diruBueltakZerrendaTesta() {
		assertEquals(Metodoak.diruBueltakZerrenda(-200), "200€-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-100), "100€-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-50), "50€-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-20), "20€-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-10), "10€-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-5), "5€-ko bilete \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-2), "2€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-1), "1€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.5), "0.5€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.2), "0.2€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.1), "0.1€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.05), "0.05€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.02), "0.02€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(-0.01), "0.01€-ko moneta \n");
		assertEquals(Metodoak.diruBueltakZerrenda(1), "");
	}

	
	@Test
	public void egunFestiboaTesta() {
		ArrayList<JaiEgunak> arrayJaiEgunak = Mockito.mock(ArrayList.class);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringsartzeData = "2019-01-01";
		String stringirtetzeData = "2019-01-02";
		Date sartzeData = null, irtetzeData = null;
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);

		} catch (ParseException e) {
			e.getMessage();
		}
		assertEquals(Metodoak.egunFestiboa(sartzeData, irtetzeData, arrayJaiEgunak), 0);

	}

	@Test
	public void egunDenboraldiAltuaTesta() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String stringsartzeData = "2019-01-01";
		String stringirtetzeData = "2019-01-02";
		Date sartzeData = null, irtetzeData = null;
		try {
			sartzeData = sdf.parse(stringsartzeData);
			irtetzeData = sdf.parse(stringirtetzeData);

		} catch (ParseException e) {
			e.getMessage();
		}
		assertEquals(Metodoak.egunDenboraldiAltua(sartzeData, irtetzeData), 0);

	}

	
}
