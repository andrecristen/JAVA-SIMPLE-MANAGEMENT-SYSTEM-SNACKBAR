package Model;

public class Atendente extends Pessoa {

    String funcao;
    String sobrenome;
    String dataNascimento;
    String dataAdmissao;

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    public String toFileString() {
        return this.codigo + ";" + this.nome + ";" + this.sobrenome + ";" + this.funcao+";"+ this.dataNascimento+";"+this.dataAdmissao+";"+this.login+";"+this.senha;
    }
}
