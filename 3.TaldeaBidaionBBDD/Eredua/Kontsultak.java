package Eredua;

import java.util.ArrayList;
import java.sql.*;
import Kontrolatzailea.*;

public class Kontsultak {

	//Leiho2-ko kontsultak
	/**
	 * Bezero (cliente) taulako datuak hartu.
	 * 
	 * @author talde1
	 * @return arrayBezeroak
	 */
	public static ArrayList<Langilea> bezeroDatuak() {
		ArrayList<Langilea> arrayBezeroak = new ArrayList<Langilea>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String izena, abizenak, NAN, pasahitza;
		int ostatu_id;
		java.sql.Date data;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT p.*, l.ostatu_id FROM langilea l, pertsona p where l.nan=p.nan");
			while (rs.next()) {
				NAN = (rs.getString(1));
				izena = (rs.getString(2));
				abizenak = (rs.getString(3));
				data = (rs.getDate(4));
				pasahitza = (rs.getString(5));
				ostatu_id = (rs.getInt(6));
				Langilea bezeroa = new Langilea(NAN, izena, abizenak, data, pasahitza, ostatu_id);
				arrayBezeroak.add(bezeroa);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayBezeroak;
	}

	public static int bilatuPertsNan(String nan) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int pertsonaKant=0;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT count(nan) FROM pertsona where nan like '"+nan+"'");
			while (rs.next()) {
				pertsonaKant = (rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pertsonaKant;
	}

	public static int bilatuLangNan(String nan) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int langileKant=0;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT count(nan) FROM langilea where nan like '"+nan+"'");
			while (rs.next()) {
				langileKant = (rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return langileKant;
	}
	
	public static ArrayList<String> ostatuIzenak() {
		ArrayList<String> arrayOstatua = new ArrayList<>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String izena;
		ResultSet rs = null;

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT DISTINCT(izena) FROM `ostatu`");
			while (rs.next()) {
				izena = (rs.getString("izena"));
				arrayOstatua.add(izena);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayOstatua;
	}

	
	//leiho2 insert
	/**
	 * Bezero berriak erregistratu.
	 * 
	 * @author talde1
	 * @param pasahitza
	 * @param NAN
	 * @param izena
	 * @param abizenak
	 * @param sexua
	 * @param jaioData
	 * @return arrayBezeroak
	 */
	public static void erregistratuPertsonak(String pasahitza, String NAN, String izena, String abizenak,
			String jaioData) {
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa
					.prepareStatement("INSERT INTO `pertsona` (`nan`, `izena`, `abizenak`, `jaiotze_data`, `pasahitza`)"
							+ " VALUES(?, ?, ?, ?, ?)");
			st.setString(1, NAN);
			st.setString(2, izena);
			st.setString(3, abizenak);
			st.setString(4, jaioData);
			st.setString(5, pasahitza);
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da pertsona");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu pertsona");
		}
	}
	
	public static void erregistratuLangileak(String NAN, int ostatu_id) {
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa.prepareStatement("INSERT INTO `langilea` (`nan`, `ostatu_id`)"+ " VALUES(?, ?)");
			st.setString(1, NAN);
			st.setInt(2, ostatu_id);
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da langilea");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu langilea");
		}
	}


}
