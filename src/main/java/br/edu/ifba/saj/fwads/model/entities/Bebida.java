package br.edu.ifba.saj.fwads.model.entities;

import java.time.LocalDate;

public class Bebida extends Produto {

    private Integer volume;

    public Bebida(Integer id, String nome, Double preco, String descricao, LocalDate dataValidade, Estoque estoque, Integer volume) {
        super(id, nome, preco, descricao, dataValidade, estoque);
        this.volume = volume;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }
}
