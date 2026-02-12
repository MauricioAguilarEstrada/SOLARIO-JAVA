package solario;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;

public class Paneles extends JFrame {
	//SE DECLARAQ EL OBJETO DATOS PARA PODER OBTENER SUS VARIABLES
	DatosUsuario datos = new DatosUsuario();
	
	// SE OBTIENE EL VALOR DEL CONSUMO ANUAL Y SE GUARDA
	private double consumoAnual = datos.getConsumoAnual();
	
	//SE DECLARAN LAS VARIABLES QUE POSTERIORMENTE SERAN MODIFICADAS
	private static double consumoBimestral = 0;
	private static int panelesCalculados = 0;
	private static int idPanel = 3;
	
	//SE GENERAN LOS GETTERS
	public double getConsumoBimestral() {
		return consumoBimestral;
	}
	public int getPanelesCalculados() {
		return panelesCalculados;
	}
	public int getIdPanel() {
		return idPanel;
	}
	
	//SE DECLARAN LAS VARIABLES DE LA LIBRERIA SWING
	private static final long serialVersionUID = 1L;
	private JPanel Paneles;
	private JButton atrasBoton, calcularBoton;
	private JTextArea consumoBimestralArea, panelesCalculadosArea;
	private JLabel consumoAnualLabel, consumoBimestralLabel, panelesCalculadosLabel, panelLabel, kWhLabel, kWhLabel2;
	private JComboBox<String> panelBox;
	private JTextField consumoAnualField;

	//SE INICIALIZA EL PANEL CON TODOS LOS METODOS 
	//SE INSERTA LA IMAGEN DE LA VENTANA DESDE LA RUTA ESTABLECIDA
	public Paneles() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		inicializarVentana();
		crearPaneles();
		botonAtras();
		botonCalcular();
	}
	
	//SE INICIALIZA LA VENTANA CON SUS MEDIDAS

	private void inicializarVentana() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Paneles = new JPanel();
		Paneles.setBackground(new Color(245, 243, 231));
		Paneles.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Paneles);
	}
	
	//SE INICIALIZAN TODOS LAS VARIABLES DE SWING 
	private void crearPaneles() {
		Paneles.setLayout(null);
		//BOTONES
		atrasBoton = new JButton("");
		atrasBoton.setIcon(new ImageIcon("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\botonregresar.png"));
		atrasBoton.setBounds(10, 10, 33, 33);
		atrasBoton.setBackground(new Color(245, 243, 231));
		atrasBoton.setBorder(null);
		Paneles.add(atrasBoton);
		
		calcularBoton = new JButton("CALCULAR");
		calcularBoton.setBackground(new Color(255, 214, 14));
		calcularBoton.setForeground(new Color(46, 46, 46));
		calcularBoton.setFont(new Font("Arial", Font.BOLD, 12));
		calcularBoton.setBounds(168, 140, 100, 20);
		Paneles.add(calcularBoton);
		
		//LABELS O EQTIQUETAS DE TEXTO
		consumoAnualLabel = new JLabel("CONSUMO ANUAL");
		consumoAnualLabel.setForeground(new Color(46, 46, 46));
		consumoAnualLabel.setFont(new Font("Arial", Font.BOLD, 14));
		consumoAnualLabel.setBounds(65, 95, 150, 20);
		Paneles.add(consumoAnualLabel);
		
		consumoBimestralLabel = new JLabel("CONSUMO BIMESTRAL:");
		consumoBimestralLabel.setForeground(new Color(46, 46, 46));
		consumoBimestralLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		consumoBimestralLabel.setBounds(65, 190, 175, 20);
		Paneles.add(consumoBimestralLabel);
		
		panelesCalculadosLabel = new JLabel("PANELES CALCULADOS:");
		panelesCalculadosLabel.setForeground(new Color(46, 46, 46));
		panelesCalculadosLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		panelesCalculadosLabel.setBounds(65, 230, 180, 20);
		Paneles.add(panelesCalculadosLabel);
		
		panelLabel = new JLabel("TIPO DE PANEL");
		panelLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panelLabel.setForeground(new Color(46, 46, 46));
		panelLabel.setBounds(65, 65, 130, 20);
		Paneles.add(panelLabel);
		
		kWhLabel = new JLabel("kWh");
		kWhLabel.setForeground(new Color(46, 46, 46));
		kWhLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		kWhLabel.setBounds(371, 95, 40, 20);
		Paneles.add(kWhLabel);
		
		kWhLabel2 = new JLabel("kWh");
		kWhLabel2.setForeground(new Color(46, 46, 46));
		kWhLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
		kWhLabel2.setBounds(346, 190, 40, 20);
		Paneles.add(kWhLabel2);
		
		//AREAS DE TEXTO
		//EL COMANDO SETFOCUSABLE AL ESTAR EN FALSE PERIMTE QUE NO SEA INTERACTUABLE POR EL USUARIO
		consumoBimestralArea = new JTextArea();
		consumoBimestralArea.setForeground(new Color(255, 0, 0));
		consumoBimestralArea.setFont(new Font("Arial", Font.ITALIC, 12));
		consumoBimestralArea.setBackground(new Color(245, 243, 231));
		consumoBimestralArea.setBounds(266, 190, 75, 20);
		consumoBimestralArea.setFocusable(false);
		Paneles.add(consumoBimestralArea);
		
		panelesCalculadosArea = new JTextArea();
		panelesCalculadosArea.setForeground(new Color(255, 0, 0));
		panelesCalculadosArea.setFont(new Font("Arial", Font.ITALIC, 12));
		panelesCalculadosArea.setBackground(new Color(245, 243, 231));
		panelesCalculadosArea.setBounds(266, 230, 75, 20);
		panelesCalculadosArea.setFocusable(false);
		Paneles.add(panelesCalculadosArea);
		
		//MENU DESPLEGABLE DE OPCIONES
		panelBox = new JComboBox<String>();
		panelBox.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBox.setForeground(new Color(46, 46, 46));
		panelBox.setBounds(266, 65, 100, 20);
		panelBox.addItem("Trina 620W");
		panelBox.addItem("Trina 510W");
		Paneles.add(panelBox);
		
		//CAMPO DE TEXTO RELLENABLE
		consumoAnualField = new JTextField();
		consumoAnualField.setForeground(new Color(46, 46, 46));
		consumoAnualField.setFont(new Font("Arial", Font.PLAIN, 12));
		consumoAnualField.setBounds(266, 95, 100, 20);
		consumoAnualField.setText(String.valueOf(consumoAnual));
		Paneles.add(consumoAnualField);
		consumoAnualField.setColumns(10);
		
	}
	
	//ESTE METODO PERMITE REGRESAR A LA VENTANA DE ANTERIOR MEDINATE UN BOTON
	private void botonAtras() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if ("".equals(accion)) {
					dispose();
					Escoger escoger = new Escoger();
					escoger.setVisible(true);
					escoger.setLocationRelativeTo(null);
				}
			}
		};
		//SE AGREGA AL BOTON LAS ACCIONES A REALIZAR CORRESPONDIENTES
		atrasBoton.addActionListener(listener);
	}
	
	//ESTE METODO PERIMITE HACER TODOS LOS CALCULOS NECESARIOS PARA MOSTRAR EL CALCULO DE LOS PANELES
	private void botonCalcular() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if("CALCULAR".equals(accion)) {
					//SE DECLARA UNA VARIABLE PARA LA ELECCION DE LA CAJA DE ELECCIONES
					String seleccion = (String) panelBox.getSelectedItem();
					
					//PARA EL PRIMER CASO DE LA CAJA DE OPCIONES
					if (seleccion == "Trina 620W") {
						//SE GUARDA EL VALOR DEL CONSUMO ANUAL EN UNA VARIABLE DOUBLE PARA PODER UTILIZARLA EN EL CONSTRUCTOR DEL OBJETO
						double cA = Double.parseDouble(consumoAnualField.getText());
						//SE INTANCIA EL OBJETO PARA PODER HACER LOS CALCULOS 
						CalculoPaneles calculoPro = new CalculoPaneles(cA,0,0);
						//SE GUARDAN LOS VALORES DEVUELTOS EN LOS METODOS EN SUS VARIBLES CORRESPONDIENTES
						consumoBimestral = calculoPro.cBP();
						panelesCalculados = (int) Math.ceil(calculoPro.nP());
						idPanel = 1;
						
						//SE MUESTRAN TODOS LOS DATOS CALCULADOS CON UN FORMATO DE MAXIMO 4 DECIMALES
						String textoFormateado = String.format("%.4f", consumoBimestral);
						consumoBimestralArea.setText(textoFormateado);
						panelesCalculadosArea.setText(String.valueOf(panelesCalculados));
						
					}
					//PARA EL SEGUNDO CASO DE LA CAJA DE OPCIONES
					else if (seleccion == "Trina 510W") {
						//SE GUARDA EL VALOR DEL CONSUMO ANUAL EN UNA VARIABLE DOUBLE PARA PODER UTILIZARLA EN EL CONSTRUCTOR DEL OBJETO
						double cA = Double.parseDouble(consumoAnualField.getText());
						//SE INTANCIA EL OBJETO PARA PODER HACER LOS CALCULOS 
						CalculoPaneles calculoPro = new CalculoPaneles(cA,0,0);
						//SE GUARDAN LOS VALORES DEVUELTOS EN LOS METODOS EN SUS VARIBLES CORRESPONDIENTES
						consumoBimestral = calculoPro.cBP();
						panelesCalculados = (int) Math.ceil(calculoPro.nP2());
						idPanel = 2;
						
						//SE MUESTRAN TODOS LOS DATOS CALCULADOS CON UN FORMATO DE MAXIMO 4 DECIMALES
						String textoFormateado = String.format("%.4f", consumoBimestral);
						consumoBimestralArea.setText(textoFormateado);
						panelesCalculadosArea.setText(String.valueOf(panelesCalculados));

					}
				}
			}
		};
		calcularBoton.addActionListener(listener);
	}
}
