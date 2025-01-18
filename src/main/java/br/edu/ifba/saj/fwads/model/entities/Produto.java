package br.edu.ifba.saj.fwads.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Produto {

    private Integer id;
    private String nome;
    private Double preco;
    private String descricao;
    private LocalDate dataValidade;

    private Estoque estoque;

    private List<Venda> vendas = new ArrayList<>();

    public Produto(Integer id, String nome, Double preco, String descricao, LocalDate dataValidade, Estoque estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.estoque = estoque;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public List<Venda> addVendas() {
        return vendas;
    }
}
