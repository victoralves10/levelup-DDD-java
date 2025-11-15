package org.acme.model.DTO;

public class DTO_T_VAGA_EMPRESA {

    private String vaga_tema;
    private String des_vaga;
    private String st_vaga;

    // CONSTRUTOR COMPLETO
    public DTO_T_VAGA_EMPRESA(String vaga_tema, String des_vaga, String st_vaga) {
        this.vaga_tema = vaga_tema;
        this.des_vaga = des_vaga;
        this.st_vaga = st_vaga;
    }

    // CONSTRUTOR SEM DESCRICAO
    public DTO_T_VAGA_EMPRESA(String vaga_tema, String st_vaga) {
        this.vaga_tema = vaga_tema;
        this.st_vaga = st_vaga;
    }


    // GET E SET

    public String getDes_vaga() {
        return des_vaga;
    }

    public void setDes_vaga(String des_vaga) {
        this.des_vaga = des_vaga;
    }

    public String getSt_vaga() {
        return st_vaga;
    }

    public void setSt_vaga(String st_vaga) {
        this.st_vaga = st_vaga;
    }

    public String getVaga_tema() {
        return vaga_tema;
    }

    public void setVaga_tema(String vaga_tema) {
        this.vaga_tema = vaga_tema;
    }
}
