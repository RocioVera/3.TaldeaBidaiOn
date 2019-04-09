package Kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Eredua.*;
import Ikuspegia.*;

public class Metodoak {

	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);

	}

	public static void bigarrenLeihoa() {
		Leiho2AukeratuOstatu Leiho2 = new Leiho2AukeratuOstatu();
		Leiho2.setVisible(true);
	}

	public static void hirugarrenLeihoa(String hartutakoHotela, double prezioTot, String sartzeData,
			String irtetzeData) {
		
		Leiho3OstatuDatuak Leiho3 = new Leiho3OstatuDatuak(hartutakoHotela, prezioTot, sartzeData, irtetzeData);
		Leiho3.setVisible(true);

	}

	public static void laugarrenLeihoa(String hartutakoHotela, double prezioTot, String sartzeData,
			String irtetzeData) {
		Leiho4Login Leiho4 = new Leiho4Login(hartutakoHotela, prezioTot, sartzeData, irtetzeData);
		Leiho4.setVisible(true);
	}

	public static void bostgarrenLeihoa(String hartutakoHotela, double prezioTot, String sartzeData, String irtetzeData,
			String nan) {
		Leiho5Ordaindu Leiho5 = new Leiho5Ordaindu(prezioTot, hartutakoHotela, sartzeData, irtetzeData, nan);
		Leiho5.setVisible(true);
	}

	public static void seigarrenLeihoa(String hartutakoHotela, String sartzeData, String irtetzeData, double prezioTot,
			String nan) {
		Leiho6Ticket Leiho6 = new Leiho6Ticket(hartutakoHotela, sartzeData, irtetzeData, prezioTot, nan);
		Leiho6.setVisible(true);
	}

	// Leiho2-ko metodoak
	public static ArrayList<String> hotelHerria() {
		ArrayList<String> arrayHerria = new ArrayList<>();
		arrayHerria = Kontsultak.hotelHerriak();
		return arrayHerria;
	}

	public static ArrayList<Hotela> hotelakAtera(String herria) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		arrayHotelak = Kontsultak.hotelakBilatu(herria);
		return arrayHotelak;
	}

	public static double hotelarenPrezioaAtera(String hotela) {
		double prezioa = 0;
		prezioa = Kontsultak.hotelarenPrezioaBilatu(hotela);
		return prezioa;
	}

	public static double prezioTotalaGauekin(Date dataSartze, Date dataIrtetze, double prezioTot) {
		//86400000 milisegundo/egun
		int gauak=(int) ((dataIrtetze.getTime()-dataSartze.getTime())/86400000);
		//gauaren prezioa biderkatu gau bakoitzagatik
		prezioTot=prezioTot*gauak;
		return prezioTot;
	}
	
	// Leiho3-ko metodoak
	
	
	
	//Leiho4-ko metodoak
	/**
	 * Frogatu dni-a erregistratuta ez dagoela.
	 * 
	 * @author talde1
	 * @param nan
	 * @return balNan
	 */
	public static boolean nanGordetaEgon(String nan) {
		ArrayList<Bezeroa> bezeroak = new ArrayList<>();
		boolean balNan = false;
		System.out.println(nan);
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroa bezeroak2 : bezeroak) {
			if (bezeroak2.getNan().equals(nan)) {
				balNan = true;
			}
		}
		return balNan;
	}

	/**
	 * Sartutako pasahitza (zifratuta) ea datu basean dagoen ala ez.
	 * 
	 * @author talde1
	 * @param pasahitza
	 * @return bal
	 */
	public static boolean frogatuPasahitza(String pasahitza) {
		boolean bal = false;
		String pasaEnkr = "";
		pasaEnkr = zifratuPasahitza(pasahitza);
		ArrayList<Bezeroa> bezeroak = new ArrayList<Bezeroa>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroa bezeroak2 : bezeroak) {
			if (pasaEnkr.equals(bezeroak2.getPasahitza()))
				bal = true;
		}
		return bal;
	}

	/**
	 * Sartutako nan-a ea datu baaean dagoen ala ez.
	 * 
	 * @author talde1
	 * @param nan
	 * @return bal
	 */
	public static boolean frogatuNAN(String nan) {
		boolean bal = false;
		ArrayList<Bezeroa> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroa bezeroak2 : bezeroak) {
			if (nan.equals(bezeroak2.getNan()))
				bal = true;
		}
		return bal;
	}

	/**
	 * Frogatu dni-a erregistratuta ez dagoela. Ez balegoke eta datuak hutzik ere
	 * ez, bezeroen erregistroa egin datu basean.
	 * 
	 * @author talde1
	 * @param pasahitza
	 * @param nan
	 * @param izena
	 * @param abizenak
	 * @param sexua
	 * @param jaioDataString
	 * @return bal
	 */
	public static boolean erregistratuBezeroak(String pasahitza, String nan, String izena, String abizenak,
			String jaioDataString) {
		boolean bal = true;
		String pasaEnkr = "";
		pasaEnkr = zifratuPasahitza(pasahitza);
		ArrayList<Bezeroa> bezeroak = new ArrayList<>();

		// fitxeroari bidali
		if (pasahitza.length() == 0 || nan.length() < 8 || izena.isEmpty() || abizenak.isEmpty() || nan.length() < 8
				|| jaioDataString == null || nanGordetaEgon(nan))
			bal = false;

		if (bal && !nanGordetaEgon(nan)) {
			bezeroak = Kontsultak.erregistratuBezeroak(pasaEnkr, nan, izena, abizenak, jaioDataString);
		}
		return bal;
	}

	/**
	 * 
	 * /** Sartutako pasahitza zifratu.
	 * 
	 * @author talde1
	 * @param pasahitza
	 * @return hashtext
	 */
	public static String zifratuPasahitza(String pasahitza) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(pasahitza.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Balidatu nan-a (lehenengo 8 zbk eta 9.a letra)
	 * 
	 * @author talde1
	 * @param nan
	 * @return nanBalidazioa
	 */
	public static boolean nanBalidazioa(String nan) {
		String nanLetra = nan.substring(8), nanLarria = nanLetra.toUpperCase();
		boolean nanBalidazioa = false;
		if (nan.length() != 9 || Character.isLetter(nan.charAt(8)) == false)
			nanBalidazioa = false;

		if (nanZenbakiak(nan) == true && nanLetra(nan).equals(nanLarria))
			nanBalidazioa = true;
		return nanBalidazioa;
	}

	/**
	 * Lehenengo 8 karaktereak zenbakiak direla balidatzen du. 8 zenbaki ez badaude
	 * NAN-a ez dago ondo.
	 * 
	 * @author talde1
	 * @param nan
	 * @return balNan
	 */
	public static boolean nanZenbakiak(String nan) {
		String zbk, nanOna = "";
		boolean balNan = false;
		String[] zbkArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (int i = 0; i < nan.length() - 1; i++) { // sartutako nan-a
			zbk = nan.substring(i, i + 1);
			for (int j = 0; j < nan.length(); j++) { // zenbakien arraya
				if (zbk.equals(zbkArray[j]))
					nanOna += zbkArray[j];
			}
		}
		if (nanOna.length() != 9)
			balNan = true;
		else
			balNan = false;
		return balNan;
	}

	/**
	 * nan-aren zenbaki guztiak gehitzen ditu eta zati 23 egiten hondarra lortzen
	 * du. Hondarra horrekin sartutako nan-aren letra bueltatzen du.
	 * 
	 * @author talde1
	 * @param nan
	 * @return nanLarria
	 */
	public static String nanLetra(String nan) {
		int nanGehiketa = Integer.parseInt(nan.substring(0, 8)), hondarra;
		String nanLarria = null;
		String[] zbkArray = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };
		hondarra = nanGehiketa % 23;
		nanLarria = zbkArray[hondarra];
		return nanLarria;
	}
	// Leiho4-ko metodoak

	// Leiho5-ko metodoak

	public static double diruaSartu(int kont, double sartutakoa) {
		switch (kont) {
		case 1:
			sartutakoa += 200;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 2:
			sartutakoa += 100;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 3:
			sartutakoa += 50;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 4:
			sartutakoa += 20;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 5:
			sartutakoa += 10;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 6:
			sartutakoa += 5;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 7:
			sartutakoa += 2;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 8:
			sartutakoa += 1;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 9:
			sartutakoa += 0.5;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 10:
			sartutakoa += 0.2;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 11:
			sartutakoa += 0.1;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 12:
			sartutakoa += 0.05;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 13:
			sartutakoa += 0.02;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;
		case 14:
			sartutakoa += 0.01;
			sartutakoa = Math.round(sartutakoa * 100.0) / 100.0;
			break;

		default:
			sartutakoa = 0;
			break;
		}
		return sartutakoa;
	}

	public static double diruFaltaBueltakMetodoa(double diruFalta, double guztiraPrez, double sartutakoa) {
		diruFalta = guztiraPrez - sartutakoa;
		diruFalta = Math.round(diruFalta * 100.0) / 100.0;
		return diruFalta;
	}

	public static String diruBueltakZerrenda(double diruFalta) {
		String bueltakString = "";
		double bueltak = 0;
		if (diruFalta < 0) {
			bueltak = -diruFalta;
			for (double i = bueltak; i > 0; i = bueltak) {
				if (bueltak >= 200) {
					bueltak = bueltak - 200;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "200€-ko bilete \n";

				} else if (bueltak >= 100) {
					bueltak = bueltak - 100;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "100€-ko bilete \n";

				} else if (bueltak >= 50) {
					bueltak = bueltak - 50;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "50€-ko bilete \n";

				} else if (bueltak >= 20) {
					bueltak = bueltak - 20;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "20€-ko bilete \n";

				} else if (bueltak >= 10) {
					bueltak = bueltak - 10;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "10€-ko bilete \n";

				} else if (bueltak >= 5) {
					bueltak = bueltak - 5;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "5€-ko bilete \n";

				} else if (bueltak >= 2) {
					bueltak = bueltak - 2;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "2€-ko moneta \n";

				} else if (bueltak >= 1) {
					bueltak = bueltak - 1;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "1€-ko moneta \n";

				} else if (bueltak >= 0.5) {
					bueltak = bueltak - 0.5;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.5€-ko moneta \n";

				} else if (bueltak >= 0.2) {
					bueltak = bueltak - 0.2;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.2€-ko moneta \n";

				} else if (bueltak >= 0.1) {
					bueltak = bueltak - 0.1;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.1€-ko moneta \n";

				} else if (bueltak >= 0.05) {
					bueltak = bueltak - 0.05;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.05€-ko moneta \n";

				} else if (bueltak >= 0.02) {
					bueltak = bueltak - 0.02;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.02€-ko moneta \n";

				} else if (bueltak >= 0.01) {
					bueltak = bueltak - 0.01;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "0.01€-ko moneta \n";
				}
			}
		}
		return bueltakString;
	}

	public static void fitxIdatzi(String hartutakoHotela, String sartzeData, String irtetzeData, double prezioTot,
			String nan) {
		FileWriter fitx = null;
		PrintWriter pw = null;

		try {
			fitx = new FileWriter("eredua\\ErreserbaFitx", true);
			pw = new PrintWriter(fitx);

			pw.println("Prezioa: " + prezioTot + " €" + "\nBezeroaren datuak:");
			pw.println("     Nan: " + nan + "\nIzena: \n     Hartutako hotela: " + hartutakoHotela + "\t");
			pw.println("     Sartze data: " + sartzeData + "\t Irtetze data: " + irtetzeData);
			pw.println(
					"******************************************************************************************************************************************");
			pw.println("");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fitx)
					fitx.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	// Leiho6-ko metodoak
	public static void Leiho_segunduak() {
		for (int i = 1; i <= 5; i++) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		lehenengoLeihoa();
	}

}
