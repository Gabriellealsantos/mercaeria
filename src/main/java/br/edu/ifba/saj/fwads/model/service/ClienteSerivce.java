package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.entities.Endereco;
import br.edu.ifba.saj.fwads.model.exception.LoginInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteSerivce {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static Cliente clienteLogado;

    static {
        Endereco endereco = new Endereco("Rua das Flores ", "123", "Perto do centro", "avenida edgar santos", "Sapeaçu");
        Cliente cliente = new Cliente(1, "Gabriel", "111.111.111-11", "1", "1", "Masculino", endereco);
        Cliente cliente2 = new Cliente(2, "Ana", "222.222.222-22", "2", "2", "Femenino", endereco);
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

    public Cliente getCliente() {
        return clienteLogado;
    }
}
