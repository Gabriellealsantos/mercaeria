package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.DAO.*;
import br.edu.ifba.saj.fwads.model.*;
import br.edu.ifba.saj.fwads.model.enums.Status;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        loader = new FXMLLoader(App.class.getResource("controller/Login.fxml"));
        scene = new Scene(loader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();

        // Instanciar os DAOs
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        VendaDAO vendaDAO = new VendaDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProdutoVendaDAO produtoVendaDAO = new ProdutoVendaDAO();

        // Criar um Usuário e persistir
        Usuario usuario = new Usuario("usuarioExemplo", "senha123");
        UUID usuarioId = usuarioDAO.salvar(usuario);
        System.out.println("Usuário salvo com ID: " + usuarioId);

        // Criar um Cliente e persistir
        Cliente<UUID> cliente = new Cliente<>("Gabriel", "12345678901", "11999999999", "M", usuarioId);
        UUID clienteId = clienteDAO.salvar(cliente);
        System.out.println("Cliente salvo com ID: " + clienteId);

        // Criar um Produto e persistir
        UnidadeMedida unidade = new UnidadeMedida("Unidade", "un");
        Produto produto = new Produto("Produto Teste", 25.0, "Produto para teste de DAO", LocalDate.now().plusDays(30), unidade, 100);
        UUID produtoId = produtoDAO.salvar(produto);
        System.out.println("Produto salvo com ID: " + produtoId);

        // Criar uma Venda e Persiste a Venda, adicionar um ProdutoVenda e persistir
        Venda<UUID> venda = new Venda<>(clienteId, usuarioId);
        UUID vendaId = vendaDAO.salvar(venda);
        cliente.adicionarVenda(vendaId);
        System.out.println("Venda salva com ID: " + vendaId);


        // Cria um ProdutoVenda para a venda
        ProdutoVenda<UUID> pv = new ProdutoVenda<>(vendaId, produtoId, 2, produto.getPreco());
        // Adiciona o produto à venda
        venda.adicionarProduto(pv);
        // Persiste o ProdutoVenda, se necessário
        UUID produtoVendaId = produtoVendaDAO.salvar(pv);
        System.out.println("ProdutoVenda salvo com ID: " + produtoVendaId);


        // Exibir total da venda calculado com base nos produtos adicionados
        System.out.println("Total da venda: R$ " + venda.calculateTotal());

        // Consultar e exibir as vendas
        System.out.println("Lista de vendas:");
        vendaDAO.consultarVendas(clienteDAO).forEach(System.out::println);

        // Atualizar informações do Cliente
        cliente.setTelefone("11888888888");
        clienteDAO.atualizar(cliente);
        Cliente<UUID> clienteAtualizado = clienteDAO.buscarPorId(clienteId);
        System.out.println("Cliente atualizado, novo telefone: " + clienteAtualizado.getTelefone());

        // Remover o Produto e testar a remoção
        produtoDAO.deletar(produtoId);
        Produto produtoRemovido = produtoDAO.buscarPorId(produtoId);
        System.out.println("Produto removido com sucesso? " + (produtoRemovido == null));
    }

    public static Object getController() {
        return loader.getController();
    }

    public static void setRoot(String fxml) {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) {
        try {
            loader = new FXMLLoader(App.class.getResource(fxml));
            Parent parent = loader.load();
            Object controller = loader.getController();
            if (controller != null) {
                parent.getProperties().put("controller", loader.getController());
            }
            return parent;
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Erro ao carregar o arquivo " + fxml).show();
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
