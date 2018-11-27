package Model;

public class Cliente extends Pessoa {
  
    String cpf;

    String sobrenome;

    String dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    
    @Override
    public String toString() {
        return "Cliente{" + "cpf=" + cpf + ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento + "}"
                + "Pessoa:" + super.toString();
    }

    public String toFileString() {
        return this.codigo + ";" + this.nome + ";" + this.sobrenome + ";" + this.cpf+";"+ this.dataNascimento+";"+this.login+";"+this.senha;
    }

}
