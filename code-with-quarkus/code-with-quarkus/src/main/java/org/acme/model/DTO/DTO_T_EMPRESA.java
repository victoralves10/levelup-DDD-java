package org.acme.model.DTO;

import org.acme.model.T_ENDERECO;
import org.acme.model.T_LVUP_LOGIN;

import java.util.Date;

public class DTO_T_EMPRESA {

    private String nm_pessoa;
    private String cpf_pessoa;
    private Date dt_nascimento;
    private T_ENDERECO endereco;
    private T_LVUP_LOGIN login;


    // CONSTRUTOR COMPLETO
    public DTO_T_EMPRESA(String nm_pessoa, String cpf_pessoa, Date dt_nascimento, T_ENDERECO endereco, T_LVUP_LOGIN login) {
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.endereco = endereco;
        this.login = login;
    }

    // CONSTRUTOR SEM ENDERECO
    public DTO_T_EMPRESA(String nm_pessoa, String cpf_pessoa, Date dt_nascimento, T_LVUP_LOGIN login) {
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
        this.login = login;
    }

    // TESTE (sem FK's)
    public DTO_T_EMPRESA(String nm_pessoa, String cpf_pessoa, Date dt_nascimento) {
        this.nm_pessoa = nm_pessoa;
        this.cpf_pessoa = cpf_pessoa;
        this.dt_nascimento = dt_nascimento;
    }
}
