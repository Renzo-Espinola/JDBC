package com.gm.jdbc.models.repositories;
import com.gm.jdbc.models.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface PersonaRepositories extends CrudRepository<PersonaEntity,Integer> {

    }

   /* private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";


    public List<Persona> seleccionar() {
        Conexion conn = new Conexion();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conn.getConnection();
            stmt = conn.connect.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                //de la info obtenida de la base de com.gm.jdbc.config.datos creamos el objeto persona
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {

            try {
                close(rs);
                close(stmt);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }


        }
        return personas;
    }

    public int insertar(Persona persona) {

        Conexion conn = new Conexion();
        PreparedStatement stmt = null;

        int registros = 0;
        try {
            conn.getConnection();
            stmt = conn.connect.prepareStatement(SQL_INSERT);

            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            //update para modificar el estado de la base de com.gm.jdbc.config.datos

            stmt.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int update(Persona persona) {
       Conexion conn = new Conexion();
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn.getConnection();
            stmt = conn.connect.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5,persona.getIdPersona());
            registros= stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                conn.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }

            return registros;
        }

    }
    public int delete(Persona persona){
        Conexion conn = new Conexion();
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn.getConnection();
            stmt = conn.connect.prepareStatement(SQL_DELETE);
            stmt.setInt(1,persona.getIdPersona());
            registros=stmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
      finally {

            try {
                close(stmt);
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
    return registros;
    }*/
