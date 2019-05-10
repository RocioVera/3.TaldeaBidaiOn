package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;
import java.util.Date;

public class Leiho10Ticket extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JLabel lblEskerrikAskoMezua1, lblEskerrikAskoMezua2;
	private JButton btnTiketaImprimatu;
	private JTextArea txtTiket;

	public Leiho10Ticket(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData, Erreserba erreserba) {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		// Eskerrik asko mezua
		lblEskerrikAskoMezua1 = new JLabel("Eskerrik asko");
		lblEskerrikAskoMezua1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua1.setFont(new Font("MS PMincho", Font.BOLD, 30));
		lblEskerrikAskoMezua1.setBounds(53, 13, 493, 40);
		getContentPane().add(lblEskerrikAskoMezua1);

		lblEskerrikAskoMezua2 = new JLabel("erosteagatik");
		lblEskerrikAskoMezua2.setFont(new Font("MS PMincho", Font.BOLD, 30));
		lblEskerrikAskoMezua2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEskerrikAskoMezua2.setBounds(63, 55, 493, 40);

		getContentPane().add(lblEskerrikAskoMezua2);

		txtTiket = new JTextArea();
		txtTiket.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		txtTiket.setText("Prezioa: " + erreserba.getPrezioTotala() + " �" + "\nBezeroaren datuak: \n     Nan: " + erreserba.getBezeroNan()
				+ "\nHotelaren datuak: \n     Izena: " + hartutakoOstatua.getIzena() + "\n\t" + "     Herria: "
				+ hartutakoOstatua.getHerria() + "\n     Helbidea: " + hartutakoOstatua.getHelbidea()
				+ "\n Logela Totala: " + erreserba.getErreserbaGelaKop() + "\n     Sartze data: " + sartzeData + "\n     Irtetze data: "
				+ irtetzeData);
		txtTiket.setEditable(false);
		txtTiket.setBackground(Color.LIGHT_GRAY);
		txtTiket.setBounds(37, 146, 545, 391);
		getContentPane().add(txtTiket);

		btnTiketaImprimatu = new JButton("Erreserba imprimatu eta bukatu erosketa");
		btnTiketaImprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketa.Leiho_segunduak();
				dispose();
			}
		});
		btnTiketaImprimatu.setBounds(131, 108, 306, 25);
		getContentPane().add(btnTiketaImprimatu);

	}
}