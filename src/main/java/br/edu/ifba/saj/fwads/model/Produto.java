package br.edu.ifba.saj.fwads.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Produto extends AbstractModel<UUID> {

    private String nome;
    private Double preco;
    private String descricao;
    private LocalDate dataValidade;
    private UnidadeMedida unidade;
    private int estoque;
    private List<ProdutoVenda> vendasAssociadas;

    public Produto(String nome, Double preco, String descricao, LocalDate dataValidade, UnidadeMedida unidade, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.unidade = unidade;
        this.estoque = estoque;
        this.vendasAssociadas = new ArrayList<>();
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

    public void adicionarVendaAssociada(ProdutoVenda produtoVenda) {
        this.vendasAssociadas.add(produtoVenda);
    }

    public int getEstoque() {
        return estoque;
    }

    public void aumentarEstoque(int quantidade) {
        if (quantidade > 0) {
            estoque += quantidade;
        } else {
            throw new IllegalArgumentException("Quantidade deve ser positiva");
        }
    }

    public void reduzirEstoque(int quantidade) {
        if (quantidade <= estoque) {
            estoque -= quantidade;
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}

