package Kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Metodoak {
	// Leiho2AukeratuOstatu
	/**
	 * Hartutako egunen arteko eta prezio totalaren arteko biderkaketa
	 * @author talde3
	 * @param dataSartze
	 * @param dataIrtetze
	 * @param prezioTot
	 * @return prezioTot
	 */
	public static double prezioTotalaGauekin(Date dataSartze, Date dataIrtetze, double prezioTot) {
		// 86400000 milisegundo/egun
		int gauak = (int) ((dataIrtetze.getTime() - dataSartze.getTime()) / 86400000);
		// gauaren prezioa biderkatu gau bakoitzagatik
		prezioTot = prezioTot * gauak;
		return prezioTot;
	}

	/**
	 * Data bati gehi egun bat egiteko metodoa
	 * @author talde3
	 * @param date
	 * @return gehiEgunBat
	 */
	public static Date gehiEgunBat(Date date) {
		Calendar gehiEgunBat;

		gehiEgunBat = Calendar.getInstance();
		gehiEgunBat.setTime(date);
		gehiEgunBat.add(Calendar.DAY_OF_YEAR, 1);
		return gehiEgunBat.getTime();

	}

	/**
	 * Hotelak, etxeak, eta apartamentuak izanda ostatuak sortzeko metodoa
	 * @author talde3
	 * @param arrayHotela
	 * @param arrayEtxea
	 * @param arrayApartamentua
	 * @return
	 */
	public static ArrayList<Ostatua> ostatuakSortu(ArrayList<Hotela> arrayHotela, ArrayList<Etxea> arrayEtxea,
			ArrayList<Apartamentua> arrayApartamentua) {
		ArrayList<Ostatua> arrayOstatua = new ArrayList<Ostatua>();

		for (Hotela h : arrayHotela) {
			arrayOstatua.add(h);
		}

		// etxeak gehitu
		for (Etxea e : arrayEtxea) {
			arrayOstatua.add(e);
		}

		// apartamentuak gehitu
		for (Apartamentua a : arrayApartamentua) {
			arrayOstatua.add(a);
		}

		return arrayOstatua;

	}

	
	//Leiho6Erregistratu
	/**
	 * nan-aren zenbaki guztiak gehitzen ditu eta zati 23 egiten hondarra lortzen
	 * du. Hondarra horrekin sartutako nan-aren letra bueltatzen du.
	 * @author talde3
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

	/**
	 * Sartutako edozein hitz zifratu.
	 * @author talde3
	 * @param hitza
	 * @return hashtext
	 */
	public static String zifratuHitza(String hitza) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(hitza.getBytes());
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

	
	//Leiho9Ordaindu
	/**
	 * Datu guztiak fitxategi batean gordetzeko metodoa
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param sartzeData
	 * @param irtetzeData
	 * @param prezioTot
	 * @param erreserba
	 */
	public static void fitxIdatzi(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData, double prezioTot, Erreserba erreserba) {
		FileWriter fitx = null;
		PrintWriter pw = null;
		String ostatuIzena = hartutakoOstatua.getIzena();

		try {
			fitx = new FileWriter("eredua\\ErreserbaFitx", true);
			pw = new PrintWriter(fitx);

			pw.println("Prezioa: " + erreserba.getPrezioTotala() + " €" + "\nBezeroaren datuak:");
			if (prezioTot<erreserba.getPrezioTotala())
				pw.println("Promozioa hartu duzunez ordaindutako prezioa " + prezioTot + " €-koa da");

			if (erreserba.getPentsioMota()!=null)
				pw.println("Pentsio mota: " + erreserba.getPentsioMota() + "");

			pw.println("     Nan: " + erreserba.getBezeroNan() + "\nIzena: \n     Hartutako ostatua: " + ostatuIzena + "\t");
			if (hartutakoOstatua.getOstatuMota().equals("H"))
				pw.println("     Logela Totala: "+ erreserba.getErreserbaGelaKop());
			pw.println("     Pertsona Kopurua: " + erreserba.getPertsonaKopuru() + "\t Irtetze data: " + irtetzeData);

			pw.println("     Sartze data: " + sartzeData + "\t Irtetze data: " + irtetzeData);
			pw.println("");
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

	/**
	 * Zenbat diru sartzen duen jakiteko egiteko.
	 * @author talde3
	 * @param kont
	 * @param sartutakoa
	 * @return sartutakoa
	 */
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
	
	/**
	 * Jakiteko zenbat diru sartu duen gero bueltak emateko ala ez.
	 * @author talde3
	 * @param diruFalta
	 * @param guztiraPrez
	 * @param sartutakoa
	 * @return diruFalta
	 */
	public static double diruFaltaBueltakMetodoa(double diruFalta, double guztiraPrez, double sartutakoa) {
		diruFalta = guztiraPrez - sartutakoa;
		diruFalta = Math.round(diruFalta * 100.0) / 100.0;
		return diruFalta;
	}

	/**
	 * Arrayan sartzeko zenbat kantitate txanpon bakoitza eta bueltatu txanpona /
	 * billete.
	 * @author talde3
	 * @param diruFalta
	 * @return bueltakString
	 */
	public static String diruBueltakZerrenda(double diruFalta) {
		String bueltakString = "";
		int kont200 = 0, kont100 = 0, kont50, kont20, kont10, kont5, kont1;
		double bueltak = 0;
		if (diruFalta < 0) {
			bueltak = -diruFalta;
			for (double i = bueltak; i > 0; i = bueltak) {
				if (bueltak >= 200) {
					bueltak = bueltak - 200;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					kont200++;
					bueltakString = bueltakString + "200€-ko bilete \n";

				} else if (bueltak >= 100) {
					bueltak = bueltak - 100;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "100€-ko bilete \n";

				} else if (bueltak >= 50) {
					bueltak = bueltak - 50;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "50€-ko bilete \n";

				} else if (bueltak >= 20) {
					bueltak = bueltak - 20;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "20€-ko bilete \n";

				} else if (bueltak >= 10) {
					bueltak = bueltak - 10;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "10€-ko bilete \n";

				} else if (bueltak >= 5) {
					bueltak = bueltak - 5;
					bueltak = Math.round(bueltak * 100.0) / 100.0;
					bueltakString = bueltakString + "5€-ko bilete \n";

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
	

	//MetodoakKontsultak
	/**
	 * Bi daten artean zenbat egun festibo dauden jakiteko metodoa.
	 * @author talde3
	 * @param dataSartze
	 * @param dataIrtetze
	 * @param arrayEgunak
	 * @return festaKant
	 */
	public static int egunFestiboa(Date dataSartze, Date dataIrtetze, ArrayList<JaiEgunak> arrayEgunak) {
		int festaKant = 0;
		for (JaiEgunak jaiEgunak : arrayEgunak) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				if (jaiEgunak.getJaiEguna().equals(auxData))
					festaKant++;
			}
		}
		return festaKant;
	}

	/**
	 * Bi daten artean zenbat egun dauden denboraldi altuak jakiteko metodoa.
	 * @author talde3
	 * @param dataSartze
	 * @param dataIrtetze
	 * @return denboraldiAltuaKant
	 */
	public static int egunDenboraldiAltua(Date dataSartze, Date dataIrtetze) {
		int denboraldiAltuaKant = 0;
		int erresHilabetea = -1, erresEguna = -1;

		// 21-06-yyyy
		Date ekainaAltuaData = new Date();
		ekainaAltuaData.setMonth(5);
		ekainaAltuaData.setDate(21);

		for (Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
				.gehiEgunBat(auxData)) {
			erresHilabetea = auxData.getMonth();
			if (erresHilabetea == 0 || erresHilabetea == 1 || erresHilabetea == 2 || erresHilabetea == 6
					|| erresHilabetea == 7 || erresHilabetea == 10 || erresHilabetea == 11) {
				denboraldiAltuaKant++;
			} else if (erresHilabetea == 5)
				if (auxData.after(ekainaAltuaData))
					denboraldiAltuaKant++;
		}
		return denboraldiAltuaKant;
	}
	


	
	
}
