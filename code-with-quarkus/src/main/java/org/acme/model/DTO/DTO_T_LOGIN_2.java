package org.acme.model.DTO;

public class DTO_T_LOGIN_2 {

    private String login;
    private String senha;

    public DTO_T_LOGIN_2(String login, String senha) {
        this.login = login;
        this.senha = senha;
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
}
