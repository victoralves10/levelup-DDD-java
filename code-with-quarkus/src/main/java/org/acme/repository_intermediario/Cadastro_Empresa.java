package org.acme.repository_intermediario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.DTO.CADASTRO.EmpresaCadastro;
import org.acme.model.DTO.DTO_T_ENDERECO;
import org.acme.model.DTO.DTO_T_LOGIN;
import org.acme.model.DTO.DTO_T_EMPRESA;
import org.acme.repository.T_ENDERECO_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository.T_EMPRESA_REPOSITORY;

import java.sql.SQLException;
import java.time.LocalDate;

@ApplicationScoped
public class Cadastro_Empresa {

    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    @Inject
    T_ENDERECO_REPOSITORY enderecoRepository;

    @Inject
    T_EMPRESA_REPOSITORY empresaRepository;

    @Transactional
    public boolean criarContaEmpresa(EmpresaCadastro ec) throws SQLException {

        // Criar login
        DTO_T_LOGIN novoLogin = new DTO_T_LOGIN(ec.getLogin(), ec.getSenha(), "S");
        Long idLogin = loginRepository.inserirLoginRetornandoId(novoLogin);

        // Criar endereço
        DTO_T_ENDERECO novoEndereco = new DTO_T_ENDERECO(
                ec.getCep(),
                ec.getPais(),
                ec.getEstado(),
                ec.getCidade(),
                ec.getBairro(),
                ec.getRua(),
                ec.getNumero(),
                ec.getComplemento()
        );
        Long idEndereco = enderecoRepository.inserirEnderecoRetornandoId(novoEndereco);

        // Tratar data
        LocalDate cadastroDate;
        if (ec.getDt_cadastro() == null || ec.getDt_cadastro().isBlank()) {
            cadastroDate = LocalDate.now();
        } else {
            try {
                cadastroDate = LocalDate.parse(ec.getDt_cadastro());
            } catch (Exception e) {
                throw new IllegalArgumentException("Formato de data inválido. Use yyyy-MM-dd.");
            }
        }

        // Criar DTO da empresa
        DTO_T_EMPRESA novaEmpresa = new DTO_T_EMPRESA(
                ec.getNome_empresa(),
                ec.getCnpj(),
                ec.getEmail(),
                cadastroDate,
                'A', // status padrão
                idEndereco,
                idLogin
        );

        return empresaRepository.inserirEmpresa(novaEmpresa);
    }

}
