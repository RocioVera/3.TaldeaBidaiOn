package Ikuspegia;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

import Kontrolatzailea.MetodoakKontsultak;
import Kontrolatzailea.MetodoakLeihoAldaketaBBDD;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class Leiho4AukeratuAldaketa extends JFrame {
	private JLabel lblKudeaketa;
	private JButton restart,btnOstatuak, btnPromozioak, btnZerbitzuak;

	public Leiho4AukeratuAldaketa() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setTitle("1.taldearen txartel salmenta");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		lblKudeaketa = new JLabel("Zer kudeatu nahi duzu?");
		lblKudeaketa.setHorizontalAlignment(SwingConstants.CENTER);
		lblKudeaketa.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblKudeaketa.setBounds(61, 65, 479, 30);
		getContentPane().add(lblKudeaketa);

		btnOstatuak = new JButton("Ostatuak");
		btnOstatuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketaBBDD.bostgarrenLeihoa();
				dispose();
			}
		});
		btnOstatuak.setBounds(216, 139, 181, 48);
		getContentPane().add(btnOstatuak);

		btnPromozioak = new JButton("Promozioak");
		btnPromozioak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.seigarrenLeihoa();
				dispose();
			}
		});
		btnPromozioak.setBounds(216, 239, 181, 48);
		getContentPane().add(btnPromozioak);

		btnZerbitzuak = new JButton("Zerbitzuak");
		btnZerbitzuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.zazpigarrenLeihoa();
				dispose();
			}
		});
		btnZerbitzuak.setBounds(216, 339, 181, 48);
		getContentPane().add(btnZerbitzuak);
		
		// botoiak
		restart = new JButton("\u2302");
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(285, 500, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);
	}
}
