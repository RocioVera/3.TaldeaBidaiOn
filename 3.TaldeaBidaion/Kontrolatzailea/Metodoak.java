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

	public static void hirugarrenLeihoa() {
		Leiho3Login Leiho3 = new Leiho3Login();
		Leiho3.setVisible(true);

	}

	public static void laugarrenLeihoa() {
		Leiho4OstatuDatuak Leiho4 = new Leiho4OstatuDatuak();
		Leiho4.setVisible(true);
	}

	public static void bostgarrenLeihoa() {
		double guztiraPrez = 10.99;
		Leiho5Ordaindu Leiho5 = new Leiho5Ordaindu(guztiraPrez);
		Leiho5.setVisible(true);
	}

	public static void seigarrenLeihoa() {
		Leiho6Ticket Leiho6 = new Leiho6Ticket();
		Leiho6.setVisible(true);
	}

	// Leiho2-ko metodoak
	public static ArrayList<Hotela> hotelakAtera(String herria) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		arrayHotelak=Kontsultak.hotelakBilatu(herria);
		return arrayHotelak;
	}
	
	
	// Leiho3-ko metodoak

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

	public static void fitxIdatzi() {
		FileWriter fitx = null;
		PrintWriter pw = null;

		try {
			fitx = new FileWriter("eredua\\ErreserbaFitx", true);
			pw = new PrintWriter(fitx);

			pw.println("kaixo");

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
