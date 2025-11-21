package org.acme.model.DTO.JOINS;

import java.time.LocalDate;

public class DTO_JOIN_PESSOA_LOGIN {

    // =============================
    // LOGIN
    // =============================
    private long id_login;
    private String login;
    private String senha;
    private String st_ativo;

    // =============================
    // PESSOA
    // =============================
    private long id_pessoa;
    private String nm_pessoa;
    private String cpf_pessoa;
    private LocalDate dt_nascimento; // agora compatível com repository

    // =============================
    // CONSTRUTOR
    // =============================
    public DTO_JOIN_PESSOA_LOGIN(long id_pessoa, String nm_pessoa, String cpf_pessoa,
                                 LocalDate dt_nascimento, long id_login,
                                 String login, String senha, String st_ativo) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.id_login = id_login;
        this.login = login;
        this.senha = senha;
        this.st_ativo = st_ativo;
    }

    // =============================
    // GETTERS E SETTERS
    // =============================
    public long getId_pessoa() { return id_pessoa; }
    public void setId_pessoa(long id_pessoa) { this.id_pessoa = id_pessoa; }

    public String getNm_pessoa() { return nm_pessoa; }
    public void setNm_pessoa(String nm_pessoa) { this.nm_pessoa = nm_pessoa; }

    public String getCpf_pessoa() { return cpf_pessoa; }
    public void setCpf_pessoa(String cpf_pessoa) { this.cpf_pessoa = cpf_pessoa; }

    public LocalDate getDt_nascimento() { return dt_nascimento; }
    public void setDt_nascimento(LocalDate dt_nascimento) { this.dt_nascimento = dt_nascimento; }

    public long getId_login() { return id_login; }
    public void setId_login(long id_login) { this.id_login = id_login; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getSt_ativo() { return st_ativo; }
    public void setSt_ativo(String st_ativo) { this.st_ativo = st_ativo; }
}
