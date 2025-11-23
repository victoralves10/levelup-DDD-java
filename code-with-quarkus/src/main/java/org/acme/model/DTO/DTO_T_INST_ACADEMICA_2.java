package org.acme.model.DTO;

public class DTO_T_INST_ACADEMICA_2 {
    private String nm_instAcademica;
    private String cnpj_inst_academica;
    private long id_endereco;

    public DTO_T_INST_ACADEMICA_2(String nm_instAcademica, String cnpj_inst_academica, long id_endereco) {
        this.nm_instAcademica = nm_instAcademica;
        this.cnpj_inst_academica = cnpj_inst_academica;
        this.id_endereco = id_endereco;
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

    public long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
