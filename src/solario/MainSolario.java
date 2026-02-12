package solario;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


public class MainSolario {

	public static void main(String[] args) {

		//INICIALIZA LA VENTANA "LOGIN" ES LA UNICA NECESARIO YA QUE A PARTIR DE ELLA SALEN LAS DEMAS VENTANAS Y SE EJECUTA TODO EL PROGRAMA
		//SE EJECUTA MEDIANTE UN TRY CATCH QUE MUESTRA UN MENSAJE DE ERROR EN CASO DE NO PODERSE EJECUTAR
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login login = new Login();
						login.setVisible(true);
						login.setLocationRelativeTo(null);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	}
}
