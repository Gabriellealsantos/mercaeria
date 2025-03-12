package br.edu.ifba.saj.fwads.DAO;

import br.edu.ifba.saj.fwads.model.Venda;

import java.util.UUID;

public class VendaDAO extends GenericDAOImpl<Venda<UUID>, UUID> {

    public VendaDAO() {
        super(UUID.class);
    }
}
