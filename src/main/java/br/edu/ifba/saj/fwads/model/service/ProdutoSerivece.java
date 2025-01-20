package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Produto;

import java.time.LocalDate;

public class ProdutoSerivece {

    private Produto produto;

    public ProdutoSerivece(Produto produto) {
        this.produto = produto;
    }

    public boolean verificarValidade(Produto produto) {
        return produto.getDataValidade().isAfter(LocalDate.now());
    }
}
