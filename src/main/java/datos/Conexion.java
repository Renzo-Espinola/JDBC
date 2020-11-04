package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
     private static final String JDBC_URL= ("jdbc:sqlite:" + Conexion.class.getClassLoader().getResource("sample.db"));
     private static final String JDBC_USER = "";
     private static final String JDBC_PASSWORD = "";

    Connection connect;

    public Connection getConnect() {
        try {
            connect = DriverManager.getConnection(JDBC_URL);
            if (connect!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
        return connect;
    }
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
