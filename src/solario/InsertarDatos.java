package solario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertarDatos {
	//SE DECALARAN LAS VARIABLES QUE SE VAN A INSERTAR EN LAS TABLAS, LA MAYORIA SE INICIALIZAN EN 0O EN " " 
	//EN CASO DE QUE LA OPCION QUE OBTIENE ESTOS DATOS NO SE REALIZE Y AL MOMENTO DE GUARDARLO EN LA BASE DE DATOS 
	//SE GUARDEN DE MANERA CORRECTA Y NO HAYA UN DESFASE CON LOS IDENTIFICADORES DE CADA TABLA
	private int idEmpleado;
	private String nombre = "";
	private String apellidoPat = "";
	private String apellidoMat = "";
	private String correo = "";
	private String telefono = "";
	private double consumoAnual = 0;
	private int idCliente;
	private int idPanel;
	private double consumoBimestral = 0;
	private int panelesCalculados = 0;
	
	private double panelesAhorro = 0;
	private double consumoAnualAhorro = 0;
	private double consumoBimestralAhorro = 0;
	private double generacionBimestralPromedio = 0;
	private double generacionDiariaPromedio = 0;
	private double porcentajeAhorro = 0;
	private double ahorroDiario = 0;
	private double ahorroBimestral = 0;
	private double ahorroAnual = 0;
	
	private int precioPaneles;
	private int panelesCotiza;
	private int instalacion;
	private int total;
	
	//SE INSTACIAN TODOS LOS OBJETOS PARA PODER OBTENER LOS VALORES QUE SE GUARDARAN EN LAS TABLAS
	Login login = new Login();
	DatosUsuario datos = new DatosUsuario();
	Paneles paneles = new Paneles();
	Ahorro ahorro = new Ahorro();
	Cotiza cotiza = new Cotiza();
	
	//SE INSERTAN LOS DATOS EN LA TABLA CLIENTES
	public void tablaClientes() {
		//SE OBTIENEN Y SE GUARDAN LOS DATOS
		idEmpleado = login.getIdEmpleado();
		nombre = datos.getNombre();
		apellidoPat = datos.getApellidoPat();
		apellidoMat = datos.getApellidoMat();
		correo = datos.getCorreo();
		telefono = datos.getTelefono();
		//SE HACE LA CONEXION CON LA BASE DE DATOS 
		try (Connection t1 = ConexionBD.conectar()) {
			//COMANDO QUE INSERTA LOS DATOS NE LA TABLA CORRESPONDIENTE
			String tablaClientes = "INSERT INTO solariodata.clientes (id_empleado, nombre, apellido_pat, apellido_mat, correo, telefono) VALUES (?, ?, ?, ?, ?, ?)";
			//SE INSTANCIA EL OBJETO QUE PERMITE ASIGNAR LOS VALORES INSERTADOS EN LA TABLA
			PreparedStatement tCli = t1.prepareStatement(tablaClientes);
	    
			//SE LE ASIGNA LOS VALORES A LOA PARAMATROS DE LA TABLA
			tCli.setInt(1, idEmpleado); 
			tCli.setString(2, nombre);
			tCli.setString(3, apellidoPat);
			tCli.setString(4, apellidoMat);
			tCli.setString(5, correo);
			tCli.setString(6, telefono);
			int filasInsertadas = tCli.executeUpdate();
			
			//VERIFICA QUE LA INSERCION DE DATOS HAYA SIDO EXITOSA
			if (filasInsertadas > 0) {
				System.out.println("¡Registro insertado correctamente!");
			} else {
				System.out.println("No se insertó ningún registro.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//SE OBTIENE EL ID DEL CLIENTE 
	public void obtenerIdCliente() {
		
		try(Connection t1 = ConexionBD.conectar()){
			//COMANDO QUE OBTIENE EL VALOR DE LA ID A PARTIR DE LAS SIGUIENTES DATOS
			String idCli = "SELECT id_cliente FROM solariodata.clientes WHERE nombre = ? AND apellido_pat = ? AND apellido_mat = ? AND correo = ? AND telefono = ?";
			//SE INSTANCIA EL OBJETO QUE PERMITE ASIGNAR LOS VALORES INSERTADOS EN LA TABLA
			PreparedStatement stmtCli = t1.prepareStatement(idCli);
			
			//SE LE ASIGNA LOS VALORES A LOA PARAMATROS DE LA TABLA
			stmtCli.setString(1, nombre);
			stmtCli.setString(2, apellidoPat);
			stmtCli.setString(3, apellidoMat);
			stmtCli.setString(4, correo);
			stmtCli.setString(5, telefono);
			//SE GUARDA EL VALOR DEL ID DEL CLIENTE
			ResultSet id = stmtCli.executeQuery();
			if(id.next()) {
				idCliente = id.getInt("id_cliente");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//SE INSERTAN LOS DATOS EN LA TABLA RECIBO DE LUZ
	public void tablaReciboLuz() {
		//SE OBTIENEN Y SE GUARDAN LOS DATOS
		consumoAnual = datos.getConsumoAnual();
		//SE HACE LA CONEXION CON LA BASE DE DATOS 
		try(Connection t2 = ConexionBD.conectar()){
			//COMANDO QUE INSERTA LOS DATOS NE LA TABLA CORRESPONDIENTE
			String tablaReciboLuz = "INSERT INTO solariodata.recibo_luz (id_cliente, consumo_kwh_anual) VALUES (?, ?)";
			//SE INSTANCIA EL OBJETO QUE PERMITE ASIGNAR LOS VALORES INSERTADOS EN LA TABLA
			PreparedStatement tReci = t2.prepareStatement(tablaReciboLuz);
			//SE LE ASIGNA LOS VALORES A LOA PARAMATROS DE LA TABLA
			tReci.setInt(1, idCliente);
			tReci.setDouble(2, consumoAnual);
			
			int filasInsertadas = tReci.executeUpdate();
			//VERIFICA QUE LA INSERCION DE DATOS HAYA SIDO EXITOSA
			if (filasInsertadas > 0) {
				System.out.println("¡Registro insertado correctamente!");
			} else {
				System.out.println("No se insertó ningún registro.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void tablaCalculoPaneles() {
		//SE OBTIENEN Y SE GUARDAN LOS DATOS
		consumoBimestral = paneles.getConsumoBimestral();
		panelesCalculados = paneles.getPanelesCalculados();
		idPanel = paneles.getIdPanel();
		//COMANDO QUE INSERTA LOS DATOS NE LA TABLA CORRESPONDIENTE
		try(Connection t3 = ConexionBD.conectar()){
			String tablaCalculoPaneles = "INSERT INTO solariodata.calculo_paneles (id_cliente, id_panel, cantidad_paneles_calculados) VALUES (?, ?, ?)";
			//SE INSTANCIA EL OBJETO QUE PERMITE ASIGNAR LOS VALORES INSERTADOS EN LA TABLA
			PreparedStatement tCPan = t3.prepareStatement(tablaCalculoPaneles);
			//SE LE ASIGNA LOS VALORES A LOA PARAMATROS DE LA TABLA
			tCPan.setInt(1, idCliente);
			tCPan.setInt(2, idPanel);
			tCPan.setInt(3, panelesCalculados);
			
			int filasInsertadas = tCPan.executeUpdate();
			//VERIFICA QUE LA INSERCION DE DATOS HAYA SIDO EXITOSA
			if (filasInsertadas > 0) {
				System.out.println("¡Registro insertado correctamente!");
			} else {
				System.out.println("No se insertó ningún registro.");
			}
			
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void tablaCalculoAhorro() {
		//SE OBTIENEN Y SE GUARDAN LOS DATOS
		consumoAnualAhorro = ahorro.getConsumoAnual();
		panelesAhorro = ahorro.getNumeroPaneles();
		consumoBimestralAhorro = ahorro.getConsumoBimestral();
		generacionBimestralPromedio = ahorro.getGeneracionBimestralPromedio();
		generacionDiariaPromedio = ahorro.getGeneracionDiariaPromedio();
		porcentajeAhorro = ahorro.getPorcentajeAhorro();
		ahorroDiario = ahorro.getAhorroDiario();
		ahorroBimestral = ahorro.getAhorroBimestral();
		ahorroAnual = ahorro.getAhorroAnual();
		//COMANDO QUE INSERTA LOS DATOS NE LA TABLA CORRESPONDIENTE
		try(Connection t4 = ConexionBD.conectar()){
			String tablaCalculoAhorro = "INSERT INTO solariodata.calculo_ahorro (id_cliente, id_recibo, id_panel, consumo_kwh_anual, num_paneles, consumo_bimestral_prom, generacion_prom_bimestral, generacion_prom_diaria, porcentaje_ahorro, ahorro_diario, ahorro_bimestral, ahorro_anual) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			//SE INSTANCIA EL OBJETO QUE PERMITE ASIGNAR LOS VALORES INSERTADOS EN LA TABLA
			PreparedStatement tCAho = t4.prepareStatement(tablaCalculoAhorro);
			//SE LE ASIGNA LOS VALORES A LOA PARAMATROS DE LA TABLA
			tCAho.setDouble(1, idCliente);
			tCAho.setDouble(2, idCliente);
			tCAho.setDouble(3, idPanel);
			tCAho.setDouble(4, consumoAnualAhorro);
			tCAho.setDouble(5, panelesAhorro);
			tCAho.setDouble(6, consumoBimestralAhorro);
			tCAho.setDouble(7, generacionBimestralPromedio);
			tCAho.setDouble(8, generacionDiariaPromedio);
			tCAho.setDouble(9, porcentajeAhorro);
			tCAho.setDouble(10, ahorroDiario);
			tCAho.setDouble(11, ahorroBimestral);
			tCAho.setDouble(12, ahorroAnual);
			
			int filasInsertadas = tCAho.executeUpdate();
			//VERIFICA QUE LA INSERCION DE DATOS HAYA SIDO EXITOSA
			if (filasInsertadas > 0) {
				System.out.println("¡Registro insertado correctamente!");
			} else {
				System.out.println("No se insertó ningún registro.");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void tablaCotizacion() {
		//SE OBTIENEN Y SE GUARDAN LOS DATOS
		precioPaneles = cotiza.getPrecioPaneles();
		panelesCotiza = cotiza.getNumeroPaneles();
		instalacion = cotiza.getInstalacion();
		total = cotiza.getTotal();
		//COMANDO QUE INSERTA LOS DATOS NE LA TABLA CORRESPONDIENTE
		try(Connection t5 = ConexionBD.conectar()){
			String tablaCotizacion = "INSERT INTO solariodata.cotizacion (id_cliente, precio_paneles, num_paneles, costo_instalacion, total) VALUES (?, ?, ?, ?, ?)";
			//SE INSTANCIA EL OBJETO QUE PERMITE ASIGNAR LOS VALORES INSERTADOS EN LA TABLA
			PreparedStatement tCCot =t5.prepareStatement(tablaCotizacion);
			//SE LE ASIGNA LOS VALORES A LOA PARAMATROS DE LA TABLA
			tCCot.setInt(1, idCliente);
			tCCot.setInt(2, precioPaneles);
			tCCot.setInt(3, panelesCotiza);
			tCCot.setInt(4, instalacion);
			tCCot.setInt(5, total);
			
			int filasInsertadas = tCCot.executeUpdate();
			//VERIFICA QUE LA INSERCION DE DATOS HAYA SIDO EXITOSA
			if (filasInsertadas > 0) {
				System.out.println("¡Registro insertado correctamente!");
			} else {
				System.out.println("No se insertó ningún registro.");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
