package br.edu.ifba.saj.fwads.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private Integer quantidade;

    List<Produto> produtos = new ArrayList<>();

    public Estoque(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

}
