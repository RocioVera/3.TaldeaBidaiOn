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

	public static ArrayList<Hotela> hotelakAtera(String herria) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		arrayHotelak = Kontsultak.hotelakBilatu(herria);
		return arrayHotelak;
	}
	
	public static ArrayList<Etxea> etxeakAtera(String herria) {
		ArrayList<Etxea> arrayEtxea = new ArrayList<Etxea>();
		arrayEtxea = Kontsultak.etxeakBilatu(herria);
		return arrayEtxea;
	}
	
	public static ArrayList<Apartamentua> apartamentuakAtera(String herria) {
		ArrayList<Apartamentua> arrayApartamentua = new ArrayList<Apartamentua>();
		arrayApartamentua = Kontsultak.apartamentuakBilatu(herria);
		return arrayApartamentua;
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
	

	public static boolean erreserbaBetetaMet(Date data, ArrayList<Hotela> arrayHotelak) {
		String izena = "";
		int hotel_kodea = 0;
		boolean erantzuna=false; 
		for (Hotela hotela : arrayHotelak) {
			izena=hotela.getIzena();
			hotel_kodea=hotela.getHotelKod();
			erantzuna=Kontsultak.erreserbaBeteta(data, izena, hotel_kodea);
			if (erantzuna) {
				break;
			}
		}
		return erantzuna;

	}
	
	
	
	// Leiho3-ko metodoak
	//oheGelaHotelaDatuak
	public static ArrayList<gelaMota_ohe_hotela> oheGelaHotelaDatuakMet(int ostatu_id) {
		return Kontsultak.oheGelaHotelaDatuak(ostatu_id);
	}	
	
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
