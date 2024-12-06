
package logica;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Conexion_BaseDatos {
     // Declaramos la conexion a mysql
    private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/departamento";
    // Funcion que va conectarse a mi bd de mysql
    public void conexion() {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
               System.out.println("se logro");
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("no se logro");
        }
    } 
    
    public boolean verificarUsuario(String usuarioIngresado, String contrasenaIngresada) {
        con = null;
        boolean credencialesValidas = false; 

        try {
 
            Class.forName(driver);

            con = (Connection) DriverManager.getConnection(url, user, pass);

            if (con != null) {
                String query = "SELECT * FROM docente WHERE email = '" + usuarioIngresado + "' AND contrasena = '" + contrasenaIngresada + "'";

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    credencialesValidas = true;
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return credencialesValidas; 
    }
}
