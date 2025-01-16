package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.controller.util.Alerts;
import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.service.ValidaCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField txSenha;

    @FXML
    private TextField txUsuario;

    @FXML
    private Button btnEntra;

    @FXML
    public void entrar(ActionEvent event) {
        try {
            // Valida o login com o serviço ValidaCliente
            Cliente cliente = new ValidaCliente().validaLogin(txUsuario.getText(), txSenha.getText());

        } catch (LoginInvalidoException e) {
            Alerts.showAlert("Login invalido", "Login ou senha inválidos. Por favor, verifique as informações e tente novamente.","Erro de Login", AlertType.ERROR);
        }
    }

    @FXML
    void limparCampos(ActionEvent event) {
        // Limpa os campos de entrada
        txUsuario.clear();
        txSenha.clear();
    }
}
