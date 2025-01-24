package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Alimento;
import br.edu.ifba.saj.fwads.model.entities.Bebida;
import br.edu.ifba.saj.fwads.model.entities.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ProdutoService {

    private List<Produto> produtos = new ArrayList<>();
    private Integer idCounter = 1;

    public List<Produto> buscarTodos() {
        if (produtos.isEmpty()) {
            produtos.add(new Alimento(generateId(), "Arroz", 20.00, "Arroz tipo 1", LocalDate.of(2025, 12, 31), null, "Grão"));
            produtos.add(new Alimento(generateId(), "Feijão", 8.50, "Feijão carioca", LocalDate.of(2025, 11, 30), null, "Grão"));
            produtos.add(new Alimento(generateId(), "Macarrão", 4.20, "Macarrão espaguete", LocalDate.of(2025, 10, 15), null, "Massa"));
            produtos.add(new Alimento(generateId(), "Farinha", 5.00, "Farinha de trigo", LocalDate.of(2025, 9, 10), null, "Pó"));
            produtos.add(new Alimento(generateId(), "Açúcar", 3.50, "Açúcar refinado", LocalDate.of(2026, 1, 20), null, "Grão"));
            produtos.add(new Alimento(generateId(), "Leite em pó", 15.00, "Leite integral em pó", LocalDate.of(2025, 7, 1), null, "Pó"));

            produtos.add(new Bebida(generateId(), "Refrigerante", 7.50, "Refrigerante de cola", LocalDate.of(2025, 12, 31), null, 2000));
            produtos.add(new Bebida(generateId(), "Suco de Laranja", 5.20, "Suco natural de laranja", LocalDate.of(2025, 10, 15), null, 1000));
            produtos.add(new Bebida(generateId(), "Água Mineral", 2.50, "Água mineral sem gás", LocalDate.of(2026, 1, 1), null, 500));
            produtos.add(new Bebida(generateId(), "Cerveja", 8.00, "Cerveja artesanal", LocalDate.of(2025, 9, 20), null, 355));
            produtos.add(new Bebida(generateId(), "Leite", 4.50, "Leite integral", LocalDate.of(2025, 8, 10), null, 1000));
            produtos.add(new Bebida(generateId(), "Energético", 10.00, "Bebida energética", LocalDate.of(2025, 11, 5), null, 250));
        }
        return produtos;
    }

    private Integer generateId() {
        return idCounter++;
    }

    public boolean verificarValidade(Produto produto) {
        return produto.getDataValidade().isAfter(LocalDate.now());
    }
}
