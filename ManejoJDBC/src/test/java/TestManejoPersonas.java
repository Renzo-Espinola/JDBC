import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        List<Persona> personas=personaDao.seleccionar();
        //funcion lambda
        personas.forEach (persona -> {
            System.out.println("Persona = " + persona);
        });

    }

}
