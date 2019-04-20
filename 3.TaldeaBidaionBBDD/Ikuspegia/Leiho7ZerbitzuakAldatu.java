package Ikuspegia;

import java.awt.*;
import javax.swing.*;

public class Leiho7ZerbitzuakAldatu extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak

	// bariableak

	public Leiho7ZerbitzuakAldatu() {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("3.taldearen ostatu zerbitzuen bilatzailea");

	}
}