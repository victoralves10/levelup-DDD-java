package org.acme.model;

import java.time.LocalDate;

public class T_PESSOA {

    private int idPessoa;           // PK
    private String nome;            // nm_pessoa
    private String cpf;             // cpf_pessoa
    private LocalDate dtNascimento; // dt_nascimento

    private long idEndereco;        // obrigatório no front
    private long idLogin;           // obrigatório

    public T_PESSOA() {}

    // Para SELECT
    public T_PESSOA(int idPessoa, String nome, String cpf,
                    LocalDate dtNascimento, long idEndereco, long idLogin) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.idEndereco = idEndereco;
        this.idLogin = idLogin;
    }

    // Para INSERT
    public T_PESSOA(String nome, String cpf,
                    LocalDate dtNascimento, long idEndereco, long idLogin) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.idEndereco = idEndereco;
        this.idLogin = idLogin;
    }

    // Getters e Setters
    public int getIdPessoa() { return idPessoa; }
    public void setIdPessoa(int idPessoa) { this.idPessoa = idPessoa; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public LocalDate getDtNascimento() { return dtNascimento; }
    public void setDtNascimento(LocalDate dtNascimento) { this.dtNascimento = dtNascimento; }

    public long getIdEndereco() { return idEndereco; }
    public void setIdEndereco(long idEndereco) { this.idEndereco = idEndereco; }

    public long getIdLogin() { return idLogin; }
    public void setIdLogin(long idLogin) { this.idLogin = idLogin; }
}
