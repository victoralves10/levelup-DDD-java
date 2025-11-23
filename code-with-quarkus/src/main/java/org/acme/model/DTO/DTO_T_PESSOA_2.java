package org.acme.model.DTO;

import java.time.LocalDate;

public class DTO_T_PESSOA_2 {

    private String nm_pessoa;
    private String cpf_pessoa;
    private LocalDate dt_nascimento;
    private long id_endereco;

    public DTO_T_PESSOA_2(String nm_pessoa, String cpf_pessoa, LocalDate dt_nascimento, long id_endereco) {
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.id_endereco = id_endereco;
    }

    public String getNm_pessoa() {
        return nm_pessoa;
    }

    public void setNm_pessoa(String nm_pessoa) {
        this.nm_pessoa = nm_pessoa;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public void setCpf_pessoa(String cpf_pessoa) {
        this.cpf_pessoa = cpf_pessoa;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(long id_endereco) {
        this.id_endereco = id_endereco;
    }
}
