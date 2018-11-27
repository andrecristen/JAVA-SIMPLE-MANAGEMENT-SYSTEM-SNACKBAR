package Controller;

import Model.Atendente;
import Model.Contato;
import Model.Endereco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class AtendenteController {
    
    Constantes cons = new Constantes();
    
    ArrayList<Atendente> atendentes = new ArrayList<>();
    ArrayList<Endereco> enderecosAtendentes = new ArrayList<>();
    ArrayList<Contato> contatosAtendentes = new ArrayList<>();

    public Atendente findAtendenteByCodigo(String codigo) {
        Atendente atendente = new Atendente();
        this.lerArquivoAtendente();
        for (Atendente atendenteAtual : this.atendentes) {
            if (atendenteAtual.getCodigo().equals(codigo)) {
                return atendenteAtual;
            }
        }
        return atendente;
    }

    public String cadastrarNovoAtendente(String codigo, String nome, String sobrenome, String login, String senha, String funcao, String nascimento, String adimissao, String[][] enderecos, String[][] contatos) {
        //Vamos buscar nossos dados referentes ao clientes;
        this.lerArquivoAtendente();
        this.lerArquivoEnderecosAtendente();
        this.lerArquivoContatosAtendente();
        Atendente atendente = new Atendente();
        atendente.setCodigo(codigo);
        atendente.setNome(nome);
        atendente.setSobrenome(sobrenome);
        atendente.setLogin(login);
        atendente.setSenha(senha);
        atendente.setDataAdmissao(adimissao);
        atendente.setDataNascimento(nascimento);
        atendente.setFuncao(senha);
        try {
            for (int i = 0; i < enderecos.length; i++) {
                Endereco endereco = new Endereco();
                endereco.setCodigo(enderecos[i][0].toString());
                endereco.setPai(atendente);
                endereco.setRua(enderecos[i][1].toString());
                endereco.setBairro(enderecos[i][2].toString());
                endereco.setCidade(enderecos[i][3].toString());
                endereco.setEstado(enderecos[i][4].toString());
                endereco.setComplemento(enderecos[i][5].toString());
                endereco.setReferencia(enderecos[i][6].toString());
                atendente.addEndereco(endereco);
                enderecosAtendentes.add(endereco);
            }
            for (int j = 0; j < contatos.length; j++) {
                if (contatos[j][0] != null) {
                    Contato contato = new Contato();
                    contato.setPai(atendente);
                    contato.setCodigo(contatos[j][0].toString());
                    contato.setTipo(contatos[j][1].toString());
                    contato.setConteudo(contatos[j][2].toString());
                    atendente.addContato(contato);
                    this.contatosAtendentes.add(contato);
                }
            }
            this.atendentes.add(atendente);
            boolean retorno = this.gravarArquivoAtendente();
            boolean retornoEndereco = this.gravarEnderecoAtendente();
            boolean retornoContato = this.gravarContatosAtendente();
            if (retorno) {
                return "Cadastro efetuado com sucesso";
            }
        } catch (Exception e) {
            return "Não foi possível executar o cadastro de um novo atendente";
        }
        return "Sem mensagem definida, contate suporte imediatamanete!";
    }

    private boolean gravarArquivoAtendente() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_ATENDENTE);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Atendente atendente : this.atendentes) {
                gravadorTexto.write(atendente.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean gravarEnderecoAtendente() {
        ArquivoController arqController = new ArquivoController();
        boolean success = arqController.gravarEndereco(cons.PATH_PART_INITIAL+cons.ENDERECO_ATENDENTE, this.enderecosAtendentes);
        return success;
    }

    private boolean gravarContatosAtendente() {
        ArquivoController arqController = new ArquivoController();
        boolean success = arqController.gravarContatos(cons.PATH_PART_INITIAL+cons.CONTATO_ATENDENTE, this.contatosAtendentes);
        return success;
    }

    private boolean lerArquivoAtendente() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_ATENDENTE);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Atendente atendente = new Atendente();
                    atendente.setCodigo(valores[0]);
                    atendente.setNome(valores[1]);
                    atendente.setSobrenome(valores[2]);
                    atendente.setFuncao(valores[3]);
                    atendente.setDataNascimento(valores[4]);
                    atendente.setDataAdmissao(valores[5]);
                    atendente.setLogin(valores[6]);
                    atendente.setSenha(valores[7]);
                    this.atendentes.add(atendente);
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

    private void lerArquivoEnderecosAtendente() {
        ArquivoController arqController = new ArquivoController();
        this.enderecosAtendentes = arqController.lerArquivoEnderecos(cons.PATH_PART_INITIAL+cons.ENDERECO_ATENDENTE, cons.TIPO_ATENDENTE);
    }

    private void lerArquivoContatosAtendente() {
        ArquivoController arqController = new ArquivoController();
        this.contatosAtendentes = arqController.lerArquivoContatos(cons.PATH_PART_INITIAL+cons.CONTATO_ATENDENTE, cons.TIPO_ATENDENTE);
    }

    public ArrayList<Atendente> selecionarTodosAtendentes() {
        lerArquivoAtendente();
        return this.atendentes;
    }

    public boolean removerAtendenteByCodigo(String codigo) {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_ATENDENTE);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Atendente atendente = new Atendente();
                    atendente.setCodigo(valores[0]);
                    atendente.setNome(valores[1]);
                    atendente.setSobrenome(valores[2]);
                    atendente.setFuncao(valores[3]);
                    atendente.setDataNascimento(valores[4]);
                    atendente.setDataAdmissao(valores[5]);
                    atendente.setLogin(valores[6]);
                    atendente.setSenha(valores[7]);
                    if (!atendente.getCodigo().equals(codigo)) {
                        this.atendentes.add(atendente);
                    }
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            ArquivoController arqController = new ArquivoController();
            arqController.apagarEnderecosAndContatosByCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.ENDERECO_ATENDENTE, cons.PATH_PART_INITIAL+cons.CONTATO_ATENDENTE, cons.TIPO_ATENDENTE);
            this.gravarArquivoAtendente();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String editarAtendente(String codigo, String nome, String sobrenome, String login, String senha, String funcao, String nascimento, String adimissao, String[][] enderecos, String[][] contatos) {
        ArquivoController arqController = new ArquivoController();
        this.lerArquivoAtendente();
        ArrayList<Atendente> atendentesEditados = new ArrayList<>();
        Atendente newAtendenteEditado = null;
        for (Atendente atendente : this.atendentes) {
            if (!atendente.getCodigo().equalsIgnoreCase(codigo)) {
                atendentesEditados.add(atendente);
            } else {
                newAtendenteEditado = new Atendente();
                newAtendenteEditado.setCodigo(codigo);
                newAtendenteEditado.setDataAdmissao(adimissao);
                newAtendenteEditado.setDataNascimento(nascimento);
                newAtendenteEditado.setFuncao(funcao);
                newAtendenteEditado.setLogin(login);
                newAtendenteEditado.setNome(nome);
                newAtendenteEditado.setSobrenome(sobrenome);
                newAtendenteEditado.setSenha(senha);
                atendentesEditados.add(newAtendenteEditado);
            }
        }
        this.atendentes = atendentesEditados;
        this.gravarArquivoAtendente();
        //Temos todos os contatos menos o deste pai pois aqui vamos regravar com os que forão editados.
        ArrayList<Contato> allContatosIgnorePai = arqController.getContatosIgnoreCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.CONTATO_ATENDENTE, cons.TIPO_ATENDENTE);
        for (int j = 0; j < contatos.length; j++) {
            if (contatos[j][0] != null) {
                Contato contato = new Contato();
                contato.setCodigo(contatos[j][0].toString());
                contato.setPai(newAtendenteEditado);
                contato.setTipo(contatos[j][1].toString());
                contato.setConteudo(contatos[j][2].toString());
                allContatosIgnorePai.add(contato);
            }
        }
        boolean successC = arqController.gravarContatos(cons.PATH_PART_INITIAL+cons.CONTATO_ATENDENTE, allContatosIgnorePai);

        ArrayList<Endereco> allEnderecosIgnorePai = arqController.getEnderecosIgnoreCodigoPai(codigo, cons.PATH_PART_INITIAL+cons.ENDERECO_ATENDENTE, cons.TIPO_ATENDENTE);
        for (int i = 0; i < enderecos.length; i++) {
            Endereco endereco = new Endereco();
            endereco.setCodigo(enderecos[i][0].toString());
            endereco.setPai(newAtendenteEditado);
            endereco.setRua(enderecos[i][1].toString());
            endereco.setBairro(enderecos[i][2].toString());
            endereco.setCidade(enderecos[i][3].toString());
            endereco.setEstado(enderecos[i][4].toString());
            endereco.setComplemento(enderecos[i][5].toString());
            endereco.setReferencia(enderecos[i][6].toString());
            allEnderecosIgnorePai.add(endereco);
        }
        boolean successE = arqController.gravarEndereco(cons.PATH_PART_INITIAL+cons.ENDERECO_ATENDENTE, allEnderecosIgnorePai);
        return "Fornecedor Editado com sucesso";
    }
    
}
