package uppgift5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/14/2020
 */
public class SignUpFromController {
    @FXML
    private Button btnTologin;

    public void setBtnTologin(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        Scene loginView = new Scene(loginParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginView);
        window.show();
    }

}
