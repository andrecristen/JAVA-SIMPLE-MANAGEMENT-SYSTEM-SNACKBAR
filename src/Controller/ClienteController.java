package Controller;

import Model.Cliente;
import Model.Contato;
import Model.Endereco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class ClienteController {

    Constantes cons = new Constantes();

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Endereco> enderecosClientes = new ArrayList<>();
    ArrayList<Contato> contatosClientes = new ArrayList<>();

    public Cliente findClienteByCodigo(String codigo) {
        Cliente cliente = new Cliente();
        this.lerArquivoCliente();
        for (Cliente clienteAtual : this.clientes) {
            if (clienteAtual.getCodigo().equals(codigo)) {
                return clienteAtual;
            }
        }
        return cliente;
    }

    public String cadastrarNovoCliente(String codigo, String nome, String sobrenome, String login, String senha, String cpf, String nascimento, String[][] enderecos, String[][] contatos) {
        //Vamos buscar nossos dados referentes ao clientes;
        this.lerArquivoCliente();
        this.lerArquivoEnderecosCliente();
        this.lerArquivoContatosCliente();
        Cliente cliente = new Cliente();
        cliente.setCodigo(codigo);
        cliente.setNome(nome);
        cliente.setSobrenome(sobrenome);
        cliente.setLogin(login);
        cliente.setSenha(senha);
        cliente.setCpf(cpf);
        cliente.setDataNascimento(nascimento);
        try {
            for (int i = 0; i < enderecos.length; i++) {
                Endereco endereco = new Endereco();
                endereco.setCodigo(enderecos[i][0].toString());
                endereco.setPai(cliente);
                endereco.setRua(enderecos[i][1].toString());
                endereco.setBairro(enderecos[i][2].toString());
                endereco.setCidade(enderecos[i][3].toString());
                endereco.setEstado(enderecos[i][4].toString());
                endereco.setComplemento(enderecos[i][5].toString());
                endereco.setReferencia(enderecos[i][6].toString());
                cliente.addEndereco(endereco);
                enderecosClientes.add(endereco);
            }
            for (int j = 0; j < contatos.length; j++) {
                if (contatos[j][0] != null) {
                    Contato contato = new Contato();
                    contato.setPai(cliente);
                    contato.setCodigo(contatos[j][0].toString());
                    contato.setTipo(contatos[j][1].toString());
                    contato.setConteudo(contatos[j][2].toString());
                    cliente.addContato(contato);
                    this.contatosClientes.add(contato);
                }
            }
            this.clientes.add(cliente);
            boolean retorno = this.gravarArquivoCliente();
            boolean retornoEndereco = this.gravarEnderecoCliente();
            boolean retornoContato = this.gravarContatosCliente();
            if (retorno) {
                return "Cadastro efetuado com sucesso";
            }
        } catch (Exception e) {
            return "Não foi possível executar o cadastro de um novo cliente";
        }
        return "Sem mensagem definida, contate suporte imediatamanete!";
    }

    private boolean gravarArquivoCliente() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_CLIENTE);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Cliente cliente : this.clientes) {
                gravadorTexto.write(cliente.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean gravarEnderecoCliente() {
        ArquivoController arqController = new ArquivoController();
        boolean success = arqController.gravarEndereco(cons.PATH_PART_INITIAL+cons.ENDERECO_CLIENTE, this.enderecosClientes);
        return success;
    }

    private boolean gravarContatosCliente() {
        ArquivoController arqController = new ArquivoController();
        boolean success = arqController.gravarContatos(cons.PATH_PART_INITIAL+cons.CONTATO_CLIENTE, this.contatosClientes);
        return success;
    }

    private boolean lerArquivoCliente() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_CLIENTE);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(valores[0]);
                    cliente.setNome(valores[1]);
                    cliente.setSobrenome(valores[2]);
                    cliente.setCpf(valores[3]);
                    cliente.setDataNascimento(valores[4]);
                    cliente.setLogin(valores[5]);
                    cliente.setSenha(valores[6]);
                    this.clientes.add(cliente);
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void lerArquivoEnderecosCliente() {
        ArquivoController arqController = new ArquivoController();
        this.enderecosClientes = arqController.lerArquivoEnderecos(cons.PATH_PART_INITIAL+cons.ENDERECO_CLIENTE, cons.TIPO_CLIENTE);
    }

    private void lerArquivoContatosCliente() {
        ArquivoController arqController = new ArquivoController();
        this.contatosClientes = arqController.lerArquivoContatos(cons.PATH_PART_INITIAL+cons.CONTATO_CLIENTE, cons.TIPO_CLIENTE);
    }

    public ArrayList selecionarTodosClientes() {
        lerArquivoCliente();
        return this.clientes;
    }

    public boolean removerClienteByCodigo(String codigo) {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_CLIENTE);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Cliente cliente = new Cliente();
                    cliente.setCodigo(valores[0]);
                    cliente.setNome(valores[1]);
                    cliente.setSobrenome(valores[2]);
                    cliente.setCpf(valores[3]);
                    cliente.setDataNascimento(valores[4]);
                    cliente.setLogin(valores[5]);
                    cliente.setSenha(valores[6]);
                    if (!cliente.getCodigo().equals(codigo)) {
                        this.clientes.add(cliente);
                    }
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            ArquivoController arqController = new ArquivoController();
            arqController.apagarEnderecosAndContatosByCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.ENDERECO_CLIENTE, cons.PATH_PART_INITIAL+cons.CONTATO_CLIENTE, cons.TIPO_CLIENTE);
            this.gravarArquivoCliente();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String editarCliente(String codigo, String nome, String sobrenome, String login, String senha, String cpf, String nascimento, String[][] enderecos, String[][] contatos) {
        ArquivoController arqController = new ArquivoController();
        this.lerArquivoCliente();
        ArrayList<Cliente> clientesEditados = new ArrayList<>();
        Cliente newClienteEditado = null;
        for (Cliente cliente : this.clientes) {
            if (!cliente.getCodigo().equalsIgnoreCase(codigo)) {
                clientesEditados.add(cliente);
            } else {
                newClienteEditado = new Cliente();
                newClienteEditado.setCodigo(codigo);
                newClienteEditado.setCpf(cpf);
                newClienteEditado.setDataNascimento(nascimento);
                newClienteEditado.setLogin(login);
                newClienteEditado.setNome(nome);
                newClienteEditado.setSobrenome(sobrenome);
                newClienteEditado.setSenha(senha);
                clientesEditados.add(newClienteEditado);
            }
        }
        this.clientes = clientesEditados;
        this.gravarArquivoCliente();
        //Temos todos os contatos menos o deste pai pois aqui vamos regravar com os que forão editados.
        ArrayList<Contato> allContatosIgnorePai = arqController.getContatosIgnoreCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.CONTATO_CLIENTE, cons.TIPO_CLIENTE);
        for (int j = 0; j < contatos.length; j++) {
            if (contatos[j][0] != null) {
                Contato contato = new Contato();
                contato.setCodigo(contatos[j][0].toString());
                contato.setPai(newClienteEditado);
                contato.setTipo(contatos[j][1].toString());
                contato.setConteudo(contatos[j][2].toString());
                allContatosIgnorePai.add(contato);
            }
        }
        boolean successC = arqController.gravarContatos(cons.PATH_PART_INITIAL+cons.CONTATO_CLIENTE, allContatosIgnorePai);

        ArrayList<Endereco> allEnderecosIgnorePai = arqController.getEnderecosIgnoreCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.ENDERECO_CLIENTE, cons.TIPO_CLIENTE);
        for (int i = 0; i < enderecos.length; i++) {
            Endereco endereco = new Endereco();
            endereco.setCodigo(enderecos[i][0].toString());
            endereco.setPai(newClienteEditado);
            endereco.setRua(enderecos[i][1].toString());
            endereco.setBairro(enderecos[i][2].toString());
            endereco.setCidade(enderecos[i][3].toString());
            endereco.setEstado(enderecos[i][4].toString());
            endereco.setComplemento(enderecos[i][5].toString());
            endereco.setReferencia(enderecos[i][6].toString());
            allEnderecosIgnorePai.add(endereco);
        }
        boolean successE = arqController.gravarEndereco(cons.PATH_PART_INITIAL+cons.ENDERECO_CLIENTE, allEnderecosIgnorePai);
        return "Cliente Editado com sucesso";
    }

}
