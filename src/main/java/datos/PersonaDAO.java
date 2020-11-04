package datos;

import domain.Persona;

import java.sql.*;
import java.util.*;

import static datos.Conexion.*;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";

    private Connection conn;

    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    private Conexion conexion= new Conexion();


    public List<Persona> seleccionar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn = conexion.getConnect();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                //de la info obtenida de la base de datos creamos el objeto persona
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
                conexion.close();
        }
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = conexion.getConnect();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            //update para modificar el estado de la base de datos
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            conexion.close();
        }
        return registros;
    }

    public int update(Persona persona) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = conexion.getConnect();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            registros= stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            conexion.close();
            return registros;
        }

    }
    public void delete(Persona persona){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexion.getConnect();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            stmt.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
      finally {
            conexion.close();
        }

    }
}
