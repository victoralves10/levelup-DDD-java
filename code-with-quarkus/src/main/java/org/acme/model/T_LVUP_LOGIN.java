package org.acme.model;

public class T_LVUP_LOGIN {
    private long id_login;
    private String login;
    private String senha;
    private String st_ativo;

    // CONSTRUTOR COMPLETO
    public T_LVUP_LOGIN(long id_login, String login, String senha, String st_ativo) {
        this.id_login = id_login;
        this.login = login;
        this.senha = senha;
        this.st_ativo = st_ativo;
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
