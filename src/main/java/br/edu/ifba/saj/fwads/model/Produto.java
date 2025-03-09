package br.edu.ifba.saj.fwads.model;

import java.time.LocalDate;

public class Produto {

    private long id;
    private String nome;
    private double preco;
    private String descricao;
    private LocalDate dataValidade;
    private UnidadeMedida unidade;
    private int estoque;

    public Produto(long id, String nome, double preco, String descricao, LocalDate dataValidade, UnidadeMedida unidade, int estoque) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
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

