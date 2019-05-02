package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import Kontrolatzailea.*;
import javax.swing.*;


public class Leiho3ZerbitzuGehigarriakEtxeak extends JFrame {
	
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");
	private JTextField txtPrezioa;
	private JLabel lblIzena=new JLabel(""), lblPrezioa=new JLabel("");

	public Leiho3ZerbitzuGehigarriakEtxeak(Ostatua hartutakoOstatua, double prezioTot, Date dataSartze, Date dataIrtetze) {
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
				MetodoakLeihoAldaketa.bostgarrenLeihoa(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze);
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
				MetodoakLeihoAldaketa.bigarrenLeihoa();
				dispose();
			}
		});
		btn_prev.setBounds(38, 508, 127, 32);
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
		
		lblIzena.setText(hartutakoOstatua.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblIzena.setBounds(0, 24, 594, 32);
		getContentPane().add(lblIzena);
		
		txtPrezioa = new JTextField();
		txtPrezioa.setText(prezioTot+" €");
		txtPrezioa.setEditable(false);
		txtPrezioa.setColumns(10);
		txtPrezioa.setBounds(268, 75, 86, 20);
		getContentPane().add(txtPrezioa);
		
		lblPrezioa = new JLabel("Prezioa:");
		lblPrezioa.setBounds(210, 78, 63, 14);
		getContentPane().add(lblPrezioa);


		
		MetodoakKontsultak.zerbGehiMet(hartutakoOstatua);
		
	
	}
}
