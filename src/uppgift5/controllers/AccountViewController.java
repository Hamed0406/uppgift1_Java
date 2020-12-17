package uppgift5.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import uppgift5.models.TransactionModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/16/2020
 */
public class AccountViewController implements Initializable {
    public Path path = Path.of("src/uppgift5/Resources/TempUser.txt");

    public String logonUser;
    public ObservableList<TransactionModel> list = FXCollections.observableArrayList();
    String balance;
    @FXML
    private Label lbLogonUser;
    @FXML
    private Button btnExt;
    @FXML
    private Button btnLodUs;
    @FXML
    private TableView<TransactionModel> tableView;
    @FXML
    private TableColumn<TransactionModel, String> transactionColumn;
    @FXML
    private TableColumn<TransactionModel, String> dateColumn;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLoadUser;
    @FXML
    private Button btnLoadTransaction;
    @FXML
    private Button btnDeposit;
    @FXML
    private Button btnWithrow;
    @FXML
    private TextField txDeposit;
    @FXML
    private TextField txWithrow;


    public void loadUser(ActionEvent event) throws FileNotFoundException {
        File file = new File(String.valueOf(path));
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            logonUser = data;
            System.out.println(data);


        }

        reader.close();

        //   System.out.println(logonUser);

        lbLogonUser.setText(logonUser);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionColumn.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        tableView.setItems(list);
    }
}
