package org.acme.model;

public class T_INST_ACADEMICA {
    private long id_instAcademica;
    private String nm_instAcademica;
    private String st_ativo;
    private String cnpj;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN login;

    // CONSTRUTOR COMPLETO
    public T_INST_ACADEMICA(long id_instAcademica, String nm_instAcademica, String st_ativo, String cnpj, T_ENDERECO endereco, T_LVUP_LOGIN login) {
        this.id_instAcademica = id_instAcademica;
        this.nm_instAcademica = nm_instAcademica;
        this.st_ativo = st_ativo;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.login = login;
    }

    //CONSTRUTOR SEM FK'S (para exibição)
    public T_INST_ACADEMICA(long id_instAcademica, String nm_instAcademica, String st_ativo, String cnpj) {
        this.id_instAcademica = id_instAcademica;
        this.nm_instAcademica = nm_instAcademica;
        this.st_ativo = st_ativo;
        this.cnpj = cnpj;
    }


    // ------- GETTER E SETTER --------
    public long getId_instAcademica() {
        return id_instAcademica;
    }

    public void setId_instAcademica(long id_instAcademica) {
        this.id_instAcademica = id_instAcademica;
    }

    public String getNm_instAcademica() {
        return nm_instAcademica;
    }

    public void setNm_instAcademica(String nm_instAcademica) {
        this.nm_instAcademica = nm_instAcademica;
    }

    public String getSt_ativo() {
        return st_ativo;
    }

    public void setSt_ativo(String st_ativo) {
        this.st_ativo = st_ativo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public T_ENDERECO getEndereco() {
        return endereco;
    }

    public void setEndereco(T_ENDERECO endereco) {
        this.endereco = endereco;
    }

    public T_LVUP_LOGIN getLogin() {
        return login;
    }

    public void setLogin(T_LVUP_LOGIN login) {
        this.login = login;
    }
}
