package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

import Kontrolatzailea.*;
import javax.swing.table.*;

public class Leiho3EtxeDatuak extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblIzena = new JLabel(""), lblPrezioa = new JLabel("Prezioa:");
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");
	private JTextField txtPrezioa;
	private ArrayList<gelaMota_ohe_ostatu> logelaOheTot = new ArrayList<gelaMota_ohe_ostatu>();
	private ArrayList<GelaMotaEtxea> gelaTot = new ArrayList<GelaMotaEtxea>();

	private int bikoitza, umeak, sinple, pertsonaKop;
	private JTextField txtBinaka, txtSinplea, txtUmeak;

	private JLabel lblBinaka = new JLabel("Bikoitza:"), lblSinplea = new JLabel("Sinplea:"),
			lblUmeak = new JLabel("Umeak:"), lblOheKopuru = new JLabel("Ohe kopuru:");
	private JLabel lblKomunKop = new JLabel("Komun kopurua:"), lblSukaldeKopurua = new JLabel("Sukalde kopurua:"),
			lblEgongelaKopurua = new JLabel("Egongela kopurua:"), lblGarajeKopurua = new JLabel("Garaje kopurua:"),
			lblLogelaKopurua = new JLabel("Logela kopurua:");
	private JTextField txtKomunKop = new JTextField(), txtSukaldeKop = new JTextField(),
			txtEgongelaKop = new JTextField(), txtGarajeKop = new JTextField(), txtLogelaKop = new JTextField();

	public Leiho3EtxeDatuak(Ostatua hartutakoOstatua, double prezioTot, java.util.Date dataSartze,
			java.util.Date dataIrtetze) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");
		btn_next.setBounds(423, 508, 122, 32);

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.laugarrenLeihoa(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze, 0,
						pertsonaKop);
				dispose();
			}
		});
		getContentPane().setLayout(null);

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
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBackground(Color.LIGHT_GRAY);
		btn_prev.setBounds(38, 508, 99, 32);
		getContentPane().add(btn_prev);

		restart.setBounds(245, 508, 72, 32);
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);
		lblIzena.setBounds(0, 30, 594, 32);

		lblIzena.setText(hartutakoOstatua.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		getContentPane().add(lblIzena);

		txtPrezioa = new JTextField();
		txtPrezioa.setEditable(false);
		txtPrezioa.setBounds(287, 80, 99, 22);
		txtPrezioa.setColumns(10);
		txtPrezioa.setText(prezioTot + " €");
		getContentPane().add(txtPrezioa);

		lblPrezioa.setBounds(225, 84, 63, 14);
		getContentPane().add(lblPrezioa);

		lblBinaka.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBinaka.setBounds(95, 421, 63, 14);
		getContentPane().add(lblBinaka);

		lblSinplea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSinplea.setBounds(245, 417, 63, 22);
		getContentPane().add(lblSinplea);

		lblUmeak.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUmeak.setBounds(389, 421, 63, 14);
		getContentPane().add(lblUmeak);

		lblOheKopuru.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOheKopuru.setBounds(64, 388, 113, 22);
		getContentPane().add(lblOheKopuru);

		logelaOheTot = MetodoakKontsultak.oheGelaDatuakMet(hartutakoOstatua.getOstatuKod());
		for (gelaMota_ohe_ostatu gmo : logelaOheTot) {
			bikoitza += gmo.getBikoitza();
			umeak += gmo.getUmeak();
			sinple += gmo.getSinplea();
		}
		pertsonaKop = bikoitza * 2 + umeak + sinple;

		txtBinaka = new JTextField();
		txtBinaka.setText(bikoitza + "");
		txtBinaka.setEditable(false);
		txtBinaka.setColumns(10);
		txtBinaka.setBounds(151, 422, 38, 15);
		getContentPane().add(txtBinaka);

		txtSinplea = new JTextField();
		txtSinplea.setText(sinple + "");
		txtSinplea.setEditable(false);
		txtSinplea.setColumns(10);
		txtSinplea.setBounds(300, 423, 38, 14);
		getContentPane().add(txtSinplea);

		txtUmeak = new JTextField();
		txtUmeak.setText(umeak + "");
		txtUmeak.setEditable(false);
		txtUmeak.setColumns(10);
		txtUmeak.setBounds(443, 423, 38, 14);
		getContentPane().add(txtUmeak);

		// komun kop
		lblKomunKop.setHorizontalAlignment(SwingConstants.CENTER);
		lblKomunKop.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKomunKop.setBounds(187, 128, 183, 22);
		getContentPane().add(lblKomunKop);

		// sukaldekop
		lblSukaldeKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblSukaldeKopurua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSukaldeKopurua.setBounds(198, 178, 165, 22);
		getContentPane().add(lblSukaldeKopurua);

		lblEgongelaKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblEgongelaKopurua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEgongelaKopurua.setBounds(198, 226, 172, 22);
		getContentPane().add(lblEgongelaKopurua);

		lblGarajeKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblGarajeKopurua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGarajeKopurua.setBounds(198, 275, 151, 22);
		getContentPane().add(lblGarajeKopurua);

		lblLogelaKopurua.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogelaKopurua.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLogelaKopurua.setBounds(198, 322, 151, 22);
		getContentPane().add(lblLogelaKopurua);
		txtKomunKop.setHorizontalAlignment(SwingConstants.CENTER);

		txtKomunKop.setText("0");
		txtKomunKop.setEditable(false);
		txtKomunKop.setColumns(10);
		txtKomunKop.setBounds(360, 131, 26, 20);
		getContentPane().add(txtKomunKop);
		txtSukaldeKop.setHorizontalAlignment(SwingConstants.CENTER);

		txtSukaldeKop.setText("0");
		txtSukaldeKop.setEditable(false);
		txtSukaldeKop.setColumns(10);
		txtSukaldeKop.setBounds(360, 178, 26, 20);
		getContentPane().add(txtSukaldeKop);
		txtEgongelaKop.setHorizontalAlignment(SwingConstants.CENTER);

		txtEgongelaKop.setText("0");
		txtEgongelaKop.setEditable(false);
		txtEgongelaKop.setColumns(10);
		txtEgongelaKop.setBounds(360, 226, 26, 20);
		getContentPane().add(txtEgongelaKop);
		txtGarajeKop.setHorizontalAlignment(SwingConstants.CENTER);

		txtGarajeKop.setText("0");
		txtGarajeKop.setEditable(false);
		txtGarajeKop.setColumns(10);
		txtGarajeKop.setBounds(360, 277, 26, 22);
		getContentPane().add(txtGarajeKop);
		txtLogelaKop.setHorizontalAlignment(SwingConstants.CENTER);

		txtLogelaKop.setText("0");
		txtLogelaKop.setEditable(false);
		txtLogelaKop.setColumns(10);
		txtLogelaKop.setBounds(360, 325, 26, 20);
		getContentPane().add(txtLogelaKop);

		gelaTot = MetodoakKontsultak.gelaKantMotaMet(hartutakoOstatua.getOstatuKod());
		for (GelaMotaEtxea gme : gelaTot) {
			if (gme.getGelaMota().equals("logela"))
				txtLogelaKop.setText("" + gme.getKantitatea());
			else if (gme.getGelaMota().equals("komuna"))
				txtKomunKop.setText("" + gme.getKantitatea());
			else if (gme.getGelaMota().equals("sukaldea"))
				txtSukaldeKop.setText("" + gme.getKantitatea());
			else if (gme.getGelaMota().equals("egongela"))
				txtEgongelaKop.setText("" + gme.getKantitatea());
			else if (gme.getGelaMota().equals("garajea"))
				txtGarajeKop.setText("" + gme.getKantitatea());

		}

	}
}
