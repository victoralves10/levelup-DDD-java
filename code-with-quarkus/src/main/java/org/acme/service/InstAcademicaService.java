package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_INST_ACADEMICA;
import org.acme.repository.T_INST_ACADEMICA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class InstAcademicaService {

    @Inject
    T_INST_ACADEMICA_REPOSITORY instAcademicaRepository;

    public List<T_INST_ACADEMICA> listarInstAcademicas()throws SQLException {

        return instAcademicaRepository.listarInstAcademicas();
    }

}
