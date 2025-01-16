package br.edu.ifba.saj.fwads.model.entities;

public class Papel {

    private int id;
    private String autoridade;

    public Papel(int id, String autoridade) {
        this.id = id;
        this.autoridade = autoridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoridade() {
        return autoridade;
    }

    public void setAutoridade(String autoridade) {
        this.autoridade = autoridade;
    }
}
