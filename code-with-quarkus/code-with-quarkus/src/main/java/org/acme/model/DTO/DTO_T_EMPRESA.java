package org.acme.model.DTO;

import java.util.Date;

public class DTO_T_EMPRESA {

    private String nm_empresa;
    private String cnpj_empresa;
    private String email_empresa;
    private Date dt_cadastro;
    private String st_empresa;

    public DTO_T_EMPRESA(String nm_empresa, String cnpj_empresa, String email_empresa, Date dt_cadastro, String st_empresa) {
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.email_empresa = email_empresa;
        this.dt_cadastro = dt_cadastro;
        this.st_empresa = st_empresa;
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
