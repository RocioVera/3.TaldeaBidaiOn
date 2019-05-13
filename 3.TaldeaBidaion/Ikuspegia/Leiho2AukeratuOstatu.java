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
	// panelaren bariableak
	private JMenuBar menuBar = new JMenuBar();

	// ostatu mota
	private JMenu mnOstatuMota = new JMenu("       Ostatu mota        ");
	private JRadioButton chckbxmntmHotela = new JRadioButton("Hotela"),
			chckbxmntmApartamentua = new JRadioButton("Apartamentua       "),
			chckbxmntmEtxea = new JRadioButton("Etxea");
	// ordenatu
	private JMenu mnOrdenatu = new JMenu("        Ordenatu            ");
	private JRadioButton chckbxmntmPrezioa = new JRadioButton("Prezioa"),
			chckbxmntmAlfabetoa = new JRadioButton("Alfabetoa"),
			chckbxmntmErreserbaKopurua = new JRadioButton("Erreserba kopurua  "),
			chckbxmntmIzar_5 = new JRadioButton("  5 Izar"), chckbxmntmIzar_1 = new JRadioButton("  4 Izar"),
			chckbxmntmIzar_2 = new JRadioButton("  3 Izar"), chckbxmntmIzar_3 = new JRadioButton("  2 Izar"),
			chckbxmntmIzar_4 = new JRadioButton("  1 Izar             ");
	// zerbitzuak
	private JMenu mnZerbitzuak = new JMenu("        Zerbitzuak            ");
	private JRadioButton chckbxmntmParkina = new JRadioButton("Parkina            ");
	// taldeak
	private ButtonGroup zerbitzuakGroup, ostatuMotaGroup, ordenatuGroup;

	private JDateChooser dchSartzeData = new JDateChooser(), dchIrtetzeData = new JDateChooser();
	private JTextFieldDateEditor dataEzEditatu; // kentzeko eskuz sartu ahal izana
	private JLabel lblSartzeData = new JLabel("Sartze data"), lblIrtetzeData = new JLabel("Irtetze data"), lblGogoratu;
	private java.util.Date dataIrtetze, dataSartze;
	private JButton btn_next = new JButton("Hurrengoa"), restart = new JButton("\u2302"),
			btnBilatu = new JButton("Bilatu");
	private JComboBox cbHerria;
	private static JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row,int column){return false;}};

	// bariableak
	private ArrayList<Hotela> arrayHotela;
	private ArrayList<Etxea> arrayEtxea;
	private ArrayList<Apartamentua> arrayApartamentua;
	private ArrayList<Ostatua> arrayOstatua;

	private Ostatua hartutakoOstatua;
	private Apartamentua hartutakoApartamentua;

	private String hotelString, ostatuIzen, ostatuMota, prezioa;
	private int hartutakoLerroa;
	private double prezioTot = 0;

	private String[] hotelaBerria = new String[3], etxeBerria = new String[3], apartamentuBerria = new String[3],
			ostatuBerria = new String[3];

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
		zerbitzuakGroup = new ButtonGroup();
		ostatuMotaGroup.clearSelection();

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
				
				chckbxmntmIzar_1.setEnabled(true);
				chckbxmntmIzar_2.setEnabled(true);
				chckbxmntmIzar_3.setEnabled(true);
				chckbxmntmIzar_4.setEnabled(true);
				chckbxmntmIzar_5.setEnabled(true);
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

				chckbxmntmIzar_1.setEnabled(false);
				chckbxmntmIzar_2.setEnabled(false);
				chckbxmntmIzar_3.setEnabled(false);
				chckbxmntmIzar_4.setEnabled(false);
				chckbxmntmIzar_5.setEnabled(false);
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
				
				chckbxmntmIzar_1.setEnabled(false);
				chckbxmntmIzar_2.setEnabled(false);
				chckbxmntmIzar_3.setEnabled(false);
				chckbxmntmIzar_4.setEnabled(false);
				chckbxmntmIzar_5.setEnabled(false);

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
			}
		});
		chckbxmntmPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmPrezioa);

		chckbxmntmAlfabetoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmAlfabetoa);
			}
		});
		chckbxmntmAlfabetoa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmAlfabetoa);

		chckbxmntmErreserbaKopurua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmErreserbaKopurua);
			}
		});
		chckbxmntmErreserbaKopurua.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmErreserbaKopurua);


		// 1
		chckbxmntmIzar_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_1);
			}
		});
		chckbxmntmIzar_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		chckbxmntmIzar_1.setEnabled(false);
		mnOrdenatu.add(chckbxmntmIzar_1);

		// 2
		chckbxmntmIzar_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_2);
			}
		});
		chckbxmntmIzar_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		chckbxmntmIzar_2.setEnabled(false);
		mnOrdenatu.add(chckbxmntmIzar_2);

		// 3
		chckbxmntmIzar_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_3);
			}
		});
		chckbxmntmIzar_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		chckbxmntmIzar_3.setEnabled(false);
		mnOrdenatu.add(chckbxmntmIzar_3);

		// 4
		chckbxmntmIzar_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_4);
			}
		});
		chckbxmntmIzar_4.setFont(new Font("Verdana", Font.PLAIN, 16));
		chckbxmntmIzar_4.setEnabled(false);
		mnOrdenatu.add(chckbxmntmIzar_4);

		// 5
		chckbxmntmIzar_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ordenatuGroup.add(chckbxmntmIzar_5);
			}
		});
		chckbxmntmIzar_5.setFont(new Font("Verdana", Font.PLAIN, 16));
		chckbxmntmIzar_5.setEnabled(false);
		mnOrdenatu.add(chckbxmntmIzar_5);

		
		// zerbitzuak
		mnZerbitzuak.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.setEnabled(false);
		menuBar.add(mnZerbitzuak);

		chckbxmntmParkina.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zerbitzuakGroup.add(chckbxmntmParkina);
				btnBilatu.setVisible(true);
				btn_next.setVisible(false);
				datuakBerritu();

			}
		});
		chckbxmntmParkina.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnZerbitzuak.add(chckbxmntmParkina);
		
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
		for (String herria : MetodoakKontsultak.hotelHerria())
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
				}
			}
			if (chckbxmntmEtxea.isSelected()) {
				for (Etxea a : arrayEtxea) {
					arrayOstatua.add(a);
				}

			}
			if (chckbxmntmHotela.isSelected()) {
				for (Hotela h : arrayHotela) {
					arrayOstatua.add(h);
				}
			}

		} else
			arrayOstatua = Metodoak.ostatuakSortu(arrayHotela, arrayEtxea, arrayApartamentua);

		/************************************************ ORDENA MAL */
		// ordenatu filtroa
		if (chckbxmntmErreserbaKopurua.isSelected()) {
			ArrayList<Ostatua> arrayOstatuaAux = new ArrayList<Ostatua>();
			for (int i = 0; i < arrayOstatua.size(); i++) {
				for (int j = 0; j < arrayOstatua.size() - 1; j++) {
					if (arrayOstatua.get(j).getErreserbaKop() < arrayOstatua.get(j + 1).getErreserbaKop()) {
						arrayOstatuaAux.add(arrayOstatua.get(j));
						// aldatu bakoitza
						arrayOstatuaAux.get(j).setErreserbaKop(arrayOstatua.get(j).getErreserbaKop());
						arrayOstatuaAux.get(j).setGelaKop(arrayOstatua.get(j).getGelaKop());
						arrayOstatuaAux.get(j).setHelbidea(arrayOstatua.get(j).getHelbidea());
						arrayOstatuaAux.get(j).setHerria(arrayOstatua.get(j).getHerria());
						arrayOstatuaAux.get(j).setIzena(arrayOstatua.get(j).getIzena());
						arrayOstatuaAux.get(j).setOstatuKod(arrayOstatua.get(j).getOstatuKod());
						arrayOstatuaAux.get(j).setOstatuMota(arrayOstatua.get(j).getOstatuMota());
						arrayOstatuaAux.get(j).setPostKod(arrayOstatua.get(j).getPostKod());

						System.out.println(j + "" + arrayOstatuaAux.get(j));
						arrayOstatua.get(j).setErreserbaKop(arrayOstatua.get(j + 1).getErreserbaKop());
						arrayOstatua.get(j).setGelaKop(arrayOstatua.get(j + 1).getGelaKop());
						arrayOstatua.get(j).setHelbidea(arrayOstatua.get(j + 1).getHelbidea());
						arrayOstatua.get(j).setHerria(arrayOstatua.get(j + 1).getHerria());
						arrayOstatua.get(j).setIzena(arrayOstatua.get(j + 1).getIzena());
						arrayOstatua.get(j).setOstatuKod(arrayOstatua.get(j + 1).getOstatuKod());
						arrayOstatua.get(j).setOstatuMota(arrayOstatua.get(j + 1).getOstatuMota());
						arrayOstatua.get(j).setPostKod(arrayOstatua.get(j + 1).getPostKod());

						arrayOstatua.get(j + 1).setErreserbaKop(arrayOstatuaAux.get(j).getErreserbaKop());
						arrayOstatua.get(j + 1).setGelaKop(arrayOstatuaAux.get(j).getGelaKop());
						arrayOstatua.get(j + 1).setHelbidea(arrayOstatuaAux.get(j).getHelbidea());
						arrayOstatua.get(j + 1).setHerria(arrayOstatuaAux.get(j).getHerria());
						arrayOstatua.get(j + 1).setIzena(arrayOstatuaAux.get(j).getIzena());
						arrayOstatua.get(j + 1).setOstatuKod(arrayOstatuaAux.get(j).getOstatuKod());
						arrayOstatua.get(j + 1).setOstatuMota(arrayOstatuaAux.get(j).getOstatuMota());
						arrayOstatua.get(j + 1).setPostKod(arrayOstatuaAux.get(j).getPostKod());

						// arrayOstatua.get(j +
						// 1).setErreserbaKop(arrayOstatua.get(j).getErreserbaKop());

						// arrayOstatua.get(j).setErreserbaKop(tmp);

					}
				}
			}
		}
		if (chckbxmntmAlfabetoa.isSelected()) {
			/*
			 * for (Ostatua o : arrayOstatua) { Collections.sort(o.getIzena()); }
			 */
		}
		if (chckbxmntmPrezioa.isSelected()) {

		}
		
		if (chckbxmntmIzar_1.isSelected()) {

		}
		
		if (chckbxmntmIzar_2.isSelected()) {

		}
		
		if (chckbxmntmIzar_3.isSelected()) {

		}
		
		if (chckbxmntmIzar_4.isSelected()) {

		}
		
		if (chckbxmntmIzar_5.isSelected()) {

		}

		for (Ostatua o : arrayOstatua) {
			ostatuIzen = o.getIzena();
			if (o.getOstatuMota().equals("H")) {
				ostatuMota = "Hotela";
				prezioa = MetodoakKontsultak.hotelarenPrezioaAtera(ostatuIzen) + " €";
			} else if (o.getOstatuMota().equals("E")) {
				ostatuMota = "Etxea";
				prezioa = MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen) + " €";
			} else if (o.getOstatuMota().equals("A")) {
				ostatuMota = "Apartamentua";
				prezioa = MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen) + " €";
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