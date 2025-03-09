package br.edu.ifba.saj.fwads.model;

public class ProdutoVenda {

    private long id;
    private Produto produto;
    private int quantidade;
    private double precoVenda;

    public ProdutoVenda(long id, Produto produto, int quantidade, double precoVenda) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
