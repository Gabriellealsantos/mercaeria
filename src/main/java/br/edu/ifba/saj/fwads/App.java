package br.edu.ifba.saj.fwads;

import br.edu.ifba.saj.fwads.model.entities.*;
import br.edu.ifba.saj.fwads.model.service.CarrinhoService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene mainScene;
    private static FXMLLoader loader;

    @Override
    public void start(Stage stage) throws IOException {
        loader = new FXMLLoader(App.class.getResource("controller/gui/Login.fxml"));
        mainScene = new Scene(loader.load(), 1000, 800);
        stage.setScene(mainScene);
        stage.setTitle("Mercearia");
        stage.show();

        // Criando cliente
        Endereco endereco = new Endereco("Rua A", "123", "Apto 101", "Centro", "Cidade X");
        Cliente cliente = new Cliente("João", "12345678901", "joao@mail.com", "senha123", "M", endereco);

        // Criando produtos
        Produto arroz = new Alimento("Arroz", 5.50, "Arroz branco", LocalDate.now().plusMonths(6), null, "Grão");
        Produto feijao = new Alimento( "Feijão", 6.80, "Feijão preto", LocalDate.now().plusMonths(6), null, "Grão");



        // Criando carrinho
        Carrinho carrinho = new Carrinho(cliente);
        carrinho.adicionarProduto(arroz);
        carrinho.adicionarProduto(feijao);

        // Criando serviço de carrinho e realizando a compra
        CarrinhoService carrinhoService = new CarrinhoService(carrinho);
        carrinhoService.realizarCompra();

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Produtos: ");
        for (Produto p : carrinho.getProdutos()) {
            System.out.println(" - " + p.getNome() + ": R$" + p.getPreco());
        }

        System.out.println("Total: R$" + carrinhoService.calcularTotal());

    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static Object getController() {
        return loader.getController();
    }

    public static void setRoot(String fxml) {
        mainScene.setRoot(loadFXML(fxml));
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
