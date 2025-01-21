package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.controller.util.Alerts;
import br.edu.ifba.saj.fwads.model.entities.Cliente;
import br.edu.ifba.saj.fwads.model.exception.LoginInvalidoException;
import br.edu.ifba.saj.fwads.model.service.ClienteSerivce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txuserEmail;

    @FXML
    private Button btnEntra;

    @FXML
    public void entrar(ActionEvent event) {
        try {
            Cliente cliente = new ClienteSerivce().login(txtUsuario.getText(), txtSenha.getText());
            App.setRoot("controller/gui/MainView.fxml");
            MainViewController controller = (MainViewController) App.getController();
            controller.setEmail(cliente.getEmail());
        } catch (LoginInvalidoException e) {
            Alerts.showAlert("Login invalido", "Login ou senha inválidos. Por favor, verifique as informações e tente novamente.", "Erro de Login", AlertType.ERROR);
        }
    }

    @FXML
    void limparCampos(ActionEvent event) {
        txtUsuario.clear();
        txtSenha.clear();
    }


}
