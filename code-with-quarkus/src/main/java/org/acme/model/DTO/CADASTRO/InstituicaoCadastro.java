package org.acme.model.DTO.CADASTRO;

public class InstituicaoCadastro {

    // ===== LOGIN =====
    private String login;
    private String senha;

    // ===== INSTITUIÇÃO =====
    private String nm_instAcademica;
    private String cnpj_inst_academica;

    // ===== ENDEREÇO =====
    private String cep;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;

    public InstituicaoCadastro() {}

    // ======================
    // GETTERS E SETTERS
    // ======================

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

    public String getNm_instAcademica() {
        return nm_instAcademica;
    }
    public void setNm_instAcademica(String nm_instAcademica) {
        this.nm_instAcademica = nm_instAcademica;
    }

    public String getCnpj_inst_academica() {
        return cnpj_inst_academica;
    }
    public void setCnpj_inst_academica(String cnpj_inst_academica) {
        this.cnpj_inst_academica = cnpj_inst_academica;
    }

    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
