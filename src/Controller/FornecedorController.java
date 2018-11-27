package Controller;

import Model.Contato;
import Model.Endereco;
import Model.Fornecedor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class FornecedorController {
    
    Constantes cons = new Constantes();

    ArrayList<Fornecedor> fornecedores = new ArrayList<>();
    ArrayList<Endereco> enderecosFornecedores = new ArrayList<>();
    ArrayList<Contato> contatosFornecedores = new ArrayList<>();

    public Fornecedor findFornecedorByCodigo(String codigo) {
        Fornecedor fornecedor = new Fornecedor();
        this.lerArquivoFornecedor();
        for (Fornecedor fornecedorAtual : this.fornecedores) {
            if (fornecedorAtual.getCodigo().equals(codigo)) {
                return fornecedorAtual;
            }
        }
        return fornecedor;
    }

    public String cadastrarNovoFornecedor(String codigo, String nome, String login, String senha, String cnpj, String nomeFantasia, String inscricaoEstadual, String[][] enderecos, String[][] contatos) {
        this.lerArquivoFornecedor();
        this.lerArquivoEnderecosFornecedor();
        this.lerArquivoContatosFornecedor();
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCodigo(codigo);
        fornecedor.setNome(nome);
        fornecedor.setLogin(login);
        fornecedor.setSenha(senha);
        fornecedor.setCnpj(cnpj);
        fornecedor.setNomeFatasia(nomeFantasia);
        fornecedor.setInscricaoEstadual(inscricaoEstadual);
        this.fornecedores.add(fornecedor);
        try {
            for (int i = 0; i < enderecos.length; i++) {
                Endereco endereco = new Endereco();
                endereco.setCodigo(enderecos[i][0].toString());
                endereco.setPai(fornecedor);
                endereco.setRua(enderecos[i][1].toString());
                endereco.setBairro(enderecos[i][2].toString());
                endereco.setCidade(enderecos[i][3].toString());
                endereco.setEstado(enderecos[i][4].toString());
                endereco.setComplemento(enderecos[i][5].toString());
                endereco.setReferencia(enderecos[i][6].toString());
                fornecedor.addEndereco(endereco);
                this.enderecosFornecedores.add(endereco);
            }
            for (int j = 0; j < contatos.length; j++) {
                if (contatos[j][0] != null) {
                    Contato contato = new Contato();
                    contato.setCodigo(contatos[j][0].toString());
                    contato.setPai(fornecedor);
                    contato.setTipo(contatos[j][1].toString());
                    contato.setConteudo(contatos[j][2].toString());
                    fornecedor.addContato(contato);
                    this.contatosFornecedores.add(contato);
                }
            }
            boolean retorno = this.gravarArquivoFornecedor();
            boolean retornoEndereco = this.gravarEnderecoFornecedor();
            boolean retornoContato = this.gravarContatoFornecedor();
            if (retorno) {
                return "Cadastro efetuado com sucesso";
            }
        } catch (Exception e) {
            return "Não foi possível executar o cadastro de um novo fornecedor";
        }
        return "Sem mensagem definida, contate suporte imediatamanete!";
    }

    private boolean gravarArquivoFornecedor() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_FORNECEDOR);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Fornecedor fornecedor : this.fornecedores) {
                gravadorTexto.write(fornecedor.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean lerArquivoFornecedor() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_FORNECEDOR);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setCodigo(valores[0]);
                    fornecedor.setNome(valores[1]);
                    fornecedor.setNomeFatasia(valores[2]);
                    fornecedor.setCnpj(valores[3]);
                    fornecedor.setInscricaoEstadual(valores[4]);
                    fornecedor.setLogin(valores[5]);
                    fornecedor.setSenha(valores[6]);
                    this.fornecedores.add(fornecedor);
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

    private boolean gravarEnderecoFornecedor() {
        ArquivoController arqController = new ArquivoController();
        boolean success = arqController.gravarEndereco(cons.PATH_PART_INITIAL+cons.ENDERECO_FORNECEDOR, this.enderecosFornecedores);
        return success;
    }

    private boolean gravarContatoFornecedor() {
        ArquivoController arqController = new ArquivoController();
        boolean success = arqController.gravarContatos(cons.PATH_PART_INITIAL+cons.CONTATO_FORNECEDOR, this.contatosFornecedores);
        return success;
    }

    private void lerArquivoEnderecosFornecedor() {
        ArquivoController arqController = new ArquivoController();
        this.enderecosFornecedores = arqController.lerArquivoEnderecos(cons.PATH_PART_INITIAL+cons.ENDERECO_FORNECEDOR, cons.TIPO_FORNECEDOR);
    }

    private void lerArquivoContatosFornecedor() {
        ArquivoController arqController = new ArquivoController();
        this.contatosFornecedores = arqController.lerArquivoContatos(cons.PATH_PART_INITIAL+cons.CONTATO_FORNECEDOR, cons.TIPO_FORNECEDOR);
    }

    public ArrayList selecionarTodosFornecedores() {
        lerArquivoFornecedor();
        return this.fornecedores;
    }

    public boolean removerFornecedorByCodigo(String codigo) {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_FORNECEDOR);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.setCodigo(valores[0]);
                    fornecedor.setNome(valores[1]);
                    fornecedor.setNomeFatasia(valores[2]);
                    fornecedor.setCnpj(valores[3]);
                    fornecedor.setInscricaoEstadual(valores[4]);
                    fornecedor.setLogin(valores[5]);
                    fornecedor.setSenha(valores[6]);
                    //Se não for o que estamos excluido adicionamos se for só ignora
                    if (!fornecedor.getCodigo().equals(codigo)) {
                        this.fornecedores.add(fornecedor);
                    }
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            ArquivoController arqController = new ArquivoController();
            arqController.apagarEnderecosAndContatosByCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.ENDERECO_FORNECEDOR, cons.PATH_PART_INITIAL+cons.CONTATO_FORNECEDOR, cons.TIPO_FORNECEDOR);
            this.gravarArquivoFornecedor();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String editarFornecedor(String codigo, String nome, String login, String senha, String cnpj, String nomeFantasia, String inscricaoEstadual, String[][] enderecos, String[][] contatos) {
        ArquivoController arqController = new ArquivoController();
        this.lerArquivoFornecedor();
        ArrayList<Fornecedor> fornecedoresEditados = new ArrayList<>();
        Fornecedor newFornecedorEditado = null;
        for (Fornecedor fornecedor : this.fornecedores) {
            if (!fornecedor.getCodigo().equalsIgnoreCase(codigo)) {
                fornecedoresEditados.add(fornecedor);
            } else {
                newFornecedorEditado = new Fornecedor();
                newFornecedorEditado.setCodigo(codigo);
                newFornecedorEditado.setCnpj(cnpj);
                newFornecedorEditado.setInscricaoEstadual(inscricaoEstadual);
                newFornecedorEditado.setLogin(login);
                newFornecedorEditado.setNome(nome);
                newFornecedorEditado.setNomeFatasia(nomeFantasia);
                newFornecedorEditado.setSenha(senha);
                fornecedoresEditados.add(newFornecedorEditado);
            }
        }
        this.fornecedores = fornecedoresEditados;
        this.gravarArquivoFornecedor();
        //Temos todos os contatos menos o deste pai pois aqui vamos regravar com os que forão editados.
        ArrayList<Contato> allContatosIgnorePai = arqController.getContatosIgnoreCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.CONTATO_FORNECEDOR, cons.TIPO_FORNECEDOR);
        for (int j = 0; j < contatos.length; j++) {
            if (contatos[j][0] != null) {
                Contato contato = new Contato();
                contato.setCodigo(contatos[j][0].toString());
                contato.setPai(newFornecedorEditado);
                contato.setTipo(contatos[j][1].toString());
                contato.setConteudo(contatos[j][2].toString());
                allContatosIgnorePai.add(contato);
            }
        }
        boolean successC = arqController.gravarContatos(cons.PATH_PART_INITIAL+cons.CONTATO_FORNECEDOR, allContatosIgnorePai);

        ArrayList<Endereco> allEnderecosIgnorePai = arqController.getEnderecosIgnoreCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.ENDERECO_FORNECEDOR, cons.TIPO_FORNECEDOR);
        for (int i = 0; i < enderecos.length; i++) {
            Endereco endereco = new Endereco();
            endereco.setCodigo(enderecos[i][0].toString());
            endereco.setPai(newFornecedorEditado);
            endereco.setRua(enderecos[i][1].toString());
            endereco.setBairro(enderecos[i][2].toString());
            endereco.setCidade(enderecos[i][3].toString());
            endereco.setEstado(enderecos[i][4].toString());
            endereco.setComplemento(enderecos[i][5].toString());
            endereco.setReferencia(enderecos[i][6].toString());
            allEnderecosIgnorePai.add(endereco);
        }
        boolean successE = arqController.gravarEndereco(cons.PATH_PART_INITIAL+cons.ENDERECO_FORNECEDOR, allEnderecosIgnorePai);
        return "Fornecedor Editado com sucesso";
    }
}
