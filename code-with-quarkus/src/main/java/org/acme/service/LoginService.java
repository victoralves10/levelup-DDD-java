package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.AUTENTICACAO.DTO_AUTENTICACAO_RETORNO;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.DTO.JOINS.DTO_JOIN_EMPRESA_LOGIN;
import org.acme.model.DTO.JOINS.DTO_JOIN_INSTITUICAO_LOGIN;
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

    private static class TokenService {
        /**
         * Gera um token simples combinando um prefixo, o ID do login e um timestamp.
         * @param idLogin O ID do login do usuário autenticado.
         * @return Uma String que representa o token.
         */
        public static String gerarToken(long idLogin) {
            // Este método cria uma string única e simples para o token.
            return "LVUP_TKN_" + idLogin + "_" + System.currentTimeMillis();
        }
    }

    public List<T_LVUP_LOGIN> listarLogins() throws SQLException {

        return loginRepository.listarLogins();
    }


    public DTO_AUTENTICACAO_RETORNO loginExistente(DTO_T_LOGIN_2 loginDigitado) throws SQLException{
        String perfil ;
        String nm_usuario;
        String token ;

        DTO_JOIN_PESSOA_LOGIN possivelPessoa = pessoaRepository.autenticaPessoaLogin(loginDigitado);
        DTO_JOIN_EMPRESA_LOGIN possivelEmpresa = empresaRepository.autenticaEmpresaLogin(loginDigitado);
        DTO_JOIN_INSTITUICAO_LOGIN possivelInstituicao =instAcademicaRepository.autenticaInstituicaoLogin(loginDigitado);

        if (possivelPessoa != null){
            perfil = "pessoa";
            nm_usuario=possivelPessoa.getNm_pessoa();
            token = TokenService.gerarToken(possivelPessoa.getId_login());

        } else if (possivelEmpresa!=null) {
            perfil = "empresa";
            nm_usuario=possivelEmpresa.getNm_empresa();
            token = TokenService.gerarToken(possivelEmpresa.getId_empresa());

        } else if (possivelInstituicao!=null) {
            perfil = "instituicaoAcademica";
            nm_usuario=possivelInstituicao.getNm_instituicao();
            token = TokenService.gerarToken(possivelInstituicao.getId_instituicao());

        }else {
            throw new IllegalArgumentException("Login ou Senha inválidos.");

        }


        return new DTO_AUTENTICACAO_RETORNO(nm_usuario,perfil,token);




    }
}
