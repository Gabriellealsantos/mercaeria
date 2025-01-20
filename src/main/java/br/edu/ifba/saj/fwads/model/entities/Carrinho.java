package br.edu.ifba.saj.fwads.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Cliente cliente;
    private List<Produto> produtos = new ArrayList<>();

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }




}
