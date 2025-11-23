package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.InstituicaoCadastro;
import org.acme.model.DTO.DTO_T_INST_ACADEMICA_2;
import org.acme.model.T_INST_ACADEMICA;
import org.acme.repository.T_INST_ACADEMICA_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository_intermediario.Cadastro_Instituicao;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class InstAcademicaService {

    @Inject
    Cadastro_Instituicao cadastroInstituicao;

    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    @Inject
    T_INST_ACADEMICA_REPOSITORY instAcademicaRepository;


    public List<T_INST_ACADEMICA> listarInstAcademicas() throws SQLException {

        return instAcademicaRepository.listarInstAcademicas();
    }

    // ================================
    // ===== CRIAR CONTA INSTITUIÇÃO ==
    // ================================
    public boolean criarContaInstituicao(InstituicaoCadastro novaInst) throws SQLException {

        // ====== VALIDAÇÕES ======
        if (novaInst.getLogin() == null || novaInst.getLogin().isBlank()) {
            throw new IllegalArgumentException("Login não pode estar vazio.");
        }

        if (novaInst.getSenha() == null || novaInst.getSenha().isBlank()) {
            throw new IllegalArgumentException("Senha não pode estar vazia.");
        }

        if (novaInst.getNm_instAcademica() == null || novaInst.getNm_instAcademica().isBlank()) {
            throw new IllegalArgumentException("Nome da instituição é obrigatório.");
        }

        if (novaInst.getCnpj_inst_academica() == null || novaInst.getCnpj_inst_academica().isBlank()) {
            throw new IllegalArgumentException("CNPJ é obrigatório.");
        }

        if (loginRepository.existeLogin(novaInst.getLogin())){
            throw new IllegalArgumentException("Esse Login já existe");
        }

        if (instAcademicaRepository.cnpjExiste(novaInst.getCnpj_inst_academica())){
            throw new IllegalArgumentException("Esse CNPJ já está cadastrado");
        }

        boolean sucesso = cadastroInstituicao.criarInstituicao(novaInst);
        System.out.println("[SERVICE] Conta criada com sucesso? " + sucesso);
        return sucesso;

    }


    public DTO_T_INST_ACADEMICA_2 getInstituicaoById(long idInstituicao) throws SQLException {
        DTO_T_INST_ACADEMICA_2 instituicao = instAcademicaRepository.getInstituicaoById(idInstituicao);
        return instituicao;
    }
}
