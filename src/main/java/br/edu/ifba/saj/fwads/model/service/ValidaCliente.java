package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.entities.Endereco;
import br.edu.ifba.saj.fwads.model.exception.CpfInvalidoException;
import br.edu.ifba.saj.fwads.model.exception.EnderecoInvalidoException;
import br.edu.ifba.saj.fwads.model.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.exception.NomeInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ValidaCliente {

    static List<Cliente> listaCliente = new ArrayList<>();


    public static void validaCliente(Cliente cliente) throws NomeInvalidoException, CpfInvalidoException, EnderecoInvalidoException {
        validaNome(cliente.getNome());
        validaCpf(cliente.getCpf());
        validaEndereco(cliente.getEndereco());
    }

    private static void validaNome(String nome) throws NomeInvalidoException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new NomeInvalidoException("Nome não pode ser vazio.");
        }
    }

    private static void validaCpf(String cpf) throws CpfInvalidoException {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new CpfInvalidoException("CPF inválido. Deve ter 11 dígitos.");
        }
    }

    private static void validaEndereco(Endereco endereco) throws EnderecoInvalidoException {
        if (endereco == null || endereco.getLogradouro() == null || endereco.getLogradouro().trim().isEmpty()) {
            throw new EnderecoInvalidoException("Endereço inválido. O logradouro não pode ser vazio.");
        }
    }


    static {
        Endereco endereco = new Endereco("Avenida", "123", "", "Centro", "Cidade");
        Cliente cliente = new Cliente(1, "admin", "123.456.958-35", "admin@admin.com", endereco, "admin", "Masculino");
        listaCliente.add(cliente);
    }


    public Cliente validaLogin(String email, String senha) throws LoginInvalidoException {

        for (Cliente cliente : listaCliente) {
            if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
                return cliente;
            }
        }
        throw new LoginInvalidoException("Não foi possível localizar o usuario " + email + ", ou a senha esta errada");
    }
}