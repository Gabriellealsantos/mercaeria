package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.entities.Produto;
import br.edu.ifba.saj.fwads.model.entities.Venda;
import br.edu.ifba.saj.fwads.model.entities.enums.Status;

import java.time.LocalDateTime;
import java.util.List;

public class VendaService {
    public Venda registrarVenda(Cliente cliente, List<Produto> produtoList, Double total) {
        Venda venda = new Venda(LocalDateTime.now(), cliente, total);
        for (Produto produto : produtoList) {
            venda.adicionarProduto(produto);
        }
        venda.setStatus(Status.PAGO);
        System.out.println("Venda registrada com sucesso: " + venda);
        return venda;
    }
}
