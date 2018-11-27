package Model;

public class Fornecedor extends Pessoa {

    String cnpj;

    String nomeFatasia;

    String inscricaoEstadual;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFatasia() {
        return nomeFatasia;
    }

    public void setNomeFatasia(String nomeFatasia) {
        this.nomeFatasia = nomeFatasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String toFileString() {
        return this.codigo + ";" + this.nome + ";" + this.nomeFatasia + ";" + this.cnpj + ";" + this.inscricaoEstadual + ";" + this.login + ";" + this.senha;
    }

}
