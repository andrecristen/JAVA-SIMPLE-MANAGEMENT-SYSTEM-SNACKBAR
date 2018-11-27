package Model;

import java.util.ArrayList;

public class Venda {

    String codigo;
    
    Cliente cliente;

    Atendente atendente;

    String dataCompra;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

     public String toFileString() {
        return this.codigo + ";" + this.cliente.getCodigo() + ";" + this.atendente.getCodigo() + ";" + this.dataCompra;
    }
}
