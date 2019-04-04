package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import com.toedter.calendar.*;

import Kontrolatzailea.Metodoak;

public class Leiho3Login extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JTextField txtPrezioTot = new JTextField(), txtNan = new JTextField(), txtIzena = new JTextField(),
			txtAbizenak = new JTextField(), txtSexua = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblPrezioTotala, lblNan, lblPasahitza, lblIzena, lblAbizenak, lblJaioData, lblSexua,
			lblErroreakonektatu, lblKonekBezeroMezua;
	private JButton btnHasiSaioa, btnKonektatu = new JButton("Konektatu"),
			btnErregistratuNahi = new JButton("Erregistratu"), btnErregistratu = new JButton("Erregistratu"),
			btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"), restart = new JButton("\u2302");
	private JDateChooser txtJaioData = new JDateChooser();
	private JTextFieldDateEditor dataEzEditatu; // kentzeko eskuz sartu ahal izana

	// bariableak
	private java.util.Date jaioData;
	private SimpleDateFormat dataFormato = new SimpleDateFormat("yyyy-MM-dd");
	private String jaioDataString, pasahitza, nan, izena, abizenak, sexua, nanLarria;;
	private float guztiraPrez;
	private boolean balPasa, balNan, balErregis, nanBalErregistratu;
	private int nanLuzera = 8, izenLuzera = 49, abizenLuzera = 99, pasahitzLuzera = 49, sexuLuzera = 0;
	private char letra;

	/**
	 * login edo erregistratu ahal den panela sortu
	 * 
	 * @param hartutakoLinea
	 * @param autobusa
	 * @param ibilbideZbk
	 * @param hasierakoGeltokiaKod
	 * @param amaierakoGeltokiaKod
	 * @param altuera1
	 * @param luzera1
	 * @param altuera2
	 * @param luzera2
	 * @author talde1
	 * @param arrayGeltokia
	 * @param dataEtorri
	 * @param dataJoan
	 */
	public Leiho3Login() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png")); 
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("1.taldearen txartel salmenta");

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bostgarrenLeihoa();
				dispose();
			}
		});
		btn_next.setBounds(423, 500, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.hirugarrenLeihoa();
				dispose();
			}
		});
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBounds(38, 500, 99, 32);
		getContentPane().add(btn_prev);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(245, 500, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);



	}
}