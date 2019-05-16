package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;
import com.toedter.calendar.*;

import Kontrolatzailea.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Leiho2AukeratuOstatu extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JMenuBar menuBar = new JMenuBar();

	// ostatu mota
	private JMenu mnOstatuMota = new JMenu("     Ostatu mota      ");
	private JRadioButton chckbxmntmHotela = new JRadioButton("Hotela"),
			chckbxmntmApartamentua = new JRadioButton("Apartamentua       "),
			chckbxmntmEtxea = new JRadioButton("Etxea");
	// ordenatu
	private JMenu mnOrdenatu = new JMenu("      Ordenatu          ");
	private JRadioButton chckbxmntmPrezioa = new JRadioButton("Prezioa"),
			chckbxmntmAlfabetoa = new JRadioButton("Alfabetoa"),
			chckbxmntmErreserbaKopurua = new JRadioButton("Erreserba kopurua  ");
	private JMenu mnIzarKop = new JMenu("     Izar Kopuru       ");
	private JRadioButton chckbxmntmIzar_5 = new JRadioButton("   5 Izar"),
			chckbxmntmIzar_4 = new JRadioButton("  >4 Izar"), chckbxmntmIzar_3 = new JRadioButton("  >3 Izar"),
			chckbxmntmIzar_2 = new JRadioButton("  >2 Izar"),
			chckbxmntmIzar_1 = new JRadioButton("  >1 Izar             ");

	// zerbitzuak
	private JMenu mnZerbitzuak = new JMenu("        Zerbitzuak            ");
	private JRadioButton chckbxmntmParkina = new JRadioButton("Parkina            "),
			chckbxmntmWifi = new JRadioButton("Wifi            "),
			chckbxmntmIgerileku = new JRadioButton("Igerileku            "),
			chckbxmntmSpa = new JRadioButton("Spa            "),
			chckbxmntmAireGirotua = new JRadioButton("Aire Girotua            "),
			chckbxmntmJatetxea = new JRadioButton("Jatetxea            "),
			chckbxmntmTaberna = new JRadioButton("Taberna            "),
			chckbxmntmGimnasioa = new JRadioButton("Gimnasioa            ");

	// taldeak
	private ButtonGroup /* zerbitzuakGroup, */ ostatuMotaGroup, ordenatuGroup, izarKopGroup;

	private JDateChooser dchSartzeData = new JDateChooser(), dchIrtetzeData = new JDateChooser();
	private JTextFieldDateEditor dataEzEditatu; // kentzeko eskuz sartu ahal izana
	private JLabel lblSartzeData = new JLabel("Sartze data"), lblIrtetzeData = new JLabel("Irtetze data"), lblGogoratu;
	private java.util.Date dataIrtetze, dataSartze;
	private JButton btn_next = new JButton("Hurrengoa"), restart = new JButton("\u2302"),
			btnBilatu = new JButton("Bilatu");
	private JComboBox cbHerria;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	// bariableak
	private ArrayList<Hotela> arrayHotela;
	private ArrayList<Etxea> arrayEtxea;
	private ArrayList<Apartamentua> arrayApartamentua;
	private ArrayList<Ostatua> arrayOstatua;

	private Ostatua hartutakoOstatua;

	private String hotelString, ostatuIzen, ostatuMota, prezioa;
	private int hartutakoLerroa;
	private double prezioTot = 0;

	private String[] hotelaBerria = new String[3], etxeBerria = new String[3], apartamentuBerria = new String[3],
			ostatuBerria = new String[3];

	/**
	 * Ostatuak eta egunak aukeratu ahal duzun panela sortu
	 * 
	 * @author talde3
	 */
	public Leiho2AukeratuOstatu() {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		this.getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hartutakoLerroa = table.getSelectedRow();
				hartutakoOstatua = arrayOstatua.get(hartutakoLerroa);

				if (modelo.getValueAt(hartutakoLerroa, 1) == "Hotela") {
					MetodoakLeihoAldaketa.hirugarrenLeihoaHotelak(hartutakoOstatua, dataSartze, dataIrtetze);
					dispose();

				} else if (modelo.getValueAt(hartutakoLerroa, 1) == "Etxea") {

					// prezioaKalkulatu
					prezioTot = MetodoakKontsultak.etxearenPrezioaAtera(hartutakoOstatua.getIzena());
					prezioTot = Metodoak.prezioTotalaGauekin(dataSartze, dataIrtetze, prezioTot);
					prezioTot = prezioTot + MetodoakKontsultak.tarifaAldatuDatengatik(dataSartze, dataIrtetze);

					MetodoakLeihoAldaketa.hirugarrenLeihoaEtxeak(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze);
					dispose();
				} else if (modelo.getValueAt(hartutakoLerroa, 1) == "Apartamentua") {
					// prezioaKalkulatu
					prezioTot = MetodoakKontsultak.etxearenPrezioaAtera(hartutakoOstatua.getIzena());
					prezioTot = Metodoak.prezioTotalaGauekin(dataSartze, dataIrtetze, prezioTot);
					prezioTot = prezioTot + MetodoakKontsultak.tarifaAldatuDatengatik(dataSartze, dataIrtetze);

					MetodoakLeihoAldaketa.hirugarrenLeihoaEtxeak(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze);
					dispose();
				}
			}
		});
		btn_next.setBounds(392, 477, 122, 32);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setForeground(Color.RED);
		btn_next.setBackground(Color.LIGHT_GRAY);
		btn_next.setVisible(false);
		getContentPane().add(btn_next);

		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(61, 483, 89, 23);
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);

		// Jmenua izar kopurua
		this.setJMenuBar(menuBar);

		// group --> bakarrik bat
		ostatuMotaGroup = new ButtonGroup();
		ordenatuGroup = new ButtonGroup();
		// zerbitzuakGroup = new ButtonGroup();
		izarKopGroup = new ButtonGroup();

		this.setJMenuBar(menuBar);

		// ostatu mota
		mnOstatuMota.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.setEnabled(false);
		mnOstatuMota.add(chckbxmntmHotela);
		menuBar.add(mnOstatuMota);

		chckbxmntmHotela.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuMotaGroup.add(chckbxmntmHotela);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

				mnIzarKop.setEnabled(true);

			}
		});
		chckbxmntmHotela.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.add(chckbxmntmApartamentua);

		chckbxmntmApartamentua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuMotaGroup.add(chckbxmntmApartamentua);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
				mnIzarKop.setEnabled(false);

			}
		});
		chckbxmntmApartamentua.setFont(new Font("Verdana", Font.PLAIN, 16));

		chckbxmntmEtxea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ostatuMotaGroup.add(chckbxmntmEtxea);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
				mnIzarKop.setEnabled(false);

			}
		});
		chckbxmntmEtxea.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.add(chckbxmntmEtxea);

		// ordenatzeko modua
		mnOrdenatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.setEnabled(false);
		menuBar.add(mnOrdenatu);

		chckbxmntmPrezioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmPrezioa);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmPrezioa);

		chckbxmntmAlfabetoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmAlfabetoa);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmAlfabetoa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmAlfabetoa);

		chckbxmntmErreserbaKopurua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmErreserbaKopurua);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmErreserbaKopurua.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmErreserbaKopurua);

		// ordenatzeko modua
		mnIzarKop.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnIzarKop.setEnabled(false);
		menuBar.add(mnIzarKop);

		// 1
		chckbxmntmIzar_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_1);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});

		// 5
		chckbxmntmIzar_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_5);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmIzar_5.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnIzarKop.add(chckbxmntmIzar_5);

		// 4
		chckbxmntmIzar_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_4);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmIzar_4.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnIzarKop.add(chckbxmntmIzar_4);

		// 3
		chckbxmntmIzar_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_3);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmIzar_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnIzarKop.add(chckbxmntmIzar_3);

		// 2
		chckbxmntmIzar_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_2);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();
			}
		});
		chckbxmntmIzar_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnIzarKop.add(chckbxmntmIzar_2);
		chckbxmntmIzar_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnIzarKop.add(chckbxmntmIzar_1);

		// zerbitzuak
		mnZerbitzuak.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.setEnabled(false);
		menuBar.add(mnZerbitzuak);

		chckbxmntmParkina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmParkina);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmParkina.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmParkina);

		chckbxmntmWifi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmWifi);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmWifi.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmWifi);

		chckbxmntmIgerileku.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmIgerileku);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmIgerileku.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmIgerileku);

		chckbxmntmSpa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmSpa);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmSpa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmSpa);

		chckbxmntmAireGirotua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmAireGirotua);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmAireGirotua.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmAireGirotua);

		chckbxmntmJatetxea.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmJatetxea);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmJatetxea.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmJatetxea);

		chckbxmntmTaberna.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmTaberna);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmTaberna.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmTaberna);

		chckbxmntmGimnasioa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// zerbitzuakGroup.add(chckbxmntmGimnasioa);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmGimnasioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmGimnasioa);

		// Sartze data
		lblSartzeData.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblSartzeData.setBounds(228, 26, 113, 30);
		getContentPane().add(lblSartzeData);

		// jcalendar sartze data
		dchSartzeData.setDateFormatString("dd-MM-yyyy");
		dchSartzeData.setBounds(216, 61, 113, 20);
		dataEzEditatu = (JTextFieldDateEditor) dchSartzeData.getDateEditor();
		dataEzEditatu.setEditable(false);
		dchSartzeData.setDate(Date.valueOf(LocalDate.now()));
		dchSartzeData.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnOstatuMota.setEnabled(false);
				mnZerbitzuak.setEnabled(false);
				mnOrdenatu.setEnabled(false);
				dchIrtetzeData.setVisible(true);
				dchIrtetzeData.setDate(null);
				btnBilatu.setVisible(false);
				btn_next.setVisible(false);
				for (int i = modelo.getRowCount() - 1; i >= 0; i--)
					modelo.removeRow(i);
			}
		});
		dchSartzeData.getJCalendar().setMinSelectableDate(Date.valueOf(LocalDate.now()));
		getContentPane().add(dchSartzeData);

		// irtetza data
		lblIrtetzeData.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblIrtetzeData.setBounds(353, 26, 113, 30);
		getContentPane().add(lblIrtetzeData);

		// jcalendar irtetze
		dchIrtetzeData.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnOstatuMota.setEnabled(true);
				mnZerbitzuak.setEnabled(true);
				mnOrdenatu.setEnabled(true);
				dataIrtetze = Metodoak.gehiEgunBat(dchSartzeData.getDate());
				dchIrtetzeData.setDate(dataIrtetze);
				dchIrtetzeData.getJCalendar().setMinSelectableDate(dataIrtetze);
				dchIrtetzeData.getJCalendar().setMaxSelectableDate(null);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				for (int i = modelo.getRowCount() - 1; i >= 0; i--)
					modelo.removeRow(i);
			}
		});
		dchIrtetzeData.setDateFormatString("dd-MM-yyyy");
		dchIrtetzeData.setBounds(341, 61, 118, 20);

		dataEzEditatu = (JTextFieldDateEditor) dchIrtetzeData.getDateEditor();
		dataEzEditatu.setEditable(false);
		getContentPane().add(dchIrtetzeData);

		// heriak atera
		cbHerria = new JComboBox<String>();
		cbHerria.setBounds(24, 61, 165, 20);
		for (String herria : MetodoakKontsultak.ostatuHerria())
			cbHerria.addItem(herria);
		getContentPane().add(cbHerria);

		cbHerria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				dchIrtetzeData.setVisible(false);
				btnBilatu.setVisible(false);

				for (int i = modelo.getRowCount() - 1; i >= 0; i--)
					modelo.removeRow(i);
			}
		});

		modelo.addColumn("Izena:");
		modelo.addColumn("Ostatu mota:");
		modelo.addColumn("Prezio (€/gaua):");

		// tabla datuak
		table = new JTable(modelo);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Verdana", Font.PLAIN, 14));

		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowHeight(32);
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(24, 152, 544, 42);
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		getContentPane().add(table);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRowCount() == 1)
					btn_next.setVisible(true);
			}

		});

		scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 145, 574, 293);
		getContentPane().add(scrollPane);

		btnBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datuakBerritu();
			}
		});

		// herria bilatzeko botoia
		btnBilatu.setBounds(471, 56, 97, 25);
		btnBilatu.setVisible(false);

		getContentPane().add(btnBilatu);

		lblGogoratu = new JLabel("Gogoratu festetan edo denboraldi altuko erreserbetan gehigarri bat dagoela");
		lblGogoratu.setForeground(Color.RED);
		lblGogoratu.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblGogoratu.setBounds(38, 104, 524, 30);
		getContentPane().add(lblGogoratu);

	}

	private void datuakBerritu() {
		table.setVisible(true);
		// ematerakoan 0 tik hasteko
		for (int i = modelo.getRowCount() - 1; i >= 0; i--)
			modelo.removeRow(i);
		dataSartze = dchSartzeData.getDate();
		dataIrtetze = dchIrtetzeData.getDate();
		// hotelak
		arrayHotela = MetodoakKontsultak.hotelakAtera((String) cbHerria.getSelectedItem(), dataSartze, dataIrtetze);
		// apartamentuak
		arrayApartamentua = MetodoakKontsultak.apartamentuakAtera((String) cbHerria.getSelectedItem(), dataIrtetze,
				dataIrtetze);
		// etxeak
		arrayEtxea = MetodoakKontsultak.etxeakAtera((String) cbHerria.getSelectedItem(), dataIrtetze, dataIrtetze);

		arrayOstatua = new ArrayList<Ostatua>();

		// ostatu mota filtroa
		if (chckbxmntmApartamentua.isSelected() || chckbxmntmHotela.isSelected() || chckbxmntmEtxea.isSelected()) {
			if (chckbxmntmApartamentua.isSelected()) {
				for (Apartamentua u : arrayApartamentua) {
					arrayOstatua.add(u);
					u.setPrezioa(MetodoakKontsultak.etxearenPrezioaAtera(u.getIzena()));
				}
			}
			if (chckbxmntmEtxea.isSelected()) {
				for (Etxea a : arrayEtxea) {
					arrayOstatua.add(a);
					a.setPrezioa(MetodoakKontsultak.etxearenPrezioaAtera(a.getIzena()));
				}

			}
			if (chckbxmntmHotela.isSelected()) {
				for (Hotela h : arrayHotela) {
					arrayOstatua.add(h);
					h.setPrezioa(MetodoakKontsultak.hotelarenPrezioaAtera(h.getIzena()));
				}
			}

		} else
			arrayOstatua = Metodoak.ostatuakSortu(arrayHotela, arrayEtxea, arrayApartamentua);

		// ordenatu filtroa
		if (chckbxmntmErreserbaKopurua.isSelected()) {
			arrayOstatua.get(0).setZbkMota(1);
		}
		if (chckbxmntmAlfabetoa.isSelected()) {
			arrayOstatua.get(0).setZbkMota(2);
		}
		if (chckbxmntmPrezioa.isSelected()) {
			arrayOstatua.get(0).setZbkMota(3);
		}

		// filtro izar kop
		if (chckbxmntmIzar_1.isSelected() || chckbxmntmIzar_2.isSelected() || chckbxmntmIzar_3.isSelected()
				|| chckbxmntmIzar_4.isSelected() || chckbxmntmIzar_5.isSelected()) {
			arrayOstatua = new ArrayList<Ostatua>();
			for (Hotela o : arrayHotela) {
				if (chckbxmntmIzar_1.isSelected() && o.getIzarKop() >= 1)
					arrayOstatua.add(o);

				if (chckbxmntmIzar_2.isSelected() && o.getIzarKop() >= 2)
					arrayOstatua.add(o);

				if (chckbxmntmIzar_3.isSelected() && o.getIzarKop() >= 3)
					arrayOstatua.add(o);

				if (chckbxmntmIzar_4.isSelected() && o.getIzarKop() >= 4)
					arrayOstatua.add(o);

				if (chckbxmntmIzar_5.isSelected() && o.getIzarKop() == 5)
					arrayOstatua.add(o);
			}
		}

		// filtro zerbitzuak
		if (chckbxmntmParkina.isSelected() || chckbxmntmWifi.isSelected() || chckbxmntmIgerileku.isSelected()
				|| chckbxmntmSpa.isSelected() || chckbxmntmAireGirotua.isSelected() || chckbxmntmJatetxea.isSelected()
				|| chckbxmntmTaberna.isSelected() || chckbxmntmGimnasioa.isSelected()) {
			ArrayList<Ostatua> arrayOstAux = new ArrayList<Ostatua>();
			int b = 0;
			for (Ostatua p : arrayOstatua) {
				arrayOstAux.add(p);
			}
			// arrayOstatua = new ArrayList<Ostatua>();
			if (chckbxmntmParkina.isSelected())
				b++;
			if (chckbxmntmWifi.isSelected())
				b++;
			if (chckbxmntmIgerileku.isSelected())
				b++;
			if (chckbxmntmSpa.isSelected())
				b++;
			if (chckbxmntmAireGirotua.isSelected())
				b++;
			if (chckbxmntmJatetxea.isSelected())
				b++;
			if (chckbxmntmTaberna.isSelected())
				b++;
			if (chckbxmntmGimnasioa.isSelected())
				b++;

			for (Ostatua o : arrayOstAux) {
				int a = 0;
				ArrayList<String> arrayZerb = MetodoakKontsultak.filtroZerbitzuGehigarriMet(o);
				for (String zb : arrayZerb) {
					if (chckbxmntmParkina.isSelected() && zb.equals("aparkalekua"))
						a++;
					if (chckbxmntmWifi.isSelected() && zb.equals("wifi"))
						a++;
					if (chckbxmntmIgerileku.isSelected() && zb.equals("igerilekua"))
						a++;
					if (chckbxmntmSpa.isSelected() && zb.equals("spa"))
						a++;
					if (chckbxmntmAireGirotua.isSelected() && zb.equals("aire girotua"))
						a++;
					if (chckbxmntmJatetxea.isSelected() && zb.equals("jatetxea"))
						a++;
					if (chckbxmntmTaberna.isSelected() && zb.equals("taberna"))
						a++;
					if (chckbxmntmGimnasioa.isSelected() && zb.equals("gimnasioa"))
						a++;
				}
				if (a < b)
					arrayOstatua.remove(o);
			}
		}
		
		Collections.sort(arrayOstatua);
		for (Ostatua o : arrayOstatua) {
			ostatuIzen = o.getIzena();
			if (o.getOstatuMota().equals("H")) {
				ostatuMota = "Hotela";
				prezioa = MetodoakKontsultak.hotelarenPrezioaAtera(ostatuIzen) + " €";

			} else if (o.getOstatuMota().equals("E")) {
				ostatuMota = "Etxea";
				prezioa = MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen) + " €";
				o.setPrezioa(MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen));
			} else if (o.getOstatuMota().equals("A")) {
				ostatuMota = "Apartamentua";
				prezioa = MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen) + " €";
				o.setPrezioa(MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen));
			}
			ostatuBerria[0] = ostatuIzen;
			ostatuBerria[1] = ostatuMota;
			ostatuBerria[2] = prezioa;

			modelo.addRow(ostatuBerria);

		}
		mnOstatuMota.setEnabled(true);
		table.setModel(modelo);
		btnBilatu.setVisible(false);

	}
}