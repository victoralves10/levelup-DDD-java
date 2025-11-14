package org.acme.model.DTO;

public class DTO_T_LOGIN {

    private String login;
    private String senha;
    private String st_ativo;

    public DTO_T_LOGIN(String login, String senha, String st_ativo) {
        this.login = login;
        this.senha = senha;
        this.st_ativo = st_ativo;
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
