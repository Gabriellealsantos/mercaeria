package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.controller.util.Alerts;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import java.io.IOException;

public class MainViewController {

    @FXML
    private BorderPane masterPane;

    @FXML
    private VBox menu;

    @FXML
    private Label userEmail;

    @FXML
    private Circle userPicture;

    @FXML
    private Button btnsobre;

    @FXML
    public void onHandleSobre(){
        loadView("gui/Sobre.fxml");
    }

    @FXML
    void logOff(MouseEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION, "Deseja realmente sair??", ButtonType.YES, ButtonType.NO);
        alert.showAndWait()
                .filter(response -> response == ButtonType.YES)
                .ifPresent(response -> {

                });
    }

    public void setEmail(String email) {
        userEmail.setText(email);
    }

    private synchronized void loadView(String absoluteName) {
        try {

            if (getClass().getResource(absoluteName) == null) {
                Alerts.showAlert("Resource Not Found", "The resource " + absoluteName + " was not found.", null, AlertType.ERROR);
                return;
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();


            Scene mainScene = App.getMainScene();

            System.out.println(mainScene.getRoot().getClass());

            VBox mainVBox = (VBox) ((BorderPane) mainScene.getRoot()).getCenter();
            mainVBox.getChildren().clear();
            mainVBox.getChildren().addAll(newVBox);

        } catch (IOException e) {
            Alerts.showAlert("IO Exception", "Error loading page: " + absoluteName, e.getMessage(), AlertType.ERROR);

        }
    }
}
