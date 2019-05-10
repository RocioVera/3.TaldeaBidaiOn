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

public class Leiho3HotelDatuak extends JFrame {
	public static gelaMota_ohe_ostatu h2;
	private static final long serialVersionUID = 1L;
	private JLabel lblIzena = new JLabel(""),
			lblJarriNahiLogela = new JLabel("Jarri nahi logela mota honen nahi dituzun logela kantitatea"),
			lblPrezioa = new JLabel("Prezioa:");
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302"), btnGehitu = new JButton("Gehitu");
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel() {
		private static final long serialVersionUID = 1L;

		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollPane;
	private JTextField txtPrezioa;
	private JComboBox<Integer> cblibreKant = new JComboBox();;

	private ArrayList<gelaMota_ohe_ostatu> oheGelaHotela;
	private String ohe_kopuru, sinplea, bikoitza, umeak, prezioa;
	private double prezioTot = 0.00;
	private int gelaLibreak, logelaKant, lehenengoAldia, logelaTot, pertsonaKop,sinpleKop,umeKop,bikoitzaKop;

	public Leiho3HotelDatuak(Ostatua hartutakoOstatua, java.util.Date dataSartze, java.util.Date dataIrtetze) {
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
				for (int i = 0; i < oheGelaHotela.size(); i++) {
					logelaTot = logelaTot + (int) table.getValueAt(i, 4);
					sinpleKop+=oheGelaHotela.get(i).getSinplea()*(int) table.getValueAt(i, 4);
					bikoitzaKop+=oheGelaHotela.get(i).getBikoitza()*(int) table.getValueAt(i, 4)*2;
					umeKop +=oheGelaHotela.get(i).getUmeak()*(int) table.getValueAt(i, 4);
				}

				prezioTot = Metodoak.prezioTotalaGauekin(dataSartze, dataIrtetze, prezioTot);
				prezioTot = prezioTot + MetodoakKontsultak.tarifaAldatuDatengatik(dataSartze, dataIrtetze) * logelaTot;
				pertsonaKop=sinpleKop+bikoitzaKop+umeKop;
				
				MetodoakLeihoAldaketa.laugarrenLeihoa(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze, logelaTot,pertsonaKop);
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

		lblIzena.setText(hartutakoOstatua.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		getContentPane().add(lblIzena);

		modelo.addColumn("Prezioa");
		modelo.addColumn("Sinplea");
		modelo.addColumn("Binaka");
		modelo.addColumn("Umeak");
		modelo.addColumn("Hartutako logelak");

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

		oheGelaHotela = MetodoakKontsultak.oheGelaHotelaDatuakMet(hartutakoOstatua.getOstatuKod());

		for (gelaMota_ohe_ostatu h : oheGelaHotela) {

			Object[] aux = new Object[5];

			ohe_kopuru = h.getOhe_kopuru() + "";
			sinplea = h.getSinplea() + "";
			bikoitza = h.getBikoitza() + "";
			umeak = h.getUmeak() + "";
			prezioa = h.getPrezioa() + "";
			aux[0] = prezioa;
			aux[1] = sinplea;
			aux[2] = bikoitza;
			aux[3] = umeak;
			aux[4] = 0;
			modelo.addRow(aux);

		}
		table.setModel(modelo);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (table.getSelectedRowCount() == 1) {

					// vaciar
					for (int i = cblibreKant.getItemCount() - 1; i >= 0; i--) {
						cblibreKant.removeItemAt(i);
					}

					gelaMota_ohe_ostatu a = oheGelaHotela.get(table.getSelectedRow());

					gelaLibreak = MetodoakKontsultak.gelaLibre(hartutakoOstatua, dataSartze, dataIrtetze,
							a.getGela_kodea());

					// llenar
					for (int i = 0; i <= gelaLibreak; i++) {
						cblibreKant.addItem(i);
					}
					cblibreKant.setVisible(true);
					lblJarriNahiLogela.setVisible(true);
					btnGehitu.setVisible(true);

					logelaKant = (int) table.getValueAt(table.getSelectedRow(), 4);
					// poner en el combobox lo que hay en la tabla
					cblibreKant.setSelectedIndex(logelaKant);
				}
			}

		});
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 68, 553, 246);
		scrollPane.setViewportBorder(null);
		getContentPane().add(scrollPane);

		cblibreKant.setBounds(256, 412, 51, 20);
		cblibreKant.setVisible(false);
		getContentPane().add(cblibreKant);

		lblJarriNahiLogela.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJarriNahiLogela.setBounds(79, 368, 451, 31);
		lblJarriNahiLogela.setVisible(false);
		getContentPane().add(lblJarriNahiLogela);

		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// precio no hace bien ********************
			//	if (lehenengoAldia == 0)
					table.setValueAt(cblibreKant.getSelectedIndex(), table.getSelectedRow(), 4);

				prezioTot = 0;
				for (int i = 0; i < table.getRowCount(); i++) {
					prezioTot = prezioTot + oheGelaHotela.get(i).getPrezioa() * (int) table.getValueAt(i, 4);
				}


				// btn_next
				if (prezioTot != 0)
					btn_next.setVisible(true);
				else
					btn_next.setVisible(false);

				txtPrezioa.setText(prezioTot + " €");

				lehenengoAldia++;

			}
		});
		btnGehitu.setBounds(245, 445, 72, 25);
		btnGehitu.setVisible(false);
		getContentPane().add(btnGehitu);

		txtPrezioa = new JTextField();
		txtPrezioa.setEditable(false);
		txtPrezioa.setBounds(307, 335, 99, 22);
		txtPrezioa.setColumns(10);
		txtPrezioa.setText(prezioTot + " €");
		getContentPane().add(txtPrezioa);

		lblPrezioa.setBounds(245, 338, 63, 14);
		getContentPane().add(lblPrezioa);

	}
}
