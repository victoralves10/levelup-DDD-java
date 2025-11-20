package org.acme.model.DTO.CADASTRO;

import java.time.LocalDate;

public class PessoaCadastro {

    // =================================================================
    // 1. T_LVUP_LOGIN (Credenciais)
    // =================================================================
    private String login;
    private String senha;

    // =================================================================
    // 2. T_PESSOA (Dados Pessoais)
    // =================================================================
    private String nome; // nm_pessoa
    private String cpf; // cpf_pessoa
    private LocalDate dataNascimento; // dt_nascimento

    // =================================================================
    // 3. T_ENDERECO
    // =================================================================
    private String cep;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String numero;
    private String complemento;

    // =================================================================
    // Construtores
    // =================================================================



    /** Construtor padrão (necessário para deserialização JSON/Jackson) */
    public PessoaCadastro() {
    }

    public PessoaCadastro(String login, String senha, String nome, String cpf, LocalDate dataNascimento, String cep, String pais, String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    /** Construtor com todos os campos (útil para testes ou Services) */

    // =================================================================
    // Getters e Setters
    // =================================================================

    // Login
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    // Senha
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Nome
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    // CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Data Nascimento
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // CEP
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    // País
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    // Estado
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Cidade
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Bairro
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    // Rua
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }

    // Número
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Complemento
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}
