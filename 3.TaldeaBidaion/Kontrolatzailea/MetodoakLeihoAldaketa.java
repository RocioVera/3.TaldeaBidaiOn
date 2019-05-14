package Kontrolatzailea;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Eredua.*;
import Ikuspegia.*;

public class MetodoakLeihoAldaketa {

	/**
	 * Leiho aldaketa1
	 * @author talde3
	 */
	public static void lehenengoLeihoa() {
		Leiho1OngiEtorria Leiho1 = new Leiho1OngiEtorria();
		Leiho1.setVisible(true);

	}

	/**
	 * Leiho aldaketa2
	 * @author talde3
	 */
	public static void bigarrenLeihoa() {
		Leiho2AukeratuOstatu Leiho2 = new Leiho2AukeratuOstatu();
		Leiho2.setVisible(true);
	}

	/**
	 * Leiho aldaketa3Hotelak
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param dataSartze
	 * @param dataIrtetze
	 */
	public static void hirugarrenLeihoaHotelak(Ostatua hartutakoOstatua, Date dataSartze, Date dataIrtetze) { 
		Leiho3HotelDatuak Leiho3 = new Leiho3HotelDatuak(hartutakoOstatua, dataSartze, dataIrtetze);
		Leiho3.setVisible(true);

	}
	
	/**
	 * Leiho aldaketa3Etxeak
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param dataSartze
	 * @param dataIrtetze
	 */
	public static void hirugarrenLeihoaEtxeak(Ostatua hartutakoOstatua, double prezioTot, Date dataSartze, Date dataIrtetze) { 
		Leiho3EtxeDatuak Leiho3 = new Leiho3EtxeDatuak(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze);
		Leiho3.setVisible(true);

	}

	/**
	 * Leiho aldaketa4
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param dataSartzeString
	 * @param dataIrtetzeString
	 * @param logelaTot
	 * @param pertsonaKop
	 */
	public static void laugarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date dataSartzeString,
			Date dataIrtetzeString, int logelaTot, int pertsonaKop) {
		Leiho4ZerbitzuGehigarriak Leiho4 = new Leiho4ZerbitzuGehigarriak(hartutakoOstatua, prezioTot, dataSartzeString,
				dataIrtetzeString, logelaTot, pertsonaKop);
		Leiho4.setVisible(true);
	}

	/**
	 * Leiho aldaketa5
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param sartzeData
	 * @param irtetzeData
	 * @param logelaTot
	 * @param pertsonaKop
	 * @param pentsioMota
	 */
	public static void bostgarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, int logelaTot,  int pertsonaKop, String pentsioMota) {
		Leiho5Login Leiho5 = new Leiho5Login(hartutakoOstatua, prezioTot, sartzeData, irtetzeData,logelaTot, pertsonaKop, pentsioMota);
		Leiho5.setVisible(true);
	}

	/**
	 * Leiho aldaketa6
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param sartzeData
	 * @param irtetzeData
	 * @param logelaTot
	 * @param pertsonaKop
	 * @param pentsioMota
	 */
	public static void seigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, int logelaTot,  int pertsonaKop, String pentsioMota) {
		Leiho6Erregistratu Leiho6 = new Leiho6Erregistratu(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop, pentsioMota);
		Leiho6.setVisible(true);
	}
	
	/**
	 * Leiho aldaketa7
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param sartzeData
	 * @param irtetzeData
	 * @param nan
	 * @param logelaTot
	 * @param pertsonaKop
	 * @param pentsioMota
	 */
	public static void zazpigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, int logelaTot, int pertsonaKop, String pentsioMota) {
		Leiho7BaseLegalak Leiho7 = new Leiho7BaseLegalak(prezioTot, hartutakoOstatua, sartzeData, irtetzeData, nan, logelaTot, pertsonaKop, pentsioMota);
		Leiho7.setVisible(true);
	}

	/**
	 * Leiho aldaketa8
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param sartzeData
	 * @param irtetzeData
	 * @param nan
	 * @param gelaTot
	 * @param pertsonaKop
	 * @param pentsioMota
	 */
	public static void zortzigarrenLeihoa(Ostatua hartutakoOstatua, double prezioTot, Date sartzeData,
			Date irtetzeData, String nan, int gelaTot, int pertsonaKop, String pentsioMota) {
		Erreserba erreserba=new Erreserba(hartutakoOstatua.getOstatuKod(), nan, pertsonaKop, prezioTot, gelaTot, pentsioMota);
		erreserba.setErreserbaKod(hartutakoOstatua.getOstatuKod()); //bestela 0 agertzen da
		Leiho8KodePromozionalak Leiho8 = new Leiho8KodePromozionalak(hartutakoOstatua, sartzeData, irtetzeData, erreserba);
		Leiho8.setVisible(true);
	}
	
	/**
	 * Leiho aldaketa9
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param sartzeData
	 * @param irtetzeData
	 * @param erreserba
	 * @param promHartu
	 */
	public static void bederatzigarrenLeihoa(Ostatua hartutakoOstatua, Date sartzeData,
			Date irtetzeData,Erreserba erreserba, Promozioa promHartu) {
		Leiho9Ordaindu Leiho9 = new Leiho9Ordaindu(hartutakoOstatua, sartzeData, irtetzeData, promHartu, erreserba);
		Leiho9.setVisible(true);
	}
	
	/**
	 * Leiho aldaketa10
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param sartzeData
	 * @param irtetzeData
	 * @param erreserba
	 */
	public static void hamargarrenLeihoa(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData, Erreserba erreserba) {
		Leiho10Ticket Leiho10 = new Leiho10Ticket(hartutakoOstatua, sartzeData, irtetzeData, erreserba);
		Leiho10.setVisible(true);
	}

	// Leiho6-ko metodoak
	/**
	 * Leiho aldaketaren 5 segunduak itxaroteko
	 * @author talde3
	 */
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
