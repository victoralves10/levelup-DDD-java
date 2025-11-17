package org.acme.model;

import java.util.Date;

public class T_EMPRESA {

    private long id_empresa;
    private String nm_empresa;
    private String cnpj_empresa;
    private String email_empresa;
    private Date dt_cadastro;
    private String st_empresa;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN login;

    //Constutor Completo
    public T_EMPRESA(long id_empresa, String nm_empresa, String cnpj_empresa, String email_empresa, Date dt_cadastro, String st_empresa, T_ENDERECO endereco, T_LVUP_LOGIN login) {
        this.id_empresa = id_empresa;
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.email_empresa = email_empresa;
        this.dt_cadastro = dt_cadastro;
        this.st_empresa = st_empresa;
        this.endereco = endereco;
        this.login = login;
    }

    //Construtor sem endereco
    public T_EMPRESA(long id_empresa, String nm_empresa, String cnpj_empresa, String email_empresa, Date dt_cadastro, String st_empresa, T_LVUP_LOGIN login) {
        this.id_empresa = id_empresa;
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.email_empresa = email_empresa;
        this.dt_cadastro = dt_cadastro;
        this.st_empresa = st_empresa;
        this.login = login;

    }

    // TESTE (SEM FK's)
    public T_EMPRESA(long id_empresa, String nm_empresa, String cnpj_empresa, String email_empresa, Date dt_cadastro, String st_empresa) {
        this.id_empresa = id_empresa;
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.email_empresa = email_empresa;
        this.dt_cadastro = dt_cadastro;
        this.st_empresa = st_empresa;
    }



    // ---------------- GETTER AND SETTER --------------------

    public long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNm_empresa() {
        return nm_empresa;
    }

    public void setNm_empresa(String nm_empresa) {
        this.nm_empresa = nm_empresa;
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public String getEmail_empresa() {
        return email_empresa;
    }

    public void setEmail_empresa(String email_empresa) {
        this.email_empresa = email_empresa;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public String getSt_empresa() {
        return st_empresa;
    }

    public void setSt_empresa(String st_empresa) {
        this.st_empresa = st_empresa;
    }
}
