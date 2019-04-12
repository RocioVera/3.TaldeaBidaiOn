package Kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Eredua.*;
import Ikuspegia.*;

public class MetodoakLeihoAldaketa {

	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);

	}

	public static void bigarrenLeihoa() {
		Leiho2AukeratuOstatu Leiho2 = new Leiho2AukeratuOstatu();
		Leiho2.setVisible(true);
	}

	public static void hirugarrenLeihoa(Hotela hartutakoHotela, Date dataSartze, Date dataIrtetze) {
		Leiho3OstatuDatuak Leiho3 = new Leiho3OstatuDatuak(hartutakoHotela, dataSartze, dataIrtetze);
		Leiho3.setVisible(true);

	}

	public static void laugarrenLeihoa(Hotela hartutakoHotela, double prezioTot, Date dataSartzeString,
			Date dataIrtetzeString, gelaMota_ohe_hotela h2) {
		Leiho4ZerbitzuGehigarriak Leiho4 = new Leiho4ZerbitzuGehigarriak(hartutakoHotela, prezioTot, dataSartzeString,
				dataIrtetzeString, h2);
		Leiho4.setVisible(true);
	}

	public static void bostgarrenLeihoa(Hotela hartutakoHotela, double prezioTot, Date sartzeData,
			Date irtetzeData, gelaMota_ohe_hotela h2) {
		Leiho5Login Leiho5 = new Leiho5Login(hartutakoHotela, prezioTot, sartzeData, irtetzeData, h2);
		Leiho5.setVisible(true);
	}

	public static void seigarrenLeihoa(Hotela hartutakoHotela, double prezioTot, Date sartzeData,
			Date irtetzeData, gelaMota_ohe_hotela h2) {
		Leiho6Erregistratu Leiho6 = new Leiho6Erregistratu(hartutakoHotela, prezioTot, sartzeData, irtetzeData, h2);
		Leiho6.setVisible(true);
	}

	public static void zazpigarrenLeihoa(Hotela hartutakoHotela, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, gelaMota_ohe_hotela h2) {
		Leiho7Ordaindu Leiho7 = new Leiho7Ordaindu(prezioTot, hartutakoHotela, sartzeData, irtetzeData, nan, h2);
		Leiho7.setVisible(true);
	}

	public static void zortzigarrenLeihoa(Hotela hartutakoHotela, Date sartzeData, Date irtetzeData,
			double prezioTot, String nan, gelaMota_ohe_hotela h2) {
		Leiho8Ticket Leiho8 = new Leiho8Ticket(hartutakoHotela, sartzeData, irtetzeData, prezioTot, nan, h2);
		Leiho8.setVisible(true);
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
