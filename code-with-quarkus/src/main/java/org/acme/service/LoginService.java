package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.DTO_T_LOGIN_2;
import org.acme.model.T_LVUP_LOGIN;
import org.acme.repository.T_LOGIN_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class LoginService {

    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    public List<T_LVUP_LOGIN> listarLogins() throws SQLException {

        return loginRepository.listarLogins();
    }


    public DTO_T_LOGIN_2 loginExistente(DTO_T_LOGIN_2 loginDigitado) throws SQLException{
        List<DTO_T_LOGIN_2> LoginExistente = loginRepository.procurarLogin(loginDigitado);
        DTO_T_LOGIN_2 loginUnico = LoginExistente.getFirst();

        if (loginUnico.getLogin().equals(loginDigitado.getLogin()) && loginUnico.getSenha().equals(loginDigitado.getSenha())){
            return loginUnico;
        }else {
            throw new IllegalArgumentException("Login ou Senha inválidos.");
        }

    }
}
