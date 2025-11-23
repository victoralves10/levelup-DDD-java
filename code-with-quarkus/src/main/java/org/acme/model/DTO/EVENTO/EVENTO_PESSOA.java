package org.acme.model.DTO.EVENTO;

public class EVENTO_PESSOA {
    private int idPessoa;
    private int idEvento;

    public EVENTO_PESSOA(int idPessoa, int idEvento) {
        this.idPessoa = idPessoa;
        this.idEvento = idEvento;
    }

    public int getIdPessoa() { return idPessoa; }
    public void setIdPessoa(int idPessoa) { this.idPessoa = idPessoa; }

    public int getIdEvento() { return idEvento; }
    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }
}
