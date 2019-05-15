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
	private JComboBox cbHerria;


	/**
	 * Ticket egiten duen panela sortu 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param sartzeData
	 * @param irtetzeData
	 * @param erreserba
	 * @param hartutakoZerbitzuArray 
	 */
	public Leiho10Ticket(Ostatua hartutakoOstatua, Date sartzeData, Date irtetzeData, Erreserba erreserba, ArrayList<HartutakoOstatuarenZerbitzuak> hartutakoZerbitzuArray) {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		//StringSartzeData=sartzeData.get
		
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
		txtTiket.setText("Prezioa: " + erreserba.getPrezioTotala() + " €" + "\nBezeroaren datuak: \n     Nan: " + erreserba.getBezeroNan()
				+ "\nHotelaren datuak: \n     Izena: " + hartutakoOstatua.getIzena() + "\n" + "     Herria: "
				+ hartutakoOstatua.getHerria() + "\n     Helbidea: " + hartutakoOstatua.getHelbidea()
				+ "\n Logela Totala: " + erreserba.getErreserbaGelaKop() + "\n     Sartze data: " + formato.format(sartzeData) + "\n     Irtetze data: "
				+ formato.format(irtetzeData));
		txtTiket.setEditable(false);
		txtTiket.setBackground(Color.LIGHT_GRAY);
		txtTiket.setBounds(12, 224, 560, 298);
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
		
		cbHerria = new JComboBox<String>();
		cbHerria.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 12));
		cbHerria.setBounds(184, 176, 250, 35);
		cbHerria.addItem("Hartutako zerbitzu gehigarriak");
		for (HartutakoOstatuarenZerbitzuak h : hartutakoZerbitzuArray) {
			if (h.getHartuta()!=null && h.getHartuta().equals("Bai"))
				cbHerria.addItem(h.getIzena());
		}
		if (hartutakoZerbitzuArray!=null)
			cbHerria.setVisible(false);
		getContentPane().add(cbHerria);

	}
}