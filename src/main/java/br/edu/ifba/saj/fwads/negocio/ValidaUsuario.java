package br.edu.ifba.saj.fwads.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.saj.fwads.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.Cliente;
import br.edu.ifba.saj.fwads.model.Endereco;
import br.edu.ifba.saj.fwads.model.Usuario;

public class ValidaUsuario {

    private static List<Usuario> listaUsuario = new ArrayList<>();
    private static Usuario clienteLogado;

    static {
        Endereco endereco = new Endereco("Rua das Flores ", 52, "Perto do centro", "Sapeaçu");
        Usuario usuario = new Usuario("Gabriel", "1");
        Usuario usuario2 = new Usuario("Ana", "1");
        listaUsuario.add(usuario);
        listaUsuario.add(usuario2);
    }

    public Usuario login(String email, String senha) throws LoginInvalidoException {
        for (Usuario cliente : listaUsuario) {
            if (cliente.getUsuario().equals(email) && cliente.getSenha().equals(senha)) {
                clienteLogado = cliente;
                return cliente;
            }
        }
        throw new LoginInvalidoException("Não foi possível localizar o usuário " + email + ", ou a senha está errada");
    }
    
}
