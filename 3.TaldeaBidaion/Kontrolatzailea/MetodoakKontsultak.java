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
	// Leiho2-ko metodoak
	public static ArrayList<String> hotelHerria() {
		ArrayList<String> arrayHerria = new ArrayList<>();
		arrayHerria = Kontsultak.hotelHerriak();
		return arrayHerria;
	}

	public static ArrayList<Hotela> hotelakAtera(String herria, Date dataSartze, Date dataIrtetze) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		arrayHotelak = Kontsultak.hotelakBilatu(herria);
		boolean libre = false;
		ArrayList<Hotela> arrayHotelak2 = new ArrayList<Hotela>();
		for (Hotela h : arrayHotelak) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				libre = false;
				if (MetodoakKontsultak.erreserbaBetetaMet(auxData, h.getIzena(), h.getHotelKod()))
					libre = true;
				else 
					break;
			}
			if (libre == true)
				arrayHotelak2.add(h);
		}
		return arrayHotelak2;
	}

	public static ArrayList<Etxea> etxeakAtera(String herria, Date dataSartze, Date dataIrtetze) {
		ArrayList<Etxea> arrayEtxea = new ArrayList<Etxea>();
		arrayEtxea = Kontsultak.etxeakBilatu(herria);
		boolean libre = true;
		ArrayList<Etxea> arrayEtxea2 = new ArrayList<Etxea>();
		for (Etxea e : arrayEtxea) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				libre = true;
				if (MetodoakKontsultak.erreserbaBetetaMet(auxData, e.getIzena(), e.getEtxeKod()))
					libre = false;
			}
			if (libre == true)
				arrayEtxea2.add(e);
		}
		return arrayEtxea2;
	}

	public static ArrayList<Apartamentua> apartamentuakAtera(String herria, Date dataSartze, Date dataIrtetze) {
		ArrayList<Apartamentua> arrayApartamentua = new ArrayList<Apartamentua>();
		arrayApartamentua = Kontsultak.apartamentuakBilatu(herria);
		boolean libre = true;
		ArrayList<Apartamentua> arrayApartamentua2 = new ArrayList<Apartamentua>();
		for (Apartamentua a : arrayApartamentua) {
			for (java.util.Date auxData = dataSartze; auxData.getTime() < dataIrtetze.getTime(); auxData = Metodoak
					.gehiEgunBat(auxData)) {
				libre = true;
				if (MetodoakKontsultak.erreserbaBetetaMet(auxData, a.getIzena(), a.getEtxeKod()))
					libre = false;
			}
			if (libre == true)
				arrayApartamentua2.add(a);
		}
		return arrayApartamentua2;
	}

	public static double hotelarenPrezioaAtera(String hotela) {
		double prezioa = 0;
		prezioa = Kontsultak.hotelarenPrezioaBilatu(hotela);
		return prezioa;
	}

	public static double etxearenPrezioaAtera(String etxea) {
		double prezioa = 0;
		prezioa = Kontsultak.etxearenPrezioaBilatu(etxea);
		return prezioa;
	}

	public static double apartamentuarenPrezioaAtera(String apartamentua) {
		double prezioa = 0;
		prezioa = Kontsultak.apartamentuarenPrezioaBilatu(apartamentua);
		return prezioa;
	}

	public static boolean erreserbaBetetaMet(Date data, String izena, int kodea) {
		boolean erantzuna = false;
		erantzuna = Kontsultak.erreserbaBeteta(data, izena, kodea);
	return erantzuna;

	}

	// Leiho3-ko metodoak
	// oheGelaHotelaDatuak
	public static ArrayList<gelaMota_ohe_hotela> oheGelaHotelaDatuakMet(int ostatu_id) {
		return Kontsultak.oheGelaHotelaDatuak(ostatu_id);
	}

	// Leiho4-ko metodoak
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
		pasaEnkr = Metodoak.zifratuPasahitza(pasahitza);
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
		pasaEnkr = Metodoak.zifratuPasahitza(pasahitza);
		System.out.println(pasaEnkr);
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

	// Leiho4-ko metodoak

	// Leiho5-ko metodoak

}
