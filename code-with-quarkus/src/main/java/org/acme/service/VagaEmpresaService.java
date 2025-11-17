package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_VAGA_EMPRESA;
import org.acme.repository.T_VAGA_EMPRESA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class VagaEmpresaService {

    @Inject
    T_VAGA_EMPRESA_REPOSITORY vagaEmpresaRepository;

    public List<T_VAGA_EMPRESA> listarVagasDasEmpresas() throws SQLException {

        return vagaEmpresaRepository.listarVagasDasEmpresas();
    }

}
