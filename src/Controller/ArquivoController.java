package Controller;

import Model.Atendente;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;
import Model.Fornecedor;
import Model.Pessoa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArquivoController {

    public boolean gravarEndereco(String path, ArrayList<Endereco> enderecos) {
        File arq = new File(path);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Endereco endereco : enderecos) {
                gravadorTexto.write(endereco.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean gravarContatos(String path, ArrayList<Contato> contatos) {
        File arq = new File(path);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Contato contato : contatos) {
                gravadorTexto.write(contato.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Contato> lerArquivoContatos(String path, String tipoPai) {
        File arq = new File(path);
        ArrayList<Contato> contatos = new ArrayList<>();
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Contato contato = new Contato();
                    contato.setCodigo(valores[0]);
                    contato.setPai(this.returnObjetoPai(tipoPai, valores[1]));
                    contato.setTipo(valores[2]);
                    contato.setConteudo(valores[3]);
                    contatos.add(contato);
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            return contatos;
        } catch (Exception e) {
            contatos.clear();
            this.exposeMessageError(path);
        }
        return contatos;
    }

    public ArrayList<Endereco> lerArquivoEnderecos(String path, String tipoPai) {
        File arq = new File(path);
        ArrayList<Endereco> enderecos = new ArrayList<>();
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Endereco endereco = new Endereco();
                    endereco.setCodigo(valores[0]);
                    endereco.setPai(this.returnObjetoPai(tipoPai, valores[1]));
                    endereco.setRua(valores[2]);
                    endereco.setBairro(valores[3]);
                    endereco.setCidade(valores[4]);
                    endereco.setEstado(valores[5]);
                    endereco.setComplemento(valores[6]);
                    endereco.setReferencia(valores[7]);
                    enderecos.add(endereco);
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            return enderecos;
        } catch (Exception e) {
            enderecos.clear();
            this.exposeMessageError(path);
        }
        return enderecos;
    }

    private void exposeMessageError(String path) {
        JOptionPane.showMessageDialog(null, "Não foi possível ler o arquivo: " + path + " , por favor contate suporte!\\n"
                + "Para garantir a integridade, reinicie o sistema.");
    }

    private boolean apagarEnderecoByPai(String codigoPaiIgnore, String pathEndereco, String tipoPai) {
        File arq = new File(pathEndereco);
        ArrayList<Endereco> enderecos = new ArrayList<>();
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Endereco endereco = new Endereco();
                    endereco.setCodigo(valores[0]);
                    endereco.setPai(this.returnObjetoPai(tipoPai, valores[1]));
                    endereco.setRua(valores[2]);
                    endereco.setBairro(valores[3]);
                    endereco.setCidade(valores[4]);
                    endereco.setEstado(valores[5]);
                    endereco.setComplemento(valores[6]);
                    endereco.setReferencia(valores[7]);
                    if (!endereco.getPai().getCodigo().equalsIgnoreCase(codigoPaiIgnore)) {
                        enderecos.add(endereco);
                    }
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            gravarEndereco(pathEndereco, enderecos);
            return true;
        } catch (Exception e) {
            enderecos.clear();
            this.exposeMessageError(pathEndereco);
            return false;
        }
    }

    private boolean apagarContatoByPai(String codigoPaiIgnore, String pathContato, String tipoPai) {
        File arq = new File(pathContato);
        ArrayList<Contato> contatos = new ArrayList<>();
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Contato contato = new Contato();
                    contato.setCodigo(valores[0]);
                    contato.setPai(this.returnObjetoPai(tipoPai, valores[1]));
                    contato.setTipo(valores[2]);
                    contato.setConteudo(valores[3]);

                    if (!contato.getPai().getCodigo().equals(codigoPaiIgnore)) {
                        contatos.add(contato);
                    }
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            gravarContatos(pathContato, contatos);
            return true;
        } catch (Exception e) {
            contatos.clear();
            this.exposeMessageError(pathContato);
            return false;
        }
    }

    private Pessoa returnObjetoPai(String tipoPai, String codigoPai) {
        if (tipoPai.equalsIgnoreCase("cliente")) {
            Cliente cliente = new Cliente();
            ClienteController controller = new ClienteController();
            cliente = controller.findClienteByCodigo(codigoPai);
            return cliente;
        } else if (tipoPai.equalsIgnoreCase("fornecedor")) {
            Fornecedor fornecedor = new Fornecedor();
            FornecedorController controller = new FornecedorController();
            fornecedor = controller.findFornecedorByCodigo(codigoPai);
            return fornecedor;
        } else if (tipoPai.equalsIgnoreCase("atendente")) {
            Atendente atendente = new Atendente();
            AtendenteController controller = new AtendenteController();
            atendente = controller.findAtendenteByCodigo(codigoPai);
            return atendente;
        } else {
            JOptionPane.showMessageDialog(null, "Não Identificado tipo de pai para o contato, contate suporte.");
        }
        return new Pessoa();
    }

    public ArrayList<Endereco> getEnderecosByCodigoPai(String path, String codigoPai, String tipoPai){
        ArrayList<Endereco> allEnderecos = this.lerArquivoEnderecos(path, tipoPai);
        //Retorna um todos os endereços do pai.
        ArrayList<Endereco> enderecosDoPai = new ArrayList<>();
        for(Endereco endereco : allEnderecos){
            if(endereco.getPai().getCodigo().equalsIgnoreCase(codigoPai)){
                enderecosDoPai.add(endereco);
            }
        }
        return enderecosDoPai;
    }
    
    public ArrayList<Endereco> getEnderecosIgnoreCodigoPai(String path, String codigoPai, String tipoPai){
        ArrayList<Endereco> allEnderecos = this.lerArquivoEnderecos(path, tipoPai);
        //Retorna um todos os endereços do pai.
        ArrayList<Endereco> enderecosNaoSaoDoPai = new ArrayList<>();
        for(Endereco endereco : allEnderecos){
            if(!endereco.getPai().getCodigo().equalsIgnoreCase(codigoPai)){
                enderecosNaoSaoDoPai.add(endereco);
            }
        }
        return enderecosNaoSaoDoPai;
    }
    
    public ArrayList<Contato> getContatosByCodigoPai(String path, String codigoPai, String tipoPai){
        ArrayList<Contato> allContatos = this.lerArquivoContatos(path, tipoPai);
        //Retorna um todos os contatos do pai.
        ArrayList<Contato> contatosDoPai = new ArrayList<>();
        for(Contato contato : allContatos){
            if(contato.getPai().getCodigo().equalsIgnoreCase(codigoPai)){
                contatosDoPai.add(contato);
            }
        }
        return contatosDoPai;
    }
    
    public ArrayList<Contato> getContatosIgnoreCodigoPai(String path, String codigoPai, String tipoPai){
        ArrayList<Contato> allContatos = this.lerArquivoContatos(path, tipoPai);
        //Retorna um todos os contatos menos os que serão editados.(Ou seja nem buscamos eles pq vamos gravar depois);
        ArrayList<Contato> contatosNaoSaoDoPai = new ArrayList<>();
        for(Contato contato : allContatos){
            if(!contato.getPai().getCodigo().equalsIgnoreCase(codigoPai)){
                contatosNaoSaoDoPai.add(contato);
            }
        }
        return contatosNaoSaoDoPai;
    }
    
    public boolean apagarEnderecosAndContatosByCodigoPai(String codigoPaiIgnore, String pathEndereco, String pathContato, String tipoPai) {
        try {
            apagarEnderecoByPai(codigoPaiIgnore, pathEndereco, tipoPai);
            apagarContatoByPai(codigoPaiIgnore, pathContato, tipoPai);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
