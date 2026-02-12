package solario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	public static Connection conectar() {
		Connection conexion = null;

		try {
			// Cargar el driver de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Conexión a la base de datos
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/solario?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC",
					"root",
					"" // Contraseña vacía
					);

			System.out.println("Conexión exitosa a la base de datos");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: No se encontró el driver JDBC de MySQL");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
			e.printStackTrace();
		}

		return conexion;
	}

}
