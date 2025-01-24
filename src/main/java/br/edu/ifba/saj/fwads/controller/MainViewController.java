package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.controller.util.Alerts;
import br.edu.ifba.saj.fwads.model.service.ProdutoService;
import com.sun.tools.javac.Main;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainViewController implements Initializable {

    @FXML
    private Label userEmail;

    @FXML
    private Button btnProdutos;

    @FXML
    private Button btnSobre;


    @FXML
    public void onBtSobre(){
        loadView("gui/Sobre.fxml", x -> {});
    }

    @FXML
    public void onBtProdutos(){
        loadView("gui/Produtos.fxml", (ProdutosController controller) -> {
            controller.setProdutoService(new ProdutoService());
            controller.updateTableView();
        });

    }



    @FXML
    void logOff(MouseEvent event) {
        Optional<ButtonType> result = Alerts.showConfirmation("Sair", "Deseja realmente sair?");


        if (result.isPresent() && result.get() == ButtonType.OK) {

            System.out.println("Usuário confirmou a saída!");

            App.setRoot("controller/gui/Login.fxml");

        } else {

            System.out.println("Usuário cancelou a saída!");
        }
    }

    public void setEmail(String email) {
        userEmail.setText(email);
    }

    private synchronized <T> void loadView(String absoluteName, Consumer<T> acaoDeInicializacao) {
        try {

            if (getClass().getResource(absoluteName) == null) {
                Alerts.showAlert("Resource Not Found", "The resource " + absoluteName + " was not found.", null, AlertType.ERROR);
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();


            Scene mainScene = App.getMainScene();

            VBox mainVBox = (VBox) ((BorderPane) mainScene.getRoot()).getCenter();
            mainVBox.getChildren().clear();
            mainVBox.getChildren().addAll(newVBox);

            T controler = loader.getController();
            acaoDeInicializacao.accept(controler);

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading page: " + absoluteName, e.getMessage(), AlertType.ERROR);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}
