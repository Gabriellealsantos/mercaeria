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
    private List<ProdutoVenda> produtos;

    public Venda(T clienteId, T usuarioId) {
        this.data = LocalDateTime.now();
        this.status = Status.PENDENTE;
        this.clienteId = clienteId;
        this.usuarioId = usuarioId;
        this.produtos = new ArrayList<>();
    }

    public T getClienteId() {
        return clienteId;
    }

    public T getUsuarioId() {
        return usuarioId;
    }

    public void cancelar() {
        if (this.status == Status.PAGO || this.status == Status.PENDENTE) {
            for (ProdutoVenda produtoVenda : produtos) {
                produtoVenda.getProduto().aumentarEstoque(produtoVenda.getQuantidade());
            }

            this.status = Status.CANCELADA;
        }
    }

    public void adicionarProduto(ProdutoVenda produtoVenda) {
        produtoVenda.setVenda(this);
        produtos.add(produtoVenda);
    }

    public void removerProduto(T idProduto) {
        produtos.removeIf(produto -> produto.getProduto().getId().equals(idProduto));
    }

    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;

        if (novoStatus == Status.PAGO) {
            finalizarVenda();
        }
    }

    private void finalizarVenda() {
        for (ProdutoVenda produtoVenda : produtos) {
            produtoVenda.getProduto().reduzirEstoque(produtoVenda.getQuantidade());
        }
    }

    public void registrarVenda() {
        if (!produtos.isEmpty()) {
            finalizarVenda();
            this.status = Status.PAGO;
        } else {
            throw new IllegalStateException("Não é possível registrar uma venda sem produtos.");
        }
    }

    public double calculateTotal() {
        return produtos.stream()
                .mapToDouble(pv -> pv.getPrecoVenda() * pv.getQuantidade())
                .sum();
    }
}
