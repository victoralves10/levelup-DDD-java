package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.AUTENTICACAO.DTO_AUTENTICACAO_RETORNO;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.JOINS.DTO_JOIN_PESSOA_LOGIN;
import org.acme.model.T_INST_ACADEMICA;
import org.acme.model.T_LVUP_LOGIN;
import org.acme.repository.T_EMPRESA_REPOSITORY;
import org.acme.repository.T_INST_ACADEMICA_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository.T_PESSOA_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class LoginService {

    @Inject
    T_LOGIN_REPOSITORY loginRepository;
    @Inject
    T_PESSOA_REPOSITORY pessoaRepository;
    @Inject
    T_EMPRESA_REPOSITORY empresaRepository;
    @Inject
    T_INST_ACADEMICA_REPOSITORY instAcademicaRepository;

    public List<T_LVUP_LOGIN> listarLogins() throws SQLException {

        return loginRepository.listarLogins();
    }


    public DTO_AUTENTICACAO_RETORNO loginExistente(DTO_T_LOGIN_2 loginDigitado) throws SQLException{
        String perfil ;
        String nm_usuario;

        DTO_JOIN_PESSOA_LOGIN possivelPessoa = pessoaRepository.autenticaPessoaLogin(loginDigitado);

        if (possivelPessoa != null){
            perfil = "pessoa";
        } else if (empresaRepository.) {

        } else if (instAcademicaRepository.) {

        }else {
            throw new IllegalArgumentException("Login ou Senha inválidos.");
        }
        //a mesma coisa para empresa e inst academica

        return new DTO_AUTENTICACAO_RETORNO(,perfil,)




    }
}
