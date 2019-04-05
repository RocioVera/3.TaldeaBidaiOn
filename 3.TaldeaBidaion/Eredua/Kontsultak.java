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
		herria="Madrid";
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
			while (rs.next()) {
				prezioa = (rs.getDouble("prezioa"));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prezioa;
	}



}
