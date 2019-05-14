package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Kontrolatzailea.*;
import javax.swing.*;

public class Leiho4ZerbitzuGehigarriak extends JFrame {
	private JTextField txtPrezioa, txtLogelak;
	private JLabel lblIzena = new JLabel(""), lblLogelak = new JLabel("Logelak:");
	private JLabel lblPrezioa = new JLabel("Prezioa:");
	private JLabel lblPentsioa = new JLabel("Pentsioa:"), lblZerbitzuak = new JLabel("Zerbitzu gehigarriak:");
	private JComboBox cboxPentsioa = new JComboBox();
	private JCheckBox chckbxGozaria = new JCheckBox("Gosaria"), chckbxWifi = new JCheckBox("Wifi"),
			chckbxIgerilekua = new JCheckBox("Igerilekua"), chckbxSpa = new JCheckBox("Spa"),
			chckbxParking = new JCheckBox("Parking"), chckbxAireGirotua = new JCheckBox("Aire girotua"),
			chckbxJatetxea = new JCheckBox("Jatetxea"), chckbxTaberna = new JCheckBox("Taberna"),
			chckbxGimnasioa = new JCheckBox("Gimnasioa");
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");
	private ArrayList<HartutakoOstatuarenZerbitzuak> zerbitzuArray = new ArrayList<HartutakoOstatuarenZerbitzuak>();
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel() {
		public boolean isCellEditable(int row,int column){return false;}};
	private String[] array = new String[1];

	public Leiho4ZerbitzuGehigarriak(Ostatua hartutakoOstatua, double prezioTot, Date dataSartze, Date dataIrtetze,
			int logelaTot, int pertsonaKop) {
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
				MetodoakLeihoAldaketa.bostgarrenLeihoa(hartutakoOstatua, prezioTot, dataSartze, dataIrtetze, logelaTot,
						pertsonaKop, cboxPentsioa.getSelectedItem() + "");
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

		lblPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrezioa.setBounds(210, 72, 63, 14);
		getContentPane().add(lblPrezioa);

		txtPrezioa = new JTextField();
		txtPrezioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPrezioa.setText(prezioTot + " €");
		txtPrezioa.setEditable(false);
		txtPrezioa.setBounds(274, 70, 136, 20);
		txtPrezioa.setColumns(10);
		getContentPane().add(txtPrezioa);

		lblLogelak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogelak.setBounds(210, 114, 72, 25);
		if (!hartutakoOstatua.getOstatuMota().equals("H"))
			lblLogelak.setVisible(false);
		getContentPane().add(lblLogelak);

		txtLogelak = new JTextField();
		txtLogelak.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLogelak.setEditable(false);
		txtLogelak.setText(logelaTot + "");
		txtLogelak.setBounds(285, 116, 32, 20);
		txtLogelak.setColumns(10);
		if (!hartutakoOstatua.getOstatuMota().equals("H"))
			txtLogelak.setVisible(false);
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

		chckbxGozaria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxGozaria.setBounds(245, 212, 97, 23);
		getContentPane().add(chckbxGozaria);

		lblZerbitzuak.setFont(new Font("Verdana", Font.BOLD, 16));
		lblZerbitzuak.setBounds(62, 263, 230, 25);
		getContentPane().add(lblZerbitzuak);

		// gehigarriak
		/*
		 * chckbxWifi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxWifi.setBounds(299, 359, 97, 23); chckbxWifi.setVisible(false);
		 * getContentPane().add(chckbxWifi);
		 * 
		 * chckbxIgerilekua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxIgerilekua.setBounds(367, 410, 97, 23);
		 * chckbxIgerilekua.setVisible(false); getContentPane().add(chckbxIgerilekua);
		 * 
		 * chckbxSpa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxSpa.setBounds(210, 410, 97, 23); chckbxSpa.setVisible(false);
		 * getContentPane().add(chckbxSpa);
		 * 
		 * chckbxParking.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxParking.setBounds(111, 307, 97, 23); chckbxParking.setVisible(false);
		 * getContentPane().add(chckbxParking);
		 * 
		 * chckbxAireGirotua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxAireGirotua.setBounds(299, 307, 133, 23);
		 * chckbxAireGirotua.setVisible(false); getContentPane().add(chckbxAireGirotua);
		 * 
		 * chckbxJatetxea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxJatetxea.setBounds(468, 307, 97, 23); chckbxJatetxea.setVisible(false);
		 * getContentPane().add(chckbxJatetxea);
		 * 
		 * chckbxTaberna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxTaberna.setBounds(468, 359, 97, 23); chckbxTaberna.setVisible(false);
		 * getContentPane().add(chckbxTaberna);
		 * 
		 * chckbxGimnasioa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 * chckbxGimnasioa.setBounds(111, 359, 97, 23);
		 * chckbxGimnasioa.setVisible(false); getContentPane().add(chckbxGimnasioa);
		 */

		zerbitzuArray = MetodoakKontsultak.zerbitzuakOstatuanMet(hartutakoOstatua);
		
		modelo.addColumn("Prezio (€/gaua):");

		// tabla datuak
		table = new JTable(modelo);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getTableHeader().setResizingAllowed(false);
		table.setRowHeight(32);
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(24, 152, 544, 42);
		table.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 15));
		table.getTableHeader().setReorderingAllowed(false);
		getContentPane().add(table);

		for (HartutakoOstatuarenZerbitzuak zerb : zerbitzuArray) {
			if (zerb.getIzena().equals("wifi"))
				array[1] = "wifi";
				modelo.addRow(array);
			if (zerb.getIzena().equals("igerilekua"))
				modeloa.addElement("igerilekua");
			if (zerb.getIzena().equals("spa"))
				modeloa.addElement("spa");
			if (zerb.getIzena().equals("aparkalekua"))
				modeloa.addElement("aparkalekua");
			if (zerb.getIzena().equals("aire girotua"))
				modeloa.addElement("aire girotua");
			if (zerb.getIzena().equals("jatetxea"))
				modeloa.addElement("jatetxea");
			if (zerb.getIzena().equals("taberna"))
				modeloa.addElement("taberna");
			if (zerb.getIzena().equals("gimnasioa"))
				modeloa.addElement("gimnasioa");
		}
		//zerbLista.getSelectionModel().addSelectionInterval(index0, index1);
		
		zerbLista.setBounds(62, 299, 508, 179);
		
		getContentPane().add(zerbLista);

	}
}
