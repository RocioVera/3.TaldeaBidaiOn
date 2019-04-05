package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import Kontrolatzailea.Hotela;
import Kontrolatzailea.Metodoak;

public class Leiho2AukeratuOstatu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTextField txtSartuHerria = new JTextField();
	private JMenuBar menuBar = new JMenuBar();
	// izarkopuru
	private JMenu mnIzarKopurua = new JMenu("       Izar kopurua      ");
	private JCheckBoxMenuItem chckbxmntmIzar_5 = new JCheckBoxMenuItem("5 Izar"),
			chckbxmntmIzar_1 = new JCheckBoxMenuItem("4 Izar"), chckbxmntmIzar_2 = new JCheckBoxMenuItem("3 Izar"),
			chckbxmntmIzar_3 = new JCheckBoxMenuItem("2 Izar"), chckbxmntmIzar_4 = new JCheckBoxMenuItem("1 Izar");
	// ostatu mota
	private JMenu mnOstatuMota = new JMenu("       Ostatu mota      ");
	private JCheckBoxMenuItem chckbxmntmHotela = new JCheckBoxMenuItem("Hotela"),
			chckbxmntmApartamentua = new JCheckBoxMenuItem("Apartamentua"),
			chckbxmntmEtxea = new JCheckBoxMenuItem("Etxea");
	// ordenatu
	private JMenu mnOrdenatu = new JMenu("        Ordenatu       ");
	private JCheckBoxMenuItem chckbxmntmPrezioa = new JCheckBoxMenuItem("Prezioa"),
			chckbxmntmAlfabetoa = new JCheckBoxMenuItem("Alfabetoa"),
			chckbxmntmErreserbaKopurua = new JCheckBoxMenuItem("Erreserba kopurua");

	private JDateChooser dchJoan = new JDateChooser(), dchEtorri = new JDateChooser();
	private JButton btn_next = new JButton("Hurrengoa"), restart = new JButton("\u2302"),
			btnBilatu = new JButton("Bilatu");
	private JList list = new JList();

	public Leiho2AukeratuOstatu() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		this.getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen ostatu zerbitzuen bilatzailea");

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.hirugarrenLeihoa();
				dispose();
			}
		});
		btn_next.setBounds(392, 477, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		btn_next.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btn_next);

		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(61, 483, 89, 23);
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);

		// Jmenua izar kopurua
		this.setJMenuBar(menuBar);
		mnIzarKopurua.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnIzarKopurua);

		// 1
		mnIzarKopurua.add(chckbxmntmIzar_1);
		chckbxmntmIzar_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 2
		mnIzarKopurua.add(chckbxmntmIzar_2);
		chckbxmntmIzar_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 3
		mnIzarKopurua.add(chckbxmntmIzar_3);
		chckbxmntmIzar_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 4
		mnIzarKopurua.add(chckbxmntmIzar_4);
		chckbxmntmIzar_4.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 5
		mnIzarKopurua.add(chckbxmntmIzar_5);
		chckbxmntmIzar_5.setFont(new Font("Verdana", Font.PLAIN, 16));

		// ostatu mota
		mnOstatuMota.setFont(new Font("Verdana", Font.PLAIN, 16));

		menuBar.add(mnOstatuMota);
		mnOstatuMota.add(chckbxmntmHotela);
		chckbxmntmHotela.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.add(chckbxmntmApartamentua);
		chckbxmntmApartamentua.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.add(chckbxmntmEtxea);
		chckbxmntmEtxea.setFont(new Font("Verdana", Font.PLAIN, 16));

		// ordenatzeko modua
		mnOrdenatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnOrdenatu);
		mnOrdenatu.add(chckbxmntmPrezioa);
		chckbxmntmPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmAlfabetoa);
		chckbxmntmAlfabetoa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmErreserbaKopurua);
		chckbxmntmErreserbaKopurua.setFont(new Font("Verdana", Font.PLAIN, 16));

		// joan data
		dchJoan.setBounds(230, 30, 113, 20);
		getContentPane().add(dchJoan);
		dchJoan.setDate(Date.valueOf(LocalDate.now()));

		// etorri data
		dchEtorri.setBounds(353, 30, 118, 20);
		getContentPane().add(dchEtorri);
		dchEtorri.setDate(Date.valueOf(LocalDate.now()));

		// herria sartzeko lekua
		txtSartuHerria.setText("");
		txtSartuHerria.setBounds(24, 30, 180, 20);
		txtSartuHerria.setColumns(10);
		getContentPane().add(txtSartuHerria);
		
		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Hotela> arrayHotelak = new ArrayList<Hotela>();
				//imprimir hoteles pero no sale la informacion
				arrayHotelak = Metodoak.hotelakAtera(txtSartuHerria.getText());
				System.out.println();
				for (int i = 0; i < arrayHotelak.size(); i++) {
					System.out.println(arrayHotelak.get(0).getIzena());
				}
			}
		});

		// herria bilatzeko botoia
		btnBilatu.setBounds(485, 25, 97, 25);
		getContentPane().add(btnBilatu);

		list.setBounds(24, 121, 534, 334);
		getContentPane().add(list);

	}
}
