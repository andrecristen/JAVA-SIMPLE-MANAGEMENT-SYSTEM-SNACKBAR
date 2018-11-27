package Model;

public class Endereco {

    String codigo; 

    String rua;

    String bairro;

    String cidade;

    String estado;

    String complemento;

    String referencia;
    
    //Recebe o valor do pai exemplo: Se for um endereço de Cliente, terá um cliente.
    Pessoa pai;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Pessoa getPai() {
        return pai;
    }

    public void setPai(Pessoa pai) {
        this.pai = pai;
    }
    
    
     public String toFileString() {
        return this.codigo + ";" + this.pai.getCodigo() + ";" + this.rua + ";" + this.bairro+";"+ this.cidade+";"+this.estado+";"+this.complemento+";"+this.referencia;
    }
}
