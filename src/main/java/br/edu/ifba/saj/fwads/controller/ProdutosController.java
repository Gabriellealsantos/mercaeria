package br.edu.ifba.saj.fwads.controller;

import br.edu.ifba.saj.fwads.App;
import br.edu.ifba.saj.fwads.model.entities.Alimento;
import br.edu.ifba.saj.fwads.model.entities.Bebida;
import br.edu.ifba.saj.fwads.model.entities.Produto;
import br.edu.ifba.saj.fwads.model.service.CarrinhoService;
import br.edu.ifba.saj.fwads.model.service.ProdutoService;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ProdutosController implements Initializable {

    private ProdutoService service;
    private CarrinhoService carrinhoService;

    @FXML
    private TableView<Produto> tableViewProduto;

    @FXML
    private TableColumn<Produto, Integer> colIdProduto;

    @FXML
    private TableColumn<Produto, Produto> colAddCarrinhoProduto;

    @FXML
    private TableColumn<Produto, String> colNomeProduto;

    @FXML
    private TableColumn<Produto, Double> colPrecoProduto;

    @FXML
    private TableColumn<Produto, String> colDescricaoProduto;

    @FXML
    private TableColumn<Produto, LocalDate> colDataDeValidadeProduto;

    @FXML
    private TableColumn<Alimento, String> colTipoProduto;

    private ObservableList<Produto> obsList;

    public void setProdutoService(ProdutoService service) {
        this.service = service;
    }

    public void setCarrinhoService(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }

    private void initializeNodes() {

        colIdProduto.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNomeProduto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPrecoProduto.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colDescricaoProduto.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colDataDeValidadeProduto.setCellValueFactory(new PropertyValueFactory<>("dataValidade"));


        colTipoProduto.setCellValueFactory(cellData -> {
            Produto produto = cellData.getValue();
            if (produto instanceof Alimento) {
                return new SimpleStringProperty(((Alimento) produto).getTipo());
            }
            return new SimpleStringProperty(String.valueOf(((Bebida) produto).getVolume()));
        });

        Stage stage = (Stage) App.getMainScene().getWindow();
        tableViewProduto.prefHeightProperty().bind(stage.heightProperty());
        initEditButtons();
    }

    public void updateTableView() {
        if (service == null) {
            throw new IllegalStateException("Service esta nulo!");
        }

        List<Produto> list = service.buscarTodos();
        obsList = FXCollections.observableArrayList(list);
        tableViewProduto.setItems(obsList);

    }

    private void initEditButtons() {
        colAddCarrinhoProduto.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        colAddCarrinhoProduto.setCellFactory(param -> new TableCell<Produto, Produto>() {
            private final Button button = new Button("Adicionar ao carrinho");

            @Override
            protected void updateItem(Produto obj, boolean empty) {
                super.updateItem(obj, empty);
                if (obj == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> {
                            carrinhoService.adicionarProduto(obj);

                        }
                );

            }
        });
    }

    ;
}
