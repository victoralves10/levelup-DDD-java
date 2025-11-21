package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.DTO_CADASTROPESSOA;
import org.acme.model.DTO.CADASTRO.PessoaCadastro;
import org.acme.model.DTO.DTO_T_ENDERECO;
import org.acme.model.DTO.DTO_T_LOGIN;
import org.acme.model.DTO.DTO_T_PESSOA;
import org.acme.model.T_PESSOA;
import org.acme.repository.T_INST_ACADEMICA_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository.T_PESSOA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @Inject
    T_PESSOA_REPOSITORY pessoaRepository;
    @Inject
    T_LOGIN_REPOSITORY loginRepository;
    @Inject
    T_INST_ACADEMICA_REPOSITORY instAcademicaRepository;

    public List<T_PESSOA> listarGeral() throws SQLException {
        return pessoaRepository.listarGeral();
    }

    public void criarContaPessoa(PessoaCadastro np){

//       Criar o login -> loginRepository.inserirLogin()

//      Criar o endereco -> -> enderecoRepository.inserirEndereco()

//      Criar a pessoa -> -> pessoaRepository.inserirPessoa()

    }


}
