package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;
import com.toedter.calendar.*;

import Kontrolatzailea.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class Leiho2AukeratuOstatu extends JFrame {
	private static final long serialVersionUID = 1L;

	private JMenuBar menuBar = new JMenuBar();
	// izarkopuru
	private JMenu mnIzarKopurua = new JMenu("       Izar kopurua      ");
	private JCheckBoxMenuItem chckbxmntmIzar_5 = new JCheckBoxMenuItem("5 Izar"),
			chckbxmntmIzar_1 = new JCheckBoxMenuItem("4 Izar"), chckbxmntmIzar_2 = new JCheckBoxMenuItem("3 Izar"),
			chckbxmntmIzar_3 = new JCheckBoxMenuItem("2 Izar"), chckbxmntmIzar_4 = new JCheckBoxMenuItem("1 Izar");
	// ostatu mota
	private JMenu mnOstatuMota = new JMenu("       Ostatu mota      ");
	private JCheckBoxMenuItem chckbxmntmHotela = new JCheckBoxMenuItem("Hotela"),
			chckbxmntmApartamentua = new JCheckBoxMenuItem("Apartamentua"),
			chckbxmntmEtxea = new JCheckBoxMenuItem("Etxea");
	// ordenatu
	private JMenu mnOrdenatu = new JMenu("        Ordenatu       ");
	private JCheckBoxMenuItem chckbxmntmPrezioa = new JCheckBoxMenuItem("Prezioa"),
			chckbxmntmAlfabetoa = new JCheckBoxMenuItem("Alfabetoa"),
			chckbxmntmErreserbaKopurua = new JCheckBoxMenuItem("Erreserba kopurua");

	private JDateChooser dchSartzeData = new JDateChooser(), dchIrtetzeData = new JDateChooser();
	private JTextFieldDateEditor dataEzEditatu; // kentzeko eskuz sartu ahal izana
	private JLabel lblSartzeData = new JLabel("Sartze data"), lblIrtetzeData = new JLabel("Irtetze data");
	private java.util.Date dataIrtetze, dataSartze;
	private JButton btn_next = new JButton("Hurrengoa"), restart = new JButton("\u2302"),
			btnBilatu = new JButton("Bilatu");
	private ArrayList<Hotela> arrayHotela;
	private ArrayList<Etxea> arrayEtxea;
	private ArrayList<Apartamentua> arrayApartamentua;

	private Ostatua hartutakoOstatua;
	private Apartamentua hartutakoApartamentua;

	private DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private String hotelString, ostatuIzen, ostatuMota, prezioa;
	private int hartutakoLerroa;
	private double prezioTot = 0;
	private JComboBox cbHerria;
	private JTable table;
	private JScrollPane scrollPane;
	private String[] hotelaBerria = new String[3], etxeBerria = new String[3], apartamentuBerria = new String[3];

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
				if (modelo.getValueAt(hartutakoLerroa, 1) == "Hotela") {
					hartutakoOstatua = arrayHotela.get(hartutakoLerroa);
					MetodoakLeihoAldaketa.hirugarrenLeihoaHotelak(hartutakoOstatua, dataSartze, dataIrtetze);
					dispose();
				} else if (modelo.getValueAt(hartutakoLerroa, 1) == "Etxea") {
					hartutakoLerroa = hartutakoLerroa-arrayHotela.size();
					hartutakoOstatua = arrayEtxea.get(hartutakoLerroa);
					prezioTot=MetodoakKontsultak.etxearenPrezioaAtera(hartutakoOstatua.getIzena());
					MetodoakLeihoAldaketa.hirugarrenLeihoaEtxeak(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze);
					dispose();
				} else if (modelo.getValueAt(hartutakoLerroa, 1) == "Apartamentua") {
					hartutakoLerroa = hartutakoLerroa-arrayHotela.size()-arrayEtxea.size();
					hartutakoOstatua = arrayApartamentua.get(hartutakoLerroa);
					prezioTot=MetodoakKontsultak.etxearenPrezioaAtera(hartutakoOstatua.getIzena());
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
		mnIzarKopurua.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnIzarKopurua);

		// 1
		mnIzarKopurua.add(chckbxmntmIzar_1);
		chckbxmntmIzar_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 2
		mnIzarKopurua.add(chckbxmntmIzar_2);
		chckbxmntmIzar_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 3
		mnIzarKopurua.add(chckbxmntmIzar_3);
		chckbxmntmIzar_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 4
		mnIzarKopurua.add(chckbxmntmIzar_4);
		chckbxmntmIzar_4.setFont(new Font("Verdana", Font.PLAIN, 16));
		// 5
		mnIzarKopurua.add(chckbxmntmIzar_5);
		chckbxmntmIzar_5.setFont(new Font("Verdana", Font.PLAIN, 16));

		// ostatu mota
		mnOstatuMota.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnOstatuMota);
		mnOstatuMota.add(chckbxmntmHotela);

		chckbxmntmHotela.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.add(chckbxmntmApartamentua);
		chckbxmntmApartamentua.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOstatuMota.add(chckbxmntmEtxea);
		chckbxmntmEtxea.setFont(new Font("Verdana", Font.PLAIN, 16));

		// ordenatzeko modua
		mnOrdenatu.setFont(new Font("Verdana", Font.PLAIN, 16));
		menuBar.add(mnOrdenatu);
		mnOrdenatu.add(chckbxmntmPrezioa);
		chckbxmntmPrezioa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmAlfabetoa);
		chckbxmntmAlfabetoa.setFont(new Font("Verdana", Font.PLAIN, 16));
		mnOrdenatu.add(chckbxmntmErreserbaKopurua);
		chckbxmntmErreserbaKopurua.setFont(new Font("Verdana", Font.PLAIN, 16));

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

		table = new JTable(modelo);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Verdana", Font.PLAIN, 14));

		// tabla datuak

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
				table.setVisible(true);
				// ematerakoan 0 tik hasteko
				for (int i = modelo.getRowCount() - 1; i >= 0; i--)
					modelo.removeRow(i);
				dataSartze = dchSartzeData.getDate();
				dataIrtetze = dchIrtetzeData.getDate();

				// hotelak gehitu
				arrayHotela = MetodoakKontsultak.hotelakAtera((String) cbHerria.getSelectedItem(), dataSartze,
						dataIrtetze);
				for (Hotela h : arrayHotela) {
					ostatuIzen = ((Hotela) h).getIzena();
					ostatuMota = "Hotela";
					prezioa = MetodoakKontsultak.hotelarenPrezioaAtera(ostatuIzen) + " €";
					hotelaBerria[0] = ostatuIzen;
					hotelaBerria[1] = ostatuMota;
					hotelaBerria[2] = prezioa;
					modelo.addRow(hotelaBerria);

				}
				// etxeak gehitu
				arrayEtxea = MetodoakKontsultak.etxeakAtera((String) cbHerria.getSelectedItem(), dataIrtetze,
						dataIrtetze);
				for (Etxea e1 : arrayEtxea) {
					ostatuIzen = e1.getIzena();
					ostatuMota = "Etxea";
					prezioa = MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen) + " €";
					etxeBerria[0] = ostatuIzen;
					etxeBerria[1] = ostatuMota;
					etxeBerria[2] = prezioa;
					modelo.addRow(etxeBerria);
				}

				table.setModel(modelo);
				btnBilatu.setVisible(false);

				// apartamentuak gehitu
				arrayApartamentua = MetodoakKontsultak.apartamentuakAtera((String) cbHerria.getSelectedItem(),
						dataIrtetze, dataIrtetze);
				for (Apartamentua a : arrayApartamentua) {
					ostatuIzen = a.getIzena();
					ostatuMota = "Apartamentua";
					prezioa = MetodoakKontsultak.etxearenPrezioaAtera(ostatuIzen) + " €";
					apartamentuBerria[0] = ostatuIzen;
					apartamentuBerria[1] = ostatuMota;
					apartamentuBerria[2] = prezioa;
					modelo.addRow(apartamentuBerria);
				}

				table.setModel(modelo);
				btnBilatu.setVisible(false);

			}
		});

		// herria bilatzeko botoia
		btnBilatu.setBounds(471, 56, 97, 25);
		btnBilatu.setVisible(false);
		getContentPane().add(btnBilatu);

	}
}
