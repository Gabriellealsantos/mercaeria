package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Usuario extends AbstractModel<UUID> {

    private String usuario;
    private String senha;
    private List<Venda> vendas;

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
        this.vendas = new ArrayList<>();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public List<Venda> listaDeVendas() {
        return Collections.unmodifiableList(vendas);
    }
}
