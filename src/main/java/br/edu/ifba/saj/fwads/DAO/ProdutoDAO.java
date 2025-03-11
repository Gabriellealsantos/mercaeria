package br.edu.ifba.saj.fwads.DAO;

import br.edu.ifba.saj.fwads.model.Produto;

import java.util.UUID;

public class ProdutoDAO extends GenericDAOImpl<Produto, UUID> {

    public ProdutoDAO() {
        super(UUID.class);
    }
}
