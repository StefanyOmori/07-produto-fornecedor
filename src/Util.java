import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {

    private Produto[] produto = new Produto[5];
    private Fornecedor[] fornecedor = new Fornecedor[5];
    private int idxProduto = 0;
    private int idxFornecedor = 0;

    public void menuPrincipal() {
        int opcao;
        String menu = "1. Cadastrar produto\n2. Pesquisar produto\n3. Pesquisar fornecedor\n4. Finalizar";
        while(true) {
            opcao = parseInt(showInputDialog(menu));
            if(opcao==4){
                return; //return e break pra encerrar
            }
                switch(opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        pesquisarProduto();
                        break;
                    case 3:
                        pesquisarFornecedor();
                        break;
                    default:
                        showMessageDialog(null, "Opção inválida");
            }
        }
    }

    private void cadastrarProduto(){
        String nome;
        double valorUni;
        int qtdEstoque;
        Fornecedor fornecedor = pesquisarFornecedor();

        if(fornecedor == null){
            fornecedor = cadastrarFornecedor();
        }

        nome = showInputDialog("Nome do produto");
        valorUni = parseDouble(showInputDialog("Valor unitário"));
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        produto[idxProduto] = new Produto(nome, valorUni, qtdEstoque, fornecedor);
        idxProduto++;
    }

    private Fornecedor cadastrarFornecedor(){
        Fornecedor fornecedor;
        String nome = showInputDialog("Nome do fornecedor");
        int cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));
        fornecedor = new Fornecedor(nome, cnpj);
        this.fornecedor[idxFornecedor] = fornecedor;
        idxFornecedor++;
        return fornecedor;
    }

    private Produto pesquisarProduto(){
        String nome = showInputDialog("Nome");
        for(int i = 0; i < idxProduto; i++) {
            if(produto[i].getNome() == nome) {
                return produto[i];
            }
        }
        showMessageDialog(null, nome + "não encontrado");
        return null;
    }

    private Fornecedor pesquisarFornecedor(){
        int cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));
        for(int i = 0; i < idxFornecedor; i++) {
            if(fornecedor[i].getCnpj() == cnpj) {
                return fornecedor[i];
            }
        }
        showMessageDialog(null, cnpj + "não encontrado");
        return null;
    }


}
