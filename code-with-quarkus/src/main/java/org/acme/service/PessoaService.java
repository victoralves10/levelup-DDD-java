package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.DTO.CADASTRO.PessoaCadastro;
import org.acme.model.DTO.DTO_T_PESSOA_2;
import org.acme.model.DTO.JOINS.DTO_EVENTOxPESSOA_RETORNO;
import org.acme.model.T_PESSOA;
import org.acme.repository.T_LOGIN_REPOSITORY;
import org.acme.repository.T_PESSOA_REPOSITORY;
import org.acme.repository_intermediario.Cadastro_Pessoa;

import java.sql.SQLException;
import java.util.List;

@ApplicationScoped
public class PessoaService {

    @Inject
    T_PESSOA_REPOSITORY pessoaRepository;
    @Inject
    Cadastro_Pessoa cadastroPessoa;
    @Inject
    T_LOGIN_REPOSITORY loginRepository;

    public List<T_PESSOA> listarGeral() throws SQLException {
        return pessoaRepository.listarGeral();
    }

    public boolean criarContaPessoa(PessoaCadastro np) throws SQLException {
        if (loginRepository.existeLogin(np.getLogin())){
            throw new IllegalArgumentException("Login já existe");
        }
        if(pessoaRepository.existeCpf(np.getCpf())){
            throw new IllegalArgumentException("CPF já cadastrado");
        }


        System.out.println("[SERVICE] Iniciando criação de conta para: " + np.getNome());
        boolean sucesso = cadastroPessoa.criarContaPessoa(np);
        System.out.println("[SERVICE] Conta criada com sucesso? " + sucesso);
        return sucesso;
    }

    public List<DTO_EVENTOxPESSOA_RETORNO> listarEventosPorPessoa(long idPessoa)throws SQLException{

        return pessoaRepository.listarEventosPorPessoa(idPessoa);
    }

    public DTO_T_PESSOA_2 buscarDadosPessoais(Long idPessoa) throws SQLException {
        return pessoaRepository.buscarDadosPessoaisPorId(idPessoa);
    }



}
