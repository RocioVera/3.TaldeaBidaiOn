package Kontrolatzailea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
	private static Connection conexion = null;
	private String makina="localhost", bezeroa="root", pasahitza="";
	
	// Datu basearen izena hartu
	public Konexioa(String datuBasea) {

		

		// Driverra erregistratu
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver-a erregistatzerakoan errorea.");
			System.exit(0); // exekuzioa gelditu
		}

		// Zerbitzariarekin konexioa ezarri
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://" + this.makina, this.bezeroa, this.pasahitza);
		} catch (SQLException e) {
			System.err.println("Zerbitzariarekin konektatzerakoan errorea.");
			System.exit(0); // parar la ejecución
		}
		System.out.println(datuBasea+ " konektatuta" );
	}

	public Connection getConexion() {
		return conexion;
	}

}