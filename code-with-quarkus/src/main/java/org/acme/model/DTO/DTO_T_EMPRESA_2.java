package org.acme.model.DTO;

import java.time.LocalDate;

public class DTO_T_EMPRESA_2 {

    private String nm_empresa;
    private String cnpj_empresa;
    private String email_empresa;
    private LocalDate dt_cadastro; // pode ser String ou Date, dependendo da serialização
    private long id_endereco;

    public DTO_T_EMPRESA_2() {
    }

    public DTO_T_EMPRESA_2(String nm_empresa, String cnpj_empresa, String email_empresa, LocalDate dt_cadastro, long id_endereco) {
        this.nm_empresa = nm_empresa;
        this.cnpj_empresa = cnpj_empresa;
        this.email_empresa = email_empresa;
        this.dt_cadastro = dt_cadastro;
        this.id_endereco = id_endereco;
    }


    public String getNm_empresa() {
        return nm_empresa;
    }

    public void setNm_empresa(String nm_empresa) {
        this.nm_empresa = nm_empresa;
    }

    public String getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(String cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public String getEmail_empresa() {
        return email_empresa;
    }

    public void setEmail_empresa(String email_empresa) {
        this.email_empresa = email_empresa;
    }

    public LocalDate getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(LocalDate dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
