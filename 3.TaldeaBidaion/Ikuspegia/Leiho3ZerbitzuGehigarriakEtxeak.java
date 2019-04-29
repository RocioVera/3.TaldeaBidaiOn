package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;

import javax.swing.*;
import Kontrolatzailea.*;
import javax.swing.*;


public class Leiho3ZerbitzuGehigarriakEtxeak extends JFrame {
	
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");

	public Leiho3ZerbitzuGehigarriakEtxeak(Hotela hartutakoHotela, double prezioTot, java.util.Date dataSartzeString, java.util.Date dataIrtetzeString, gelaMota_ohe_hotela h2) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");


		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
				dispose();
			}
		});
		restart.setBounds(245, 508, 72, 32);
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);
	
	}
}
