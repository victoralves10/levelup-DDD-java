package org.acme.repository_intermediario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.InstituicaoCadastro;
import org.acme.model.DTO.DTO_T_ENDERECO;
import org.acme.model.DTO.DTO_T_INST_ACADEMICA;
import org.acme.model.DTO.DTO_T_LOGIN;
import org.acme.model.T_LVUP_LOGIN;
import org.acme.repository.T_EMPRESA_REPOSITORY;
import org.acme.repository.T_ENDERECO_REPOSITORY;
import org.acme.repository.T_INST_ACADEMICA_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;

import java.sql.SQLException;

@ApplicationScoped
public class Cadastro_Instituicao {

    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    @Inject
    T_ENDERECO_REPOSITORY enderecoRepository;

    @Inject
    T_INST_ACADEMICA_REPOSITORY instAcademicaRepository;


    public boolean criarInstituicao(InstituicaoCadastro novaInst) throws SQLException {

        DTO_T_LOGIN novoLogin = new DTO_T_LOGIN(novaInst.getLogin(), novaInst.getSenha(), "S");
        Long idLogin = loginRepository.inserirLoginRetornandoId(novoLogin);

        // Criar endereço
        DTO_T_ENDERECO novoEndereco = new DTO_T_ENDERECO(
                novaInst.getCep(),
                novaInst.getPais(),
                novaInst.getEstado(),
                novaInst.getCidade(),
                novaInst.getBairro(),
                novaInst.getRua(),
                novaInst.getNumero(),
                novaInst.getComplemento()
        );
        Long idEndereco = enderecoRepository.inserirEnderecoRetornandoId(novoEndereco);


        // 3) Criar INSTITUIÇÃO ACADÊMICA
        DTO_T_INST_ACADEMICA instituicao = new DTO_T_INST_ACADEMICA(
                novaInst.getNm_instAcademica(),
                "S",
                novaInst.getCnpj_inst_academica(),
                idEndereco,
                idLogin
        );
        return instAcademicaRepository.inserirInstituicao(instituicao);
    }
}
