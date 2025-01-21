package br.edu.ifba.saj.fwads.model.entities;

import br.edu.ifba.saj.fwads.model.entities.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private static Integer idCounter = 1;
    private Integer id;
    private LocalDateTime data;
    private Double total;
    private Status status;

    private Cliente cliente;

    private List<Produto> produtos = new ArrayList<>();

    public Venda() {
    }

    public Venda(LocalDateTime data, Cliente cliente, Double total) {
        this.id = idCounter++;
        this.data = data;
        this.cliente = cliente;
        this.total = total;
        this.status = Status.PENDENTE;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", data=" + data +
                ", total=" + total +
                ", status=" + status +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
