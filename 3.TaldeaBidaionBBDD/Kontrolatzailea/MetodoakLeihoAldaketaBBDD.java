package Kontrolatzailea;

import Ikuspegia.*;

public class MetodoakLeihoAldaketaBBDD {

	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);
	}

	public static void bigarrenLeihoa() {
		Leiho2Login Leiho2 = new Leiho2Login();
		Leiho2.setVisible(true);
	}

	public static void hirugarrenLeihoa() {
		Leiho3Erregistratu Leiho3 = new Leiho3Erregistratu();
		Leiho3.setVisible(true);

	}

	public static void laugarrenLeihoa() {
		Leiho4AukeratuAldaketa Leiho4 = new Leiho4AukeratuAldaketa();
		Leiho4.setVisible(true);
	}
	
	public static void bostgarrenLeihoa() {
		Leiho5OstatuakAldatu Leiho5 = new Leiho5OstatuakAldatu();
		Leiho5.setVisible(true);
	}

	
	public static void seigarrenLeihoa() {
		Leiho6PromozioakAldatu Leiho6 = new Leiho6PromozioakAldatu();
		Leiho6.setVisible(true);
	}

	
	public static void zazpigarrenLeihoa() {
		Leiho7ZerbitzuakAldatu Leiho7 = new Leiho7ZerbitzuakAldatu();
		Leiho7.setVisible(true);
	}


}
