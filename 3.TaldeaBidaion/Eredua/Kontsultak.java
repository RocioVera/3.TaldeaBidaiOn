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
			ResultSet rs = st.executeQuery("SELECT * FROM `hotela`,`ostatu` where herria LIKE '"+herria+"'");
			//ResultSet rs = st.executeQuery("SELECT * FROM `hotela` h,`ostatu` o WHERE h.hotel_kod=o.ostatu_id" );
			while (rs.next()) {
				izarKop = (rs.getInt("izarkop"));
				ostatu_id = (rs.getInt("ostatu_id"));
				izena = (rs.getString("izena"));
	//			herria = (rs.getString("herria"));
				helbidea = (rs.getString("helbidea"));
				postKod = (rs.getInt("postaKod"));
				ostatuMota = (rs.getString("ostatu_mota"));
				gelaKop = (rs.getInt("gela_kopuru"));
				erreserbaKop = (rs.getInt("erreserba_kopuru"));
				
				Hotela hotela = new Hotela(izena, herria, helbidea, postKod, ostatuMota, gelaKop, erreserbaKop, izarKop, ostatu_id);
				arrayHotelak.add(hotela);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return arrayHotelak;
	}



}
