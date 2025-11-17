package org.acme.model.DTO;

import org.acme.model.T_ENDERECO;
import org.acme.model.T_LVUP_LOGIN;

import java.util.Date;

public class DTO_T_PESSOA {
    // atributos
    private String nm_pessoa;
    private String cpf_pessoa;
    private Date dt_nascimento;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN login;

    public DTO_T_PESSOA() {
    }
    //CONSTRUTOR COM TODOS OS CAMPOS PREENCHIDOS
    public DTO_T_PESSOA( String nm_pessoa, String cpf_pessoa, Date dt_nascimento, T_ENDERECO endereco, T_LVUP_LOGIN login) {
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.login = login;
    }

    //CONSTRUTOR SEM ENDERECO
    public DTO_T_PESSOA(String nm_pessoa, String cpf_pessoa, Date dt_nascimento, T_LVUP_LOGIN login) {
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.login = login;
    }

    public String getNm_pessoa() {
        return nm_pessoa;
    }

    public void setNm_pessoa(String nm_pessoa) {
        this.nm_pessoa = nm_pessoa;
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

    public T_LVUP_LOGIN getLogin() {
        return login;
    }

    public void setLogin(T_LVUP_LOGIN login) {
        this.login = login;
    }


}
