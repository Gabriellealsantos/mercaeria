package br.edu.ifba.saj.fwads.model;

import java.time.LocalDate;
import java.util.UUID;

public class Produto extends AbstractModel<UUID> {

    private String nome;
    private double preco;
    private String descricao;
    private LocalDate dataValidade;
    private UnidadeMedida unidade;
    private int estoque;

    public Produto(String nome, double preco, String descricao, LocalDate dataValidade, UnidadeMedida unidade, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.unidade = unidade;
        this.estoque = estoque;
    }

    public boolean verificarValidade() {
        return LocalDate.now().isBefore(dataValidade);
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }


    public int getEstoque() {
        return estoque;
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}

