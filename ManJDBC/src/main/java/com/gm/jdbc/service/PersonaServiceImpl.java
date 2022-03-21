package com.gm.jdbc.service;

import com.gm.jdbc.models.entity.PersonaEntity;
import com.gm.jdbc.models.repositories.PersonaRepositories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class PersonaServiceImpl implements IPersonaService {
    @Autowired
    private PersonaRepositories personaRepository;


    @Override
    @Transactional (readOnly = true)
    public Iterable<PersonaEntity> findall() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaEntity save(PersonaEntity persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Optional<PersonaEntity> findById(int idPersona) {
        return personaRepository.findById(idPersona);
    }

    @Override
    public void deleteById(int idPersona) {
     personaRepository.deleteById(idPersona);

    }


}


  /*public List<PersonaEntity> listarPersonas() {
        List<PersonaEntity> listaPersonaEntities = personaRepository.findAll();
        log.info("lista de personas: {}", listaPersonaEntities);
        return listaPersonaEntities;
    }
    public void crearPersona(){
        personaRepository.*/