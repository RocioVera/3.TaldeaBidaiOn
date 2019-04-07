package Ikuspegia;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class Leiho3AukeratuAldaketa extends JFrame {
	private JLabel lblKudeaketa;
	private JButton btnOstatuak, btnPromozioak, btnZerbitzuak;

	public Leiho3AukeratuAldaketa() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setTitle("1.taldearen txartel salmenta");
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));

		lblKudeaketa = new JLabel("Zer kudeatu nahi duzu?");
		lblKudeaketa.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 18));
		lblKudeaketa.setBounds(60, 33, 259, 30);
		add(lblKudeaketa);

		btnOstatuak = new JButton("Ostatuak");
		btnOstatuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOstatuak.setBounds(88, 74, 181, 48);
		add(btnOstatuak);

		btnPromozioak = new JButton("Promozioak");
		btnPromozioak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPromozioak.setBounds(87, 133, 181, 48);
		add(btnPromozioak);

		btnZerbitzuak = new JButton("Zerbitzuak");
		btnZerbitzuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnZerbitzuak.setBounds(88, 191, 181, 48);
		add(btnZerbitzuak);
	}
}
