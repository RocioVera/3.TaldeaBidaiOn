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
	public static void hirugarrenLeihoaEtxeak(Ostatua hartutakoOstatua, double prezioTot, Date dataSartze, Date dataIrtetze) { 
		Leiho3EtxeDatuak Leiho3 = new Leiho3EtxeDatuak(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze);
		Leiho3.setVisible(true);

	}

	public static void laugarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date dataSartzeString,
			Date dataIrtetzeString, int logelaTot, int pertsonaKop) {
		Leiho4ZerbitzuGehigarriak Leiho4 = new Leiho4ZerbitzuGehigarriak(hartutakoOstatua, prezioTot, dataSartzeString,
				dataIrtetzeString, logelaTot, pertsonaKop);
		Leiho4.setVisible(true);
	}

	public static void bostgarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, int logelaTot,  int pertsonaKop) {
		Leiho5Login Leiho5 = new Leiho5Login(hartutakoOstatua, prezioTot, sartzeData, irtetzeData,logelaTot, pertsonaKop);
		Leiho5.setVisible(true);
	}

	public static void seigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, int logelaTot,  int pertsonaKop) {
		Leiho6Erregistratu Leiho6 = new Leiho6Erregistratu(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop);
		Leiho6.setVisible(true);
	}
	
	public static void zazpigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, int logelaTot, int pertsonaKop) {
		Leiho7BaseLegalak Leiho7 = new Leiho7BaseLegalak(prezioTot, hartutakoOstatua, sartzeData, irtetzeData, nan, logelaTot, pertsonaKop);
		Leiho7.setVisible(true);
	}

	public static void zortzigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, int logelaTot, int pertsonaKop) {
		Leiho8KodePromozionalak Leiho8 = new Leiho8KodePromozionalak(prezioTot, hartutakoOstatua, sartzeData, irtetzeData, nan, logelaTot, pertsonaKop);
		Leiho8.setVisible(true);
	}
	
	public static void bederatzigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, int logelaTot, Promozioa promHartu, int pertsonaKop) {
		Leiho9Ordaindu Leiho9 = new Leiho9Ordaindu(prezioTot, hartutakoOstatua, sartzeData, irtetzeData, nan, logelaTot, promHartu, pertsonaKop);
		Leiho9.setVisible(true);
	}

	
	public static void hamargarrenLeihoa(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData,
			double prezioTot, String nan, int logelaTot, int pertsonaKop) {
		Leiho10Ticket Leiho10 = new Leiho10Ticket(hartutakoOstatua, sartzeData, irtetzeData, prezioTot, nan, logelaTot, pertsonaKop);
		Leiho10.setVisible(true);
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
