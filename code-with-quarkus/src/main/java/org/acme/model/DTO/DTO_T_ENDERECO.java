package org.acme.model.DTO;

public class DTO_T_ENDERECO {

    private String cep;
    private String pais;        // VARCHAR2(3) - validar tamanho
    private String estado;      // VARCHAR2(2) - validar tamanho
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;         // INTEGER conforme DDL
    private String complemento;

    public DTO_T_ENDERECO() {}

    public DTO_T_ENDERECO(String cep, String pais, String estado,
                          String cidade, String bairro, String rua, int numero, String complemento) {
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public DTO_T_ENDERECO(String cep, String pais, String estado,
                          String cidade, String bairro, String rua, int numero) {
        this(cep, pais, estado, cidade, bairro, rua, numero, null);
    }

    // getters / setters

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
