package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Carrinho;
import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.entities.Endereco;
import br.edu.ifba.saj.fwads.model.exception.LoginInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteSerivce {

    static List<Cliente> listaCliente = new ArrayList<>();

    static {

        Endereco endereco = new Endereco("Rua das Flores ", "123", "Perto do centro", "avenida edgar santos", "Sapeaçu");

        Cliente cliente = new Cliente("Gabriel", "088.278.365-35", "1", "1", "Masculino", endereco);

        listaCliente.add(cliente);

        Carrinho carrinho = new Carrinho(cliente);
    }

    public Cliente login(String email, String senha) throws LoginInvalidoException {

        for (Cliente cliente : listaCliente) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        throw new LoginInvalidoException("Não foi possível localizar o usuario " + email + ", ou a senha esta errada");
    }
}