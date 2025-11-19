package org.acme.model.DTO.JOINS;

public class DTO_JOIN_EMPRESA_LOGIN {
    // Dados de LOGIN (T_LVUP_LOGIN)
    private long id_login;
    private String login;
    private String senha;
    private String st_ativo;

    // Dados de EMPRESA (T_EMPRESA)
    private long id_empresa;
    private String nm_empresa;
    private String cnpj_empresa;

    public DTO_JOIN_EMPRESA_LOGIN(long id_empresa, String nm_empresa, String cnpj_empresa, long id_login, String login, String senha, String st_ativo) {
        this.id_empresa = id_empresa;
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.id_login = id_login;
        this.login = login;
        this.senha = senha;
        this.st_ativo = st_ativo;
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public long getId_login() {
        return id_login;
    }

    public void setId_login(long id_login) {
        this.id_login = id_login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNm_empresa() {
        return nm_empresa;
    }

    public void setNm_empresa(String nm_empresa) {
        this.nm_empresa = nm_empresa;
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
