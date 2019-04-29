package Kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Eredua.*;
import Ikuspegia.*;

public class MetodoakKontsultak {

	// Leiho2-ko metodoak
	/**
	 * Frogatu dni-a erregistratuta ez dagoela.
	 * 
	 * @author talde1
	 * @param nan
	 * @return balNan
	 */
	/*public static boolean nanGordetaEgon(String nan) {
		ArrayList<Langilea> bezeroak = new ArrayList<>();
		boolean balNan = true;
		bezeroak = Kontsultak.bezeroDatuak();
		for (Langilea bezeroak2 : bezeroak) {
			if (bezeroak2.getNan().equals(nan)) {
				balNan = false;
			}
		}
		return balNan;
	}*/

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
		ArrayList<Langilea> bezeroak = new ArrayList<Langilea>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Langilea bezeroak2 : bezeroak) {
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
		ArrayList<Langilea> bezeroak = new ArrayList<>();
		bezeroak = Kontsultak.bezeroDatuak();
		for (Langilea bezeroak2 : bezeroak) {
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
	public static ArrayList<String> ostatuIzenak() {
		ArrayList<String> arrayIzenak = new ArrayList<>();
		arrayIzenak = Kontsultak.ostatuIzenak();
		return arrayIzenak;
	}

	public static boolean nanGordetaEgon(String nan) {
		boolean bal=false;
		int pertsonaKant=Kontsultak.bilatuPertsNan(nan);
		int langileKant=Kontsultak.bilatuLangNan(nan);
		if (langileKant!=1 && pertsonaKant!=1)
			bal=true;
		return bal;
	}
	
	public static boolean erregistratuBezeroak(String pasahitza, String nan, String izena, String abizenak,
			String jaioDataString, int ostatu_id) {
		boolean bal = true;
		int pertsonaKant, langileKant;

		// fitxeroari bidali
		if (pasahitza.length() == 0 || nan.length() < 9 || izena.isEmpty() || abizenak.isEmpty()
				|| jaioDataString == null)
			bal = false;

		if (bal) {
			pertsonaKant=Kontsultak.bilatuPertsNan(nan);
			langileKant=Kontsultak.bilatuLangNan(nan);
			
			if (pertsonaKant==0)
				Kontsultak.erregistratuPertsonak(pasahitza, nan, izena, abizenak, jaioDataString);
			
			if (langileKant==0)
				Kontsultak.erregistratuLangileak(nan, ostatu_id);
			
			
			
		}
		return bal;
	}

}
