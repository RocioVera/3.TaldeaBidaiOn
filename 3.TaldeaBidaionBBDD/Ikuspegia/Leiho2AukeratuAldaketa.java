package Ikuspegia;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;

public class Leiho2AukeratuAldaketa extends JPanel {

	/**
	 * Create the panel.
	 */
	public Leiho2AukeratuAldaketa() {
		this.setBounds(350,50,363,273);
		setLayout(null);
		
		JLabel lblGestioa = new JLabel("Zer kudeatu nahi da ?");
		lblGestioa.setFont(new Font("Source Sans Pro ExtraLight", Font.PLAIN, 18));
		lblGestioa.setBounds(60, 33, 259, 30);
		add(lblGestioa);
		
		JButton btnOstatuak = new JButton("Ostatuak");
		btnOstatuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOstatuak.setBounds(88, 74, 181, 48);
		add(btnOstatuak);
		
		JButton btnPromozioak = new JButton("Promozioak");
		btnPromozioak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPromozioak.setBounds(87, 133, 181, 48);
		add(btnPromozioak);
		
		JButton btnSerbitzuak = new JButton("Serbitzuak");
		btnSerbitzuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSerbitzuak.setBounds(88, 191, 181, 48);
		add(btnSerbitzuak);
	}
}
