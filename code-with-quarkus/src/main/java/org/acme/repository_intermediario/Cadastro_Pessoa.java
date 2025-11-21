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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

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
        // Validação básica
        if (np.getNome() == null || np.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (np.getCpf() == null || np.getCpf().isBlank()) {
            throw new IllegalArgumentException("CPF é obrigatório");
        }
        if (np.getLogin() == null || np.getLogin().isBlank()) {
            throw new IllegalArgumentException("Login é obrigatório");
        }
        if (np.getSenha() == null || np.getSenha().isBlank()) {
            throw new IllegalArgumentException("Senha é obrigatória");
        }
        if (np.getData_nascimento() == null || np.getData_nascimento().isBlank()) {
            throw new IllegalArgumentException("Data de nascimento é obrigatória");
        }

        // Conversão da data de nascimento de String para LocalDate
        LocalDate dtNascimento;
        try {
            dtNascimento = LocalDate.parse(np.getData_nascimento());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de nascimento inválida. Use o formato YYYY-MM-DD.");
        }

        // Criar login
        System.out.println("[INTERMEDIARIO] Criando login...");
        DTO_T_LOGIN novoLogin = new DTO_T_LOGIN(np.getLogin(), np.getSenha(), "S");
        Long idLogin = loginRepository.inserirLoginRetornandoId(novoLogin);
        System.out.println("[INTERMEDIARIO] Login criado com ID: " + idLogin);

        // Criar endereço
        System.out.println("[INTERMEDIARIO] Criando endereço...");
        DTO_T_ENDERECO novoEndereco = new DTO_T_ENDERECO(
                np.getCep(),
                np.getPais(),
                np.getEstado(),
                np.getCidade(),
                np.getBairro(),
                np.getRua(),
                np.getNumero(),
                np.getComplemento()
        );
        Long idEndereco = enderecoRepository.inserirEnderecoRetornandoId(novoEndereco);
        System.out.println("[INTERMEDIARIO] Endereço criado com ID: " + idEndereco);

        // Criar pessoa
        System.out.println("[INTERMEDIARIO] Criando pessoa...");
        DTO_T_PESSOA novaPessoa = new DTO_T_PESSOA(
                np.getNome(),
                np.getCpf(),
                dtNascimento,
                idLogin,
                idEndereco
        );

        boolean pessoaInserida = pessoaRepository.inserirPessoa(novaPessoa);
        System.out.println("[INTERMEDIARIO] Pessoa inserida com sucesso? " + pessoaInserida);

        return pessoaInserida;
    }
}
