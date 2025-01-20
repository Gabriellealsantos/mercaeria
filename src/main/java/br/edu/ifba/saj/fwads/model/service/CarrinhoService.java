package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Carrinho;
import br.edu.ifba.saj.fwads.model.entities.Produto;
import br.edu.ifba.saj.fwads.model.entities.Venda;

public class CarrinhoService {

    private Carrinho carrinho;

    public CarrinhoService(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void realizarCompra() {

        double total = calcularTotal();

        System.out.println("Total da compra: " + total);


        VendaService vendaService = new VendaService();


        Venda venda = vendaService.registrarVenda(carrinho.getCliente(), carrinho.getProdutos(), total);

        if (venda != null) {
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Erro ao registrar a venda!");
        }


        limparCarrinho();
        System.out.println("Carrinho limpo após a compra.");
    }

    public void limparCarrinho() {
        carrinho.getProdutos().clear();
    }

    public void adicionarProduto(Produto produto) {
        carrinho.getProdutos().add(produto);
    }

    public void removerProduto(Produto produto) {
        carrinho.getProdutos().remove(produto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : carrinho.getProdutos()) {
            total += produto.getPreco();
        }
        return total;
    }
}