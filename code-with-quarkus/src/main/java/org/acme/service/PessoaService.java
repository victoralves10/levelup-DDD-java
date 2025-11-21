package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.PessoaCadastro;
import org.acme.model.T_PESSOA;
import org.acme.repository.T_INST_ACADEMICA_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository.T_PESSOA_REPOSITORY;
import org.acme.repository_intermediario.Cadastro_Pessoa;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @Inject
    T_PESSOA_REPOSITORY pessoaRepository;
    @Inject
    Cadastro_Pessoa cadastroPessoa;

    public List<T_PESSOA> listarGeral() throws SQLException {
        return pessoaRepository.listarGeral();
    }

    public boolean criarContaPessoa(PessoaCadastro np) throws SQLException {
        return cadastroPessoa.criarContaPessoa(np);
    }



}
