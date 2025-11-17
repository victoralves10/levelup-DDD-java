package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_EMPRESA;
import org.acme.repository.T_EMPRESA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class EmpresaService {

    @Inject
    T_EMPRESA_REPOSITORY empresaRepository;

    public List<T_EMPRESA> listarEmpresas () throws SQLException {


        return empresaRepository.listarEmpresas();
    }

}
