package Aplikazioa;

import Kontrolatzailea.*;

public class BidaionAPP {

	public static void main(String[] args) {
		String basedatos = "bidaion";
		Konexioa konex = new Konexioa(basedatos);
		konex.getConexion();
		
		MetodoakLeihoAldaketa.lehenengoLeihoa();

	}

}
