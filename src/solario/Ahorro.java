package solario;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.Font;

public class Ahorro extends JFrame {
	//SE INSTANCIAN LOS OBJETOS QUE PERMITIRAN OBETENER LOS DATOS NECESARIOS
	static DatosUsuario datos = new DatosUsuario();
	static Paneles panel = new Paneles();
	
	//SE DECLARAN LAS VARIABLES QUE POSTERIORMENTE SERAN MODIFICADAS
	private static int numeroPaneles = panel.getPanelesCalculados();
	private static double consumoAnual = datos.getConsumoAnual();
	private static double consumoBimestral = panel.getConsumoBimestral();
	private static double potenciaTotal;
	private static double generacionBimestralPromedio;
	private static double generacionDiariaPromedio;
	private static double porcentajeAhorro;
	private static double ahorroDiario;
	private static double ahorroBimestral;
	private static double ahorroAnual;
	
	
	//Se crean los getters
	public static int getNumeroPaneles() {
		return numeroPaneles;
	}
	public static double getConsumoAnual() {
		return consumoAnual;
	}
	public static double getConsumoBimestral() {
		return consumoBimestral;
	}
	public static double getGeneracionBimestralPromedio() {
		return generacionBimestralPromedio;
	}
	public static double getGeneracionDiariaPromedio() {
		return generacionDiariaPromedio;
	}
	public static double getPorcentajeAhorro() {
		return porcentajeAhorro;
	}
	public static double getAhorroDiario() {
		return ahorroDiario;
	}
	public static double getAhorroBimestral() {
		return ahorroBimestral;
	}
	public static double getAhorroAnual() {
		return ahorroAnual;
	}

	//Se declaran variables de la libreria SWING
	private static final long serialVersionUID = 1L;
	private JPanel Ahorro;
	private JLabel consumoAnualLabel, consumoBimestralLabel, numPanelesLabel, generacionDiariaLabel, generacionBimestralLabel;
	private JLabel porcentajeAhorroLabel, ahorroDiarioLabel, ahorroBimestralLabel, ahorroAnualLabel;
	private JTextArea consumoBimestralArea, generacionDiariaArea, generacionBimestralArea,porcentajeAhorroArea;
	private JTextArea ahorroDiarioArea, ahorroBimestralArea, ahorroAnualArea;
	private JButton atrasBoton, calcularBoton;
	private JTextField consumoAnualField;
	private JTextField numeroPanelesField;
	private JComboBox<String> panelBox;
	private JLabel panelLabel;
	private JTextArea advPanelesArea;
	private JTextArea advConsumoArea;
	private JLabel kWhLabel;
	private JLabel kWhLabel_1;
	private JLabel kWhLabel_2;
	private JLabel porcentajeLabel;
	private JLabel aDLabel;
	private JLabel aDLabel_1;
	private JLabel aDLabel_2;
	private JLabel nombreObliLabel;
	
	
	//Se inicializa el panel con todos los metodos
	public Ahorro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		inicializarVentana();
		crearAhorro();
		botonAtras();
		botonCalcular();
	}
	
	//Se inicializa la ventana
	private void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		Ahorro = new JPanel();
		Ahorro.setBackground(new Color(245, 243, 231));
		Ahorro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Ahorro);
	}
	
	private void crearAhorro() {
		Ahorro.setLayout(null);
		atrasBoton = new JButton("");
		atrasBoton.setIcon(new ImageIcon("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\botonregresar.png"));
		atrasBoton.setBounds(10, 10, 33, 33);
		atrasBoton.setBackground(new Color(245, 243, 231));
		atrasBoton.setBorder(null);
		Ahorro.add(atrasBoton);
		
		//LABELS O ETIQUETAS DE TEXTO
		consumoAnualLabel = new JLabel("CONSUMO ANUAL");
		consumoAnualLabel.setFont(new Font("Arial", Font.BOLD, 14));
		consumoAnualLabel.setForeground(new Color(46, 46, 46));
		consumoAnualLabel.setBounds(50, 140, 130, 20);
		Ahorro.add(consumoAnualLabel);
		
		consumoBimestralLabel = new JLabel("CONSUMO BIMESTRAL:");
		consumoBimestralLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		consumoBimestralLabel.setForeground(new Color(46, 46, 46));
		consumoBimestralLabel.setBounds(50, 300, 170, 20);
		Ahorro.add(consumoBimestralLabel);
		
		numPanelesLabel = new JLabel("NUMERO DE PANELES");
		numPanelesLabel.setForeground(new Color(46, 46, 46));
		numPanelesLabel.setFont(new Font("Arial", Font.BOLD, 14));
		numPanelesLabel.setBounds(50, 190, 160, 20);
		Ahorro.add(numPanelesLabel);
		
		generacionDiariaLabel = new JLabel("GENERACION DIARIA:");
		generacionDiariaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		generacionDiariaLabel.setForeground(new Color(46, 46, 46));
		generacionDiariaLabel.setBounds(50, 360, 150, 20);
		Ahorro.add(generacionDiariaLabel);
		
		generacionBimestralLabel = new JLabel("GENERACION BIMESTRAL:");
		generacionBimestralLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		generacionBimestralLabel.setForeground(new Color(46, 46, 46));
		generacionBimestralLabel.setBounds(50, 330, 185, 20);
		Ahorro.add(generacionBimestralLabel);
		
		porcentajeAhorroLabel = new JLabel("PORCENTAJE DE AHORRO:");
		porcentajeAhorroLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		porcentajeAhorroLabel.setForeground(new Color(46, 46, 46));
		porcentajeAhorroLabel.setBounds(50, 390, 200, 20);
		Ahorro.add(porcentajeAhorroLabel);
		
		ahorroDiarioLabel = new JLabel("AHORRO DIARIO:");
		ahorroDiarioLabel.setForeground(new Color(46, 46, 46));
		ahorroDiarioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		ahorroDiarioLabel.setBounds(50, 420, 120, 20);
		Ahorro.add(ahorroDiarioLabel);
		
		ahorroBimestralLabel = new JLabel("AHORRO BIMESTRAL:");
		ahorroBimestralLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		ahorroBimestralLabel.setForeground(new Color(46, 46, 46));
		ahorroBimestralLabel.setBounds(50, 450, 155, 20);
		Ahorro.add(ahorroBimestralLabel);
		
		ahorroAnualLabel = new JLabel("AHORRO ANUAL:");
		ahorroAnualLabel.setForeground(new Color(46, 46, 46));
		ahorroAnualLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		ahorroAnualLabel.setBounds(50, 480, 120, 20);
		Ahorro.add(ahorroAnualLabel);
		
		
		kWhLabel = new JLabel("kWh");
		kWhLabel.setForeground(new Color(46, 46, 46));
		kWhLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		kWhLabel.setBounds(335, 300, 40, 20);
		Ahorro.add(kWhLabel);
		
		kWhLabel_1 = new JLabel("kWh");
		kWhLabel_1.setForeground(new Color(46, 46, 46));
		kWhLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		kWhLabel_1.setBounds(335, 330, 40, 20);
		Ahorro.add(kWhLabel_1);
		
		kWhLabel_2 = new JLabel("kWh");
		kWhLabel_2.setForeground(new Color(46, 46, 46));
		kWhLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		kWhLabel_2.setBounds(335, 360, 40, 20);
		Ahorro.add(kWhLabel_2);
		
		porcentajeLabel = new JLabel("%");
		porcentajeLabel.setForeground(new Color(46, 46, 46));
		porcentajeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		porcentajeLabel.setBounds(335, 390, 40, 20);
		Ahorro.add(porcentajeLabel);
		
		aDLabel = new JLabel("$");
		aDLabel.setForeground(new Color(46, 46, 46));
		aDLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel.setBounds(250, 420, 10, 20);
		Ahorro.add(aDLabel);
		
		aDLabel_1 = new JLabel("$");
		aDLabel_1.setForeground(new Color(46, 46, 46));
		aDLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel_1.setBounds(250, 450, 10, 20);
		Ahorro.add(aDLabel_1);
		
		aDLabel_2 = new JLabel("$");
		aDLabel_2.setForeground(new Color(46, 46, 46));
		aDLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel_2.setBounds(250, 480, 10, 20);
		Ahorro.add(aDLabel_2);
		
		nombreObliLabel = new JLabel("*");
		nombreObliLabel.setForeground(Color.RED);
		nombreObliLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreObliLabel.setBackground(Color.RED);
		nombreObliLabel.setBounds(210, 190, 10, 20);
		Ahorro.add(nombreObliLabel);
		
		panelLabel = new JLabel("TIPO DE PANEL");
		panelLabel.setForeground(new Color(46, 46, 46));
		panelLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panelLabel.setBounds(50, 90, 120, 20);
		Ahorro.add(panelLabel);
		
		//CAMPOS DE TEXTO RELLENABLES
		consumoAnualField = new JTextField();
		consumoAnualField.setFont(new Font("Arial", Font.PLAIN, 12));
		consumoAnualField.setForeground(new Color(46, 46, 46));
		consumoAnualField.setBounds(250, 140, 100, 20);
		consumoAnualField.setText(String.valueOf(consumoAnual));
		Ahorro.add(consumoAnualField);
		consumoAnualField.setColumns(10);
		
		numeroPanelesField = new JTextField();
		numeroPanelesField.setForeground(new Color(46, 46, 46));
		numeroPanelesField.setFont(new Font("Arial", Font.PLAIN, 12));
		numeroPanelesField.setBounds(250, 190, 100, 20);
		numeroPanelesField.setText(String.valueOf(numeroPaneles));
		Ahorro.add(numeroPanelesField);
		numeroPanelesField.setColumns(10);
		
		
		//AREAS DE TEXTO
		//EL COMANDO SETFOCUSABLE AL ESTAR EN FALSE PERIMTE QUE NO SEA INTERACTUABLE POR EL USUARIO
		consumoBimestralArea = new JTextArea();
		consumoBimestralArea.setBackground(new Color(245, 243, 231));
		consumoBimestralArea.setForeground(new Color(255, 0, 0));
		consumoBimestralArea.setFont(new Font("Arial", Font.ITALIC, 12));
		consumoBimestralArea.setBounds(260, 300, 75, 20);
		consumoBimestralArea.setFocusable(false);
		Ahorro.add(consumoBimestralArea);
		
		generacionDiariaArea = new JTextArea();
		generacionDiariaArea.setForeground(new Color(255, 0, 0));
		generacionDiariaArea.setFont(new Font("Arial", Font.ITALIC, 12));
		generacionDiariaArea.setBackground(new Color(245, 243, 231));
		generacionDiariaArea.setBounds(260, 360, 75, 20);
		generacionDiariaArea.setFocusable(false);
		Ahorro.add(generacionDiariaArea);
		
		generacionBimestralArea = new JTextArea();
		generacionBimestralArea.setBackground(new Color(245, 243, 231));
		generacionBimestralArea.setForeground(new Color(255, 0, 0));
		generacionBimestralArea.setFont(new Font("Arial", Font.ITALIC, 12));
		generacionBimestralArea.setBounds(260, 330, 75, 20);
		generacionBimestralArea.setFocusable(false);
		Ahorro.add(generacionBimestralArea);
		
		porcentajeAhorroArea = new JTextArea();
		porcentajeAhorroArea.setBackground(new Color(245, 243, 231));
		porcentajeAhorroArea.setFont(new Font("Arial", Font.ITALIC, 12));
		porcentajeAhorroArea.setForeground(new Color(255, 0, 0));
		porcentajeAhorroArea.setBounds(260, 390, 75, 20);
		porcentajeAhorroArea.setFocusable(false);
		Ahorro.add(porcentajeAhorroArea);
		
		ahorroDiarioArea = new JTextArea();
		ahorroDiarioArea.setBackground(new Color(245, 243, 231));
		ahorroDiarioArea.setForeground(new Color(255, 0, 0));
		ahorroDiarioArea.setFont(new Font("Arial", Font.ITALIC, 12));
		ahorroDiarioArea.setBounds(260, 420, 75, 20);
		ahorroDiarioArea.setFocusable(false);
		Ahorro.add(ahorroDiarioArea);
		
		ahorroBimestralArea = new JTextArea();
		ahorroBimestralArea.setBackground(new Color(245, 243, 231));
		ahorroBimestralArea.setForeground(new Color(255, 0, 0));
		ahorroBimestralArea.setFont(new Font("Arial", Font.ITALIC, 12));
		ahorroBimestralArea.setBounds(260, 450, 75, 20);
		ahorroBimestralArea.setFocusable(false);
		Ahorro.add(ahorroBimestralArea);
		
		ahorroAnualArea = new JTextArea();
		ahorroAnualArea.setBackground(new Color(245, 243, 231));
		ahorroAnualArea.setForeground(new Color(255, 0, 0));
		ahorroAnualArea.setFont(new Font("Arial", Font.ITALIC, 12));
		ahorroAnualArea.setBounds(260, 480, 75, 20);
		ahorroAnualArea.setFocusable(false);
		Ahorro.add(ahorroAnualArea);
		
		advConsumoArea = new JTextArea();
		advConsumoArea.setBackground(new Color(245, 243, 231));
		advConsumoArea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 8));
		advConsumoArea.setForeground(new Color(255, 0, 0));
		advConsumoArea.setFocusable(false);
		advConsumoArea.setBounds(250, 160, 100, 20);
		Ahorro.add(advConsumoArea);
		
		advPanelesArea = new JTextArea();
		advPanelesArea.setBackground(new Color(245, 243, 231));
		advPanelesArea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 8));
		advPanelesArea.setForeground(new Color(255, 0, 0));
		advPanelesArea.setFocusable(false);
		advPanelesArea.setBounds(250, 210, 100, 20);
		Ahorro.add(advPanelesArea);
		
		//MENU DESPLEGABLE DE OPCIONES
		panelBox = new JComboBox<String>();
		panelBox.setForeground(new Color(46, 46, 46));
		panelBox.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBox.setBounds(250, 90, 100, 20);
		panelBox.addItem("Trina 620W");
		panelBox.addItem("Trina 510W");
		Ahorro.add(panelBox);
		
		//BOTONES
		calcularBoton = new JButton("CALCULAR");
		calcularBoton.setFont(new Font("Arial", Font.BOLD, 12));
		calcularBoton.setBackground(new Color(255, 214, 10));
		calcularBoton.setBounds(168, 245, 100, 20);
		Ahorro.add(calcularBoton);
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
	//ESTE METODO PERIMITE HACER TODOS LOS CALCULOS NECESARIOS PARA MOSTRAR EL AHORRO
	private void botonCalcular() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if("CALCULAR".equals(accion)) {
					//SE DECLARA UNA VARIABLE PARA LA ELECCION DE LA CAJA DE ELECCIONES
					String seleccion = (String) panelBox.getSelectedItem();
					//SE GUARDAN LOS DATOS PARA PODER INSTANCIAR EL OBJETO
					numeroPaneles = Integer.parseInt(numeroPanelesField.getText());
					consumoAnual = Double.parseDouble(consumoAnualField.getText());
					
					//SE INSTANCIA EL OBEJTO QUE PERMITIRA HACER EL CALCULO DEL CONSUMO BIMESTRAL
					CalculoPaneles cBP = new CalculoPaneles(consumoAnual,0,numeroPaneles);
					consumoBimestral = cBP.cBP();
					 
					//VERIFICA QUE LOS CAMPOS A RELLENAR NO ESTEN VACIOS
					if (numeroPaneles == 0 && consumoAnual == 0) {
						numeroPanelesField.setText("");
						consumoAnualField.setText("");
						advPanelesArea.setText("*Campo obligatorio");
						advConsumoArea.setText("*Campo obligatorio");
					}
					else if( numeroPaneles == 0 ) {
						numeroPanelesField.setText("");
						advPanelesArea.setText("*Campo obligatorio");
					}
					else if (consumoAnual == 0) {
						consumoAnualField.setText("");
						advConsumoArea.setText("*Campo obligatorio");
					}
					//EN CASO DE QUE NO HAYA ERRORES EN LOS CAMPOS A RELLENAR SE GUARDAN EN LAS VARIABLES ANTES DECLARADAS
					else {
						//PARA EL PRIMER CASO DE LA CAJA DE OPCIONES
						if (seleccion == "Trina 620W") {
							//SE INSTANCIA EL OBEJTO QUE PERMITIRA HACER LOS CALCULOS DEL AHORRO
							CalculoAhorro calculoAhorroPro = new CalculoAhorro(consumoAnual,0,numeroPaneles,0,0,0,0,0,0,0);
							//SE GUARDAN LOS VALORES DEVUELTOS EN LOS METODOS EN SUS VARIBLES CORRESPONDIENTES
							potenciaTotal = calculoAhorroPro.pT();
							generacionBimestralPromedio = calculoAhorroPro.gBP();
							generacionDiariaPromedio = calculoAhorroPro.gDP();
							porcentajeAhorro = calculoAhorroPro.pA();
							ahorroDiario = calculoAhorroPro.aD();
							ahorroBimestral = calculoAhorroPro.aB();
							ahorroAnual = calculoAhorroPro.aA();
							
							//SE BORRAN LAS ADVERTENCIAS
							advPanelesArea.setText("");
							advConsumoArea.setText("");
							
							//SE MUESTRAN TODOS LOS DATOS CALCULADOS CON UN FORMATO DE MAXIMO 4 DECIMALES
							String textoFormateado = String.format("%.4f", consumoBimestral);
							consumoBimestralArea.setText(textoFormateado);
							String textoFormateado2 = String.format("%.4f", generacionBimestralPromedio);
							generacionBimestralArea.setText(textoFormateado2);
							String textoFormateado3 = String.format("%.4f", generacionDiariaPromedio);
							generacionDiariaArea.setText(textoFormateado3);
							String textoFormateado4 = String.format("%.4f", porcentajeAhorro);
							porcentajeAhorroArea.setText(textoFormateado4);
							String textoFormateado5 = String.format("%.4f", ahorroDiario);
							ahorroDiarioArea.setText(textoFormateado5);
							String textoFormateado6 = String.format("%.4f", ahorroBimestral);
							ahorroBimestralArea.setText(textoFormateado6);
							String textoFormateado7 = String.format("%.4f", ahorroAnual);
							ahorroAnualArea.setText(textoFormateado7);
							

						}
						//PARA EL SEGUNDO CASO DE LA CAJA DE OPCIONES
						else if (seleccion == "Trina 510W") {
							//SE INSTANCIA EL OBEJTO QUE PERMITIRA HACER LOS CALCULOS
							CalculoAhorro calculoAhorroPro = new CalculoAhorro(consumoAnual,0,numeroPaneles,0,0,0,0,0,0,0);
							//SE GUARDAN LOS VALORES DEVUELTOS EN LOS METODOS EN SUS VARIBLES CORRESPONDIENTES
							potenciaTotal = calculoAhorroPro.pT2();
							generacionBimestralPromedio = calculoAhorroPro.gBP2();
							generacionDiariaPromedio = calculoAhorroPro.gDP2();
							porcentajeAhorro = calculoAhorroPro.pA2();
							ahorroDiario = calculoAhorroPro.aD2();
							ahorroBimestral = calculoAhorroPro.aB2();
							ahorroAnual = calculoAhorroPro.aA2();
							
							//SE BORRAN LAS ADVERTENCIAS
							advPanelesArea.setText("");
							advConsumoArea.setText("");
							
							//SE MUESTRAN TODOS LOS DATOS CALCULADOS CON UN FORMATO DE MAXIMO 4 DECIMALES
							String textoFormateado = String.format("%.4f", consumoBimestral);
							consumoBimestralArea.setText(textoFormateado);
							String textoFormateado2 = String.format("%.4f", generacionBimestralPromedio);
							generacionBimestralArea.setText(textoFormateado2);
							String textoFormateado3 = String.format("%.4f", generacionDiariaPromedio);
							generacionDiariaArea.setText(textoFormateado3);
							String textoFormateado4 = String.format("%.4f", porcentajeAhorro);
							porcentajeAhorroArea.setText(textoFormateado4);
							String textoFormateado5 = String.format("%.4f", ahorroDiario);
							ahorroDiarioArea.setText(textoFormateado5);
							String textoFormateado6 = String.format("%.4f", ahorroBimestral);
							ahorroBimestralArea.setText(textoFormateado6);
							String textoFormateado7 = String.format("%.4f", ahorroAnual);
							ahorroAnualArea.setText(textoFormateado7);
						
						}
					}
				}
			}
		};
		//SE AGREGA AL BOTON LAS ACCIONES A REALIZAR CORRESPONDIENTES
		calcularBoton.addActionListener(listener);
	}
}



