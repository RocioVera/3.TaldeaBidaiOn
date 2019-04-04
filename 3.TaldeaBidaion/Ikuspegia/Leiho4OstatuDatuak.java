package Ikuspegia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Kontrolatzailea.Metodoak;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Leiho4OstatuDatuak extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1, textField_2;
	private JLabel lblIzena = new JLabel("Izena:"), lblLogelak = new JLabel("Logelak:");
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

	public Leiho4OstatuDatuak() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(350, 50, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bostgarrenLeihoa();
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
				Metodoak.hirugarrenLeihoa();

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
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(245, 508, 72, 32);
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		lblIzena.setBounds(62, 58, 158, 14);
		contentPane.add(lblIzena);

		lblLogelak.setBounds(329, 95, 72, 25);
		contentPane.add(lblLogelak);

		lblPrezioa.setBounds(329, 58, 63, 14);
		contentPane.add(lblPrezioa);

		lblOheak.setBounds(62, 111, 46, 14);
		contentPane.add(lblOheak);

		lblSinpleak.setBounds(72, 139, 103, 14);
		contentPane.add(lblSinpleak);

		cboxOheSinpleak.setBounds(174, 136, 46, 20);
		contentPane.add(cboxOheSinpleak);

		lblBikoitzak.setBounds(72, 177, 103, 14);
		contentPane.add(lblBikoitzak);

		cboxOheBikoitzak.setBounds(174, 174, 46, 20);
		contentPane.add(cboxOheBikoitzak);

		lblUmeentzat.setBounds(72, 217, 103, 14);
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

		lblPentsioa.setBounds(329, 150, 72, 14);
		contentPane.add(lblPentsioa);

		cboxPentsioa.setBounds(404, 147, 86, 20);
		contentPane.add(cboxPentsioa);

		chckbxGozaria.setBounds(329, 195, 97, 23);
		contentPane.add(chckbxGozaria);

		lblZerbitzuak.setBounds(62, 280, 97, 14);
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
