package Kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import com.toedter.calendar.JDateChooser;

import Eredua.*;
import Ikuspegia.*;

public class MetodoakKontsultak {
	// Leiho2AukeratuOstatu

	/**
	 * Etxe baten prezioa ateratzeko kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param etxea
	 * @return Kontsultak.etxearenPrezioaBilatu(etxea)
	 */
	public static double etxearenPrezioaAtera(String etxea) {
		return Kontsultak.etxearenPrezioaBilatu(etxea);
	}

	/**
	 * Bi daten artean dauden festiboak eta denboraldi altuan izatekotan plusa
	 * gehitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param dataSartze
	 * @param dataIrtetze
	 * @return prezioa
	 */
	public static double tarifaAldatuDatengatik(java.util.Date dataSartze, java.util.Date dataIrtetze) {
		double prezioa = 0;
		ArrayList<JaiEgunak> arrayEgunak = new ArrayList<JaiEgunak>();
		arrayEgunak = Kontsultak.jaiEgunakAtera();
		int festaKant = Metodoak.egunFestiboa(dataSartze, dataIrtetze, arrayEgunak);
		int denboraldiAltuaKant = Metodoak.egunDenboraldiAltua(dataSartze, dataIrtetze);

		prezioa = (festaKant * 10) + (denboraldiAltuaKant * 20);

		return prezioa;
	}

	/**
	 * Herri guztiak ateratzen duen kontsultari deitzen duen metodoa
	 * 
	 * @author talde3
	 * @return arrayHerria
	 */
	public static ArrayList<String> ostatuHerria() {
		ArrayList<String> arrayHerria = new ArrayList<>();
		arrayHerria = Kontsultak.ostatuHerriak();
		return arrayHerria;
	}

	/**
	 * Hartutako egunen artean egun guztietan libre dauden hotelak ateratzen duen
	 * metodoa.
	 * 
	 * @author talde3
	 * @param herria
	 * @param dataSartze
	 * @param dataIrtetze
	 * @return arrayHotelak2
	 */
	public static ArrayList<Hotela> hotelakAtera(String herria, Date dataSartze, Date dataIrtetze) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		arrayHotelak = Kontsultak.hotelakBilatu(herria);
		boolean libre = false;
		ArrayList<Hotela> arrayHotelak2 = new ArrayList<Hotela>();
		for (Hotela h : arrayHotelak) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				libre = false;
				if (MetodoakKontsultak.erreserbaBetetaMet(auxData, h.getIzena(), h.getOstatuKod()))
					libre = true;
				else
					break;
			}
			if (libre == true)
				arrayHotelak2.add(h);
		}
		return arrayHotelak2;
	}

	/**
	 * Hartutako egunen artean egun guztietan libre dauden apartamentuak ateratzen
	 * duen metodoa.
	 * 
	 * @author talde3
	 * @param herria
	 * @param dataSartze
	 * @param dataIrtetze
	 * @return arrayApartamentua2
	 */
	public static ArrayList<Apartamentua> apartamentuakAtera(String herria, Date dataSartze, Date dataIrtetze) {
		ArrayList<Apartamentua> arrayApartamentua = new ArrayList<Apartamentua>();
		arrayApartamentua = Kontsultak.apartamentuakBilatu(herria);
		boolean libre = true;
		ArrayList<Apartamentua> arrayApartamentua2 = new ArrayList<Apartamentua>();
		for (Apartamentua a : arrayApartamentua) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				libre = true;
				if (MetodoakKontsultak.erreserbaBetetaMet(auxData, a.getIzena(), a.getOstatuKod()))
					libre = false;
			}
			if (libre == true)
				arrayApartamentua2.add(a);
		}
		return arrayApartamentua2;
	}

	/**
	 * Hartutako egunen artean egun guztietan libre dauden etxeak ateratzen duen
	 * metodoa.
	 * 
	 * @author talde3
	 * @param herria
	 * @param dataSartze
	 * @param dataIrtetze
	 * @return arrayEtxea2
	 */
	public static ArrayList<Etxea> etxeakAtera(String herria, Date dataSartze, Date dataIrtetze) {
		ArrayList<Etxea> arrayEtxea = new ArrayList<Etxea>();
		arrayEtxea = Kontsultak.etxeakBilatu(herria);
		boolean libre = true;
		ArrayList<Etxea> arrayEtxea2 = new ArrayList<Etxea>();
		for (Etxea e : arrayEtxea) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				libre = true;
				if (MetodoakKontsultak.erreserbaBetetaMet(auxData, e.getIzena(), e.getOstatuKod()))
					libre = false;
			}
			if (libre == true)
				arrayEtxea2.add(e);
		}
		return arrayEtxea2;
	}

	/**
	 * Hotela baten prezioa ateratzeko kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param hotela
	 * @return Kontsultak.hotelarenPrezioaBilatu(hotela)
	 */
	public static double hotelarenPrezioaAtera(String hotela) {
		return Kontsultak.hotelarenPrezioaBilatu(hotela);
	}

	// Leiho3EtxeDatuak
	/**
	 * Gela batean dauden datuak ateratzeko kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param ostatu_id
	 * @return Kontsultak.oheGelaEtxeakDatuak(ostatu_id)
	 */
	public static ArrayList<gelaMota_ohe_ostatu> oheGelaDatuakMet(int ostatu_id) {
		return Kontsultak.oheGelaEtxeakDatuak(ostatu_id);

	}

	/**
	 * Etxe batean dauden gela kantitatea ateratzeko kontsultari deitzen duen
	 * metodoa.
	 * 
	 * @author talde3
	 * @param ostatu_id
	 * @return Kontsultak.gelaKantMota(ostatu_id)
	 */
	public static ArrayList<GelaMotaEtxea> gelaKantMotaMet(int ostatu_id) {
		return Kontsultak.gelaKantMota(ostatu_id);

	}

	// Leiho3HotelDatuak
	/**
	 * Ostatu batean dauden ohe datuak ateratzeko kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param ostatu_id
	 * @return Kontsultak.oheGelaHotelaDatuak(ostatu_id)
	 */
	public static ArrayList<gelaMota_ohe_ostatu> oheGelaHotelaDatuakMet(int ostatu_id) {
		return Kontsultak.oheGelaHotelaDatuak(ostatu_id);

	}

	/**
	 * Bi daten artean dauden gela libreak ateratzen duen metodoa.
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param dataSartze
	 * @param dataIrtetze
	 * @param gelaKod
	 * @return gelaLibreak
	 */
	public static int gelaLibre(Ostatua hartutakoOstatua, Date dataSartze, Date dataIrtetze, int gelaKod) {
		int gelaTot = Kontsultak.gelaLibreKant(hartutakoOstatua, gelaKod);
		int gelaLibreak = 0, erreserbaKant = 0;

		for (Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
				.gehiEgunBat(auxData)) {
			int auxErreserbaKant = Kontsultak.gelaErreserbaKant(hartutakoOstatua, gelaKod, auxData);
			if (erreserbaKant < auxErreserbaKant)
				erreserbaKant = auxErreserbaKant;
		}
		gelaLibreak = gelaTot - erreserbaKant;

		return gelaLibreak;

	}

	// Leiho4ZerbitzuGehigarriak
	/**
	 * Hartutako ostatuaren zerbituak ateratzen duen kontsultari deitzen duen
	 * metodoa.
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @return Kontsultak.zerbitzuGehigarriakOstatuan(hartutakoOstatua)
	 */
	public static ArrayList<HartutakoOstatuarenZerbitzuak> zerbitzuakOstatuanMet(Ostatua hartutakoOstatua) {
		return Kontsultak.zerbitzuGehigarriakOstatuan(hartutakoOstatua);
	}

	// Leiho5Login
	/**
	 * Sartutako pasahitza (zifratuta) ea datu basean dagoen ala ez.
	 * 
	 * @author talde3
	 * @param pasahitza
	 * @return bal
	 */
	public static boolean frogatuPasahitza(String pasahitza) {
		boolean bal = false;
		String pasaEnkr = "";
		pasaEnkr = Metodoak.zifratuHitza(pasahitza);
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
	 * @author talde3
	 * @param nan
	 * @return bal
	 */
	public static boolean frogatuNAN(String nan) {
		boolean bal = false;
		ArrayList<Bezeroa> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.bezeroDatuak();
		nan = Metodoak.zifratuHitza(nan);
		for (Bezeroa bezeroak2 : bezeroak) {
			if (nan.equals(bezeroak2.getNan()))
				bal = true;
		}
		return bal;
	}

	// Leiho6Erregistratu
	/**
	 * Frogatu dni-a erregistratuta ez dagoela. Ez balegoke eta datuak hutzik ere
	 * ez, bezeroen erregistroa egin datu basean.
	 * 
	 * @author talde3
	 * @param pasahitza
	 * @param nan
	 * @param izena
	 * @param abizenak
	 * @param jaioDataString
	 * @return bal
	 */
	public static boolean erregistratuBezeroak(String pasahitza, String nan, String izena, String abizenak,
			String jaioDataString) {
		boolean bal = true;
		pasahitza = Metodoak.zifratuHitza(pasahitza);
		nan = Metodoak.zifratuHitza(nan);
		izena = Metodoak.zifratuHitza(izena);
		abizenak = Metodoak.zifratuHitza(abizenak);
		jaioDataString = Metodoak.zifratuHitza(jaioDataString);

		ArrayList<Bezeroa> bezeroak = new ArrayList<>();

		// fitxeroari bidali
		if (pasahitza.length() == 0 || nan.length() < 8 || izena.isEmpty() || abizenak.isEmpty() || nan.length() < 8
				|| jaioDataString == null || nanGordetaEgon(nan))
			bal = false;

		if (bal && !nanGordetaEgon(nan)) {
			bezeroak = Kontsultak.erregistratuBezeroak(pasahitza, nan, izena, abizenak, jaioDataString);
		}
		return bal;
	}

	/**
	 * Frogatu dni-a erregistratuta ez dagoela.
	 * 
	 * @author talde3
	 * @param nan
	 * @return balNan
	 */
	public static boolean nanGordetaEgon(String nan) {
		ArrayList<Bezeroa> bezeroak = new ArrayList<>();
		boolean balNan = false;
		bezeroak = Kontsultak.bezeroDatuak();
		for (Bezeroa bezeroak2 : bezeroak) {
			if (bezeroak2.getNan().equals(nan)) {
				balNan = true;
			}
		}
		return balNan;
	}

	// Leiho8KodePromozionalak
	/**
	 * Bezero zehatz batek zein promozio dituen bilatzen duen metodoa.
	 * 
	 * @author talde3
	 * @param nan
	 * @return Kontsultak.promozioakBilatu(nan)
	 */
	public static ArrayList<Promozioa> promozioakBilatuMet(String nan) {
		nan = Metodoak.zifratuHitza(nan);
		return Kontsultak.promozioakBilatu(nan);

	}

	// Leiho9Ordaindu
	/**
	 * Erreserba gordetzeko kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param erreserba
	 * @param prezioTot
	 */
	public static void erreserbaGordeMet(Erreserba erreserba, double prezioTot) {
		Kontsultak.erreserbaGorde(erreserba, prezioTot);
	}

	/**
	 * Base legalak onartu dituela kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param erreserbaKod
	 */
	public static void baseLegalakIgoMet(int erreserbaKod) {
		Kontsultak.baseLegalakIgo(erreserbaKod);
	}

	/**
	 * Erreserbak zenbatzen dituen kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @return Kontsultak.erreserbakZenbatu()
	 */
	public static int erreserbakZenbatuMet() {
		return Kontsultak.erreserbakZenbatu();
	}

	/**
	 * Promozio bat erabili duela kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param promozioa
	 */
	public static void promozioaErabilitaMet(Promozioa promozioa) {
		Kontsultak.promozioaErabilita(promozioa);
	}

	/**
	 * Erreserba egin duela kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param erreserba
	 * @param dataSartze
	 * @param dataIrtetze
	 */
	public static void erresJaiEgunIgoMet(Erreserba erreserba, Date dataSartze, Date dataIrtetze) {
		int erresHilabetea = -1, erresEguna = -1;
		String denboraldia = "baxua";

		// 21-06-yyyy
		Date ekainaAltuaData = new Date();
		ekainaAltuaData.setMonth(5);
		ekainaAltuaData.setDate(21);

		for (Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
				.gehiEgunBat(auxData)) {
			erresHilabetea = auxData.getMonth();
			if (erresHilabetea == 0 || erresHilabetea == 1 || erresHilabetea == 2 || erresHilabetea == 6
					|| erresHilabetea == 7 || erresHilabetea == 10 || erresHilabetea == 11) {
				denboraldia = "altua";
			} else if (erresHilabetea == 5) {
				if (auxData.after(ekainaAltuaData))
					denboraldia = "altua";
			} else {
				denboraldia = "baxua";
			}

			Kontsultak.erresJaiEgunIgoMet(auxData, denboraldia);
		}
	}

	public static void zerbiErregisIgoMet(ArrayList<HartutakoOstatuarenZerbitzuak> hartutakoZerbitzuArray) {
		for (HartutakoOstatuarenZerbitzuak h : hartutakoZerbitzuArray) {
			if (h.getHartuta()!=null && h.getHartuta().equals("Bai"))
				Kontsultak.zerbiErregisIgo(h.getKodZerbitzua());
		}
	}

	/**
	 * Erreserba egin duela kontsultari deitzen duen metodoa.
	 * 
	 * @author talde3
	 * @param gelaMotaErreserba
	 */
	public static void gelaMotaErreserbaIgoMet(ArrayList<GelaMotaErreserba> gelaMotaErreserba) {
		for (GelaMotaErreserba gelaMotaErreserba2 : gelaMotaErreserba) {
			Kontsultak.gelaMotaErreserbaIgo(gelaMotaErreserba2);
		}

	}

	// MetodoakKontsultak

	/**
	 * @author talde3
	 * @param data
	 * @param izena
	 * @param kodea
	 * @return Kontsultak.erreserbaBeteta(data, izena, kodea)
	 */
	public static boolean erreserbaBetetaMet(Date data, String izena, int kodea) {
		return Kontsultak.erreserbaBeteta(data, izena, kodea);

	}

	/**
	 * /** Ostatuari + bat egin erreserbetan
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 */
	public static void ostatuErreserbaKopuruBerriaMet(Ostatua hartutakoOstatua) {
		Kontsultak.ostatuErreserbaKopuruBerria(hartutakoOstatua);

	}

}
