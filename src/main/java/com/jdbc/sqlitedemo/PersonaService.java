package com.jdbc.sqlitedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonaService {

    @Autowired
    private PersonaRepositorio personaRepository;

    public List<Persona> listarClientes() {
        List<Persona> listasPersonas= personaRepository.findAll();
        log.info("Lista de personas: {}", listasPersonas);
        return listasPersonas;
    }


}
