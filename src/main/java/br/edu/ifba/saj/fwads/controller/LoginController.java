package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.service.ValidaCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML // fx:id="txSenha"
    private PasswordField txSenha; // Value injected by FXMLLoader

    @FXML // fx:id="txUsuario"
    private TextField txUsuario; // Value injected by FXMLLoader

    @FXML
    void entrar(ActionEvent event) {
        try {
            // Valida o login com o serviço ValidaCliente
            Cliente cliente = new ValidaCliente().validaLogin(txUsuario.getText(), txSenha.getText());

            // Carrega a próxima tela e configura o MasterController



        } catch (LoginInvalidoException e) {
            // Exibe alerta de erro no login
            new Alert(AlertType.ERROR, e.getMessage()).showAndWait();
        }
    }

    @FXML
    void limparCampos(ActionEvent event) {
        // Limpa os campos de entrada
        txUsuario.clear();
        txSenha.clear();
    }
}
