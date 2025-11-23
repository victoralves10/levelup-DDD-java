package org.acme.model.DTO.JOINS;

import java.time.LocalDate;

public class DTO_EVENTOxPESSOA_RETORNO {

    private long id_evento;
    private String nm_evento;
    private String descricao_evento;
    private int qt_dias;
    private LocalDate dt_inicio_evento;

    // Construtor vazio (importante para desserialização JSON)
    public DTO_EVENTOxPESSOA_RETORNO() {}

    public DTO_EVENTOxPESSOA_RETORNO(long id_evento, String nm_evento, String descricao_evento,
                                     int qt_dias, LocalDate dt_inicio_evento) {
        this.id_evento = id_evento;
        this.nm_evento = nm_evento;
        this.descricao_evento = descricao_evento;
        this.qt_dias = qt_dias;
        this.dt_inicio_evento = dt_inicio_evento;
    }

    // Getters e setters
    public long getId_evento() { return id_evento; }
    public void setId_evento(long id_evento) { this.id_evento = id_evento; }

    public String getNm_evento() { return nm_evento; }
    public void setNm_evento(String nm_evento) { this.nm_evento = nm_evento; }

    public String getDescricao_evento() { return descricao_evento; }
    public void setDescricao_evento(String descricao_evento) { this.descricao_evento = descricao_evento; }

    public int getQt_dias() { return qt_dias; }
    public void setQt_dias(int qt_dias) { this.qt_dias = qt_dias; }

    public LocalDate getDt_inicio_evento() { return dt_inicio_evento; }
    public void setDt_inicio_evento(LocalDate dt_inicio_evento) { this.dt_inicio_evento = dt_inicio_evento; }
}
