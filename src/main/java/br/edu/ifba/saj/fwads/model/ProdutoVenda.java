package br.edu.ifba.saj.fwads.model;

import java.util.UUID;

public class ProdutoVenda<T> extends AbstractModel<UUID> {

    private T vendaId;
    private T produtoId;
    private int quantidade;
    private double precoVenda;

    public ProdutoVenda(T vendaId, T produtoId, int quantidade, double precoVenda) {
        this.vendaId = vendaId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public T getVenda() {
        return vendaId;
    }

    public void setVenda(T vendaId) {
        this.vendaId = vendaId;
    }

    public T getProduto() {
        return produtoId;
    }

    public void setProduto(T produto) {
        this.produtoId = produto;
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
            throw new IllegalArgumentException("Quantidade insuficiente no pedido!");
        }
    }

    public void alterarPreco(double preco) {
        this.precoVenda = preco;
    }
}
