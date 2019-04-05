package Kontrolatzailea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konexioa {
	private static Connection conexion = null;
	private String makina, bezeroa, pasahitza, zerbitzaria;
	private int portua;

	// Datu basearen izena hartu
	public Konexioa(String datuBasea) {
		this.makina = "localhost/bidaion";
		this.bezeroa = "root";
		this.pasahitza = "";
		this.portua = 3306;
		this.zerbitzaria = "127.0.0.1";

		this.zerbitzaria = "jdbc:mysql://" + this.makina + ":" + this.portua + "/" + datuBasea;

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
		System.out.println(datuBasea + " konektatuta");
	}

	public static Connection getConexion() {
		return conexion;
	}

}