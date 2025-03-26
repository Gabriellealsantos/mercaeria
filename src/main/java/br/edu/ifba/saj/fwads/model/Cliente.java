package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Cliente<T> extends AbstractModel<UUID> {

    private String nome;
    private final String cpf;
    private String telefone;
    private String sexo;
    private List<Endereco> enderecos;
    private List<T> vendasIds;
    private T usuarioId;

    public Cliente(String nome, String cpf, String telefone, String sexo, T usuarioId) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.enderecos = new ArrayList<>();
        this.vendasIds = new ArrayList<>();
        this.usuarioId = usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void adicionarVenda(T venda) {
        this.vendasIds.add(venda);
    }

    public List<T> listaDeVendas() {
        return Collections.unmodifiableList(vendasIds);
    }

    public T getUsuarioId() {
        return usuarioId;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", sexo='" + sexo + '\'' +
                ", enderecos=" + enderecos +
                ", vendas=" + vendasIds +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
