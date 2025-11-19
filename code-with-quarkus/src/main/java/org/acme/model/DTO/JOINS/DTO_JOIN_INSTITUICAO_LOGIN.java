package org.acme.model.DTO.JOINS;

public class DTO_JOIN_INSTITUICAO_LOGIN {
    // Dados de LOGIN (T_LVUP_LOGIN)
    private long id_login;
    private String login;
    private String senha;
    private String st_ativo;

    // Dados de INSTITUICAO (T_INSTITUICAO)
    private long id_instituicao;
    private String nm_instituicao;
    private String cnpj_instituicao;

    public DTO_JOIN_INSTITUICAO_LOGIN(String cnpj_instituicao, long id_instituicao, long id_login, String login, String nm_instituicao, String senha, String st_ativo) {
        this.cnpj_instituicao = cnpj_instituicao;
        this.id_instituicao = id_instituicao;
        this.id_login = id_login;
        this.login = login;
        this.nm_instituicao = nm_instituicao;
        this.senha = senha;
        this.st_ativo = st_ativo;
    }

    public String getCnpj_instituicao() {
        return cnpj_instituicao;
    }

    public void setCnpj_instituicao(String cnpj_instituicao) {
        this.cnpj_instituicao = cnpj_instituicao;
    }

    public long getId_instituicao() {
        return id_instituicao;
    }

    public void setId_instituicao(long id_instituicao) {
        this.id_instituicao = id_instituicao;
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

    public String getNm_instituicao() {
        return nm_instituicao;
    }

    public void setNm_instituicao(String nm_instituicao) {
        this.nm_instituicao = nm_instituicao;
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
