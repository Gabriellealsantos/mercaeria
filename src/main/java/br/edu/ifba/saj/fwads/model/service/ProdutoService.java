package br.edu.ifba.saj.fwads.model.service;

import br.edu.ifba.saj.fwads.model.entities.Alimento;
import br.edu.ifba.saj.fwads.model.entities.Bebida;
import br.edu.ifba.saj.fwads.model.entities.Produto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {

    public List<Produto> buscarTodos() {
        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Alimento("Arroz", 20.00, "Arroz tipo 1", LocalDate.of(2025, 12, 31), null, "Grão"));
        produtos.add(new Alimento("Feijão", 8.50, "Feijão carioca", LocalDate.of(2025, 11, 30), null, "Grão"));
        produtos.add(new Alimento("Macarrão", 4.20, "Macarrão espaguete", LocalDate.of(2025, 10, 15), null, "Massa"));
        produtos.add(new Alimento("Farinha", 5.00, "Farinha de trigo", LocalDate.of(2025, 9, 10), null, "Pó"));
        produtos.add(new Alimento("Açúcar", 3.50, "Açúcar refinado", LocalDate.of(2026, 1, 20), null, "Grão"));
        produtos.add(new Alimento("Leite em pó", 15.00, "Leite integral em pó", LocalDate.of(2025, 7, 1), null, "Pó"));

        produtos.add(new Bebida("Refrigerante", 7.50, "Refrigerante de cola", LocalDate.of(2025, 12, 31), null, 2000));
        produtos.add(new Bebida("Suco de Laranja", 5.20, "Suco natural de laranja", LocalDate.of(2025, 10, 15), null, 1000));
        produtos.add(new Bebida("Água Mineral", 2.50, "Água mineral sem gás", LocalDate.of(2026, 1, 1), null, 500));
        produtos.add(new Bebida("Cerveja", 8.00, "Cerveja artesanal", LocalDate.of(2025, 9, 20), null, 355));
        produtos.add(new Bebida("Leite", 4.50, "Leite integral", LocalDate.of(2025, 8, 10), null, 1000));
        produtos.add(new Bebida("Energético", 10.00, "Bebida energética", LocalDate.of(2025, 11, 5), null, 250));

        return produtos;
    }


    public boolean verificarValidade(Produto produto) {
        return produto.getDataValidade().isAfter(LocalDate.now());
    }
}
