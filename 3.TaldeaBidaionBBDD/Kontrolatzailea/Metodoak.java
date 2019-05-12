package Kontrolatzailea;

import java.math.BigInteger;
import java.security.*;

public class Metodoak {
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

}
