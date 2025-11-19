package org.acme.model.DTO.JOINS;

import org.acme.model.T_ENDERECO;
import org.acme.model.T_LVUP_LOGIN;

import java.util.Date;

public class DTO_JOIN_PESSOA_LOGIN {
    //login
    private long id_login;
    private String login;
    private String senha;
    private String st_ativo;
    //pessoa
    private long id_pessoa;
    private String nm_pessoa;
    private String cpf_pessoa;
    private Date dt_nascimento;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN fk_login;

    public DTO_JOIN_PESSOA_LOGIN(String cpf_pessoa, Date dt_nascimento, T_ENDERECO endereco, long id_login, long id_pessoa, String login, T_LVUP_LOGIN login1, String nm_pessoa, String senha, String st_ativo) {
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.id_login = id_login;
        this.id_pessoa = id_pessoa;
        this.login = login;
        this.fk_login = login1;
        this.nm_pessoa = nm_pessoa;
        this.senha = senha;
        this.st_ativo = st_ativo;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public T_ENDERECO getEndereco() {
        return endereco;
    }

    public void setEndereco(T_ENDERECO endereco) {
        this.endereco = endereco;
    }

    public T_LVUP_LOGIN getFk_login() {
        return fk_login;
    }

    public void setFk_login(T_LVUP_LOGIN fk_login) {
        this.fk_login = fk_login;
    }

    public long getId_login() {
        return id_login;
    }

    public void setId_login(long id_login) {
        this.id_login = id_login;
    }

    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNm_pessoa() {
        return nm_pessoa;
    }

    public void setNm_pessoa(String nm_pessoa) {
        this.nm_pessoa = nm_pessoa;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSt_ativo() {
        return st_ativo;
    }

    public void setSt_ativo(String st_ativo) {
        this.st_ativo = st_ativo;
    }
}
