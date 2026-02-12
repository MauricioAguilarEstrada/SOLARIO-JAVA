package solario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import javax.swing.DropMode;

public class Login extends JFrame {
	
	//SE DECLARA LA VARIABLE idEmpleado COMO ESTATICA PARA MANDARLA A LLAMAR DESTE OTRAS CLASES
	private static int idEmpleado;
	//SE ESTABLECE EL GETTER
	public int getIdEmpleado() {
		return idEmpleado;
	}

	//SE DECLARAN LAS VARIABLES DE LA LIBRERIA SWING
	private static final long serialVersionUID = 1L;
	private JPanel contentPane, loginPanel;
	private JLabel bienvenidoLabel, usuarioLabel, passwordLabel,logoLabel;
	private JPasswordField passwordField;
	private JTextField usuarioField;
	private JTextArea advUsuarioArea, advPasswordArea;
	private JTextArea sesionExitosaArea;
	private JButton loginBoton;

	//SE INICIALIZA EL PANEL CON TODOS LOS METODOS 
	//SE INSERTA LA IMAGEN DE LA VENTANA DESDE LA RUTA ESTABLECIDA
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		setTitle("SOLARIO");
		inicializarVentana();
		crearLogin();
		eventoBoton();
	}
	
	//SE INICIALIZA LA VENTANA CON SUS MEDIDAS
	private void inicializarVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	//SE INICIALIZAN TODOS LAS VARIABLES DE SWING 
	private void crearLogin() {
		//PANEL
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(245, 243, 231));
		loginPanel.setBounds(0, 0, 386, 313);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		//LABELS O ETIQUETAS DE TEXTO
		bienvenidoLabel = new JLabel("BIENVENIDO");
		bienvenidoLabel.setBounds(38, 38, 220, 40);
		bienvenidoLabel.setBackground(new Color(46, 46, 46));
		bienvenidoLabel.setFont(new Font("Arial Black", Font.PLAIN, 30));
		loginPanel.add(bienvenidoLabel);
		
		usuarioLabel = new JLabel("USUARIO");
		usuarioLabel.setForeground(new Color(46, 46, 46));
		usuarioLabel.setBounds(38, 120, 90, 20);
		usuarioLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		loginPanel.add(usuarioLabel);

		
		passwordLabel = new JLabel("CONTRASEÑA");
		passwordLabel.setForeground(new Color(46, 46, 46));
		passwordLabel.setBounds(38, 180, 130, 20);
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		loginPanel.add(passwordLabel);
		
		logoLabel = new JLabel("New label");
		logoLabel.setBounds(296, 28, 50, 50);
		logoLabel.setIcon(new ImageIcon("C:\\Users\\aemau\\eclipse-workspace\\SOLARIO\\LOGO 50.png"));
		loginPanel.add(logoLabel);
		
		//CAMPOS DE TEXTO RELLENABLES
		usuarioField = new JTextField();
		usuarioField.setFont(new Font("Arial", Font.PLAIN, 12));
		usuarioField.setBounds(206, 120, 120, 20);
		usuarioField.setBackground(new Color(245, 245, 245));
		loginPanel.add(usuarioField);
		usuarioField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
		passwordField.setBounds(206, 180, 120, 20);
		passwordField.setBackground(new Color(245, 245, 245));
		loginPanel.add(passwordField);
		
		//BOTONES
		loginBoton = new JButton("LOGIN");
		loginBoton.setForeground(new Color(46, 46, 46));
		loginBoton.setBackground(new Color(255, 214, 10));
		loginBoton.setBounds(150, 240, 85, 25);
		loginBoton.setFont(new Font("Arial", Font.BOLD, 15));
		loginPanel.add(loginBoton);
		
		
		//AREAS DE TEXTO
		//EL COMANDO SETFOCUSABLE AL ESTAR EN FALSE PERIMTE QUE NO SEA INTERACTUABLE POR EL USUARIO
		advUsuarioArea = new JTextArea();
		advUsuarioArea.setBackground(new Color(245, 243, 231));
		advUsuarioArea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 8));
		advUsuarioArea.setEditable(false);
		advUsuarioArea.setBounds(206, 140, 120, 20);
		advUsuarioArea.setForeground(new Color(255, 0, 0));
		advUsuarioArea.setFocusable(false);
		loginPanel.add(advUsuarioArea);
		
		advPasswordArea = new JTextArea();
		advPasswordArea.setBackground(new Color(245, 243, 231));
		advPasswordArea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 8));
		advPasswordArea.setEditable(false);
		advPasswordArea.setBounds(206, 200, 120, 20);
		advPasswordArea.setForeground(new Color(255, 0, 0));
		advPasswordArea.setFocusable(false);
		loginPanel.add(advPasswordArea);
		
		sesionExitosaArea = new JTextArea();
		sesionExitosaArea.setBackground(new Color(245, 243, 231));
		sesionExitosaArea.setText(" ");
		sesionExitosaArea.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		sesionExitosaArea.setBounds(93, 275, 200, 30);
		sesionExitosaArea.setForeground(new Color(255, 0, 0));
		sesionExitosaArea.setFocusable(false);
		loginPanel.add(sesionExitosaArea);
	}
	
	
	//ESTE METODO PERMITE REALIZAR EL "LOGIN' MEDIANTE LA INICIALIZACION DEL METODO "LOGUEARSE"
	private void eventoBoton() {
		//SE INSTANCIA EL OBJETO QUE PERMITIRA AL BOTON REALIZAR LA ACCION
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accion = e.getActionCommand();
				if ("LOGIN".equals(accion)) {
					loguearse();
				}
			}
			
		};
		loginBoton.addActionListener(listener);
	}
	
	//ESTE METODO ES EL QUE VERIFICA QUE TODOS LOS DATOS INGRESADOS POR EL USUARIO SEAN CORRECTOS
	private void loguearse() {
		//VARIABLES LOCALES DECLARADAS PARA EL FUNCIONAMIENTO DEL METODO 
		String usuario = usuarioField.getText();
		String password = new String(passwordField.getPassword());
		
		//VERIFICA QUE LOS CAMPOS DE LAS CREDENCIALES NO ESTEN VACIOS
		if (usuario.isEmpty() && password.isEmpty()) {
			advUsuarioArea.setText("INGRESE UN USUARIO");
			advPasswordArea.setText("INGRESE UNA CONTRASEÑA");
			return;
		}
		else if (usuario.isEmpty()) {
			advUsuarioArea.setText("INGRESE UN USUARIO");
			return;
		}
		else if(password.isEmpty()) {
			advPasswordArea.setText("INGRESE UNA CONTRASEÑA");
			return;
		}
		
		//VERIFICA CON LA BASE DE DATOS SI LAS CREDENCIALES INGRESADAS EXISTEN EN LA MISMA
        try (Connection conn = ConexionBD.conectar()) {
        	//COMANDO DE MYSQL QUE VERIFICA LOS VALORES
            String sql = "SELECT * FROM solariodata.empleados WHERE nombre = ? AND contraseña = ?";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            // EN CASO DE QUE SI EXISTAN GUARDA EL VALOR DE EL ID DEL EMPLEADO PARA UTILIZARLO DESPUES POR LAS DEMAS INSERCIONES DE DATOS
            if (rs.next()) {
                String idE = "SELECT id_empleado FROM solario.empleados WHERE nombre = ?";
                try (Connection conn2 = ConexionBD.conectar();
                	     java.sql.PreparedStatement stmt2 = conn2.prepareStatement(idE)) {

                	    stmt2.setString(1, usuario);

                	    ResultSet rs2 = stmt2.executeQuery();

                	    if (rs2.next()) {
                	        idEmpleado = rs2.getInt("id_empleado");
                	    } 
                	} catch (Exception e) {
                	    e.printStackTrace();
                	}
                //CIERRA LA VENTANA E INSTANCIA EL OBJETO DE LA CLASE DATOS USUARIO PARA ABRIR LA SIGUIENTE VENTANA
            	dispose();
            	DatosUsuario datos = new DatosUsuario();
            	datos.setVisible(true);
            	datos.setLocationRelativeTo(null);
            } 
            //SI LAS CREDENCIALE NO EXISTEN O SON INCORRECTAS SALTA EL SIGUIENTE MENSAJE Y BORRA TODOS LOS CAMPOS
            else {
                sesionExitosaArea.setText("CREDENCIALES INCORRECTAS");
                usuarioField.setText("");
                passwordField.setText("");
                advUsuarioArea.setText("");
                advPasswordArea.setText("");
            }
        //EN DADO CASO DE QUE NO EXISTA UNA CONEXION CON LA BASE DE DATOS SALTA EL SIGUIENTE MENSAJE
        } catch (Exception e) {
            e.printStackTrace();
            sesionExitosaArea.setText("Error al conectar a la base de datos.");
        }
	}
}
