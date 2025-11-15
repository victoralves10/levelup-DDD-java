package org.acme.model.DTO;

import org.acme.model.T_ENDERECO;
import org.acme.model.T_LVUP_LOGIN;

public class DTO_T_INST_ACADEMICA {
    private String nm_instAcademica;
    private String st_ativo;
    private String cnpj;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN login;

    // Construtor Completo
    public DTO_T_INST_ACADEMICA(String nm_instAcademica, String st_ativo, String cnpj, T_ENDERECO endereco, T_LVUP_LOGIN login) {
        this.nm_instAcademica = nm_instAcademica;
        this.st_ativo = st_ativo;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.login = login;
    }


    // -------- GETTER E SETTER ---------
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
