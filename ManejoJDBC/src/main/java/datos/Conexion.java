package datos;

import java.sql.*;

public class Conexion {
 private static final String JDBC_URL= "jdbc:sqlite:/C:/Users/renzo/Desktop/db/sample.db";
 private static final String JDBC_USER = "";
 private static final String JDBC_PASSWORD = "";

 public static Connection getConnection() throws SQLException {
     return DriverManager.getConnection(JDBC_URL);

 }
public static void close (ResultSet rs) throws SQLException {
     rs.close();
}
public static void close (Statement smtm) throws SQLException {
     smtm.close();
}
public static void close (PreparedStatement smtm) throws SQLException {
        smtm.close();
    }
    public static void close (Connection conn) throws SQLException {
     conn.close();
    }

}
