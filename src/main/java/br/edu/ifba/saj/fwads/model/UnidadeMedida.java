package br.edu.ifba.saj.fwads.model;

public class UnidadeMedida {

    private String nome;
    private String abreviacao;

    public UnidadeMedida(String nome, String abreviacao) {
        this.nome = nome;
        this.abreviacao = abreviacao;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }
}
