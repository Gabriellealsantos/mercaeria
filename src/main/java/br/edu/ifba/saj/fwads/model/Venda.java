package br.edu.ifba.saj.fwads.model;

import br.edu.ifba.saj.fwads.model.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Venda<ClienteId, ProdutoId> extends AbstractModel<UUID> {

    private LocalDateTime data;
    private double total;
    private Status status;
    private ClienteId clienteId;
    private List<ProdutoVenda> produtos;

    public Venda(ClienteId clienteId) {
        this.data = LocalDateTime.now();
        this.total = 0.0;
        this.status = Status.PENDENTE;
        this.clienteId = clienteId;
        this.produtos = new ArrayList<>();
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public void registrarVenda() {
        if (!produtos.isEmpty()) {
            this.status = Status.PAGO;
            System.out.println("Venda registrada com sucesso!");
        } else {
            System.out.println("Não é possível registrar uma venda sem produtos.");
        }
    }

    public void cancelar() {
        if (this.status == Status.PAGO || this.status == Status.PENDENTE) {
            for (ProdutoVenda produtoVenda : produtos) {
                produtoVenda.getProduto().aumentarEstoque(produtoVenda.getQuantidade());
            }

            this.status = Status.CANCELADA;
            setUpdatedAt(LocalDateTime.now());
        }
    }

    public void adicionarProduto(ProdutoVenda produtoVenda) {
        produtoVenda.setVenda(this);
        produtos.add(produtoVenda);
        total += produtoVenda.getPrecoVenda() * produtoVenda.getQuantidade();
        produtoVenda.getProduto().reduzirEstoque(produtoVenda.getQuantidade());
    }

    public void removerProduto(ProdutoId idProduto) {
        produtos.removeIf(produto -> produto.getProduto().getId().equals(idProduto));
    }

    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;
    }

    public double getTotal() {
        return total;
    }
}
