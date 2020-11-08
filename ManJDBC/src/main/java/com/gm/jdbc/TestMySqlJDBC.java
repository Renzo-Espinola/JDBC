package com.gm.jdbc;

import com.gm.jdbc.models.entity.PersonaEntity;
import com.gm.jdbc.models.model.Persona;
import com.gm.jdbc.service.IPersonaService;
import com.gm.jdbc.service.PersonaServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Class.forName;

@SpringBootApplication
public class TestMySqlJDBC {
    public static void main(String[] args) {
        SpringApplication.run(TestMySqlJDBC.class,args);

    }
}
