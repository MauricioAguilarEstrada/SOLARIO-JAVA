package solario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Escoger extends JFrame {
	
	//SE DECLARAN LAS VARIABLES DE LA LIBRERIA SWING
	private static final long serialVersionUID = 1L;
	private JPanel Escoger;
	private JButton panelesBoton, ahorroBoton, cotizacionBoton, finalBoton, salirBoton;
	private JLabel tituloLabel;

	
	//SE INICIALIZA EL PANEL CON TODOS LOS METODOS 
	//SE INSERTA LA IMAGEN DE LA VENTANA DESDE LA RUTA ESTABLECIDA
	public Escoger() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		inicializarVentana();
		crearEscoger();
		botonAtras();
		botonAccion();
		botonFinal();
		botonSalir();
	}
	
	//SE INICIALIZA LA VENTANA CON SUS MEDIDAS
	private void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Escoger.setLayout(null);
		setBounds(100, 100, 600, 400);
		Escoger = new JPanel();
		Escoger.setBackground(new Color(245, 243, 231));
		Escoger.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Escoger);
		
	}
	
	//SE INICIALIZAN TODOS LAS VARIABLES DE SWING 
	private void crearEscoger() {
		//BOTONES
		salirBoton = new JButton("SALIR");
		salirBoton.setFont(new Font("Arial", Font.BOLD, 12));
		salirBoton.setBackground(new Color(255, 0, 0));
		salirBoton.setBounds(102, 310, 140, 20);
		Escoger.add(salirBoton);
		
		finalBoton = new JButton("GUARDAR DATOS");
		finalBoton.setFont(new Font("Arial", Font.BOLD, 12));
		finalBoton.setBounds(344, 310, 140, 20);
		finalBoton.setBackground(new Color(0, 255, 0));
		Escoger.add(finalBoton);
		
		cotizacionBoton = new JButton("COTIZA");
		cotizacionBoton.setBounds(221, 220, 150, 30);
		cotizacionBoton.setFont(new Font("Arial", Font.BOLD, 15));
		cotizacionBoton.setForeground(new Color(46, 46, 46));
		cotizacionBoton.setBackground(new Color(255, 214, 14));
		Escoger.add(cotizacionBoton);
		
		ahorroBoton = new JButton("CALCULA TU AHORRO");
		ahorroBoton.setBounds(316, 152, 220, 30);
		ahorroBoton.setForeground(new Color(46, 46, 46));
		ahorroBoton.setFont(new Font("Arial", Font.BOLD, 15));
		ahorroBoton.setBackground(new Color(255, 214, 14));
		Escoger.add(ahorroBoton);
		
		panelesBoton = new JButton("CALCULA TUS PANELES");
		panelesBoton.setBounds(48, 152, 220, 30);
		panelesBoton.setForeground(new Color(46, 46, 46));
		panelesBoton.setFont(new Font("Arial", Font.BOLD, 15));
		panelesBoton.setBackground(new Color(255, 214, 14));
		Escoger.add(panelesBoton);
		
		//LABEL O ETIQUETA DE TEXTO
		tituloLabel = new JLabel("¿QUE DESEA HACER?");
		tituloLabel.setBounds(110, 75, 365, 30);
		tituloLabel.setBackground(new Color(0, 0, 0));
		tituloLabel.setForeground(new Color(46, 46, 46));
		tituloLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		Escoger.add(tituloLabel);
	}
	
	//ESTE METODO PERMITE REGRESAR A LA VENTANA DE DATOSUSUARIO MEDINATE UN BOTON
	private void botonAtras() {
		//VARIABLES LOCALES DECLARADAS PARA EL FUNCIONAMIENTO DEL METODO 

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if ("".equals(accion)) {
					//CIERRA LA VENTANA ACTUAL Y ABRE LA REQUERIDA
					dispose();
					DatosUsuario datos = new DatosUsuario();
					datos.setVisible(true);
					datos.setLocationRelativeTo(null);
				}
			}
		};
	}
	
	//ESTE METODO PERMITE ABRIR LA VENTANA LA CUAL SEA SELECCIONADA POR EL USUARIO MEDIANTE CULQUIERA DE LOS TRES BOTONES QUE HAYAN SIDO PRESIONADOS
	private void botonAccion() {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				
				//SI SE PRESIONA EL BOTOM CALCULA TUS PANELES CIERRA LA VENTANA YA BRE LA SIGUIENTE
				if("CALCULA TUS PANELES".equals(accion)) {
					dispose();
					Paneles paneles = new Paneles();
					paneles.setVisible(true);
					paneles.setLocationRelativeTo(null);
				}
				//SI SE PRESIONA EL BOTON CALCULA TU AHORRO CIERRA LA VENTANA YA BRE LA SIGUIENTE
				else if("CALCULA TU AHORRO".equals(accion)) {
					dispose();
					Ahorro ahorro = new Ahorro();
					ahorro.setVisible(true);
					ahorro.setLocationRelativeTo(null);
				}
				//SI SE PRESIONA EL BOTON COTIZA CIERRA LA VENTANA YA BRE LA SIGUIENTE
				else if("COTIZA".equals(accion)) {
					dispose();
					Cotiza cotiza = new Cotiza();
					cotiza.setVisible(true);
					cotiza.setLocationRelativeTo(null);
				}
			}
		};
		//SE AGREGA A LOS BOTONES LAS ACCIONES A REALIZAR CORRESPONDIENTES
		panelesBoton.addActionListener(listener);
		ahorroBoton.addActionListener(listener);
		cotizacionBoton.addActionListener(listener);
	}
	
	//ESTE METODO MANDA A LLAMAR A LOS METODOS DE LA CLASE  INSERTAR DATOS Y E INSERTAR TODOS LOS DATOS CALCULADOS Y GUARDADOS HASTA EL MOMENTO EN LA BASE DE DATOS
	private void botonFinal() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertarDatos ins = new InsertarDatos();
				ins.tablaClientes();
				ins.obtenerIdCliente();
				ins.tablaReciboLuz();
				ins.tablaCalculoPaneles();
				ins.tablaCalculoAhorro();
				ins.tablaCotizacion();
				
				//MUESTRA UN MENSAJE ESTILO POP UP INFORMATIVO
				JOptionPane.showMessageDialog(Escoger, "DATOS ALMACENADOS CORRECTAMENTE \n GRACIAS POR CONFIAR EN SOLARIO");
				dispose();
			}
		};
		//SE AGREGA AL BOTON LAS ACCIONES A REALIZAR CORRESPONDIENTES
		finalBoton.addActionListener(listener);
	}
	//ESTE METODO UNICAMENTE CIERRA EL PROGRAMA
	private void botonSalir() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MENSAJE ESTILO POP UP INFORMATIVO
				JOptionPane.showMessageDialog(Escoger, "SESION CERRADA");
				//CIERRA LA VENTANA
				dispose();
			}
		};
		//SE AGREGA AL BOTON LAS ACCIONES A REALIZAR CORRESPONDIENTES
		salirBoton.addActionListener(listener);
	}
	
}
