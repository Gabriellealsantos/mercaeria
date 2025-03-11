package br.edu.ifba.saj.fwads.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Cliente extends AbstractModel<UUID> {

    private String nome;
    private String cpf;
    private String telefone;
    private String sexo;
    private List<Endereco> enderecos;
    private List<Venda> vendas;

    public Cliente(String nome, String cpf, String telefone, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.sexo = sexo;
        this.enderecos = new ArrayList<>();
        this.vendas = new ArrayList<>();
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public List<Venda> listaDeVendas() {
        return Collections.unmodifiableList(vendas);
    }

}
