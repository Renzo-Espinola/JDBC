import java.sql.*;

import static java.lang.Class.forName;

public class TestMySqlJDBC {
    public static void main(String[] args) {
        var url = "jdbc:sqlite:/C:/Users/renzo/Desktop/db/sample.db";
        try {
            //Class.forName("org.sqlite.JDBC");
            Connection conexion = DriverManager.getConnection(url);
            Statement instruccion = conexion.createStatement();
            var sql ="SELECT id_persona, nombre, apellido, email, telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()){
                System.out.print("id_persona: "+ resultado.getInt("id_persona"));
                System.out.print(" Nombre: "+ resultado.getString("nombre"));
                System.out.print(" Apellido: " + resultado.getString("apellido"));
                System.out.print(" Email: "+ resultado.getString("email"));
                System.out.print(" Telefono: "+ resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        /*} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        }
    }
}
