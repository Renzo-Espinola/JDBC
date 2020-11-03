import datos.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
       //Insertar un nuevo objeto de tipo Persona
        Persona personaNueva = new Persona("renzo","Espinola", "AtheEspinola@gmail.com", "44706");
        personaDao.insertar(personaNueva);

        //Persona personaMod = new Persona(7,"Tatiana","Rios", "tati@gmail.com", "44706");
        //personaDao.update(personaMod);

        //Persona personaDel = new Persona(6);
       //personaDao.delete(personaDel);

        List<Persona> personas=personaDao.seleccionar();
        //funcion lambda
        personas.forEach (persona -> {
            System.out.println("Persona = " + persona);
        });
    }

}
