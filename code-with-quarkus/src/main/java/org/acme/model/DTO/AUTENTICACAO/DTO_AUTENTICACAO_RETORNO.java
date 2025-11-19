package org.acme.model.DTO.AUTENTICACAO;

public class DTO_AUTENTICACAO_RETORNO {

    private String token;
    private String perfil;
    private String nomeUsuario;

    public DTO_AUTENTICACAO_RETORNO(String nomeUsuario, String perfil, String token) {
        this.nomeUsuario = nomeUsuario;
        this.perfil = perfil;
        this.token = token;
    }

    // --- Getters e Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }

    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }

}
