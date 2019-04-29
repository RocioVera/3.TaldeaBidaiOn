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

public class Leiho3OstatuDatuak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblIzena = new JLabel("");
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
			if (column == 4)
				return true;
			return false;
		}
	};
	private JScrollPane scrollPane;
	private ArrayList<gelaMota_ohe_hotela> oheGelaHotela;
	private String ohe_kopuru, sinplea, bikoitza, umeak, prezioa;
	private JComboBox<String> cblibreKant;
	private TableColumn col;
	private double prezioTot;

	private gelaMota_ohe_hotela h2;

	public Leiho3OstatuDatuak(Hotela hartutakoHotela, Date dataSartze, Date dataIrtetze) {
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

				h2 = oheGelaHotela.get(table.getSelectedRow());
				System.out.println(h2.getPrezioa());
				prezioTot = h2.getPrezioa();
				prezioTot = Metodoak.prezioTotalaGauekin(dataSartze, dataIrtetze, prezioTot);

				MetodoakLeihoAldaketa.laugarrenLeihoa(hartutakoHotela, prezioTot, dataSartze, dataIrtetze, h2);
				dispose();
			}
		});
		getContentPane().setLayout(null);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setBackground(Color.LIGHT_GRAY);
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);
		btn_prev.setBounds(38, 508, 99, 32);
		btn_next.setVisible(false);

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
		lblIzena.setBounds(0, 25, 594, 32);

		lblIzena.setText(hartutakoHotela.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		getContentPane().add(lblIzena);

		modelo.addColumn("Prezioa");
		modelo.addColumn("Sinplea");
		modelo.addColumn("Binaka");
		modelo.addColumn("Umeeak");
		modelo.addColumn("Logela libre kantitatea");

		table = new JTable(modelo);
		table.setBounds(1, 1, 537, 0);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setAutoCreateRowSorter(true);

		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(25);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.getTableHeader().setResizingAllowed(false);
		table.setRowHeight(32);
		table.setBackground(Color.LIGHT_GRAY);
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		getContentPane().add(table);

		oheGelaHotela = MetodoakKontsultak.oheGelaHotelaDatuakMet(hartutakoHotela.getHotelKod());
		col = table.getColumnModel().getColumn(4);
        
		for (gelaMota_ohe_hotela h : oheGelaHotela) {
			Object[] aux = new Object[5];
			// lamarmet -1;
			cblibreKant = new JComboBox<String>();
			cblibreKant.addItem("0");
			cblibreKant.addItem("1");
			cblibreKant.addItem("2");
			cblibreKant.setSelectedIndex(0);
		
	        
			col.setCellEditor(new DefaultCellEditor(cblibreKant));
			
			ohe_kopuru = h.getOhe_kopuru() + "";
			sinplea = h.getSinplea() + "";
			bikoitza = h.getBikoitza() + "";
			umeak = h.getUmeak() + "";
			prezioa = h.getPrezioa() + "";
			aux[0] = prezioa;
			aux[1] = sinplea;
			aux[2] = bikoitza;
			aux[3] = umeak;
			modelo.addRow(aux);

		}
		table.setModel(modelo);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRowCount() == 1)
					btn_next.setVisible(true);
			}

		});
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(21, 68, 563, 402);
		scrollPane.setViewportBorder(null);
		getContentPane().add(scrollPane);
		
	}
}
