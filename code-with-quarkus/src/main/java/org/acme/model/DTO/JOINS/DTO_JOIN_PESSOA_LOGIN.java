package org.acme.model.DTO.JOINS;

import org.acme.model.T_ENDERECO; // Mantendo as dependências originais
import org.acme.model.T_LVUP_LOGIN; // Mantendo as dependências originais

import java.util.Date;

public class DTO_JOIN_PESSOA_LOGIN {
    // login
    private long id_login;
    private String login;
    private String senha;
    private String st_ativo;
    // pessoa
    private long id_pessoa;
    private String nm_pessoa;
    private String cpf_pessoa;
    private Date dt_nascimento;

    // Construtor para a query de autenticação (simplificado)
    // Assumimos que o SELECT * está retornando:
    // id_pessoa, nm_pessoa, cpf_pessoa, dt_nascimento, id_login, login, senha, st_ativo
    public DTO_JOIN_PESSOA_LOGIN(long id_pessoa, String nm_pessoa, String cpf_pessoa, Date dt_nascimento, long id_login, String login, String senha, String st_ativo) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.id_login = id_login;
        this.login = login;
        this.senha = senha;
        this.st_ativo = st_ativo;
    }

    // Outros campos originais (mantidos para compatibilidade, mas podem ser removidos se não usados)
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN fk_login;


    // Getters and Setters (Omitidos aqui, mas necessários no arquivo)

    public String getNm_pessoa() {
        return nm_pessoa;
    }
    // ... (outros getters/setters)
    public long getId_login() {
        return id_login;
    }
}