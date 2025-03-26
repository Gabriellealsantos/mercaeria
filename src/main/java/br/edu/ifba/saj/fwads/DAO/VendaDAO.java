package br.edu.ifba.saj.fwads.DAO;

import br.edu.ifba.saj.fwads.model.Cliente;
import br.edu.ifba.saj.fwads.model.Venda;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class VendaDAO extends GenericDAOImpl<Venda<UUID>, UUID> {

    public VendaDAO() {
        super(UUID.class);
    }

    public List<String> consultarVendas(ClienteDAO clienteDAO) {
        return buscarTodos().stream().map(venda -> {
            Cliente<UUID> cliente = clienteDAO.buscarPorId(venda.getClienteId());
            System.out.println("Cliente encontrado: " + cliente);
            return String.format("Venda ID: %s | Cliente: %s | Data: %s | Total: R$ %.2f",
                    venda.getId(),
                    cliente != null ? cliente.getNome() : "Desconhecido",
                    venda.getData(),
                    venda.calculateTotal()
            );
        }).collect(Collectors.toList());
    }
}
