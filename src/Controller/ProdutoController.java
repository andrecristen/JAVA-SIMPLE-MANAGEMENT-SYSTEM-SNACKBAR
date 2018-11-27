package Controller;

import Model.Produto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProdutoController {
    
    Constantes cons = new Constantes();

    ArrayList<Produto> produtos = new ArrayList<>();

    public Produto findProdutoByCodigo(String codigo) {
        Produto produto = new Produto();
        this.lerArquivoProduto();
        for (Produto produtoAtual : this.produtos) {
            if (produtoAtual.getCodigo().equals(codigo)) {
                return produtoAtual;
            }
        }
        return produto;
    }

    public String cadastrarNovoProduto(String codigo, String codigoFornecedor, String nome, String descricao, String precoCompra, String precoVenda) {
        //Vamos buscar nossos dados referentes ao clientes;
        this.lerArquivoProduto();
        try {
            Produto produto = new Produto();
            produto.setCodigo(codigo);
            FornecedorController controller = new FornecedorController();
            produto.setPai(controller.findFornecedorByCodigo(codigoFornecedor));
            produto.setDescricao(descricao);
            produto.setNome(nome);
            produto.setPrecoCompra(Float.parseFloat(precoCompra));
            produto.setPrecoVenda(Float.parseFloat(precoVenda));
            this.produtos.add(produto);
            boolean retorno = this.gravarArquivoProduto();
            if (retorno) {
                return "Cadastro efetuado com sucesso";
            }
        } catch (Exception e) {
            return "Não foi possível executar o cadastro de um novo produto";
        }

        return "Sem mensagem definida, contate suporte imediatamanete!";
    }

    private boolean gravarArquivoProduto() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_PRODUTO);
        try {
            FileWriter gravadorArq = new FileWriter(arq);
            BufferedWriter gravadorTexto = new BufferedWriter(gravadorArq);
            for (Produto produto : this.produtos) {
                gravadorTexto.write(produto.toFileString());
                gravadorTexto.newLine();
            }
            gravadorTexto.close();
            gravadorArq.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean lerArquivoProduto() {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_PRODUTO);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Produto produto = new Produto();
                    produto.setCodigo(valores[0]);
                    FornecedorController controller = new FornecedorController();
                    produto.setPai(controller.findFornecedorByCodigo(valores[1]));
                    produto.setNome(valores[2]);
                    produto.setDescricao(valores[3]);
                    produto.setPrecoCompra(Float.parseFloat(valores[4]));
                    produto.setPrecoVenda(Float.parseFloat(valores[5]));
                    this.produtos.add(produto);
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

    public ArrayList<Produto> selecionarTodosProdutos() {
        lerArquivoProduto();
        return this.produtos;
    }

    public boolean removerProdutoByCodigo(String codigo) {
        File arq = new File(cons.PATH_PART_INITIAL+cons.ARQUIVO_PRODUTO);
        try {
            if (arq.exists()) {
                FileReader leitorArq = new FileReader(arq);
                BufferedReader leitorTexto = new BufferedReader(leitorArq);
                String linha = leitorTexto.readLine();
                while (linha != null) {
                    String[] valores = linha.split(";");
                    Produto produto = new Produto();
                    produto.setCodigo(valores[0]);
                    FornecedorController controller = new FornecedorController();
                    produto.setPai(controller.findFornecedorByCodigo(valores[1]));
                    produto.setNome(valores[2]);
                    produto.setDescricao(valores[3]);
                    produto.setPrecoCompra(Float.parseFloat(valores[4]));
                    produto.setPrecoVenda(Float.parseFloat(valores[5]));
                    if (!produto.getCodigo().equalsIgnoreCase(codigo)) {
                        this.produtos.add(produto);
                    }
                    linha = leitorTexto.readLine();
                }
                leitorTexto.close();
                leitorArq.close();
            }
            this.gravarArquivoProduto();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public String editarProduto(String codigo, String codigoFornecedor, String nome, String descricao, String precoCompra, String precoVenda) {
        this.lerArquivoProduto();
        ArrayList<Produto> produtosEditados = new ArrayList<>();
        FornecedorController controller = new FornecedorController();
        try {
            for (Produto produto : this.produtos) {
                if (!produto.getCodigo().equalsIgnoreCase(codigo)) {
                    produtosEditados.add(produto);
                } else {
                    Produto produtoEditado = new Produto();
                    produtoEditado.setCodigo(codigo);
                    produtoEditado.setPai(controller.findFornecedorByCodigo(codigoFornecedor));
                    produtoEditado.setNome(nome);
                    produtoEditado.setDescricao(descricao);
                    produtoEditado.setPrecoCompra(Float.parseFloat(precoCompra));
                    produtoEditado.setPrecoVenda(Float.parseFloat(precoVenda));
                    produtosEditados.add(produtoEditado);
                }
            }
            this.produtos.clear();
            this.produtos = produtosEditados;
            this.gravarArquivoProduto();
        } catch (Exception e) {
            return "Não foi possível editar o Produto";
        }
        return "Produto Editado com Sucesso";
    }

}
