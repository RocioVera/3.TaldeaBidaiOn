package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Leiho10Ticket extends JFrame {
	private static final long serialVersionUID = 1L;

	// panelan ikusten diren bariableak
	private JLabel lblEskerrikAskoMezua1, lblEskerrikAskoMezua2;
	private JButton btnTiketaImprimatu;
	private JTextArea txtTiket;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	private String zerbStr = "", gosariaStr = "";

	/**
	 * Ticket egiten duen panela sortu
	 * 
	 * @author talde3
	 * @param hartutakoOstatua Ostatua
	 * @param sartzeData	Ostatua
	 * @param irtetzeData	Ostatua
	 * @param erreserba	Ostatua
	 * @param hartutakoZerbitzuArray	Ostatua
	 * @param gosaria	Ostatua
	 */
	public Leiho10Ticket(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData, Erreserba erreserba,
			ArrayList<HartutakoOstatuarenZerbitzuak> hartutakoZerbitzuArray, boolean gosaria) {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		// zerbitzuak gehitu
		for (HartutakoOstatuarenZerbitzuak h : hartutakoZerbitzuArray) {
			if (h.getHartuta() != null && h.getHartuta().equals("Bai"))
				zerbStr += "     " + h.getIzena() + "\n";
		}
		if (gosaria) {
			gosariaStr = "Hartu duzu gosaria";
		}

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
		txtTiket.setText("Prezioa: " + erreserba.getPrezioTotala() + " €" + "\nBezeroaren datuak: \n     Nan: "
				+ erreserba.getBezeroNan() + "\nHotelaren datuak: \n     Izena: " + hartutakoOstatua.getIzena() + "\n"
				+ "     Herria: " + hartutakoOstatua.getHerria() + "\n     Helbidea: " + hartutakoOstatua.getHelbidea()
				+ "\n Logela Totala: " + erreserba.getErreserbaGelaKop() + "\n     Sartze data: "
				+ formato.format(sartzeData) + "\n     Irtetze data: " + formato.format(irtetzeData)
				+ "\nHartutako zerbitzuak:\n" + zerbStr + gosariaStr + "\nHartutako pentsio mota:\n     "
				+ erreserba.getPentsioMota());
		txtTiket.setEditable(false);
		txtTiket.setBackground(Color.LIGHT_GRAY);
		txtTiket.setBounds(97, 144, 416, 394);
		getContentPane().add(txtTiket);

		btnTiketaImprimatu = new JButton("Erreserba imprimatu eta bukatu erosketa");
		btnTiketaImprimatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketa.Leiho_segunduak();
				dispose();
			}
		});
		btnTiketaImprimatu.setBounds(148, 108, 306, 25);
		getContentPane().add(btnTiketaImprimatu);

	}
}