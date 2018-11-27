package Model;

public class Contato {
    String codigo;
    
    String tipo;

    String conteudo;
    
    //Recebe o valor do pai exemplo: Se for um endereço de Cliente, terá um cliente
    Pessoa pai;
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConteudo() {
        return conteudo;
    }
    
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
     public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
    
    
    public String toFileString() {
        return this.codigo + ";" + this.pai.getCodigo() + ";" + this.tipo + ";" + this.conteudo;
    }
}
