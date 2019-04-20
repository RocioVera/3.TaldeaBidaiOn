package Ikuspegia;

import Kontrolatzailea.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import com.toedter.calendar.*;

public class Leiho3Erregistratu extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JTextField txtNan = new JTextField(), txtIzena = new JTextField(), txtAbizenak = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblNan, lblPasahitza, lblIzena, lblAbizenak, lblJaioData, lblErroreakonektatu;
	private JButton btnErregistratuNahi = new JButton("Erregistratu"), btnErregistratu = new JButton("Erregistratu"),
			btn_prev = new JButton("Hasi saioa"), restart = new JButton("\u2302");
	private JDateChooser txtJaioData = new JDateChooser();
	private JTextFieldDateEditor dataEzEditatu; // kentzeko eskuz sartu ahal izana

	// bariableak
	private java.util.Date jaioData;
	private SimpleDateFormat dataFormato = new SimpleDateFormat("yyyy-MM-dd");
	private String jaioDataString, pasahitza, nan, izena, abizenak, nanLarria, nanBalLarria;
	private boolean balPasa, balNan, balErregis;
	private int nanLuzera = 8, izenLuzera = 49, abizenLuzera = 99, pasahitzLuzera = 49, sexuLuzera = 0;
	private char letra;

	public Leiho3Erregistratu() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen ostatu zerbitzuen bilatzailea");

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// MetodoakLeihoAldaketa.bostgarrenLeihoa();
				MetodoakLeihoAldaketaBBDD.bigarrenLeihoa();

				dispose();
			}
		});
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBounds(150, 500, 154, 32);
		getContentPane().add(btn_prev);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(462, 502, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);
		lblNan = new JLabel("NAN:");
		lblPasahitza = new JLabel("Pasahitza:");

		lblErroreakonektatu = new JLabel();
		lblErroreakonektatu.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblErroreakonektatu);

		lblIzena = new JLabel("Izena:");
		lblAbizenak = new JLabel("Abizenak:");
		lblJaioData = new JLabel("Jaio data:");

		// non, formatua eta zer jarri
		lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNan.setBounds(207, 58, 62, 20);
		getContentPane().add(lblNan);

		txtNan.setBounds(281, 60, 86, 20);
		getContentPane().add(txtNan);
		txtNan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				letra = e.getKeyChar();
				// 9 baino gehiago edo espazioa sartzerakoan
				if (txtNan.getText().length() > nanLuzera || (letra == '\b'))
					e.consume(); // ez du godetzen
			}
		});

		lblIzena.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIzena.setBounds(207, 125, 62, 20);
		getContentPane().add(lblIzena);

		txtIzena.setBounds(281, 127, 86, 20);
		getContentPane().add(txtIzena);
		txtIzena.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// 50 baino gehiago ez sartzeko
				if (txtIzena.getText().length() > izenLuzera)
					e.consume(); // ez du godetzen
			}
		});

		lblAbizenak.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAbizenak.setBounds(181, 194, 93, 20);
		getContentPane().add(lblAbizenak);

		txtAbizenak.setBounds(281, 196, 86, 20);
		getContentPane().add(txtAbizenak);
		txtAbizenak.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// 100 baino gehiago ez sartzeko
				if (txtAbizenak.getText().length() > abizenLuzera)
					e.consume(); // ez du godetzen
			}
		});

		// non, formatua eta zer jarri
		lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPasahitza.setBounds(170, 331, 93, 20);
		getContentPane().add(lblPasahitza);

		passwordField.setEchoChar('*');
		passwordField.setBounds(281, 333, 86, 20);
		getContentPane().add(passwordField);
		passwordField.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyTyped(KeyEvent e) {
				letra = e.getKeyChar();
				// 50 baino gehiago ez sartzeko
				if (passwordField.getPassword().length > pasahitzLuzera)
					e.consume(); // ez du godetzen
			}
		});

		// non, formatua eta zer jarri
		lblJaioData.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblJaioData.setBounds(181, 266, 90, 20);
		getContentPane().add(lblJaioData);

		txtJaioData.setDateFormatString("dd-MM-yyyy");
		txtJaioData.setBounds(281, 266, 112, 20);
		dataEzEditatu = (JTextFieldDateEditor) txtJaioData.getDateEditor();
		dataEzEditatu.setEditable(false);
		getContentPane().add(txtJaioData);
		txtJaioData.setMaxSelectableDate(Date.valueOf(LocalDate.now()));// gehienez jarri gaurko data

		// ziurtatzeko bete dituela datu guztiak
		btnErregistratu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bbdd-ra konektatu pasahitza frogatzeko
				nan = txtNan.getText();
				pasahitza = String.valueOf(passwordField.getPassword());
				izena = txtIzena.getText();
				abizenak = txtAbizenak.getText();
				jaioData = txtJaioData.getDate();
				lblErroreakonektatu.setForeground(Color.RED);
				lblErroreakonektatu.setBounds(122, 445, 318, 22);
				lblErroreakonektatu.setVisible(true);

				// erregistratzen duen metodoari deitu
				if (jaioData != null)
					jaioDataString = dataFormato.format(jaioData);

				if (nan.matches("^[0-9]{8}[A-Za-z]$")) {
					nanLarria = nan.substring(8).toUpperCase();
					nan = nan.substring(0, 8) + nanLarria;
					nanBalLarria = Metodoak.nanLetra(nan);
					if (nanBalLarria.equals(nanLarria)) {
						balErregis = MetodoakKontsultak.erregistratuBezeroak(pasahitza, nan, izena, abizenak,
								jaioDataString);

						if (nan.length() - 1 == nanLuzera && !MetodoakKontsultak.nanGordetaEgon(nan))
							txtNan.setEnabled(false);
						else if (!izena.isEmpty())
							txtIzena.setEnabled(false);
						else if (!abizenak.isEmpty())
							txtAbizenak.setEnabled(false);
						else if (jaioData != null)
							txtJaioData.setEnabled(false);
						else if (pasahitza.length() != 0)
							passwordField.setEnabled(false);
					}
				}

				if (balErregis) {
					if (!MetodoakKontsultak.nanGordetaEgon(nan)) { // dagoela erregistratuta
						lblErroreakonektatu.setText("Erregistratuta zaude, hasi saioa.");
						passwordField.setEnabled(false);
						txtIzena.setEnabled(false);
						txtAbizenak.setEnabled(false);
						txtJaioData.setEnabled(false);
					} else {
						MetodoakLeihoAldaketaBBDD.laugarrenLeihoa();
						dispose();

					}
				} else { // !balErregis
					lblErroreakonektatu.setForeground(Color.RED);
					if (nan.length() + 1 < nanLuzera) {
						lblErroreakonektatu.setBounds(126, 91, 318, 22);
						lblErroreakonektatu.setText("nan-a bete behar duzu.");
					} else if (!nan.matches("^[0-9]{8}[A-Za-z]$") || !nanBalLarria.equals(nanLarria)) {
						lblErroreakonektatu.setBounds(126, 91, 318, 22);
						lblErroreakonektatu.setText("nan-a txarto sartu duzu.");
					} else if (MetodoakKontsultak.nanGordetaEgon(nan)) {
						lblErroreakonektatu.setBounds(122, 445, 318, 22);
						lblErroreakonektatu.setText("Erregistratuta zaude, hasi saioa.");
						passwordField.setEnabled(false);
						txtIzena.setEnabled(false);
						txtAbizenak.setEnabled(false);
						txtJaioData.setEnabled(false);
					} else if (izena.isEmpty()) {
						lblErroreakonektatu.setBounds(123, 159, 318, 22);
						lblErroreakonektatu.setText("izena bete behar duzu.");
					} else if (abizenak.isEmpty()) {
						lblErroreakonektatu.setBounds(125, 227, 318, 22);
						lblErroreakonektatu.setText("abizena bete behar duzu.");
					} else if (jaioData == null) {
						lblErroreakonektatu.setBounds(119, 296, 318, 22);
						lblErroreakonektatu.setText("jaioData bete behar duzu.");
					} else if (pasahitza.length() == 0) {
						lblErroreakonektatu.setBounds(120, 364, 318, 22);
						lblErroreakonektatu.setText("pasahitza bete behar duzu.");
					}
				}
			}

		});
		btnErregistratu.setBounds(247, 401, 109, 25);
		getContentPane().add(btnErregistratu);

	}
}