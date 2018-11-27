package Controller;

import Model.Venda;
import Model.VendaProduto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VendaController {
    
    Constantes cons = new Constantes();

    ArrayList<Venda> vendas = new ArrayList<>();
    ArrayList<VendaProduto> vendasProdutos = new ArrayList<>();

    ClienteController clienteController = new ClienteController();
    AtendenteController atendenteController = new AtendenteController();
    ProdutoController produtoController = new ProdutoController();

    public VendaController() {
        lerArquivoVendas();
        lerArquivoVendasProdutos();
    }

    public String cadastrarNovaVenda(String codigo, String codigoCliente, String codigoAtendente, String[][] produtos){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setCliente(clienteController.findClienteByCodigo(codigoCliente));
        venda.setAtendente(atendenteController.findAtendenteByCodigo(codigoAtendente));
        venda.setDataCompra(dateFormat.format(date));
        this.vendas.add(venda);
        for (int i = 0; i < produtos.length; i++) {
            try {
                Thread.currentThread().sleep(10);
            } catch (Exception e) {}
            VendaProduto vendaProduto = new VendaProduto();
            vendaProduto.setVenda(venda);
            vendaProduto.setProduto(produtoController.findProdutoByCodigo(produtos[i][0]));
            vendaProduto.setQuantidade(produtos[i][1]);
            DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
            Date dateCodigo = new Date();
            vendaProduto.setCodigo(format.format(dateCodigo));
            this.vendasProdutos.add(vendaProduto);
        }
        this.gravarVendas();
        this.gravarVendasProdutos();
        return "Venda realizada com sucesso, favor verificar na lista de vendas.";
    }

    private boolean gravarVendas() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_VENDA);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Venda venda : this.vendas) {
                gravadorTexto.write(venda.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean gravarVendasProdutos() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_VENDA_PRODUTO);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (VendaProduto vendaProduto : this.vendasProdutos) {
                gravadorTexto.write(vendaProduto.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean lerArquivoVendas() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_VENDA);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Venda venda = new Venda();
                    venda.setCodigo(valores[0]);
                    venda.setCliente(clienteController.findClienteByCodigo(valores[1]));
                    venda.setAtendente(atendenteController.findAtendenteByCodigo(valores[2]));
                    venda.setDataCompra(valores[3]);
                    this.vendas.add(venda);
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

    public Venda findVendaByCodigo(String codigo) {
        //Vamos garantir que nenhuma venda ficou de fora do arquivo;
        //talvez seja exageiro mas vamos garantir
        this.vendas.clear();
        this.lerArquivoVendas();
        for (Venda venda : this.vendas) {
            if (venda.getCodigo().equalsIgnoreCase(codigo)) {
                return venda;
            }
        }
        return new Venda();
    }

    private boolean lerArquivoVendasProdutos() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_VENDA_PRODUTO);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    VendaProduto vendaProduto = new VendaProduto();
                    vendaProduto.setCodigo(valores[0]);
                    vendaProduto.setVenda(this.findVendaByCodigo(valores[1]));
                    vendaProduto.setProduto(produtoController.findProdutoByCodigo(valores[2]));
                    vendaProduto.setQuantidade(valores[3]);
                    this.vendasProdutos.add(vendaProduto);
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
    
    public ArrayList<Venda> selecionarTodasVendas(){
        return this.vendas;
    }
}
