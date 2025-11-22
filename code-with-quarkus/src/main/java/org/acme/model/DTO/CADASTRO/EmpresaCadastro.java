package org.acme.model.DTO.CADASTRO;

public class EmpresaCadastro {

    // =============================
    // DADOS DE LOGIN (T_LVUP_LOGIN)
    // =============================
    private String login;
    private String senha;
    private String confirmar_senha; // Campo de controle do frontend

    // =============================
    // DADOS DA EMPRESA (T_EMPRESA)
    // =============================
    private String nome_empresa;      // nm_empresa
    private String cnpj;              // cnpj_empresa
    private String email;             // email_empresa
    private String dt_cadastro;       // Mantido como string para receber do frontend

    // =============================
    // ENDEREÇO (T_ENDERECO)
    // =============================
    private String cep;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;

    // =============================
    // GETTERS E SETTERS
    // =============================
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getConfirmar_senha() { return confirmar_senha; }
    public void setConfirmar_senha(String confirmar_senha) { this.confirmar_senha = confirmar_senha; }

    public String getNome_empresa() { return nome_empresa; }
    public void setNome_empresa(String nome_empresa) { this.nome_empresa = nome_empresa; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDt_cadastro() { return dt_cadastro; }
    public void setDt_cadastro(String dt_cadastro) { this.dt_cadastro = dt_cadastro; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
}
