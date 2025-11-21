package org.acme.model;

import java.time.LocalDate;


public class T_PESSOA {
    // atributos
    private long id_pessoa;
    private String nm_pessoa;
    private String cpf_pessoa;
    private LocalDate dt_nascimento;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN login;

    public T_PESSOA() {
    }
    //CONSTRUTOR COM TODOS OS CAMPOS PREENCHIDOS
    public T_PESSOA(long id_pessoa, String nm_pessoa, String cpf_pessoa, LocalDate dt_nascimento, T_ENDERECO endereco, T_LVUP_LOGIN login) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.login = login;
    }

    //CONSTRUTOR SEM ENDERECO
    public T_PESSOA(long id_pessoa, String nm_pessoa, String cpf_pessoa, LocalDate dt_nascimento, T_LVUP_LOGIN login) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.login = login;
    }

    // TESTE
    public T_PESSOA(long id_pessoa, String nm_pessoa, String cpf_pessoa,LocalDate dt_nascimento) {
        this.id_pessoa = id_pessoa;
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
    }


    // ------------- getter and setter -------------
    public long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(long id_pessoa) {
        this.id_pessoa = id_pessoa;
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

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
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
