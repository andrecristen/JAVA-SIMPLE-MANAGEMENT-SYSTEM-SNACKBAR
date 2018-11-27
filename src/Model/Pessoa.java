package Model;

import java.util.ArrayList;

public class Pessoa {

    String nome;

    String login;

    String senha;

    String codigo;

    ArrayList contatos = new ArrayList<Contato>();
    ArrayList enderecos = new ArrayList<Endereco>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ArrayList getContatos() {
        return contatos;
    }

    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    public ArrayList getEnderecos() {
        return enderecos;
    }

    public void addEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", login=" + login + ", senha=" + senha + ", contatos=" + contatos + ", enderecos=" + enderecos + '}';
    }

}
