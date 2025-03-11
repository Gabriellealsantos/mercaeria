package br.edu.ifba.saj.fwads.model;

import java.util.UUID;

public class ProdutoVenda extends AbstractModel<UUID> {

    private Venda venda;
    private Produto produto;
    private int quantidade;
    private double precoVenda;

    public ProdutoVenda(Venda venda, Produto produto, int quantidade, double precoVenda) {
        this.venda = venda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public void incrementarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void decrementarQuantidade(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente no pedido!");
        }
    }

    public void alterarPreco(double preco) {
        this.precoVenda = preco;
    }
}
