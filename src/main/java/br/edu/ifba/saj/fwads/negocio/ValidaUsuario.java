package br.edu.ifba.saj.fwads.negocio;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.saj.fwads.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.Cliente;
import br.edu.ifba.saj.fwads.model.Endereco;

public class ValidaUsuario {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static Cliente clienteLogado;

    static {
        Endereco endereco = new Endereco("Rua das Flores ", 52, "Perto do centro", "Sapeaçu");
        Cliente cliente = new Cliente(1, "Gabriel", "111.111.111-11", "1", "1", "Masculino", null);
        Cliente cliente2 = new Cliente(2, "Ana", "222.222.222-22", "2", "2", "Femenino", null);
        listaCliente.add(cliente);
        listaCliente.add(cliente2);
    }

    public Cliente login(String email, String senha) throws LoginInvalidoException {
        for (Cliente cliente : listaCliente) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                clienteLogado = cliente;
                return cliente;
            }
        }
        throw new LoginInvalidoException("Não foi possível localizar o usuário " + email + ", ou a senha está errada");
    }
    
}
