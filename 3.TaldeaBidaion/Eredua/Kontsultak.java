package Eredua;

import java.util.ArrayList;
import java.sql.*;
import Kontrolatzailea.*;

public class Kontsultak {

	//Leiho2-ko kontsultak
	public static ArrayList<Hotela> hotelakBilatu(String herria) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int izarKop, ostatu_id, postKod, gelaKop, erreserbaKop;
		String izena, helbidea, ostatuMota;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `hotela` h,`ostatu` o where o.herria LIKE '"+herria+"' and h.hotel_kod LIKE o.ostatu_id");
			while (rs.next()) {
				izarKop = (rs.getInt("izarkop"));
				ostatu_id = (rs.getInt("ostatu_id"));
				izena = (rs.getString("izena"));
				helbidea = (rs.getString("helbidea"));
				postKod = (rs.getInt("postaKod"));
				ostatuMota = (rs.getString("ostatu_mota"));
				gelaKop = (rs.getInt("gela_kopuru"));
				erreserbaKop = (rs.getInt("erreserba_kopuru"));

				Hotela hotela = new Hotela(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop, izarKop, ostatu_id);
				arrayHotelak.add(hotela);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayHotelak;
	}
	
	public static double hotelarenPrezioaBilatu(String izena) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		double prezioa=0;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT prezioa FROM `gelamota_hotela` gh, `gelamota` g , `hotela` h WHERE gh.gela_hotel_kod=h.hotel_kod AND g.gela_kodea=gh.gelaMota_gela_kodea "+ 
				    "AND g.mota like lower('logela') AND h.hotel_kod IN (SELECT ostatu_id FROM `ostatu` WHERE lower(ostatu.izena)"+ 
				                 	"LIKE lower('"+izena+"'))");
			//ResultSet rs = st.executeQuery("SELECT gelaPrezioa FROM `hotel_preziominimoa`, `ostatu` WHERE hotelKod LIKE ostatu_id AND lower(ostatu.izena) LIKE lower('"+izena+"')");

			while (rs.next()) {
				prezioa = (rs.getDouble("prezioa"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prezioa;
	}

	//Lehio3-ko kontsultak
	/**
	 * Bezero (cliente) taulako datuak hartu.
	 * @author talde1
	 * @return arrayBezeroak
	 */
	public static ArrayList<Bezeroa> bezeroDatuak() {
		ArrayList<Bezeroa> arrayBezeroak = new ArrayList<Bezeroa>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String izena, abizenak, NAN, pasahitza;
		java.sql.Date data;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT * FROM bezeroa");
			while (rs.next()) {
				NAN = (rs.getString(1));
				izena = (rs.getString(2));
				abizenak = (rs.getString(3));
				data = (rs.getDate(4));
				pasahitza = (rs.getString(5));
				Bezeroa bezeroa = new Bezeroa(NAN, izena, abizenak, data, pasahitza);
				arrayBezeroak.add(bezeroa);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arrayBezeroak;
	}

	//Leiho3-ko insertak
	/**
	 * Bezero berriak erregistratu.
	 * @author talde1
	 * @param pasahitza
	 * @param NAN
	 * @param izena
	 * @param abizenak
	 * @param sexua
	 * @param jaioData
	 * @return arrayBezeroak
	 */
	public static ArrayList<Bezeroa> erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak,
			String jaioData) {
		ArrayList<Bezeroa> arrayBezeroak = new ArrayList<Bezeroa>();
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `bezeroa` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			st.setString(1, NAN);
			st.setString(2, izena);
			st.setString(3, abizenak);
			st.setString(4, jaioData);
			st.setString(5, pasahitza);
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu");
		}
		arrayBezeroak = bezeroDatuak();
		return arrayBezeroak;
	}
}
