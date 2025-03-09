package br.edu.ifba.saj.fwads.model;

import br.edu.ifba.saj.fwads.model.enums.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private long id;
    private LocalDateTime data;
    private double total;
    private Status status;
    private Cliente cliente;
    private List<ProdutoVenda> produtos;

    public Venda(long id, Cliente cliente) {
        this.id = id;
        this.data = LocalDateTime.now();
        this.total = 0.0;
        this.status = Status.PENDENTE;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    public void registrarVenda() {
        if (!produtos.isEmpty()) {
            this.status = Status.PAGO;
            System.out.println("Venda registrada com sucesso!");
        } else {
            System.out.println("Não é possível registrar uma venda sem produtos.");
        }
    }

    public void adicionarProduto(ProdutoVenda produtoVenda) {
        produtos.add(produtoVenda);
        total += produtoVenda.getPrecoVenda() * produtoVenda.getQuantidade();
    }

    public void removerProduto(long idProduto) {
        produtos.removeIf(produto -> produto.getProduto().getId() == idProduto);
    }

    public void atualizarStatus(Status novoStatus) {
        this.status = novoStatus;
    }

    public double getTotal() {
        return total;
    }
}

