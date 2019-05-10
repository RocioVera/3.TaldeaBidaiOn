package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import com.toedter.calendar.*;

public class Leiho5Login extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JTextField txtPrezioTot = new JTextField(), txtNan = new JTextField(), txtIzena = new JTextField(),
			txtAbizenak = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblPrezioTotala, lblNan, lblPasahitza, lblIzena, lblAbizenak, lblJaioData, lblErroreakonektatu,
			lblKonekBezeroMezua;
	private JButton btnErregistratuNahi = new JButton("Erregistratu"), btnErregistratu = new JButton("Erregistratu"),
			btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"), restart = new JButton("\u2302");
	private JDateChooser txtJaioData = new JDateChooser();

	// bariableak
	private String pasahitza, nan, nanLarria;
	private boolean balPasa, balNan;
	private int nanLuzera = 8;
	private char letra;

	public Leiho5Login(Ostatua hartutakoOstatua, double prezioTot, java.util.Date sartzeData, java.util.Date irtetzeData, int logelaTot, int pertsonaKop, String pentsioMota) {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// bbdd-ra konektatu pasahitza frogatzeko
				nan = txtNan.getText();

				if (nan.matches("^[0-9]{8}[A-Za-z]$")) {
					nanLarria = nan.substring(8).toUpperCase();
					nan = nan.substring(0, 8) + nanLarria;
					pasahitza = String.valueOf(passwordField.getPassword());
					balPasa = MetodoakKontsultak.frogatuPasahitza(pasahitza);
					balNan = MetodoakKontsultak.frogatuNAN(nan);
					System.out.println(balNan);
					if (balPasa && balNan) {
						MetodoakLeihoAldaketa.zazpigarrenLeihoa(hartutakoOstatua, prezioTot, sartzeData, irtetzeData,
								nan, logelaTot, pertsonaKop, pentsioMota);
						dispose();
					} else {
						lblErroreakonektatu.setBounds(145, 329, 318, 22);
						lblErroreakonektatu.setForeground(Color.RED);
						lblErroreakonektatu.setText("NAN-a edo pasahitza ez dago ondo, sartu berriz");
						lblErroreakonektatu.setVisible(true);
					}
				} else {
					lblErroreakonektatu.setBounds(145, 329, 318, 22);
					lblErroreakonektatu.setForeground(Color.RED);
					lblErroreakonektatu.setText("NAN-a 8 zenbaki eta letra bat du");
					lblErroreakonektatu.setVisible(true);
				}

			}
		});
		btn_next.setBounds(423, 500, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.laugarrenLeihoa(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop);
				dispose();
			}
		});
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBounds(38, 500, 107, 32);
		getContentPane().add(btn_prev);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(245, 500, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);

		// non, formatua eta zer jarri
		lblPrezioTotala = new JLabel("Prezio totala:");
		lblPrezioTotala.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrezioTotala.setBounds(157, 37, 117, 20);
		getContentPane().add(lblPrezioTotala);

		txtPrezioTot.setEditable(false);
		txtPrezioTot.setColumns(10);
		txtPrezioTot.setBounds(281, 37, 86, 20);

		// guztiraPrez kalkulatzeko metodoari deitu
		txtPrezioTot.setText(prezioTot + " €");
		getContentPane().add(txtPrezioTot);

		lblNan = new JLabel("NAN:");
		lblPasahitza = new JLabel("Pasahitza:");

		lblKonekBezeroMezua = new JLabel("Hasi saioa edo erregistratu");
		lblKonekBezeroMezua.setForeground(Color.BLUE);
		lblKonekBezeroMezua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKonekBezeroMezua.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		lblKonekBezeroMezua.setBounds(122, 74, 328, 25);
		getContentPane().add(lblKonekBezeroMezua);

		lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNan.setBounds(214, 211, 62, 20);
		getContentPane().add(lblNan);

		txtNan.setBounds(283, 211, 86, 20);
		getContentPane().add(txtNan);
		txtNan.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				letra = e.getKeyChar();
				// 9 baino gehiago edo espazioa sartzerakoan
				if (txtNan.getText().length() > nanLuzera || (letra == '\b'))
					e.consume(); // ez du godetzen
			}
		});

		lblPasahitza.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPasahitza.setBounds(184, 266, 93, 20);
		getContentPane().add(lblPasahitza);

		passwordField.setEchoChar('*');
		passwordField.setBounds(283, 269, 86, 20);
		getContentPane().add(passwordField);

		lblErroreakonektatu = new JLabel();
		lblErroreakonektatu.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblErroreakonektatu);

		lblIzena = new JLabel("Izena:");
		lblAbizenak = new JLabel("Abizenak:");
		lblJaioData = new JLabel("Jaio data:");

		// erregistratu ematerakoan agertu behar diren bariableak
		btnErregistratuNahi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketa.seigarrenLeihoa(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop, pentsioMota);
				dispose();
			}
		});
		btnErregistratuNahi.setBounds(227, 122, 122, 25);
		getContentPane().add(btnErregistratuNahi);

	}
}