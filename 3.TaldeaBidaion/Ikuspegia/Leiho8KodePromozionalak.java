package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Leiho8KodePromozionalak extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// panelan ikusten diren bariableak
	private JButton btnErregistratuNahi = new JButton("Erregistratu"),
			restart = new JButton("\u2302"), btn_next = new JButton("Ordaindu");
	private JLabel lblKodePromozionalikBadaukazu = new JLabel("Kode promozionalik dauzkazu?"), lblSartu = new JLabel("Aukeratu ezazu kodea:");;
	private JComboBox comboBox = new JComboBox();
	
	// bariableak
	private ArrayList<Promozioa> promArray = new ArrayList<Promozioa>();
	
	public Leiho8KodePromozionalak(Ostatua hartutakoOstatua, java.util.Date sartzeData,
			java.util.Date irtetzeData, Erreserba erreserba) {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Promozioa promHartu=null;
				if ( promArray.size()>0 )
					if (comboBox.getSelectedIndex()!=0)
						promHartu = promArray.get(comboBox.getSelectedIndex()-1);

				MetodoakLeihoAldaketa.bederatzigarrenLeihoa(hartutakoOstatua, sartzeData, irtetzeData, erreserba, promHartu);
				dispose();
			}
		});
		btn_next.setForeground(Color.RED);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setBounds(216, 340, 179, 32);
		getContentPane().add(btn_next);


		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.lehenengoLeihoa();
				dispose();
			}
		});
		restart.setBounds(267, 517, 72, 32);
		restart.setForeground(Color.RED);
		getContentPane().add(restart);
		
		lblKodePromozionalikBadaukazu.setHorizontalAlignment(SwingConstants.CENTER);
		lblKodePromozionalikBadaukazu.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 21));
		lblKodePromozionalikBadaukazu.setBounds(10, 65, 584, 32);
		getContentPane().add(lblKodePromozionalikBadaukazu);
		
		
		lblSartu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSartu.setFont(new Font("Verdana", Font.ITALIC, 17));
		lblSartu.setBounds(10, 132, 574, 32);
		getContentPane().add(lblSartu);
		
		comboBox.setBounds(195, 189, 224, 32);
		comboBox.addItem("Promozio koderik ez");
		promArray=MetodoakKontsultak.promozioakBilatuMet(erreserba.getBezeroNan());
		
		for (Promozioa promozioa : promArray) {
			comboBox.addItem(promozioa.getZergatia()+" (-"+promozioa.getPrezioa()+"€)");
		}

		getContentPane().add(comboBox);

 		
	}
}