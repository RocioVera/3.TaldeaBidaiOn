package Ikuspegia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Kontrolatzailea.MetodoakLeihoAldaketaBBDD;

public class Leiho5OstatuakAldatu extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JButton restart, btn_prev;
	private JMenuBar menuBar = new JMenuBar();
	private ButtonGroup ostatuGroup;

	private JMenu mnHotela, mnEtxea, mnApartamentua;
	private JRadioButton rbHAldatu, rbHGehitu, rbHEzabatu, rbEAldatu, rbEGehitu, rbEEzabatu, rbAGehitu, rbAAldatu,
			rbAEzabatu;

	// bariableak

	public Leiho5OstatuakAldatu() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen administratzaileen aplikazioa");

		// botoiak
		restart = new JButton("\u2302");
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(421, 477, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);

		btn_prev = new JButton("Atzera");
		btn_prev.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketaBBDD.laugarrenLeihoa();
				dispose();
			}
		});
		btn_prev.setBounds(73, 476, 125, 32);
		btn_prev.setForeground(Color.RED);
		getContentPane().add(btn_prev);

		// group --> bakarrik bat
		ostatuGroup = new ButtonGroup();
		this.setJMenuBar(menuBar);

		// Hotela
		mnHotela = new JMenu("           Hotela           ");
		mnHotela.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnHotela);

		rbHAldatu = new JRadioButton("Aldatu                 ");
		rbHAldatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbHAldatu);
			}
		});
		rbHAldatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnHotela.add(rbHAldatu);

		rbHGehitu = new JRadioButton("Gehitu");
		rbHGehitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbHGehitu);
			}
		});
		rbHGehitu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnHotela.add(rbHGehitu);

		rbHEzabatu = new JRadioButton("Ezabatu");
		rbHEzabatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbHEzabatu);
			}
		});
		rbHEzabatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnHotela.add(rbHEzabatu);

		// etxea
		mnEtxea = new JMenu("           Etxea           ");
		mnEtxea.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnEtxea);

		rbEAldatu = new JRadioButton("Aldatu                ");
		rbEAldatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbEAldatu);
			}
		});
		rbEAldatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnEtxea.add(rbEAldatu);

		rbEGehitu = new JRadioButton("Gehitu");
		rbEGehitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbEGehitu);
			}
		});
		rbEGehitu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnEtxea.add(rbEGehitu);

		rbEEzabatu = new JRadioButton("Ezabatu");
		rbEEzabatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbEEzabatu);
			}
		});
		rbEEzabatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnEtxea.add(rbEEzabatu);

		// apartamentua
		mnApartamentua = new JMenu("        Apartamentua       ");
		mnApartamentua.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnApartamentua);

		rbAAldatu = new JRadioButton("Aldatu                    ");
		rbAAldatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbAAldatu);
			}
		});
		rbAAldatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnApartamentua.add(rbAAldatu);

		rbAGehitu = new JRadioButton("Gehitu");
		rbAGehitu.setFont(new Font("Verdana", Font.PLAIN, 16));
		rbAGehitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbAGehitu);
			}
		});
		mnApartamentua.add(rbAGehitu);

		rbAEzabatu = new JRadioButton("Ezabatu");
		rbAEzabatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		rbAEzabatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuGroup.add(rbAEzabatu);
			}
		});
		mnApartamentua.add(rbAEzabatu);

	}
}