package org.acme.model;

import java.time.LocalDate;

public class T_LVUP_EVENTO {

    private long id_evento;
    private String nm_evento;
    private String descricao_evento;
    private Integer qt_dias;
    private LocalDate dt_inicio_evento;
    private long id_instAcademica;
    private long id_endereco;
    private long id_vagaEmpresa; // pode ser null

    public T_LVUP_EVENTO() {}

    public T_LVUP_EVENTO(long id_evento, String nm_evento, String descricao_evento, Integer qt_dias,
                         LocalDate dt_inicio_evento, long id_instAcademica, long id_endereco, long id_vagaEmpresa) {
        this.id_evento = id_evento;
        this.nm_evento = nm_evento;
        this.descricao_evento = descricao_evento;
        this.qt_dias = qt_dias;
        this.dt_inicio_evento = dt_inicio_evento;
        this.id_instAcademica = id_instAcademica;
        this.id_endereco = id_endereco;
        this.id_vagaEmpresa = id_vagaEmpresa;
    }

    // Getters e Setters
    public long getId_evento() { return id_evento; }
    public void setId_evento(long id_evento) { this.id_evento = id_evento; }

    public String getNm_evento() { return nm_evento; }
    public void setNm_evento(String nm_evento) { this.nm_evento = nm_evento; }

    public String getDescricao_evento() { return descricao_evento; }
    public void setDescricao_evento(String descricao_evento) { this.descricao_evento = descricao_evento; }

    public Integer getQt_dias() { return qt_dias; }
    public void setQt_dias(Integer qt_dias) { this.qt_dias = qt_dias; }

    public LocalDate getDt_inicio_evento() { return dt_inicio_evento; }
    public void setDt_inicio_evento(LocalDate dt_inicio_evento) { this.dt_inicio_evento = dt_inicio_evento; }

    public long getId_instAcademica() { return id_instAcademica; }
    public void setId_instAcademica(long id_instAcademica) { this.id_instAcademica = id_instAcademica; }

    public long getId_endereco() { return id_endereco; }
    public void setId_endereco(long id_endereco) { this.id_endereco = id_endereco; }

    public long getId_vagaEmpresa() { return id_vagaEmpresa; }
    public void setId_vagaEmpresa(long id_vagaEmpresa) { this.id_vagaEmpresa = id_vagaEmpresa; }
}
