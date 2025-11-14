package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_PESSOA;
import org.acme.repository.T_PESSOA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @Inject
    T_PESSOA_REPOSITORY pessoaRepository;

    public List<T_PESSOA> listarGeral() throws SQLException {

        return pessoaRepository.listarGeral();
    }
}
