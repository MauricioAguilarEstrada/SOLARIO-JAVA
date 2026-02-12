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

public class Cotiza extends JFrame {
	//SE INSTANCIAN EL OBJETO QUE PERMITIRAN OBETENER LOS DATOS NECESARIOS
	static Paneles panel = new Paneles();
	
	//SE DECLARAN LAS VARIABLES QUE POSTERIORMENTE SERAN MODIFICADAS
	private int precioPanel;
	private static int precioPaneles;
	private static int numeroPaneles = panel.getPanelesCalculados();
	private static int instalacion;
	private static int total;
	
	
	//SE ESTABLECEN LOS GETTERS
	public static int getPrecioPaneles() {
		return precioPaneles;
	}
	public static int getNumeroPaneles() {
		return numeroPaneles;
	}
	public static int getInstalacion() {
		return instalacion;
	}
	public static int getTotal() {
		return total;
	}
	
	//SE DECLARAN LAS VARIABLES DE LA LIBRERIA SWING
	private static final long serialVersionUID = 1L;
	private JPanel Cotiza;
	private JButton atrasBoton;
	private JLabel tipoPanelLabel, numeroPanelesLabel, instalacionLabel, totalLabel;
	private JTextArea instalacionArea, totalArea;
	private JTextField numeroPanelesField;
	private JComboBox<String> panelBox;
	private JButton calcularBoton;
	private JTextArea advPanelesArea;
	private JLabel totalPanelesLabel;
	private JTextArea totalPanelesArea;
	private JLabel precioUnitarioLabel;
	private JTextArea precioUnitarioArea;
	private JLabel aDLabel;
	private JLabel aDLabel_1;
	private JLabel aDLabel_2;
	private JLabel aDLabel_3;
	private JLabel lblNewLabel;
	private JLabel nombreObliLabel;
	private JLabel nombreObliLabel_1;
	private JLabel nombreObliLabel_2;
	
	//SE INICIALIZA EL PANEL CON TODOS LOS METODOS 
	//SE INSERTA LA IMAGEN DE LA VENTANA DESDE LA RUTA ESTABLECIDA
	public Cotiza() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		inicializarVentana();
		crearCotiza();
		botonAtras();
		botonCalcular();
	}
	//SE INICIALIZA LA VENTANA CON SUS MEDIDAS
	private void inicializarVentana() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		Cotiza = new JPanel();
		Cotiza.setBackground(new Color(245, 243, 231));
		Cotiza.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Cotiza);
	}
	//SE INICIALIZAN TODOS LAS VARIABLES DE SWING 
	private void crearCotiza() {
		Cotiza.setLayout(null);
		//BOTONES
		atrasBoton = new JButton("");
		atrasBoton.setIcon(new ImageIcon("C:\\Users\\aemau\\OneDrive\\Escritorio\\FTS JAVA\\botonregresar.png"));
		atrasBoton.setBounds(10, 10, 33, 33);
		atrasBoton.setBackground(new Color(245, 243, 231));
		atrasBoton.setBorder(null);
		Cotiza.add(atrasBoton);
		
		calcularBoton = new JButton("CALCULAR");
		calcularBoton.setBackground(new Color(255, 214, 14));
		calcularBoton.setFont(new Font("Arial", Font.BOLD, 12));
		calcularBoton.setForeground(new Color(46, 46, 46));
		calcularBoton.setBounds(143, 165, 100, 20);
		Cotiza.add(calcularBoton);
		
		//LABELS O ETIQUETAS DE TEXTO
		tipoPanelLabel = new JLabel("TIPO DE PANEL");
		tipoPanelLabel.setFont(new Font("Arial", Font.BOLD, 14));
		tipoPanelLabel.setBounds(50, 75, 110, 20);
		Cotiza.add(tipoPanelLabel);
		
		numeroPanelesLabel = new JLabel("NUMERO DE PANELES");
		numeroPanelesLabel.setFont(new Font("Arial", Font.BOLD, 14));
		numeroPanelesLabel.setBounds(50, 115, 160, 20);
		Cotiza.add(numeroPanelesLabel);

		instalacionLabel = new JLabel("COSTO DE INSTALACION");
		instalacionLabel.setForeground(new Color(46, 46, 46));
		instalacionLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		instalacionLabel.setBounds(50, 265, 175, 20);
		Cotiza.add(instalacionLabel);
		
		totalLabel = new JLabel("TOTAL");
		totalLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		totalLabel.setForeground(new Color(46, 46, 46));
		totalLabel.setBounds(127, 311, 50, 20);
		Cotiza.add(totalLabel);
		
		totalPanelesLabel = new JLabel("TOTAL PANELES");
		totalPanelesLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		totalPanelesLabel.setForeground(new Color(46, 46, 46));
		totalPanelesLabel.setBounds(50, 235, 120, 20);
		Cotiza.add(totalPanelesLabel);
		
		precioUnitarioLabel = new JLabel("PRECIO UNITARIO");
		precioUnitarioLabel.setForeground(new Color(46, 46, 46));
		precioUnitarioLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		precioUnitarioLabel.setBounds(50, 205, 130, 20);
		Cotiza.add(precioUnitarioLabel);
		aDLabel = new JLabel("$");
		aDLabel.setForeground(new Color(46, 46, 46));
		aDLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel.setBounds(240, 205, 10, 20);
		Cotiza.add(aDLabel);
		
		aDLabel_1 = new JLabel("$");
		aDLabel_1.setForeground(new Color(46, 46, 46));
		aDLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel_1.setBounds(240, 235, 10, 20);
		Cotiza.add(aDLabel_1);
		
		aDLabel_2 = new JLabel("$");
		aDLabel_2.setForeground(new Color(46, 46, 46));
		aDLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel_2.setBounds(240, 265, 10, 20);
		Cotiza.add(aDLabel_2);
		
		aDLabel_3 = new JLabel("$");
		aDLabel_3.setForeground(new Color(46, 46, 46));
		aDLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		aDLabel_3.setBounds(187, 311, 10, 20);
		Cotiza.add(aDLabel_3);
		
		lblNewLabel = new JLabel("DATOS APROXIMADOS*");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 8));
		lblNewLabel.setBounds(143, 341, 100, 13);
		Cotiza.add(lblNewLabel);
		
		nombreObliLabel = new JLabel("*");
		nombreObliLabel.setForeground(Color.RED);
		nombreObliLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreObliLabel.setBackground(Color.RED);
		nombreObliLabel.setBounds(175, 205, 10, 20);
		Cotiza.add(nombreObliLabel);
		
		nombreObliLabel_1 = new JLabel("*");
		nombreObliLabel_1.setForeground(Color.RED);
		nombreObliLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreObliLabel_1.setBackground(Color.RED);
		nombreObliLabel_1.setBounds(170, 235, 10, 20);
		Cotiza.add(nombreObliLabel_1);
		
		nombreObliLabel_2 = new JLabel("*");
		nombreObliLabel_2.setForeground(Color.RED);
		nombreObliLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreObliLabel_2.setBackground(Color.RED);
		nombreObliLabel_2.setBounds(225, 265, 10, 20);
		Cotiza.add(nombreObliLabel_2);
		
		//CAMPOS DE TEXTO RELLENABLES
		numeroPanelesField = new JTextField();
		numeroPanelesField.setForeground(new Color(46, 46, 46));
		numeroPanelesField.setFont(new Font("Arial", Font.PLAIN, 12));
		numeroPanelesField.setBounds(225, 115, 100, 20);
		numeroPanelesField.setText(String.valueOf(numeroPaneles));
		Cotiza.add(numeroPanelesField);
		numeroPanelesField.setColumns(10);
		
		//AREAS DE TEXTO
		//EL COMANDO SETFOCUSABLE AL ESTAR EN FALSE PERIMTE QUE NO SEA INTERACTUABLE POR EL USUARIO
		instalacionArea = new JTextArea();
		instalacionArea.setBackground(new Color(245, 243, 231));
		instalacionArea.setForeground(new Color(255, 0, 0));
		instalacionArea.setFont(new Font("Arial", Font.ITALIC, 12));
		instalacionArea.setBounds(250, 265, 75, 20);
		instalacionArea.setFocusable(false);
		Cotiza.add(instalacionArea);
		
		totalArea = new JTextArea();
		totalArea.setBackground(new Color(245, 243, 231));
		totalArea.setForeground(new Color(255, 0, 0));
		totalArea.setFont(new Font("Arial", Font.ITALIC, 14));
		totalArea.setBounds(197, 309, 75, 20);
		totalArea.setFocusable(false);
		Cotiza.add(totalArea);
		
		advPanelesArea = new JTextArea();
		advPanelesArea.setBackground(new Color(245, 243, 231));
		advPanelesArea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 8));
		advPanelesArea.setForeground(new Color(255, 0, 0));
		advPanelesArea.setFocusable(false);
		advPanelesArea.setBounds(225, 135, 100, 20);
		Cotiza.add(advPanelesArea);
		
		totalPanelesArea = new JTextArea();
		totalPanelesArea.setBackground(new Color(245, 243, 231));
		totalPanelesArea.setForeground(new Color(255, 0, 0));
		totalPanelesArea.setFont(new Font("Arial", Font.ITALIC, 12));
		totalPanelesArea.setFocusable(false);
		totalPanelesArea.setBounds(250, 235, 75, 20);
		Cotiza.add(totalPanelesArea);
		
		precioUnitarioArea = new JTextArea();
		precioUnitarioArea.setBackground(new Color(245, 243, 231));
		precioUnitarioArea.setFont(new Font("Arial", Font.ITALIC, 12));
		precioUnitarioArea.setForeground(Color.RED);
		precioUnitarioArea.setFocusable(false);
		precioUnitarioArea.setBounds(250, 205, 75, 20);
		Cotiza.add(precioUnitarioArea);
		
		//MENU DESPLEGABLE DE OPCIONES
		panelBox = new JComboBox<String>();
		panelBox.setFont(new Font("Arial", Font.PLAIN, 12));
		panelBox.setForeground(new Color(46, 46, 46));
		panelBox.setBounds(225, 74, 100, 20);
		panelBox.addItem("Trina 620W");
		panelBox.addItem("Trina 510W");
		Cotiza.add(panelBox);
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
	
	//ESTE METODO PERIMITE HACER TODOS LOS CALCULOS NECESARIOS PARA MOSTRAR EL CALCULO DE LA COTIZACION
	public void botonCalcular() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if("CALCULAR".equals(accion)) {
					//SE DECLARA UNA VARIABLE PARA LA ELECCION DE LA CAJA DE ELECCIONES
					String seleccion = (String) panelBox.getSelectedItem();
					//SE GUARDAN LOS DATOS PARA PODER INSTANCIAR EL OBJETO
					numeroPaneles = Integer.parseInt(numeroPanelesField.getText());
					
					//VERIFICA QUE LOS CANTIDAD DE PANELES SEA CORRECTA
					if( numeroPaneles == 0 ) {
						numeroPanelesField.setText("");
						advPanelesArea.setText("*Campo obligatorio");
					}
					
					//EN CASO DE QUE NO HAYA ERRORES EN LOS CAMPOS A RELLENAR SE GUARDAN EN LAS VARIABLES ANTES DECLARADAS
					else {
						//PARA EL PRIMER CASO DE LA CAJA DE OPCIONES
						if (seleccion == "Trina 620W") {
							//SE INSTANCIA EL OBJETO QUE PERMITIRA REALIZAR LOS CALCULOS DEL AHORRO ANUAL
							CalculoAhorro calculoAhorroPro = new CalculoAhorro(0,0,numeroPaneles,0,0,0,0,0,0,0);
							//SE GUARDAN LOS VALORES DEVUELTOS EN LOS METODOS EN SUS VARIBLES CORRESPONDIENTES
							precioPanel = calculoAhorroPro.getPrecioPanel620();
							precioPaneles = calculoAhorroPro.precioPaneles();
							instalacion = calculoAhorroPro.getInstalacion();
							total = calculoAhorroPro.cotizacion();
							
							//SE MUESTRAN TODOS LOS DATOS CALCULADOS
							precioUnitarioArea.setText(String.valueOf(precioPanel));
							totalPanelesArea.setText(String.valueOf(precioPaneles));
							instalacionArea.setText(String.valueOf(instalacion));
							totalArea.setText(String.valueOf(total));
						}
						//PARA EL SEGUNDO CASO DE LA CAJA DE OPCIONES
						else if (seleccion == "Trina 510W") {
							//SE INSTANCIA EL OBJETO QUE PERMITIRA REALIZAR LOS CALCULOS DEL AHORRO ANUAL
							CalculoAhorro calculoAhorroPro = new CalculoAhorro(0,0,numeroPaneles,0,0,0,0,0,0,0);
							//SE GUARDAN LOS VALORES DEVUELTOS EN LOS METODOS EN SUS VARIBLES CORRESPONDIENTES
							precioPanel = calculoAhorroPro.getPrecioPanel510();
							precioPaneles = calculoAhorroPro.precioPaneles2();
							instalacion = calculoAhorroPro.getInstalacion();
							total = calculoAhorroPro.cotizacion2();
							
							//SE MUESTRAN TODOS LOS DATOS CALCULADOS CON UN FORMATO DE MAXIMO 4 DECIMALES
							precioUnitarioArea.setText(String.valueOf(precioPanel));
							totalPanelesArea.setText(String.valueOf(precioPaneles));
							instalacionArea.setText(String.valueOf(instalacion));
							totalArea.setText(String.valueOf(total));
						}
					}
				}
			}
		};
		calcularBoton.addActionListener(listener);
	}
}
