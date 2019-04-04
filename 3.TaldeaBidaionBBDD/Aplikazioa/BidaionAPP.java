package Aplikazioa;

import Kontrolatzailea.*;
 
public class BidaionAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String basedatos = "bidaion";
		Konexioa konex = new Konexioa(basedatos);
		konex.getConexion();
		
	//Metodoak.lehenengoLeihoa();

	}

}
