package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

import javax.swing.*;
import Kontrolatzailea.*;
import javax.swing.*;


public class Leiho4ZerbitzuGehigarriak extends JFrame {
	private JTextField txtPrezioa, txtLogelak;
	private JLabel lblIzena = new JLabel(""), lblLogelak = new JLabel("Logelak:");
	private JLabel lblPrezioa = new JLabel("Prezioa:"), lblOheak = new JLabel("Oheak:");
	private JLabel lblSinpleak = new JLabel("Sinpleak(num):"), lblBikoitzak = new JLabel("Bikoitzak(num):"),
			lblUmeentzat = new JLabel("Umeentzat(num):"), lblPentsioa = new JLabel("Pentsioa:"),
			lblZerbitzuak = new JLabel("Zerbitzuak:");
	private JComboBox cboxOheSinpleak = new JComboBox(), cboxOheBikoitzak = new JComboBox(),
			cboxOheUmeentzat = new JComboBox(), cboxPentsioa = new JComboBox();
	private JCheckBox chckbxGozaria = new JCheckBox("Gozaria"), chckbxWifi = new JCheckBox("Wifi"),
			chckbxIgerilekua = new JCheckBox("Igerilekua"), chckbxSpa = new JCheckBox("Spa"),
			chckbxParking = new JCheckBox("Parking"), chckbxAireGirotua = new JCheckBox("Aire girotua"),
			chckbxJatetxea = new JCheckBox("Jatetxea"), chckbxTaberna = new JCheckBox("Taberna"),
			chckbxGimnasioa = new JCheckBox("Gimnasioa");
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");

	public Leiho4ZerbitzuGehigarriak(Hotela hartutakoHotela, double prezioTot, java.util.Date dataSartzeString, java.util.Date dataIrtetzeString, gelaMota_ohe_hotela h2) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen ostatu zerbitzuen bilatzailea");


		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bostgarrenLeihoa(hartutakoHotela, prezioTot, dataSartzeString, dataIrtetzeString, h2);
				dispose();
			}
		});
		btn_next.setBounds(423, 508, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setBackground(Color.LIGHT_GRAY);
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				MetodoakLeihoAldaketa.hirugarrenLeihoa(hartutakoHotela, dataSartzeString, dataIrtetzeString);
				dispose();
			}
		});
		btn_prev.setBounds(38, 508, 99, 32);
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(btn_prev);

		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(245, 508, 72, 32);
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);
		
		lblIzena.setText(hartutakoHotela.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblIzena.setBounds(0, 24, 594, 32);
		getContentPane().add(lblIzena);

		lblLogelak.setBounds(329, 134, 72, 25);
		getContentPane().add(lblLogelak);

		lblPrezioa.setBounds(210, 72, 63, 14);
		getContentPane().add(lblPrezioa);
		lblOheak.setFont(new Font("Verdana", Font.BOLD, 13));

		lblOheak.setBounds(62, 97, 75, 28);
		getContentPane().add(lblOheak);

		lblSinpleak.setBounds(72, 139, 103, 14);
		getContentPane().add(lblSinpleak);

		cboxOheSinpleak.setBounds(174, 136, 46, 20);
		getContentPane().add(cboxOheSinpleak);

		lblBikoitzak.setBounds(72, 177, 103, 14);
		getContentPane().add(lblBikoitzak);

		cboxOheBikoitzak.setBounds(174, 174, 46, 20);
		getContentPane().add(cboxOheBikoitzak);

		lblUmeentzat.setBounds(72, 217, 103, 14);
		getContentPane().add(lblUmeentzat);

		cboxOheUmeentzat.setBounds(174, 214, 46, 20);
		getContentPane().add(cboxOheUmeentzat);

		txtPrezioa = new JTextField();
		txtPrezioa.setText(h2.getPrezioa()+" €");
		txtPrezioa.setEditable(false);
		txtPrezioa.setBounds(268, 69, 86, 20);
		txtPrezioa.setColumns(10);
		getContentPane().add(txtPrezioa);

		txtLogelak = new JTextField();
		txtLogelak.setEditable(false);
		txtLogelak.setBounds(404, 136, 86, 20);
		getContentPane().add(txtLogelak);
		txtLogelak.setColumns(10);

		lblPentsioa.setBounds(329, 190, 72, 14);
		getContentPane().add(lblPentsioa);

		cboxPentsioa.setBounds(404, 187, 86, 20);
		getContentPane().add(cboxPentsioa);

		chckbxGozaria.setBounds(373, 213, 97, 23);
		getContentPane().add(chckbxGozaria);
		lblZerbitzuak.setFont(new Font("Verdana", Font.BOLD, 13));

		lblZerbitzuak.setBounds(62, 280, 97, 25);
		getContentPane().add(lblZerbitzuak);

		chckbxWifi.setBounds(359, 328, 97, 23);
		getContentPane().add(chckbxWifi);

		chckbxIgerilekua.setBounds(210, 376, 97, 23);
		getContentPane().add(chckbxIgerilekua);

		chckbxSpa.setBounds(62, 328, 97, 23);
		getContentPane().add(chckbxSpa);

		chckbxParking.setBounds(62, 376, 97, 23);
		getContentPane().add(chckbxParking);

		chckbxAireGirotua.setBounds(62, 424, 97, 23);
		getContentPane().add(chckbxAireGirotua);

		chckbxJatetxea.setBounds(210, 328, 97, 23);
		getContentPane().add(chckbxJatetxea);

		chckbxTaberna.setBounds(210, 424, 97, 23);
		getContentPane().add(chckbxTaberna);

		chckbxGimnasioa.setBounds(359, 376, 97, 23);
		getContentPane().add(chckbxGimnasioa);
	}
}
