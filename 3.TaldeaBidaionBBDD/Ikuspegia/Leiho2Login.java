package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;

public class Leiho2Login extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JTextField txtNan = new JTextField();
	private JPasswordField passwordField = new JPasswordField();
	private JLabel lblNan, lblPasahitza, lblErroreakonektatu, lblKonekBezeroMezua;
	private JButton btnErregistratuNahi = new JButton("Erregistratu"),btn_next = new JButton("Hurrengoa"), restart = new JButton("\u2302");

	// bariableak
	private String pasahitza, nan, nanLarria;
	private boolean balPasa, balNan;
	private int nanLuzera = 8;
	private char letra;

	public Leiho2Login() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen administratzaileen aplikazioa");

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
					if (balPasa && balNan) {
						MetodoakLeihoAldaketaBBDD.laugarrenLeihoa();
						dispose();
					}
					else {
						lblErroreakonektatu.setBounds(145, 350, 318, 22);
						lblErroreakonektatu.setForeground(Color.RED);
						lblErroreakonektatu.setText("NAN-a edo pasahitza ez dago ondo, sartu berriz");
						lblErroreakonektatu.setVisible(true);
					}
				} else {
					lblErroreakonektatu.setBounds(145, 350, 318, 22);
					lblErroreakonektatu.setForeground(Color.RED);
					lblErroreakonektatu.setText("NAN-a edo pasahitza ez dago ondo, sartu berriz");
					lblErroreakonektatu.setVisible(true);
				}

			}
		});
		btn_next.setBounds(377, 474, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(122, 475, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);

		lblNan = new JLabel("NAN:");
		lblPasahitza = new JLabel("Pasahitza:");

		lblKonekBezeroMezua = new JLabel("Hasi saioa edo erregistratu");
		lblKonekBezeroMezua.setForeground(Color.BLUE);
		lblKonekBezeroMezua.setHorizontalAlignment(SwingConstants.CENTER);
		lblKonekBezeroMezua.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 14));
		lblKonekBezeroMezua.setBounds(122, 82, 328, 25);
		getContentPane().add(lblKonekBezeroMezua);

		lblNan.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNan.setBounds(212, 221, 62, 20);
		getContentPane().add(lblNan);

		txtNan.setBounds(283, 223, 86, 20);
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
		lblPasahitza.setBounds(180, 282, 93, 20);
		getContentPane().add(lblPasahitza);

		passwordField.setEchoChar('*');
		passwordField.setBounds(283, 284, 86, 20);
		getContentPane().add(passwordField);

		lblErroreakonektatu = new JLabel();
		lblErroreakonektatu.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblErroreakonektatu);

		// erregistratu ematerakoan agertu behar diren bariableak
		btnErregistratuNahi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketaBBDD.hirugarrenLeihoa();
				dispose();
			}
		});
		btnErregistratuNahi.setBounds(227, 144, 122, 25);
		getContentPane().add(btnErregistratuNahi);

	}
}