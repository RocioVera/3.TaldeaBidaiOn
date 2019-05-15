package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Kontrolatzailea.*;
import javax.swing.*;

public class Leiho4ZerbitzuGehigarriak extends JFrame {
	// panelan ikusten diren bariableak
	private JTextField txtPrezioa, txtLogelak;
	private JLabel lblIzena = new JLabel(""), lblLogelak = new JLabel("Logelak:"), lblPrezioa = new JLabel("Prezioa:"),
			lblPentsioa = new JLabel("Pentsioa:"), lblZerbitzuak = new JLabel("Zerbitzu gehigarriak:");

	private JComboBox cboxPentsioa = new JComboBox();
	private JCheckBox chckbxGosaria = new JCheckBox("Gosaria");

	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");

	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	private JScrollPane scrollPane;

	// bariableak
	private ArrayList<HartutakoOstatuarenZerbitzuak> zerbitzuArray = new ArrayList<HartutakoOstatuarenZerbitzuak>(), hartutakoZerbitzuArray = new ArrayList<HartutakoOstatuarenZerbitzuak>();
	private String[] array = new String[3];
	private double prezioTot2;
	private int i = 0;

	/**
	 * Zerbitzu gehigarri datuak agertzen den panela sortu
	 * 
	 * @author talde3
	 * @param hartutakoOstatua
	 * @param prezioTot
	 * @param dataSartze
	 * @param dataIrtetze
	 * @param logelaTot
	 * @param pertsonaKop
	 */
	public Leiho4ZerbitzuGehigarriak(Ostatua hartutakoOstatua, double prezioTot, Date dataSartze, Date dataIrtetze,
			int logelaTot, int pertsonaKop) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");
		prezioTot2 = prezioTot;
		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
				MetodoakLeihoAldaketa.bostgarrenLeihoa(hartutakoOstatua, prezioTot2, dataSartze, dataIrtetze, logelaTot,
						pertsonaKop, cboxPentsioa.getSelectedItem() + "", zerbitzuArray);
				
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
				// System.out.println(hartutakoOstatua.getOstatuMota());
				if (hartutakoOstatua.getOstatuMota().equals("H"))
					MetodoakLeihoAldaketa.hirugarrenLeihoaHotelak(hartutakoOstatua, dataSartze, dataIrtetze);
				else
					MetodoakLeihoAldaketa.hirugarrenLeihoaEtxeak(hartutakoOstatua, prezioTot, dataIrtetze, dataIrtetze);
				dispose();
			}
		});
		btn_prev.setBounds(38, 508, 107, 32);
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

		// panela
		lblIzena.setText(hartutakoOstatua.getIzena());
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 21));
		lblIzena.setBounds(0, 13, 594, 32);
		getContentPane().add(lblIzena);

		lblLogelak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogelak.setBounds(210, 114, 72, 25);
		getContentPane().add(lblLogelak);

		txtLogelak = new JTextField();
		txtLogelak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogelak.setEditable(false);
		txtLogelak.setText(logelaTot + "");
		txtLogelak.setBounds(285, 116, 32, 20);
		txtLogelak.setColumns(10);
		getContentPane().add(txtLogelak);

		lblPentsioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPentsioa.setBounds(210, 165, 72, 14);
		if (!hartutakoOstatua.getOstatuMota().equals("H"))
			lblPentsioa.setVisible(false);
		getContentPane().add(lblPentsioa);

		cboxPentsioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboxPentsioa.addItem("Ez");
		cboxPentsioa.addItem("erdia");
		cboxPentsioa.addItem("osoa");
		cboxPentsioa.setBounds(285, 162, 111, 20);
		getContentPane().add(cboxPentsioa);
		if (!hartutakoOstatua.getOstatuMota().equals("H"))
			cboxPentsioa.setVisible(false);

		chckbxGosaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxGosaria.setBounds(245, 201, 97, 23);
		chckbxGosaria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int gauak = (int) ((dataIrtetze.getTime() - dataSartze.getTime()) / 86400000);
				double gosariPrezioa = 3 * gauak;
				if (chckbxGosaria.isSelected())
					prezioTot2 = prezioTot2 + gosariPrezioa;
				else
					prezioTot2 = prezioTot2 - gosariPrezioa;
				txtPrezioa.setText(prezioTot2 + " €");
			}
		});
		getContentPane().add(chckbxGosaria);

		lblZerbitzuak.setFont(new Font("Verdana", Font.BOLD, 16));
		lblZerbitzuak.setBounds(51, 244, 230, 25);
		getContentPane().add(lblZerbitzuak);

		// gehigarriak
		zerbitzuArray = MetodoakKontsultak.zerbitzuakOstatuanMet(hartutakoOstatua);

		modelo.addColumn("Izena:");
		modelo.addColumn("Prezio gehigarria:");
		modelo.addColumn("Hartuta:");

		// tabla datuak
		table = new JTable(modelo);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Verdana", Font.PLAIN, 14));

		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowHeight(32);
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(24, 152, 544, 42);
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		getContentPane().add(table);

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.getClickCount() == 1) {
					i = 1;
					if (table.getValueAt(table.getSelectedRow(), 2).equals("Ez"))
						i = 1;
					else
						i = 2;
					System.out.println(zerbitzuArray.get(table.getSelectedRow()).getKodZerbitzua()+"aaa");
					if (i == 1) {
						table.setValueAt("Bai", table.getSelectedRow(), 2);
						prezioTot2 = prezioTot2 + zerbitzuArray.get(table.getSelectedRow()).getPrezioa();
						zerbitzuArray.get(table.getSelectedRow()).setHartuta("Bai");
					}
					if (i == 2) {
						table.setValueAt("Ez", table.getSelectedRow(), 2);
						prezioTot2 = prezioTot2 - zerbitzuArray.get(table.getSelectedRow()).getPrezioa();
						zerbitzuArray.get(table.getSelectedRow()).setHartuta("Ez");
					}
					txtPrezioa.setText(prezioTot2 + " €");
					System.out.println(i);
				}
			}
		});

		scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(20, 282, 562, 188);

		getContentPane().add(scrollPane);

		for (HartutakoOstatuarenZerbitzuak zerb : zerbitzuArray) {
			array[0] = zerb.getIzena();
			array[1] = zerb.getPrezioa() + " €";
			array[2] = "Ez";
			modelo.addRow(array);
		}
		table.setModel(modelo);

		lblPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrezioa.setBounds(210, 72, 63, 14);
		getContentPane().add(lblPrezioa);

		txtPrezioa = new JTextField();
		txtPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrezioa.setText(prezioTot2 + " €");
		txtPrezioa.setEditable(false);
		txtPrezioa.setBounds(274, 70, 136, 20);
		txtPrezioa.setColumns(10);
		getContentPane().add(txtPrezioa);

	}
}
