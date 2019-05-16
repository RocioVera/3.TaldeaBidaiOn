package Eredua;

import java.util.ArrayList;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Kontrolatzailea.*;

public class Kontsultak {
	// Leiho2AukeratuOstatu
	/**
	 * Ostatu batean dauden zerbitzu gehigarriak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @return zerbitzuArray
	 */
	public static ArrayList<String> filtroZerbitzuGehigarri(Ostatua hartutakoOstatua) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();

		ArrayList<String> zerbitzuArray = new ArrayList<String>();

		String izena;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT zg.izena FROM zerbitzugehigarriak_ostatu zgo, zerbitzugehigarriak zg WHERE zgo.ostatu_ostatu_id ="
							+ hartutakoOstatua.getOstatuKod()
							+ " AND zg.kod_zerbitzuak=zgo.zerbitzuGehigarriak_kod_zerbitzuak");

			while (rs.next()) {
				izena = (rs.getString("izena"));

				zerbitzuArray.add(izena);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return zerbitzuArray;
	}

	/**
	 * Etxe baten prezioa bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param izena
	 * @return prezioa
	 */
	public static double etxearenPrezioaBilatu(String izena) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		double prezioa = 0;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT SUM(prezioa) FROM `etxea_gelamota` eg, `gelamota` g , `etxea` e WHERE eg.etxea_etxe_kod=e.etxe_kod AND g.gela_kodea=eg.gelaMota_gela_kodea AND e.etxe_kod IN (SELECT ostatu_id FROM `ostatu` WHERE lower(ostatu.izena) LIKE lower('"
							+ izena + "'))");

			while (rs.next()) {
				prezioa = (rs.getDouble("sum(prezioa)"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prezioa;
	}

	/**
	 * Jai egunak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @return arrayEgunak
	 */
	public static ArrayList<JaiEgunak> jaiEgunakAtera() {
		ArrayList<JaiEgunak> arrayEgunak = new ArrayList<JaiEgunak>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String arrazoia;
		int jaiEgunKod;
		Date jaiEgunData;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT * FROM jaiegunak");
			while (rs.next()) {
				jaiEgunKod = (rs.getInt(1));
				jaiEgunData = (rs.getDate(2));

				arrazoia = (rs.getString(3));

				JaiEgunak jaiEgunak = new JaiEgunak(jaiEgunKod, jaiEgunData, arrazoia);
				arrayEgunak.add(jaiEgunak);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayEgunak;
	}

	/**
	 * Ostatuen herriak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @return arrayHerriak
	 */
	public static ArrayList<String> ostatuHerriak() {
		ArrayList<String> arrayHerria = new ArrayList<>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String herria;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT DISTINCT(herria) FROM `ostatu`");
			while (rs.next()) {
				herria = (rs.getString("herria"));
				arrayHerria.add(herria);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayHerria;
	}

	/**
	 * Herri baten hotelak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param herria
	 * @return arrayHotelak
	 */
	public static ArrayList<Hotela> hotelakBilatu(String herria) {
		ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int izarKop, ostatu_id, postKod, gelaKop, erreserbaKop;
		String izena, helbidea, ostatuMota;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `hotela` h,`ostatu` o where o.herria LIKE '" + herria
					+ "' and h.hotel_kod LIKE o.ostatu_id AND o.ostatu_mota LIKE 'H'");

			while (rs.next()) {
				izarKop = (rs.getInt("izarkop"));
				ostatu_id = (rs.getInt("ostatu_id"));
				izena = (rs.getString("izena"));
				helbidea = (rs.getString("helbidea"));
				postKod = (rs.getInt("postaKod"));
				ostatuMota = (rs.getString("ostatu_mota"));
				gelaKop = (rs.getInt("gela_kopuru"));
				erreserbaKop = (rs.getInt("erreserba_kopuru"));

				Hotela hotela = new Hotela(izena, herria, helbidea, ostatuMota, ostatu_id, postKod, gelaKop,
						erreserbaKop, izarKop);

				arrayHotelak.add(hotela);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayHotelak;
	}

	/**
	 * Herri baten apartamentuak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param herria
	 * @return arrayApartamentua
	 */
	public static ArrayList<Apartamentua> apartamentuakBilatu(String herria) {
		ArrayList<Apartamentua> arrayApartamentua = new ArrayList<Apartamentua>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int komun_kop, ostatu_id, postKod, gelaKop, erreserbaKop, solairua;
		double m2;
		String izena, helbidea, ostatuMota;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT e.komun_kop, e.m2, o.*, a.solairua FROM `etxea` e,`ostatu` o, `apartamentua` a where LOWER(o.herria) LIKE LOWER('"
							+ herria
							+ "') and e.etxe_kod LIKE o.ostatu_id AND e.etxe_kod LIKE a.etxea_etxe_kod AND o.ostatu_mota LIKE 'A'");
			while (rs.next()) {
				ostatu_id = (rs.getInt("ostatu_id"));
				komun_kop = (rs.getInt("komun_kop"));
				m2 = (rs.getInt("m2"));
				izena = (rs.getString("izena"));
				helbidea = (rs.getString("helbidea"));
				postKod = (rs.getInt("postaKod"));
				ostatuMota = (rs.getString("ostatu_mota"));
				gelaKop = (rs.getInt("gela_kopuru"));
				erreserbaKop = (rs.getInt("erreserba_kopuru"));
				solairua = (rs.getInt("solairua"));

				Apartamentua apartamentua = new Apartamentua(izena, herria, helbidea, ostatuMota, postKod, gelaKop,
						erreserbaKop, komun_kop, ostatu_id, m2, solairua);
				arrayApartamentua.add(apartamentua);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayApartamentua;
	}

	/**
	 * Herri baten etxeak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param herria
	 * @return arrayEtxeak
	 */
	public static ArrayList<Etxea> etxeakBilatu(String herria) {
		ArrayList<Etxea> arrayEtxeak = new ArrayList<Etxea>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int komun_kop, ostatu_id, postKod, gelaKop, erreserbaKop;
		double m2;
		String izena, helbidea, ostatuMota;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `etxea` e,`ostatu` o where LOWER(o.herria) LIKE LOWER('"
					+ herria + "') and e.etxe_kod LIKE o.ostatu_id AND o.ostatu_mota LIKE 'E'");

			while (rs.next()) {
				ostatu_id = (rs.getInt("ostatu_id"));
				komun_kop = (rs.getInt("komun_kop"));
				m2 = (rs.getInt("m2"));
				izena = (rs.getString("izena"));
				helbidea = (rs.getString("helbidea"));
				postKod = (rs.getInt("postaKod"));
				ostatuMota = (rs.getString("ostatu_mota"));
				gelaKop = (rs.getInt("gela_kopuru"));
				erreserbaKop = (rs.getInt("erreserba_kopuru"));

				Etxea etxea = new Etxea(izena, herria, helbidea, ostatuMota, postKod, gelaKop, erreserbaKop, komun_kop,
						ostatu_id, m2);

				arrayEtxeak.add(etxea);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayEtxeak;
	}

	/**
	 * Hotel baten prezioa bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param izena
	 * @return prezioa
	 */
	public static double hotelarenPrezioaBilatu(String izena) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		double prezioa = 0;
		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT min(prezioa) FROM `gelamota_hotela` gh, `gelamota` g , `hotela` h WHERE gh.hotela_hotel_kod=h.hotel_kod "
							+ "AND g.gela_kodea=gh.gelaMota_gela_kodea AND g.mota like lower('logela') AND h.hotel_kod IN ("
							+ " SELECT ostatu_id FROM `ostatu` WHERE lower(ostatu.izena) LIKE lower('" + izena + "'))");

			while (rs.next()) {
				prezioa = (rs.getDouble("min(prezioa)"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return prezioa;
	}

	// Leiho3EtxeDatuak
	/**
	 * Etxe batean ohe motak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param ostatu_id
	 * @return gelaOheHotelaArray
	 */
	public static ArrayList<gelaMota_ohe_ostatu> oheGelaEtxeakDatuak(int ostatu_id) {
		ArrayList<gelaMota_ohe_ostatu> gelaOheHotelaArray = new ArrayList<gelaMota_ohe_ostatu>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int gela_kodea = 0;
		double prezioa = 0;
		ResultSet rs = null;
		gelaMota_ohe_ostatu goh = null;

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT gela_kodea, prezioa FROM ostatu_etxea_gelamota oegm WHERE ostatu_id="
					+ ostatu_id + " AND oegm.mota like 'logela'");

			while (rs.next()) {
				gela_kodea = (rs.getInt(1));
				prezioa = (rs.getDouble(2));
				goh = new gelaMota_ohe_ostatu(gela_kodea, prezioa);
				gelaOheHotelaArray.add(goh);

			}

			for (int i = 0; i < gelaOheHotelaArray.size(); i++) {
				rs = st.executeQuery(
						"SELECT o.ohe_id,ohe_kopuru, ohe_mota FROM gelamota_oheak gmo, oheak o WHERE gmo.gelaMota_gela_kodea="
								+ gelaOheHotelaArray.get(i).getGela_kodea()
								+ " AND gmo.oheak_ohe_id=o.ohe_id ORDER BY o.ohe_id ASC");

				while (rs.next()) {
					if (rs.getInt(1) == 1)
						gelaOheHotelaArray.get(i).setSinplea(rs.getInt(2));
					if (rs.getInt(1) == 2)
						gelaOheHotelaArray.get(i).setBikoitza(rs.getInt(2));
					if (rs.getInt(1) == 3)
						gelaOheHotelaArray.get(i).setUmeak(rs.getInt(2));
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return gelaOheHotelaArray;
	}

	/**
	 * Etxe batean gela motak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param ostatu_id
	 * @return gelaMotaEtxeaArray
	 */
	public static ArrayList<GelaMotaEtxea> gelaKantMota(int ostatu_id) {
		ArrayList<GelaMotaEtxea> gelaMotaEtxeaArray = new ArrayList<GelaMotaEtxea>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int kant = 0;
		String mota;
		ResultSet rs = null;
		GelaMotaEtxea gme = null;

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT count(*), mota FROM ostatu_etxea_gelamota oegm WHERE ostatu_id=" + ostatu_id
					+ " GROUP BY mota");

			while (rs.next()) {
				kant = (rs.getInt(1));
				mota = (rs.getString(2));

				gme = new GelaMotaEtxea(ostatu_id, mota, kant);
				gelaMotaEtxeaArray.add(gme);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return gelaMotaEtxeaArray;
	}

	// Leiho3HotelDatuak
	/**
	 * Hotel batean ohe motak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param ostatu_id
	 * @return gelaOheHotelaArray
	 */
	public static ArrayList<gelaMota_ohe_ostatu> oheGelaHotelaDatuak(int ostatu_id) {
		ArrayList<gelaMota_ohe_ostatu> gelaOheHotelaArray = new ArrayList<gelaMota_ohe_ostatu>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int gela_kodea = 0;
		double prezioa = 0;
		ResultSet rs = null;
		gelaMota_ohe_ostatu goh = null;

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery(
					"SELECT gela_kodea, prezioa FROM `ostatu_hotela_gelamota` WHERE ostatu_id=" + ostatu_id + "");

			while (rs.next()) {
				gela_kodea = (rs.getInt(1));
				prezioa = (rs.getDouble(2));
				goh = new gelaMota_ohe_ostatu(gela_kodea, prezioa);
				gelaOheHotelaArray.add(goh);

			}

			for (int i = 0; i < gelaOheHotelaArray.size(); i++) {
				rs = st.executeQuery(
						"SELECT o.ohe_id,ohe_kopuru, ohe_mota FROM gelamota_oheak gmo, oheak o WHERE gmo.gelaMota_gela_kodea="
								+ gelaOheHotelaArray.get(i).getGela_kodea()
								+ " AND gmo.oheak_ohe_id=o.ohe_id ORDER BY o.ohe_id ASC");

				while (rs.next()) {
					if (rs.getInt(1) == 1)
						gelaOheHotelaArray.get(i).setSinplea(rs.getInt(2));
					if (rs.getInt(1) == 2)
						gelaOheHotelaArray.get(i).setBikoitza(rs.getInt(2));
					if (rs.getInt(1) == 3)
						gelaOheHotelaArray.get(i).setUmeak(rs.getInt(2));
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return gelaOheHotelaArray;
	}

	/**
	 * Hotel batean gela libre motak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param gelaKod
	 * @return kant
	 */
	public static int gelaLibreKant(Ostatua hartutakoOstatua, int gelaKod) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int kant = 0;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT gmh.kantitatea FROM gelamota_hotela gmh, hotela h , gelamota gm, ostatu o where gmh.hotela_hotel_kod=h.hotel_kod AND gm.gela_kodea=gmh.gelaMota_gela_kodea AND o.ostatu_id=h.hotel_kod AND o.ostatu_id="
							+ hartutakoOstatua.getOstatuKod() + " AND gm.gela_kodea=" + gelaKod);

			while (rs.next()) {
				kant = (rs.getInt("kantitatea"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kant;
	}

	/**
	 * Gela erreserba kantitatea bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param gelaKod
	 * @param auxData
	 * @return kant
	 */
	public static int gelaErreserbaKant(Ostatua hartutakoOstatua, int gelaKod, java.util.Date auxData) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int kant = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String data = sdf.format(auxData);

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT sum(gme.kantitatea) FROM erreserba e, ostatu o, gelamota_erreserba gme, gelamota gm, erreserba_jaiegunak eje WHERE o.ostatu_id=e.ostatu_ostatu_id AND eje.erreserba_erreserba_kod=e.erreserba_kod AND gm.gela_kodea=gme.gelaMota_gela_kodea AND e.erreserba_kod=gme.erreserba_erreserba_kod AND o.ostatu_id="
							+ hartutakoOstatua.getOstatuKod() + " AND gm.gela_kodea=" + gelaKod + " AND eje.eguna='"
							+ data + "'");

			while (rs.next()) {
				kant = (rs.getInt("sum(gme.kantitatea)"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kant;
	}

	// Leiho4ZerbitzuGehigarriak
	/**
	 * Ostatu batean dauden zerbitzu gehigarriak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @return zerbitzuArray
	 */
	public static ArrayList<HartutakoOstatuarenZerbitzuak> zerbitzuGehigarriakOstatuan(Ostatua hartutakoOstatua) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();

		ArrayList<HartutakoOstatuarenZerbitzuak> zerbitzuArray = new ArrayList<HartutakoOstatuarenZerbitzuak>();
		HartutakoOstatuarenZerbitzuak zerbitzuak = null;

		int kod_zerbitzua;
		String izena;
		double prezioa;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT DISTINCT(zp.kod_zerbitzuak), zp.izena, zp.prezioa FROM zerbitzuprezioak zp, zerbitzugehigarriak_ostatu zgo, ostatu o WHERE zp.kod_zerbitzuak=zgo.zerbitzuGehigarriak_kod_zerbitzuak AND o.ostatu_id=zgo.ostatu_ostatu_id AND o.ostatu_id="
							+ hartutakoOstatua.getOstatuKod());

			while (rs.next()) {
				kod_zerbitzua = (rs.getInt("kod_zerbitzuak"));
				izena = (rs.getString("izena"));
				prezioa = (rs.getDouble("prezioa"));

				zerbitzuak = new HartutakoOstatuarenZerbitzuak(kod_zerbitzua, izena, prezioa);
				zerbitzuArray.add(zerbitzuak);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return zerbitzuArray;
	}

	// Leiho5Login
	/**
	 * Bezero taulako datuak hartu.
	 * 
	 * @author talde3
	 * @return arrayBezeroak
	 */
	public static ArrayList<Bezeroa> bezeroDatuak() {
		ArrayList<Bezeroa> arrayBezeroak = new ArrayList<Bezeroa>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		String izena, abizenak, NAN, pasahitza, data;
		int erreserba_kop;
		ResultSet rs = null;
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT p.*, b.erreserba_kop FROM bezeroa b, pertsona p where b.nan=p.nan");
			while (rs.next()) {
				NAN = (rs.getString(1));
				izena = (rs.getString(2));
				abizenak = (rs.getString(3));
				data = (rs.getString(4));
				pasahitza = (rs.getString(5));
				erreserba_kop = (rs.getInt(6));
				Bezeroa bezeroa = new Bezeroa(NAN, izena, abizenak, data, pasahitza, erreserba_kop);
				arrayBezeroak.add(bezeroa);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayBezeroak;
	}

	// Leiho6Erregistratu
	/**
	 * Bezero berriak erregistratu.
	 * 
	 * @author talde3
	 * @param pasahitza
	 * @param NAN
	 * @param izena
	 * @param abizenak
	 * @param jaioData
	 * @return arrayBezeroak
	 */
	public static ArrayList<Bezeroa> erregistratuBezeroak(String pasahitza, String NAN, String izena, String abizenak,
			String jaioData) {
		ArrayList<Bezeroa> arrayBezeroak = new ArrayList<Bezeroa>();
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

		try {
			PreparedStatement st = konexioa.prepareStatement("INSERT INTO `bezeroa` (`nan`)" + " VALUES(?)");
			st.setString(1, NAN);
			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da bezeroa");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu bezeroa");
		}

		arrayBezeroak = bezeroDatuak();
		return arrayBezeroak;
	}

	// Leiho8KodePromozionalak
	/**
	 * Bezero batek dituen promozioak bilatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param nan
	 * @return arrayPromozioa
	 */
	public static ArrayList<Promozioa> promozioakBilatu(String nan) {
		ArrayList<Promozioa> arrayPromozioa = new ArrayList<Promozioa>();
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		double prezioa;
		int promoKod;
		String promoZergatia;
		Date iraungitzeData, gaurData = Date.valueOf(LocalDate.now());

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT promozio_kod, promozio_zergatia, prezioa, iraungitzeData FROM promozioa WHERE bezeroa_nan='"
							+ nan + "' AND erabilita= 0");
			while (rs.next()) {
				promoKod = (rs.getInt("promozio_kod"));
				promoZergatia = (rs.getString("promozio_zergatia"));
				prezioa = (rs.getDouble("prezioa"));
				iraungitzeData = (rs.getDate("iraungitzeData"));

				if (!iraungitzeData.before(gaurData) || iraungitzeData.equals(gaurData)) {
					Promozioa promozioa = new Promozioa(promoKod, promoZergatia, prezioa, iraungitzeData);
					arrayPromozioa.add(promozioa);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return arrayPromozioa;
	}

	// Leiho9Ordaindu
	/**
	 * Erreserba gordetzen duen kontsulta
	 * 
	 * @author talde3
	 * @param erreserba
	 * @param prezioTot
	 */
	public static void erreserbaGorde(Erreserba erreserba, double prezioTot) {
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `erreserba`(`ostatu_ostatu_id`, `bezeroa_nan`, `pertsona_kopuru`, `prezio_totala`, `erreserbaGela_kopuru`, `pentsio_mota`)"
							+ " VALUES(?, MD5( ? ), ?, ?, ?, ?)");
			st.setInt(1, erreserba.getErreserbaKod());
			st.setString(2, erreserba.getBezeroNan());
			st.setInt(3, erreserba.getPertsonaKopuru());
			st.setDouble(4, prezioTot);
			st.setInt(5, erreserba.getErreserbaGelaKop());
			st.setString(6, erreserba.getPentsioMota());

			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da erreserbaigo");

		} catch (SQLException e) {
			System.out.println("Ez da gehitu erreserbaigo");
			e.getMessage();
		}
	}

	/**
	 * Erreserba totala zenbatzen duen kontsulta
	 * 
	 * @author talde3
	 * @return zenbatErreserba
	 */
	public static int erreserbakZenbatu() {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int zenbatErreserba = 0;

		try {
			st = konexioa.createStatement();
			ResultSet rs = st.executeQuery("SELECT MAX(erreserba_kod) FROM `erreserba`");
			while (rs.next()) {
				zenbatErreserba = (rs.getInt("MAX(erreserba_kod)"));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return zenbatErreserba;
	}

	/**
	 * Base legalak onartu dituela gordetzen duen kontsulta
	 * 
	 * @author talde3
	 * @param erreserbaKod
	 */
	public static void baseLegalakIgo(int erreserbaKod) {
		LocalDateTime gaurordua = LocalDateTime.now();
		Date gaurData = Date.valueOf(LocalDate.now());

		int orduak = gaurordua.getHour();
		int minutuak = gaurordua.getMinute();
		int segunduak = gaurordua.getSecond();

		String gaurOrduOsoa = orduak + ":" + minutuak + ":" + segunduak;

		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `legeaonartu`(`erreserbaKod`, `data`, `ordua`)" + " VALUES(?, ?, ?)");
			st.setInt(1, erreserbaKod);
			st.setDate(2, gaurData);
			st.setString(3, gaurOrduOsoa);

			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da legea");

		} catch (SQLException e) {
			System.out.println("Ez da gehitu legea");
		}
	}

	/**
	 * Erreserba erregistratzen duen kontsulta
	 * 
	 * @author talde3
	 * @param data
	 * @param denboraldia
	 */
	public static void erresJaiEgunIgoMet(java.util.Date data, String denboraldia) {
		Connection konexioa = Konexioa.getConexion();
		int erreserbaKod = erreserbakZenbatu();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dataString = sdf.format(data);

		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `erreserba_jaiEgunak`(`erreserba_erreserba_kod`, `eguna`, `tarifa_denboraldia`)"
							+ " VALUES(?, ?, ?)");
			st.setInt(1, erreserbaKod);
			st.setString(2, dataString);
			st.setString(3, denboraldia);

			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da erresJaiEgun");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Ez da gehitu erresJaiEgun");
		}

		jaiEgunKodIgo(data, konexioa);
	}

	public static void zerbiErregisIgo(int zerbitzuKod) {
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `zerbitzugehigarriak_erreserba`(`zerbitzuGehigarriak_kod_zerbitzuak`, `erreserba_erreserba_kod`) VALUES (?,?)");
			st.setInt(1, zerbitzuKod);
			st.setInt(2, erreserbakZenbatu());

			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da zerbitzuErreserba");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Ez da gehitu zerbitzuErreserba");
		}
	}

	/**
	 * Jai egunen kodigoa ateratzen duen kontsulta
	 * 
	 * @author talde3
	 * @param data
	 * @param konexioa
	 */
	public static void jaiEgunKodIgo(java.util.Date data, Connection konexioa) {
		int jaiEgunKod;
		ArrayList<JaiEgunak> arrayEgunak = jaiEgunakAtera();
		int erreserbaKod = 0;
		Statement st2 = null;

		for (JaiEgunak jaiEgunak : arrayEgunak) {
			if (jaiEgunak.getJaiEguna().equals(data)) {
				jaiEgunKod = jaiEgunak.getJaiEgunKod();

				try {
					st2 = konexioa.createStatement();
					ResultSet rs = st2.executeQuery("SELECT MAX(erreserba_jaiegunKod) FROM erreserba_jaiegunak");

					while (rs.next()) {
						erreserbaKod = (rs.getInt("MAX(erreserba_jaiegunKod)"));
					}

					PreparedStatement st = konexioa
							.prepareStatement("UPDATE erreserba_jaiegunak SET jaiEgunak_jaiEgunak_kod=" + jaiEgunKod
									+ " WHERE erreserba_jaiegunKod = " + erreserbaKod);

					st.executeUpdate();
					st.close();
					System.out.println("Gehitu da egun kod");

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					System.out.println("Ez da gehitu egun kod");
				}
				break;
			}
		}
	}

	/**
	 * Erreserba erregistratzen duen kontsulta
	 * 
	 * @author talde3
	 * @param gelaMotaErreserba2
	 */
	public static void gelaMotaErreserbaIgo(GelaMotaErreserba gelaMotaErreserba2) {
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa.prepareStatement(
					"INSERT INTO `gelamota_erreserba`(`gelaMota_gela_kodea`, `erreserba_erreserba_kod`, `kantitatea`) VALUES (?,?,?)");
			st.setInt(1, gelaMotaErreserba2.getGelaMotaKod());
			st.setInt(2, erreserbakZenbatu());
			st.setInt(3, gelaMotaErreserba2.getKantitatea());

			st.executeUpdate();
			st.close();
			System.out.println("Gehitu da gelaMotaErreserba");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Ez da gehitu gelaMotaErreserba");
		}

	}

	/**
	 * Promozioa erabilita dagoela erregistratzen duen kontsulta
	 * 
	 * @author talde3
	 * @param promozioa
	 */
	public static void promozioaErabilita(Promozioa promozioa) {
		Connection konexioa = Konexioa.getConexion();
		try {
			PreparedStatement st = konexioa
					.prepareStatement("UPDATE `promozioa` SET `erabilita` = '1' WHERE `promozioa`.`promozio_kod` = ?");
			st.setInt(1, promozioa.getPromozioKod());

			st.executeUpdate();
			st.close();
			System.out.println("Aldatu da promozioa");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu pertsona");
		}
	}

	/**
	 * Zenbat erreserba dauden zenbatzen duen kontsulta
	 * 
	 * @author talde3
	 * @param data
	 * @param izena
	 * @param kodea
	 * @return erantzuna
	 */
	public static boolean erreserbaBeteta(java.util.Date data, String izena, int kodea) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int erreserbaKop = 0, gelaKopuru = 0;
		boolean erantzuna = false;
		ResultSet rs = null;
		java.sql.Date sqlDate = new java.sql.Date(data.getTime());
		try {
			st = konexioa.createStatement();
			rs = st.executeQuery(
					"SELECT COUNT(eje.eguna) FROM ostatu o, erreserba e, erreserba_jaiegunak eje WHERE o.ostatu_id = e.ostatu_ostatu_id AND e.erreserba_kod = eje.erreserba_erreserba_kod AND lower(o.izena) like lower('"
							+ izena + "') AND o.ostatu_id=" + kodea + " AND eje.eguna='" + sqlDate + "'");
			while (rs.next()) {
				erreserbaKop = (rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery("SELECT o.gela_kopuru FROM `ostatu` o where o.ostatu_id=" + kodea + "");
			while (rs.next()) {
				gelaKopuru = (rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		if (gelaKopuru > erreserbaKop)
			erantzuna = true;
		return erantzuna;
	}

	/**
	 * Ostatuari + bat egin erreserbetan
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 */
	public static void ostatuErreserbaKopuruBerria(Ostatua hartutakoOstatua) {
		Statement st = null;
		Connection konexioa = Konexioa.getConexion();
		int erreserbaKop = 0;
		boolean erantzuna = false;
		ResultSet rs = null;

		try {
			st = konexioa.createStatement();
			rs = st.executeQuery(
					"SELECT erreserba_kopuru FROM ostatu WHERE ostatu_id=" + hartutakoOstatua.getOstatuKod());
			while (rs.next()) {
				erreserbaKop = (rs.getInt(1)) + 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(erreserbaKop);
		try {
			PreparedStatement st2 = konexioa
					.prepareStatement("UPDATE `ostatu` SET erreserba_kopuru=? WHERE ostatu_id=?");
			st2.setInt(1, erreserbaKop);
			st2.setInt(2, hartutakoOstatua.getOstatuKod());

			st2.executeUpdate();
			st2.close();
			System.out.println("Aldatu da erreskopurua");
		} catch (SQLException e) {
			System.out.println("Ez da gehitu erreskopurua");
		}

	}

}
