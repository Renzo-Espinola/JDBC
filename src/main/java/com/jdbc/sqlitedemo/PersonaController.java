package com.jdbc.sqlitedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;
    @RequestMapping("/listarPersonas")
    public List<Persona> index() {
        return personaService.listarClientes();
    }
}

