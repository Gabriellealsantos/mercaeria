package br.edu.ifba.saj.fwads.model;

import br.edu.ifba.saj.fwads.model.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Venda<T> extends AbstractModel<UUID> {

    private LocalDateTime data;
    private Status status;
    private T clienteId;
    private T usuarioId;
    private List<ProdutoVenda> produtoVendas;

    public Venda(T clienteId, T usuarioId) {
        this.data = LocalDateTime.now();
        this.status = Status.PENDENTE;
        this.clienteId = clienteId;
        this.usuarioId = usuarioId;
        this.produtoVendas = new ArrayList<>();
    }

    public T getClienteId() {
        return clienteId;
    }

    public T getUsuarioId() {
        return usuarioId;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    public void adicionarProduto(ProdutoVenda<UUID> produtoVenda) {
        produtoVendas.add(produtoVenda);
    }

    public double calculateTotal() {
        return produtoVendas.stream()
                .mapToDouble(pv -> pv.getPrecoVenda() * pv.getQuantidade())
                .sum();
    }
}
