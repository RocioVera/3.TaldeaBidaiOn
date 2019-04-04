package Ikuspegia;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class Leiho3OstatuDatuak extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblIzena = new JLabel("Izena");
	private JLabel lblLogelak = new JLabel("Logelak:");
	private JLabel lblPrezioa = new JLabel("Prezioa:");
	private JLabel lblOheak = new JLabel("Oheak:");
	private JLabel lblSinpleak = new JLabel("Sinpleak(num):");
	private JLabel lblBikoitzak = new JLabel("Bikoitzak(num):");
	private JLabel lblUmeentzat = new JLabel("Umeentzat(num):");
	private JLabel lblPentsioa = new JLabel("Pentsioa:");
	private JLabel lblZerbitzuak = new JLabel("Zerbitzuak:");
	private JComboBox cboxOheSinpleak = new JComboBox();
	private JComboBox cboxOheBikoitzak = new JComboBox();
	private JComboBox cboxOheUmeentzat = new JComboBox();
	private JComboBox cboxPentsioa = new JComboBox();
	private JCheckBox chckbxGozaria = new JCheckBox("Gozaria");
	private JCheckBox chckbxWifi = new JCheckBox("Wifi");
	private JCheckBox chckbxIgerilekua = new JCheckBox("Igerilekua");
	private JCheckBox chckbxSpa = new JCheckBox("Spa");
	private JCheckBox chckbxParking = new JCheckBox("Parking");
	private JCheckBox chckbxAireGirotua = new JCheckBox("Aire girotua");
	private JCheckBox chckbxJatetxea = new JCheckBox("Jatetxea");
	private JCheckBox chckbxTaberna = new JCheckBox("Taberna");
	private JCheckBox chckbxGimnasioa = new JCheckBox("Gimnasioa");

	public Leiho3OstatuDatuak() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		lblIzena.setBounds(62, 58, 158, 14);
		contentPane.add(lblIzena);

		lblLogelak.setBounds(329, 100, 46, 14);
		contentPane.add(lblLogelak);

		lblPrezioa.setBounds(329, 58, 46, 14);
		contentPane.add(lblPrezioa);

		lblOheak.setBounds(62, 111, 46, 14);
		contentPane.add(lblOheak);

		lblSinpleak.setBounds(72, 139, 71, 14);
		contentPane.add(lblSinpleak);

		cboxOheSinpleak.setBounds(174, 136, 46, 20);
		contentPane.add(cboxOheSinpleak);

		lblBikoitzak.setBounds(72, 177, 85, 14);
		contentPane.add(lblBikoitzak);

		cboxOheBikoitzak.setBounds(174, 174, 46, 20);
		contentPane.add(cboxOheBikoitzak);

		lblUmeentzat.setBounds(72, 217, 85, 14);
		contentPane.add(lblUmeentzat);

		cboxOheUmeentzat.setBounds(174, 214, 46, 20);
		contentPane.add(cboxOheUmeentzat);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(404, 55, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(404, 97, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		lblPentsioa.setBounds(329, 150, 46, 14);
		contentPane.add(lblPentsioa);

		cboxPentsioa.setBounds(404, 147, 86, 20);
		contentPane.add(cboxPentsioa);

		chckbxGozaria.setBounds(329, 195, 97, 23);
		contentPane.add(chckbxGozaria);

		lblZerbitzuak.setBounds(62, 280, 61, 14);
		contentPane.add(lblZerbitzuak);

		chckbxWifi.setBounds(359, 328, 97, 23);
		contentPane.add(chckbxWifi);

		chckbxIgerilekua.setBounds(210, 376, 97, 23);
		contentPane.add(chckbxIgerilekua);

		chckbxSpa.setBounds(62, 328, 97, 23);
		contentPane.add(chckbxSpa);

		chckbxParking.setBounds(62, 376, 97, 23);
		contentPane.add(chckbxParking);

		chckbxAireGirotua.setBounds(62, 424, 97, 23);
		contentPane.add(chckbxAireGirotua);

		chckbxJatetxea.setBounds(210, 328, 97, 23);
		contentPane.add(chckbxJatetxea);

		chckbxTaberna.setBounds(210, 424, 97, 23);
		contentPane.add(chckbxTaberna);

		chckbxGimnasioa.setBounds(359, 376, 97, 23);
		contentPane.add(chckbxGimnasioa);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Ostatu datuak");
	}
}
