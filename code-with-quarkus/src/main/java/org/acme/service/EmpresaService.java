package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.EmpresaCadastro;
import org.acme.model.DTO.DTO_T_EMPRESA;
import org.acme.model.T_EMPRESA;
import org.acme.repository.T_EMPRESA_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository_intermediario.Cadastro_Empresa;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class EmpresaService {

    @Inject
    T_EMPRESA_REPOSITORY empresaRepository;
    @Inject
    Cadastro_Empresa cadastroEmpresa;
    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    public List<T_EMPRESA> listarEmpresas () throws SQLException {

        return empresaRepository.listarEmpresas();
    }


    public boolean criarContaEmpresa(EmpresaCadastro novaEmpresa) throws SQLException{

        // =====================
        // VALIDAÇÕES
        // =====================

        if (novaEmpresa.getNome_empresa() == null || novaEmpresa.getNome_empresa().isBlank()) {
            throw new IllegalArgumentException("O nome da empresa é obrigatório.");
        }

        if (novaEmpresa.getCnpj() == null || novaEmpresa.getCnpj().isBlank()) {
            throw new IllegalArgumentException("O CNPJ é obrigatório.");
        }

        if (novaEmpresa.getCnpj().length()!=14) {
            throw new IllegalArgumentException("CNPJ inválido. Deve conter 14 dígitos.");
        }

        if (novaEmpresa.getEmail() == null || novaEmpresa.getEmail().isBlank()) {
            throw new IllegalArgumentException("O e-mail da empresa é obrigatório.");
        }

        // Validação básica do email
        if (!novaEmpresa.getEmail().contains("@") || !novaEmpresa.getEmail().contains(".")) {
            throw new IllegalArgumentException("E-mail inválido.");
        }

        if (novaEmpresa.getLogin() == null || novaEmpresa.getLogin().isBlank()) {
            throw new IllegalArgumentException("Login da empresa é obrigatório.");
        }
        if (empresaRepository.cnpjExiste(novaEmpresa.getCnpj())){
            throw new IllegalArgumentException("Esse CNPJ já existe.");
        }
        if (loginRepository.existeLogin(novaEmpresa.getLogin())){
            throw new IllegalArgumentException("Esse Login já existe");
        }


        return cadastroEmpresa.criarContaEmpresa(novaEmpresa);
    }

}
