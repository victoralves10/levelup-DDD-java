package org.acme.model.DTO;

import org.acme.model.T_ENDERECO;
import org.acme.model.T_LVUP_LOGIN;

public class DTO_T_INST_ACADEMICA {
    private String nm_instAcademica;
    private String st_ativo;
    private String cnpj;
    private long endereco;
    private long login;

    public DTO_T_INST_ACADEMICA(String nm_instAcademica, String st_ativo, String cnpj, long endereco, long login) {
        this.nm_instAcademica = nm_instAcademica;
        this.st_ativo = st_ativo;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.login = login;
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

    public long getEndereco() {
        return endereco;
    }

    public void setEndereco(long endereco) {
        this.endereco = endereco;
    }

    public long getLogin() {
        return login;
    }

    public void setLogin(long login) {
        this.login = login;
    }
}
