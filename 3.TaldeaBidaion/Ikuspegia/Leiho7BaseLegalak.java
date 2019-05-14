package Ikuspegia;

import java.awt.*;
import javax.swing.*;
import Kontrolatzailea.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import com.toedter.calendar.*;

public class Leiho7BaseLegalak extends JFrame {
	private static final long serialVersionUID = 1L;
	// panelan ikusten diren bariableak
	private JButton btnErregistratuNahi = new JButton("Erregistratu"), btn_prev = new JButton("Hasi saioa"),
			restart = new JButton("\u2302"), btn_next = new JButton("Hurrengoa");
	private JTextField txtBaseLegalak;
	private JScrollPane scroll;
	private JCheckBox chckbxIrakurrita;

	// bariableak
	private String legea;
	private JTextArea txtrTxtareabaselegalak = new JTextArea();
	private JLabel lblAcuerdo = new JLabel("ACUERDO ENTRE EL USUARIO Y Airour");

	/**
	 * Base legalak onartzen duen panela sortu 
	 * @author talde3
	 * @param prezioTot
	 * @param hartutakoOstatua
	 * @param sartzeData
	 * @param irtetzeData
	 * @param nan
	 * @param logelaTot
	 * @param pertsonaKop
	 * @param pentsioMota
	 */
	public Leiho7BaseLegalak(double prezioTot, Ostatua hartutakoOstatua, java.util.Date sartzeData,
			java.util.Date irtetzeData, String nan, int logelaTot, int pertsonaKop, String pentsioMota) {
		// panelaren propietateak
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\Argazkiak\\logoa.png"));
		getContentPane().setLayout(null);
		this.setBounds(350, 50, 600, 600);
		this.setResizable(false); // neurketak ez aldatzeko
		this.setSize(new Dimension(600, 600));
		this.setTitle("Airour ostatu bilatzailea");

		btn_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MetodoakLeihoAldaketa.zortzigarrenLeihoa(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, nan,
						logelaTot, pertsonaKop, pentsioMota);
				dispose();

			}
		});
		btn_next.setForeground(Color.RED);
		btn_next.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_next.setBounds(443, 515, 122, 32);
		btn_next.setVisible(false);
		getContentPane().add(btn_next);

		btn_prev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MetodoakLeihoAldaketa.bostgarrenLeihoa(hartutakoOstatua, prezioTot, sartzeData, irtetzeData, logelaTot, pertsonaKop, pentsioMota);
				dispose();
			}
		});
		btn_prev.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btn_prev.setForeground(Color.RED);
		btn_prev.setBounds(34, 515, 154, 32);
		getContentPane().add(btn_prev);

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

		getContentPane().add(txtrTxtareabaselegalak);
		lblAcuerdo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAcuerdo.setFont(new Font("Verdana", Font.BOLD, 20));
		lblAcuerdo.setBounds(10, 11, 574, 25);
		getContentPane().add(lblAcuerdo);

		legea = "1. General\n" + "El cumplimiento de las presentes Condiciones por nuestra parte \n"
				+ "está sujeto a leyes y los procedimientos legales vigentes y nada\n"
				+ "de lo contenido en ellas limita nuestro derecho a cumplir con lo\n"
				+ "dispuesto por las leyes aplicables u otras exigencias o condiciones\n"
				+ "administrativas o legales relacionadas con el uso que hagas de\n"
				+ "nuestra Plataforma o de la información que nos facilites o"
				+ "\nrecopilemos con respecto a dicho uso.\n"
				+ "Estas Condiciones no crean ni implican ningún derecho exigible por\n"
				+ "ninguna persona que no sea parte en ellas.\n"
				+ "Podremos transferir nuestros derechos y obligaciones descritos en\n"
				+ "estas Condiciones a otra organización, sin que ello afecte a tus\n"
				+ "derechos o a nuestras obligaciones, recogidas en las presentes\n"
				+ "Condiciones. Únicamente tú puedes transferir tus derechos u\n"
				+ "obligaciones contemplados en estas Condiciones si lo aceptáramos\n" + "por escrito.\n"
				+ "Si alguna de las secciones de las presentes Condiciones se\n"
				+ "declarara no válida, ilegal o inaplicable, la validez, la legalidad\n"
				+ "y la aplicabilidad de las disposiciones restantes no se verían\n"
				+ "afectadas ni menoscabadas en modo alguno. La omisión o demora\n"
				+ "por nuestra parte en cualquier momento en la exigencia de\n"
				+ "cumplimiento de cualquier disposición recogida en estas Condiciones\n"
				+ "no supone renuncia a nuestro derecho a exigir el cumplimiento de\n"
				+ "dicha disposición o de cualquier otra aquí contenida en el futuro.\n"
				+ "Los nombres ficticios de empresas, productos, personas, personajes\n"
				+ "o datos mencionados en la Plataforma no pretenden referirse a\n"
				+ "ningún individuo, empresa, producto o evento existentes en la\n"
				+ "realidad.Nos reservamos todos los derechos no otorgados\n" + "expresamente en las\n"
				+ "presentes Condiciones.\n" + "\n" + "2. Acceso y uso de la Plataforma\n"
				+ "En este momento, la Plataforma está disponible de forma gratuita\n"
				+ "para su uso personal y no comercial. No podemos garantizar que\n"
				+ "el acceso a la Plataforma o a cualquiera de sus contenidos\n"
				+ "esté siempre disponible o no se interrumpa. Podremos\n"
				+ "suspender, retirar, interrumpir total o parcialmente la Plataforma\n" + "sin previo aviso.\n" + "\n"
				+ "3. No vendemos productos hoteleros\n"
				+ "La Plataforma es un motor de búsqueda de hoteles que ofrece a los\n"
				+ "usuarios comparaciones de diferentes ofertas de habitación de hotel.\n"
				+ "Airour no ofrece, posee ni controla ninguno de los servicios ni de\n"
				+ "los productos hoteleros a los que el usuario podrá acceder a través\n"
				+ "de nuestra Plataforma (los «Productos hoteleros»). Los Productos\n"
				+ "hoteleros son propiedad, se controlan y se ponen a disposición a\n"
				+ "través de terceros (los «Proveedores hoteleros»), ya sea\n"
				+ "directamente (por ejemplo, un hotel) o a través de un facilitador\n"
				+ "de reservas de hotel (por ejemplo, una compañía de viajes online).\n"
				+ "Los Proveedore hoteleros son responsables de los Productos hoteleros\n"
				+ "y de todos los contratos de reserva, incluido, por ejemplo, Airour\n"
				+ "Express. La reserva de un Producto hotelero se realizará únicamente\n"
				+ "en las plataformas del Proveedor hotelero. A su reserva se aplicarán\n"
				+ "las condiciones y las políticas de privacidad del Proveedor hotelero,\n"
				+ "por lo que deberás aceptar y entender dichas condiciones. Además,\n"
				+ "también se aplicarán a tu reserva las condiciones del hotel donde\n"
				+ "tengas intención de alojarte, si estas fuesen diferentes de las del\n"
				+ "Proveedor hotelero, por lo que también deberás aceptar y entender\n"
				+ "dichas condiciones. Cualquier interacción que realices con cualquier\n"
				+ "Proveedor hotelero a través de nuestra Plataforma será por tu cuenta\n"
				+ "y riesgo, y Airour no será responsable en modo alguno si surgiera\n"
				+ "algún problema con tu reserva.\n"
				+ "Airour no controla los Productos ni a los Proveedores hoteleros.\n" + "\n" + "4. Airour Express\n"
				+ "El servicio «Airour Express» facilita la reserva de un Producto\n"
				+ "hotelero con un Proveedor hotelero a través de nuestra\n"
				+ "Plataforma. Airour Express estará disponible ocasionalmente\n"
				+ "a nuestra exclusiva discreción. Si decides utilizar Airour\n"
				+ "Express (en caso de que esté disponible), la reserva se\n"
				+ "realizará con el Proveedor hotelero que figure en la página\n"
				+ "de reserva y Airour le enviará al Proveedor hotelero\n"
				+ "correspondiente la información que facilites para la reserva.\n" + "\n" + "5. Uso de la Plataforma\n"
				+ "Como condición para usar nuestra Plataforma, aceptas:\n" + "que tienes al menos 18 años de edad,\n"
				+ "que posees capacidad de obrar suficiente para obligarte mediante\n"
				+ "una relación contractual, que usarás la Plataforma según las\n"
				+ "presentes Condiciones, que solo usarás la Plataforma con fines\n"
				+ "privados, con el objeto de buscar\n" + "ofertas de hotel legítimas,\n"
				+ "que si usaras la Plataforma en nombre de un tercero, le informarás\n"
				+ "de las Condiciones que se aplican a las búsquedas o reservas que\n"
				+ "hayas realizado en su nombre, incluidas todas las normas y\n"
				+ "restricciones correspondientes, que toda la información que\n"
				+ "facilites en nuestra Plataforma es veraz, precisa, actual y\n"
				+ "completa y que, en caso de disponer de una cuenta de Airour,\n"
				+ "protegerás la información de tu cuenta, la supervisarás y serás\n"
				+ "plenamente responsable del uso que tú o cualquier otra persona\n"
				+ "distinta de ti hagáis de ella.\n"
				+ "Nos reservamos el derecho, a nuestro exclusivo criterio, de denegar\n"
				+ "el acceso a cualquier persona a nuestra Plataforma y a los servicios\n"
				+ "que ofrecemos en cualquier momento y por cualquier motivo, incluido,\n"
				+ "entre otros, el incumplimiento de las presentes Condiciones. Los\n"
				+ "Productos hoteleros que se ofrecen en la Plataforma se mostrarán en\n"
				+ "la divisa que hayas seleccionado. Si no seleccionaras ninguna divisa,\n"
				+ "se usará como valor predeterminado la moneda correspondiente al dominio\n"
				+ "de nivel superior. Nuestra conversión de divisa se indica con fines\n"
				+ "informativos exclusivamente y no se debe tomar como un valor preciso ni\n"
				+ "actualizado en tiempo real. Algunos Productos hoteleros también se pueden\n"
				+ "vender en otra divisa distinta a la preestablecida o a la que hubieras\n"
				+ "seleccionado para visualizar los resultados de la búsqueda. Las tasas de\n"
				+ "cambio reales podrían variar y tu proveedor de pagos (por ejemplo, tu\n"
				+ "compañía de tarjeta de crédito) podría cobrarte comisiones de conversión\n"
				+ "y aplicar la tasa de cambio vigente para una fecha diferente.\n"
				+ "Todos los precios indicados deberán entenderse como aplicables a una noche\n"
				+ "de estancia. Para reservas de más de una noche se muestra el precio medio\n"
				+ "por noche para el período seleccionado.\n"
				+ "Los precios indicados incluyen la tarifa de reserva, el IVA y la tarifa de\n"
				+ "servicio, pero no incluyen otras tasas hoteleras, de resort, ni impuestos\n" + "municipales.\n"
				+ "\n" + "6. Obligaciones del usuario y actividades prohibidas\n"
				+ "Como usuario de la Plataforma, eres responsable de todo el Contenido del\n"
				+ "usuario (texto, fotos, reseñas, enlaces, etc.) que compartas en Airour.\n"
				+ "Deberás garantizar que dispones de todos los derechos sobre cualquier\n"
				+ "contenido que publiques en la Plataforma de Airour y que el Contenido\n"
				+ "del usuario que publiques en la Plataforma de Airour no infringe derechos\n" + "de terceros.\n"
				+ "En especial, no crearás ni compartirás ningún Contenido del usuario:\n"
				+ "que sea publicidad encubierta con la apariencia de una crítica,\n"
				+ "que no disponga de contenido específico para un producto evaluado,\n"
				+ "que no sea objetivo o que sea deliberadamente falso,\n"
				+ "que sea inmoral, pornográfico u ofensivo en cualquier otro modo,\n"
				+ "que infrinja los derechos de terceros, en especial derechos de propiedad\n"
				+ "intelectual o industrial, que infrinja en cualquier modo la legislación\n"
				+ "vigente o constituya una infracción penal, que contenga virus u otros\n"
				+ "programas informáticos que puedan dañar el software o el hardware, o que\n"
				+ "puedan perjudicar el uso de los ordenadores, que sea una encuesta o carta\n"
				+ "en cadena o que tenga como objetivo recopilar o utilizar datos personales\n"
				+ "de otros usuarios, sobre todo con fines comerciales.\n" + "7. Privacidad\n"
				+ "Airour se toma en serio la protección de tu privacidad.\n" + "8. Disponibilidad\n"
				+ "No podemos garantizar que nuestra Plataforma esté siempre disponible,\n"
				+ "carezca de interrupciones, sea segura o esté exenta de fallos o virus,\n"
				+ "o que no contenga errores u omisiones.\n"
				+ "No seremos responsables de ningún retraso ni avería que se deba a causas\n"
				+ "de fuerza mayor o motivos que escapen a nuestro control razonable,\n"
				+ "incluidos, entre otros, los fallos debidos a circunstancias imprevistas\n"
				+ "o causas ajenas a nuestro control, tales como actos de guerra, terrorismo,\n"
				+ "disturbios, embargos, actuaciones de autoridades civiles o militares,incendios,\n"
				+ "inundaciones, accidentes, huelgas, epidemias u otros desastres naturales,\n"
				+ "escasez de servicios de transporte, combustible, energía, mano de obra o\n"
				+ "materiales, o averías en las redes de telecomunicaciones públicas o privadas.";

		txtrTxtareabaselegalak.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txtrTxtareabaselegalak.setEditable(false);
		txtrTxtareabaselegalak.setText(legea);

		scroll = new JScrollPane(txtrTxtareabaselegalak);
		scroll.setBounds(10, 46, 574, 387);
		getContentPane().add(scroll);

		chckbxIrakurrita = new JCheckBox("Baldintzak eta erabilera baldintzak irakurri dut eta onartzen ditut.");
		chckbxIrakurrita.setFont(new Font("Verdana", Font.PLAIN, 13));
		chckbxIrakurrita.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxIrakurrita.setBounds(0, 447, 588, 37);
		getContentPane().add(chckbxIrakurrita);

		chckbxIrakurrita.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxIrakurrita.isSelected())
					btn_next.setVisible(true);
				else
					btn_next.setVisible(false);
			}
		});
	}
}