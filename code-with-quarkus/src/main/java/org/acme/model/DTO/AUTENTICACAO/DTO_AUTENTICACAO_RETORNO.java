package org.acme.model.DTO.AUTENTICACAO;

public class DTO_AUTENTICACAO_RETORNO {

    private String token;
    private String perfil;
    private String nm_usuario; // <-- trocar de nomeUsuario
    private long id_usuario;   // <-- trocar de idUsuario

    public DTO_AUTENTICACAO_RETORNO(String token, String perfil, String nm_usuario, long id_usuario) {
        this.token = token;
        this.perfil = perfil;
        this.nm_usuario = nm_usuario;
        this.id_usuario = id_usuario;
    }

    // getters e setters
    public String getNm_usuario() { return nm_usuario; }
    public void setNm_usuario(String nm_usuario) { this.nm_usuario = nm_usuario; }

    public long getId_usuario() { return id_usuario; }
    public void setId_usuario(long id_usuario) { this.id_usuario = id_usuario; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getPerfil() { return perfil; }
    public void setPerfil(String perfil) { this.perfil = perfil; }
}
