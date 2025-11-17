package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_ENDERECO;
import org.acme.repository.T_ENDERECO_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class EnderecoService {

    @Inject
    T_ENDERECO_REPOSITORY enderecoRepository;

    public List<T_ENDERECO> listarEnderecos() throws SQLException {

        return enderecoRepository.listarEnderecos();
    }
}
