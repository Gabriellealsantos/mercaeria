package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Produto;

import java.time.LocalDate;

public class ProdutoSerivece {

    public boolean verificarValidade(Produto produto) {
        return produto.getDataValidade().isAfter(LocalDate.now());
    }
}
