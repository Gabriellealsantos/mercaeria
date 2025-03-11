package br.edu.ifba.saj.fwads.DAO;

import br.edu.ifba.saj.fwads.model.Usuario;

import java.util.UUID;

public class UsuarioDAO extends GenericDAOImpl<Usuario, UUID> {

    public UsuarioDAO() {
        super(UUID.class);
    }
}
