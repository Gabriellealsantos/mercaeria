package br.edu.ifba.saj.fwads.model.entities;

import java.time.LocalDate;

public class Alimento extends Produto {

    private String tipo;

    public Alimento(Integer id, String nome, Double preco, String descricao, LocalDate dataValidade, Estoque estoque, String tipo) {
        super(id, nome, preco, descricao, dataValidade, estoque);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
