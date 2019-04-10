package Ikuspegia;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Kontrolatzailea.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Leiho3OstatuDatuak extends JFrame {
	private JLabel lblIzena = new JLabel("");
	private JButton btn_next = new JButton("Hurrengoa"), btn_prev = new JButton("Atzera"),
			restart = new JButton("\u2302");
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JScrollPane scrollPane;

	public Leiho3OstatuDatuak(String hartutakoHotela, double prezioTot, String sartzeData, String irtetzeData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen ostatu zerbitzuen bilatzailea");
		btn_next.setBounds(423, 508, 122, 32);


		// botoiak
		btn_next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.laugarrenLeihoa(hartutakoHotela, prezioTot, sartzeData, irtetzeData);
				dispose();
			}
		});
		getContentPane().setLayout(null);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setBackground(Color.LIGHT_GRAY);
		btn_next.setForeground(Color.RED);
		getContentPane().add(btn_next);
		btn_prev.setBounds(38, 508, 99, 32);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Metodoak.bigarrenLeihoa();
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
				Metodoak.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setForeground(Color.RED);
		restart.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(restart);
		lblIzena.setBounds(0, 25, 594, 32);
		
		lblIzena.setText(hartutakoHotela);
		lblIzena.setHorizontalAlignment(SwingConstants.CENTER);
		lblIzena.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		getContentPane().add(lblIzena);
		
		modelo.addColumn("Logela");
		modelo.addColumn("Prezioa");
		modelo.addColumn("Ohe Mota");
		modelo.addColumn("Kopurua");

		table = new JTable(modelo);
		table.setBounds(1, 1, 537, 0);
		table.setShowVerticalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		table.setRowHeight(32);
		table.setBackground(Color.LIGHT_GRAY);
		table.getTableHeader().setReorderingAllowed(false);
		getContentPane().add(table);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override 
		    public void valueChanged(ListSelectionEvent e) { 
				if ( table.getSelectedRowCount()==1)
					btn_next.setVisible(true);
			} 

		});

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 145, 539, 293);
		scrollPane.setViewportBorder(null);
		getContentPane().add(scrollPane);
		
		JLabel lblLogela = new JLabel("Logela:");
		lblLogela.setBounds(57, 120, 46, 14);
		getContentPane().add(lblLogela);
		
		JLabel lblPrezioa = new JLabel("Prezioa:");
		lblPrezioa.setBounds(189, 120, 46, 14);
		getContentPane().add(lblPrezioa);
		
		JLabel lblOheMota = new JLabel("Ohe Mota:");
		lblOheMota.setBounds(328, 120, 63, 14);
		getContentPane().add(lblOheMota);
		
		JLabel lblKopurua = new JLabel("Kopurua:");
		lblKopurua.setBounds(468, 120, 46, 14);
		getContentPane().add(lblKopurua);
	}
}
