package com.gm.jdbc.service;

import com.gm.jdbc.models.entity.PersonaEntity;
import com.gm.jdbc.models.model.Persona;

import java.util.Optional;

public interface IPersonaService {
    Iterable<PersonaEntity>findall();

    PersonaEntity save (PersonaEntity persona);

    Optional<PersonaEntity> findById(int idPersona);

    void deleteById (int idPersona);


}
