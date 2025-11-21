package org.acme.repository_intermediario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.PessoaCadastro;
import org.acme.model.DTO.DTO_T_ENDERECO;
import org.acme.model.DTO.DTO_T_LOGIN;
import org.acme.model.DTO.DTO_T_PESSOA;
import org.acme.repository.T_ENDERECO_REPOSITORY;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository.T_PESSOA_REPOSITORY;

import jakarta.transaction.Transactional;
import java.sql.SQLException;

@ApplicationScoped
public class Cadastro_Pessoa {

    @Inject
    T_LOGIN_REPOSITORY loginRepository;
    @Inject
    T_ENDERECO_REPOSITORY enderecoRepository;
    @Inject
    T_PESSOA_REPOSITORY pessoaRepository;

    @Transactional
    public boolean criarContaPessoa(PessoaCadastro np) throws SQLException {

        System.out.println("[INTERMEDIARIO] Criando login...");
        DTO_T_LOGIN novoLogin = new DTO_T_LOGIN(np.getLogin(), np.getSenha(), "S");
        Long idLogin = loginRepository.inserirLoginRetornandoId(novoLogin);
        System.out.println("[INTERMEDIARIO] Login criado com ID: " + idLogin);

        System.out.println("[INTERMEDIARIO] Criando endereço...");
        DTO_T_ENDERECO novoEndereco = new DTO_T_ENDERECO(
                np.getCep(), np.getPais(), np.getEstado(), np.getCidade(),
                np.getBairro(), np.getRua(), np.getNumero(), np.getComplemento()
        );
        Long idEndereco = enderecoRepository.inserirEnderecoRetornandoId(novoEndereco);
        System.out.println("[INTERMEDIARIO] Endereço criado com ID: " + idEndereco);

        System.out.println("[INTERMEDIARIO] Criando pessoa...");
        DTO_T_PESSOA novaPessoa = new DTO_T_PESSOA(
                np.getNome(), np.getCpf(), np.getDataNascimento(), idLogin, idEndereco
        );
        boolean pessoaInserida = pessoaRepository.inserirPessoa(novaPessoa);
        System.out.println("[INTERMEDIARIO] Pessoa inserida com sucesso? " + pessoaInserida);

        return pessoaInserida;
    }
}
