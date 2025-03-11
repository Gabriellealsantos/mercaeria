package br.edu.ifba.saj.fwads.DAO;

import br.edu.ifba.saj.fwads.model.ProdutoVenda;

import java.util.UUID;

public class ProdutoVendaDAO extends GenericDAOImpl<ProdutoVenda, UUID> {

    public ProdutoVendaDAO() {
        super(UUID.class);
    }
}
