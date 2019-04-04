package Ikuspegia;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import java.awt.Component;

public class Leiho2AukeratuOstatu extends JFrame {

	private JPanel contentPane;
	private JTextField textField = new JTextField();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnIzarKopurua = new JMenu("Izar kopurua");
	private JCheckBoxMenuItem chckbxmntmIzar = new JCheckBoxMenuItem("5 Izar");
	private JCheckBoxMenuItem chckbxmntmIzar_1 = new JCheckBoxMenuItem("4 Izar");
	private JCheckBoxMenuItem chckbxmntmIzar_2 = new JCheckBoxMenuItem("3 Izar");
	private JCheckBoxMenuItem chckbxmntmIzar_3 = new JCheckBoxMenuItem("2 Izar");
	private JCheckBoxMenuItem chckbxmntmIzar_4 = new JCheckBoxMenuItem("1 Izar");
	private JMenu mnOstatuMota = new JMenu("Ostatu mota");
	private JCheckBoxMenuItem chckbxmntmHotela = new JCheckBoxMenuItem("Hotela");
	private JCheckBoxMenuItem chckbxmntmApartamentua = new JCheckBoxMenuItem("Apartamentua");
	private JCheckBoxMenuItem chckbxmntmEtxea = new JCheckBoxMenuItem("Etxea");
	private JMenu mnOrdenatu = new JMenu("Ordenatu");
	private JCheckBoxMenuItem chckbxmntmPrezioa = new JCheckBoxMenuItem("Prezioa");
	private JCheckBoxMenuItem chckbxmntmAlfabetoa = new JCheckBoxMenuItem("Alfabetoa");
	private JCheckBoxMenuItem chckbxmntmErreserbaKopurua = new JCheckBoxMenuItem("Erreserba kopurua");
	private JDateChooser dchJoan = new JDateChooser();
	private JDateChooser dchEtorri = new JDateChooser();
	private JButton btnNewButton = new JButton("Bilatu");
	private JList list = new JList();

	public Leiho2AukeratuOstatu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		setJMenuBar(menuBar);
		menuBar.add(mnIzarKopurua);
		mnIzarKopurua.add(chckbxmntmIzar);
		mnIzarKopurua.add(chckbxmntmIzar_1);
		mnIzarKopurua.add(chckbxmntmIzar_2);
		mnIzarKopurua.add(chckbxmntmIzar_3);
		mnIzarKopurua.add(chckbxmntmIzar_4);
		menuBar.add(mnOstatuMota);
		mnOstatuMota.add(chckbxmntmHotela);
		mnOstatuMota.add(chckbxmntmApartamentua);
		mnOstatuMota.add(chckbxmntmEtxea);
		menuBar.add(mnOrdenatu);
		mnOrdenatu.add(chckbxmntmPrezioa);
		mnOrdenatu.add(chckbxmntmAlfabetoa);
		mnOrdenatu.add(chckbxmntmErreserbaKopurua);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Ostatu zerrenda");

		dchJoan.setBounds(230, 30, 113, 20);
		contentPane.add(dchJoan);
		dchJoan.setDate(Date.valueOf(LocalDate.now()));

		dchEtorri.setBounds(353, 30, 118, 20);
		contentPane.add(dchEtorri);
		dchEtorri.setDate(Date.valueOf(LocalDate.now()));

		btnNewButton.setBounds(481, 30, 89, 23);
		contentPane.add(btnNewButton);

		textField.setBounds(24, 30, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		list.setBounds(24, 121, 534, 334);
		contentPane.add(list);
	}
}
