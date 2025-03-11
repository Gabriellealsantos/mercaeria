package br.edu.ifba.saj.fwads.DAO;

import br.edu.ifba.saj.fwads.model.Cliente;

import java.util.UUID;

public class ClienteDAO extends GenericDAOImpl<Cliente, UUID> {

    public ClienteDAO() {
        super(UUID.class);
    }
}
