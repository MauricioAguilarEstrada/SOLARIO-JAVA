package solario;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class DatosUsuario extends JFrame {
	//SE DECLARAN LAS VARIABLES QUE POSTERIORMENTE SERAN MODIFICADAS
	private static final long serialVersionUID = 1L;
	private static String nombre, apellidoPat, apellidoMat, correo;
	private static String telefono;
	private static double consumoAnual;
	
	//SE ESTABLECEN LOS GETTERS
	public String getNombre() {
		return nombre;
	}
	public String getApellidoPat() {
		return apellidoPat;
	}
	public String getApellidoMat() {
		return apellidoMat;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public double getConsumoAnual() {
		return consumoAnual;
	}
	
	//SE DECLARAN LAS VARIABLES DE LA LIBRERIA SWING
	private JPanel Clientes;
	private JButton atrasBoton, clienteBoton;
	private JLabel nombreLabel, apellidoPatLabel, apellidoMatLabel, correoLabel, telefonoLabel;
	private JTextField nombreField, apellidoPatField, apellidoMatField, correoField, telefonoField;
	private JTextArea nombreArea, correoArea, telefonoArea;
	private JLabel nombreObliLabel;
	private JLabel correoObliLabel;
	private JLabel tituloLabel;
	private JLabel telefonoObliLabel;
	private JLabel consumoLabel;
	private JTextField consumoField;
	private JTextArea consumoArea;
	private JLabel consumoObliLabel;

	
	//SE INICIALIZA EL PANEL CON TODOS LOS METODOS 
	//SE INSERTA LA IMAGEN DE LA VENTANA DESDE LA RUTA ESTABLECIDA
	public DatosUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		setBackground(new Color(255, 255, 255));
		inicializarVentana();
		crearDatos();
		botonAtras();
		clienteBoton();
	}
	
	//SE INICIALIZA LA VENTANA CON SUS MEDIDAS
	private void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 450);
		Clientes = new JPanel();
		Clientes.setBackground(new Color(245, 243, 231));
		Clientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Clientes);
		
	}
	
	//SE INICIALIZAN TODOS LAS VARIABLES DE SWING 
	private void crearDatos() {
		Clientes.setLayout(null);
		//BOTONES
		atrasBoton = new JButton("");
		atrasBoton.setIcon(new ImageIcon("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\botonregresar.png"));
		atrasBoton.setBounds(10, 10, 32, 32);
		atrasBoton.setBackground(new Color(245, 243, 231));
		atrasBoton.setBorder(null);
		Clientes.add(atrasBoton);
		
		clienteBoton = new JButton("AGREGAR CLIENTE");
		clienteBoton.setForeground(new Color(46, 46, 46));
		clienteBoton.setFont(new Font("Arial", Font.BOLD, 12));
		clienteBoton.setBackground(new Color(255, 214, 10));
		clienteBoton.setBounds(98, 360, 150, 30);
		Clientes.add(clienteBoton);
		
		//LABELS O ETIQUETAS
		nombreLabel = new JLabel("NOMBRE");
		nombreLabel.setForeground(new Color(46, 46, 46));
		nombreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreLabel.setBounds(40, 100, 65, 20);
		Clientes.add(nombreLabel);
		
		apellidoPatLabel = new JLabel("APELLIDO \r\nPATERNO");
		apellidoPatLabel.setForeground(new Color(46, 46, 46));
		apellidoPatLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		apellidoPatLabel.setBounds(40, 140, 145, 20);
		Clientes.add(apellidoPatLabel);
		
		apellidoMatLabel = new JLabel("APELLIDO MATERNO");
		apellidoMatLabel.setForeground(new Color(46, 46, 46));
		apellidoMatLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		apellidoMatLabel.setBounds(40, 180, 145, 20);
		Clientes.add(apellidoMatLabel);
		
		correoLabel = new JLabel("CORREO");
		correoLabel.setForeground(new Color(46, 46, 46));
		correoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		correoLabel.setBounds(40, 220, 65, 20);
		Clientes.add(correoLabel);
		
		telefonoLabel = new JLabel("TELEFONO (10)");
		telefonoLabel.setForeground(new Color(46, 46, 46));
		telefonoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		telefonoLabel.setBounds(40, 260, 110, 20);
		Clientes.add(telefonoLabel);
		
		nombreObliLabel = new JLabel("*");
		nombreObliLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		nombreObliLabel.setForeground(new Color(255, 0, 0));
		nombreObliLabel.setBackground(new Color(255, 0, 0));
		nombreObliLabel.setBounds(105, 100, 10, 20);
		Clientes.add(nombreObliLabel);
		
		correoObliLabel = new JLabel("*");
		correoObliLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		correoObliLabel.setForeground(Color.RED);
		correoObliLabel.setBackground(Color.RED);
		correoObliLabel.setBounds(105, 220, 10, 20);
		Clientes.add(correoObliLabel);
		
		tituloLabel = new JLabel("DATOS DEL CLIENTE");
		tituloLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		tituloLabel.setBounds(33, 50, 280, 30);
		Clientes.add(tituloLabel);
		
		telefonoObliLabel = new JLabel("*");
		telefonoObliLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		telefonoObliLabel.setForeground(Color.RED);
		telefonoObliLabel.setBackground(Color.RED);
		telefonoObliLabel.setBounds(155, 261, 10, 20);
		Clientes.add(telefonoObliLabel);
		
		consumoLabel = new JLabel("CONSUMO ANUAL");
		consumoLabel.setForeground(new Color(46, 46, 46));
		consumoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		consumoLabel.setBounds(40, 300, 130, 20);
		Clientes.add(consumoLabel);
		
		consumoObliLabel = new JLabel("*");
		consumoObliLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		consumoObliLabel.setForeground(Color.RED);
		consumoObliLabel.setBackground(Color.RED);
		consumoObliLabel.setBounds(170, 301, 10, 20);
		Clientes.add(consumoObliLabel);
		
		//CAMPOS DE TEXTO RELLENABLES
		nombreField = new JTextField();
		nombreField.setFont(new Font("Arial", Font.PLAIN, 12));
		nombreField.setBounds(210, 100, 100, 20);
		Clientes.add(nombreField);
		nombreField.setColumns(10);
		
		apellidoPatField = new JTextField();
		apellidoPatField.setFont(new Font("Arial", Font.PLAIN, 12));
		apellidoPatField.setBounds(210, 140, 100, 20);
		Clientes.add(apellidoPatField);
		apellidoPatField.setColumns(10);
		
		apellidoMatField = new JTextField();
		apellidoMatField.setFont(new Font("Arial", Font.PLAIN, 12));
		apellidoMatField.setBounds(210, 180, 100, 20);
		Clientes.add(apellidoMatField);
		apellidoMatField.setColumns(10);
		
		correoField = new JTextField();
		correoField.setFont(new Font("Arial", Font.PLAIN, 12));
		correoField.setBounds(210, 220, 100, 20);
		Clientes.add(correoField);
		correoField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setFont(new Font("Arial", Font.PLAIN, 13));
		telefonoField.setBounds(210, 260, 100, 20);
		Clientes.add(telefonoField);
		telefonoField.setColumns(10);
		
		consumoField = new JTextField();
		consumoField.setFont(new Font("Arial", Font.PLAIN, 12));
		consumoField.setColumns(10);
		consumoField.setBounds(210, 300, 100, 20);
		Clientes.add(consumoField);
		
		//AREAS DE TEXTO
		//EL COMANDO SETFOCUSABLE AL ESTAR EN FALSE PERIMTE QUE NO SEA INTERACTUABLE POR EL USUARIO
		nombreArea = new JTextArea();
		nombreArea.setBackground(new Color(245, 243, 231));
		nombreArea.setFont(new Font("Arial", Font.PLAIN, 12));
		nombreArea.setForeground(new Color(255, 0, 0));
		nombreArea.setEditable(false);
		nombreArea.setBounds(211, 120, 100, 20);
		nombreArea.setFocusable(false);
		Clientes.add(nombreArea);
		
		correoArea = new JTextArea();
		correoArea.setBackground(new Color(245, 243, 231));
		correoArea.setForeground(new Color(255, 0, 0));
		correoArea.setFont(new Font("Arial", Font.PLAIN, 12));
		correoArea.setEditable(false);
		correoArea.setBounds(210, 240, 100, 20);
		correoArea.setFocusable(false);
		Clientes.add(correoArea);
		
		telefonoArea = new JTextArea();
		telefonoArea.setForeground(new Color(255, 0, 0));
		telefonoArea.setFont(new Font("Arial", Font.PLAIN, 12));
		telefonoArea.setBackground(new Color(245, 243, 231));
		telefonoArea.setEditable(false);
		telefonoArea.setBounds(210, 280, 100, 20);
		telefonoArea.setFocusable(false);
		Clientes.add(telefonoArea);
		
		consumoArea = new JTextArea();
		consumoArea.setForeground(Color.RED);
		consumoArea.setFont(new Font("Arial", Font.PLAIN, 12));
		consumoArea.setFocusable(false);
		consumoArea.setEditable(false);
		consumoArea.setBackground(new Color(245, 243, 231));
		consumoArea.setBounds(210, 320, 100, 20);
		Clientes.add(consumoArea);
	}
	
	//ESTE METODO PERMITE REGRESAR A LA VENTANA DE LOGIN MEDINATE UN BOTON
	private void botonAtras() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if ("".equals(accion)) {
					//CIERRA LA VENTANA ACTUAL Y ABRE LA REQUERIDA
					dispose();
					Login login = new Login();
					login.setVisible(true);
					login.setLocationRelativeTo(null);
				}
			}
		};
		//SE AGREGA AL BOTON LAS ACCIONES A REALIZAR CORRESPONDIENTES
		atrasBoton.addActionListener(listener);
	}
	
	//ESTE METODO PERMITRE REALIZAR EL METODO INSERTAR DATOS MEDIANTE EL USO DE UN BOTON
	private void clienteBoton() {	
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if ("AGREGAR CLIENTE".equals(accion)) {
					insertarDatos();
				}
			}
		};
		//SE AGREGA AL BOTON LAS ACCIONES A REALIZAR CORRESPONDIENTES
		clienteBoton.addActionListener(listener);
	}
	
	//ESTE METODO GUARDA LOS DATOS DEL CLIENTE EN LAS VARIABLES ANTES DECLARADAS
	private void insertarDatos() {
		nombre = nombreField.getText();
		apellidoPat = apellidoPatField.getText();
		apellidoMat = apellidoMatField.getText();
		correo = correoField.getText();
		telefono = telefonoField.getText();
		//SI EL CAMPO DEL CONSUMO ESTA VACIO RELLENAR EL AREA CONSUMO CON EL MENSAJE "CAMPO OBLIGATORIO"
		String texto = consumoField.getText();
		if (texto.isEmpty()) {
			consumoArea.setText("*Campo obligatorio");
		} else {
			//HACE LA CONVERSION DE TEXTO A DOUBLE
			try {
				consumoAnual = Double.parseDouble(texto);
			} catch (NumberFormatException e) {
				consumoArea.setText("*Solo números válidos");
			}
		}
		
		//VERIFICA QUE LOS VALORES DE LOS CAMPOS OLBIGATORIOS NO SE ENCUENTREN VACIOS 
		if (nombre.isEmpty() && correo.isEmpty() && telefono.isEmpty() && consumoField.getText().isEmpty()) {
			nombreArea.setText("*Campo obligatorio");
			correoArea.setText("*Campo obligatorio");
			telefonoArea.setText("*Campo obligatorio");
			consumoArea.setText("*Campo obligatorio");
		}
		else if(nombre.isEmpty()) {
			nombreArea.setText("*Campo obligatorio");
		}
		else if (correo.isEmpty()) {
			correoArea.setText("*Campo obligatorio");
		}
		else if (telefono.isEmpty()) {
			telefonoArea.setText("*Campo obligatorio");
		}
		else if(consumoField.getText().isEmpty()) {
			consumoArea.setText("*Campo obligatorio");
		}
		//VERIFICA QUE LA LONGITUD DEL NUMERO DEL TELEFONO SEA DE 10 DIGITOS
		else if(telefono.length() != 10) {
			telefonoArea.setText("Numero no valido");
		}
		//CIERRA LA VENTANA Y ABRE LA SIGUIENTE SI LOAS ANTERIORRES CASOS NO SE DIERON
		else {
			dispose();
			Escoger escoger = new Escoger();
			escoger.setVisible(true);
			escoger.setLocationRelativeTo(null);
		}
	}
}
