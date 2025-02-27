package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Carrinho;
import br.edu.ifba.saj.fwads.model.entities.Produto;

public class CarrinhoService {

    private Carrinho carrinho;

    public CarrinhoService(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void realizarCompra() {

        double total = calcularTotal();

        System.out.println("Total da compra: " + total);


        VendaService vendaService = new VendaService();

        vendaService.registrarVenda(carrinho.getCliente(), carrinho.getProdutos(), total);


        if (vendaService != null) {
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
        carrinho.adicionarProduto(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto);
        System.out.println("Produto adicionado ao carrinho: " + carrinho);
    }

    public void removerProduto(Produto produto) {
        carrinho.removerProduto(produto);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : carrinho.getProdutos()) {
            total += produto.getPreco();
        }
        return total;
    }
}