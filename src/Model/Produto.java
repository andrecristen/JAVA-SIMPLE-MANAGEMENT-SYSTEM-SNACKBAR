package Model;

public class Produto {

    String codigo;

    String nome;

    String descricao;

    Float precoVenda;

    Float precoCompra;

    Fornecedor pai;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public Fornecedor getPai() {
        return pai;
    }

    public void setPai(Fornecedor pai) {
        this.pai = pai;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

     public String toFileString() {
        return this.codigo + ";" + this.pai.getCodigo() + ";" + this.nome + ";" + this.descricao+";"+this.precoCompra+";"+this.precoVenda;
    }
}
