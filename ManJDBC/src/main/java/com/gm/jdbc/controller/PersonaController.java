package com.gm.jdbc.controller;

import com.gm.jdbc.models.entity.PersonaEntity;
import com.gm.jdbc.models.model.Persona;
import com.gm.jdbc.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@RestController
@RequestMapping("/Api Personas")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;


    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok().body(personaService.findall());
    }


    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PersonaEntity persona) {
        PersonaEntity personadb=personaService.save(persona);
        return  ResponseEntity.status(HttpStatus.CREATED).body(personadb);

    }

   @GetMapping("/{idPersona}")
   public ResponseEntity<?> buscarIdPersona(@PathVariable int idPersona) {
       Optional<PersonaEntity> persona = personaService.findById(idPersona);
            if (persona.isEmpty()){
             return ResponseEntity.notFound().build();

            }
       return ResponseEntity.ok(persona.get());
   }

   @PutMapping("/{idPersona}")
   public  ResponseEntity<?> editarPersona(@RequestBody PersonaEntity persona,@PathVariable int idPersona) {
       Optional<PersonaEntity> p1 = personaService.findById(idPersona);
       if(p1.isEmpty()){
           return ResponseEntity.notFound().build();
       }
       PersonaEntity personaDb = p1.get();
       personaDb.setNombre(persona.getNombre());
       personaDb.setApellido(persona.getApellido());
       personaDb.setEmail(persona.getEmail());
       personaDb.setTelefono(persona.getTelefono());
       return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(personaDb));
   }

   @DeleteMapping("/{idPersona}")
    public ResponseEntity<?> eliminarPersona(@PathVariable int idPersona){
        personaService.deleteById(idPersona);
        return ResponseEntity.noContent().build();
   }


}