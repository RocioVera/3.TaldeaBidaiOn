package Ikuspegia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Kontrolatzailea.MetodoakLeihoAldaketaBBDD;

public class Leiho6PromozioakAldatu extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JButton restart, btn_prev;
	private JMenuBar menuBar = new JMenuBar();
	private ButtonGroup promozioGroup;

	private JMenu mnAldatu, mnGehitu, mnEzabatu;
	private JRadioButton rbAPromozioa, rbAPromozioPrezioa, rbABezeroPromozio, rbGPromozioa, rbGPromozioPrezioa,
			rbGBezeroPromozio, rbEPromozioa, rbEPromozioPrezioa, rbEBezeroPromozio;

	// bariableak

	public Leiho6PromozioakAldatu() {
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
		promozioGroup = new ButtonGroup();
		this.setJMenuBar(menuBar);

		// Aldatu
		mnAldatu = new JMenu("           Aldatu           ");

		mnAldatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnAldatu);

		rbAPromozioa = new JRadioButton("Promozioa            ");
		rbAPromozioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbAPromozioa);
			}
		});
		rbAPromozioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnAldatu.add(rbAPromozioa);

		rbAPromozioPrezioa = new JRadioButton("Promozio prezioa");
		rbAPromozioPrezioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbAPromozioPrezioa);
			}
		});
		rbAPromozioPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnAldatu.add(rbAPromozioPrezioa);

		rbABezeroPromozio = new JRadioButton("Bezero promozioa");
		rbABezeroPromozio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbABezeroPromozio);
			}
		});
		rbABezeroPromozio.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnAldatu.add(rbABezeroPromozio);

		// gehitu
		mnGehitu = new JMenu("           Gehitu           ");

		mnGehitu.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnGehitu);

		rbGPromozioa = new JRadioButton("Promozioa            ");
		rbGPromozioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbGPromozioa);
			}
		});
		rbGPromozioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnGehitu.add(rbGPromozioa);

		rbGPromozioPrezioa = new JRadioButton("Promozio prezioa");
		rbGPromozioPrezioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbGPromozioPrezioa);
			}
		});
		rbGPromozioPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnGehitu.add(rbGPromozioPrezioa);

		rbGBezeroPromozio = new JRadioButton("Bezero promozioa");
		rbGBezeroPromozio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbGBezeroPromozio);
			}
		});
		rbGBezeroPromozio.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnGehitu.add(rbGBezeroPromozio);

		// ezabatu
		mnEzabatu = new JMenu("           Ezabatu           ");
		mnEzabatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnEzabatu);

		rbEPromozioa = new JRadioButton("Promozioa               ");
		rbEPromozioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbEPromozioa);
			}
		});
		rbEPromozioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnEzabatu.add(rbEPromozioa);

		rbEPromozioPrezioa = new JRadioButton("Promozio prezioa");
		rbEPromozioPrezioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbEPromozioPrezioa);
			}
		});
		rbEPromozioPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnEzabatu.add(rbEPromozioPrezioa);

		rbEBezeroPromozio = new JRadioButton("Bezero promozioa");
		rbEBezeroPromozio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				promozioGroup.add(rbEBezeroPromozio);
			}
		});
		rbEBezeroPromozio.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnEzabatu.add(rbEBezeroPromozio);
	}
}