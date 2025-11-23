package org.acme.model.DTO;

public class DTO_T_VAGA_EMPRESA_2 {
    private String vaga_tema;
    private String des_vaga;

    public DTO_T_VAGA_EMPRESA_2(String vaga_tema, String des_vaga) {
        this.vaga_tema = vaga_tema;
        this.des_vaga = des_vaga;
    }


    // GET E SET

    public String getDes_vaga() {
        return des_vaga;
    }

    public void setDes_vaga(String des_vaga) {
        this.des_vaga = des_vaga;
    }


    public String getVaga_tema() {
        return vaga_tema;
    }

    public void setVaga_tema(String vaga_tema) {
        this.vaga_tema = vaga_tema;
    }
}
