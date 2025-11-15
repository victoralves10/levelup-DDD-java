package org.acme.model;

public class T_VAGA_EMPRESA {

    private long id_vagaEmpresa;
    private String vaga_tema;
    private String des_vaga;
    private String st_vaga;

    public T_VAGA_EMPRESA(long id_vagaEmpresa, String vaga_tema, String des_vaga, String st_vaga) {
        this.id_vagaEmpresa = id_vagaEmpresa;
        this.vaga_tema = vaga_tema;
        this.des_vaga = des_vaga;
        this.st_vaga = st_vaga;
    }
    public T_VAGA_EMPRESA(long id_vagaEmpresa, String vaga_tema, String st_vaga) {
        this.id_vagaEmpresa = id_vagaEmpresa;
        this.vaga_tema = vaga_tema;
        this.st_vaga = st_vaga;
    }

     // ------ getter e setter -------


    public long getId_vagaEmpresa() {
        return id_vagaEmpresa;
    }

    public void setId_vagaEmpresa(long id_vagaEmpresa) {
        this.id_vagaEmpresa = id_vagaEmpresa;
    }

    public String getVaga_tema() {
        return vaga_tema;
    }

    public void setVaga_tema(String vaga_tema) {
        this.vaga_tema = vaga_tema;
    }

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
}
