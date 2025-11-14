package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.T_LOGIN;
import org.acme.repository.T_LOGIN_REPOSITORY;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class LoginService {

    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    public List<T_LOGIN> listarLogins() throws SQLException {

        return loginRepository.listarLogins();
    }
}
