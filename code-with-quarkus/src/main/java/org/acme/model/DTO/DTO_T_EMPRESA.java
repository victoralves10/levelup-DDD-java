package org.acme.model.DTO;

import org.acme.model.T_ENDERECO;
import org.acme.model.T_LVUP_LOGIN;

import java.time.LocalDate;

public class DTO_T_EMPRESA {

    private String nm_empresa;
    private String cnpj_empresa;
    private String email_empresa;
    private LocalDate dt_cadastro;
    private char st_empresa; // 'A' ou 'I'
    private long endereco;
    private long login;

    // ================================
    // CONSTRUTOR COMPLETO (com endereço e login)
    // ================================
    public DTO_T_EMPRESA(String nm_empresa, String cnpj_empresa, String email_empresa,
                         LocalDate dt_cadastro, char st_empresa, long endereco, long login) {
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.email_empresa = email_empresa;
        this.dt_cadastro = dt_cadastro;
        this.st_empresa = st_empresa;
        this.endereco = endereco;
        this.login = login;
    }

    // ================================
    // GETTERS E SETTERS
    // ================================
    public String getNm_empresa() { return nm_empresa; }
    public void setNm_empresa(String nm_empresa) { this.nm_empresa = nm_empresa; }

    public String getCnpj_empresa() { return cnpj_empresa; }
    public void setCnpj_empresa(String cnpj_empresa) { this.cnpj_empresa = cnpj_empresa; }

    public String getEmail_empresa() { return email_empresa; }
    public void setEmail_empresa(String email_empresa) { this.email_empresa = email_empresa; }

    public LocalDate getDt_cadastro() { return dt_cadastro; }
    public void setDt_cadastro(LocalDate dt_cadastro) { this.dt_cadastro = dt_cadastro; }

    public char getSt_empresa() { return st_empresa; }
    public void setSt_empresa(char st_empresa) { this.st_empresa = st_empresa; }

    public long getEndereco() { return endereco; }
    public void setEndereco(long endereco) { this.endereco = endereco; }

    public long getLogin() { return login; }
    public void setLogin(long login) { this.login = login; }
}
