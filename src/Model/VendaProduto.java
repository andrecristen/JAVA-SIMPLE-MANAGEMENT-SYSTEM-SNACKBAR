package Model;

public class VendaProduto {
    String codigo;
    
    Venda venda = new Venda();
    
    String quantidade;
    
    Produto produto;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public String toFileString(){
        return this.codigo+";"+this.venda.getCodigo()+";"+this.produto.getCodigo()+";"+this.quantidade;
    }
}
