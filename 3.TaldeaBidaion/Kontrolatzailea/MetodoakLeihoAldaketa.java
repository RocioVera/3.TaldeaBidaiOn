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

	public static void hirugarrenLeihoaHotelak(Ostatua hartutakoOstatua, Date dataSartze, Date dataIrtetze) { 
		Leiho3HotelDatuak Leiho3 = new Leiho3HotelDatuak(hartutakoOstatua, dataSartze, dataIrtetze);
		Leiho3.setVisible(true);

	}

	public static void laugarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date dataSartzeString,
			Date dataIrtetzeString, int logelaTot) {
		Leiho4ZerbitzuGehigarriak Leiho4 = new Leiho4ZerbitzuGehigarriak(hartutakoOstatua, prezioTot, dataSartzeString,
				dataIrtetzeString, logelaTot);
		Leiho4.setVisible(true);
	}

	public static void bostgarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, int logelaTot) {
		Leiho5Login Leiho5 = new Leiho5Login(hartutakoOstatua, prezioTot, sartzeData, irtetzeData,logelaTot);
		Leiho5.setVisible(true);
	}

	public static void seigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, int logelaTot) {
		Leiho6Erregistratu Leiho6 = new Leiho6Erregistratu(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, logelaTot);
		Leiho6.setVisible(true);
	}

	public static void zazpigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, int logelaTot) {
		Leiho7Ordaindu Leiho7 = new Leiho7Ordaindu(prezioTot, hartutakoOstatua, sartzeData, irtetzeData, nan, logelaTot);
		Leiho7.setVisible(true);
	}

	
	public static void zortzigarrenLeihoa(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData,
			double prezioTot, String nan, int logelaTot) {
		Leiho8Ticket Leiho8 = new Leiho8Ticket(hartutakoOstatua, sartzeData, irtetzeData, prezioTot, nan, logelaTot);
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
