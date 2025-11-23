package org.acme.model.DTO;

import java.util.Date;

public class DTO_JOIN_ENDERECO_EVENTO {
    private long id_evento;
    private String nm_evento;
    private String descricao_evento;
    private int qt_dias;
    private Date dt_inicio_evento;

    private long id_endereco;
    private String cep;
    private String pais;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;

    public DTO_JOIN_ENDERECO_EVENTO(long id_evento, String nm_evento, String descricao_evento, int qt_dias, Date dt_inicio_evento,
                                    long id_endereco, String cep, String pais, String estado, String cidade, String bairro, String rua,
                                    int numero, String complemento) {
        this.id_evento = id_evento;
        this.nm_evento = nm_evento;
        this.descricao_evento = descricao_evento;
        this.qt_dias = qt_dias;
        this.dt_inicio_evento = dt_inicio_evento;
        this.id_endereco = id_endereco;
        this.cep = cep;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    // Getters e Setters
    public long getId_evento() { return id_evento; }
    public void setId_evento(long id_evento) { this.id_evento = id_evento; }

    public String getNm_evento() { return nm_evento; }
    public void setNm_evento(String nm_evento) { this.nm_evento = nm_evento; }

    public String getDescricao_evento() { return descricao_evento; }
    public void setDescricao_evento(String descricao_evento) { this.descricao_evento = descricao_evento; }

    public int getQt_dias() { return qt_dias; }
    public void setQt_dias(int qt_dias) { this.qt_dias = qt_dias; }

    public Date getDt_inicio_evento() { return dt_inicio_evento; }
    public void setDt_inicio_evento(Date dt_inicio_evento) { this.dt_inicio_evento = dt_inicio_evento; }

    public long getId_endereco() { return id_endereco; }
    public void setId_endereco(long id_endereco) { this.id_endereco = id_endereco; }

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