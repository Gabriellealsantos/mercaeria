package br.edu.ifba.saj.fwads.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String sexo;

    private Endereco endereco;
    private Carrinho carrinho;

    private List<Papel> papeis = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    public Cliente(Integer id, String nome, String cpf, String email, String senha, String sexo, Endereco endereco, Carrinho carrinho) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.sexo = sexo;
        this.endereco = endereco;
        this.carrinho = carrinho;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public void removerVenda(Venda venda) {
        this.vendas.remove(venda);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
