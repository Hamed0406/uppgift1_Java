package uppgift5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/12/2020
 */
public class LoginController {
    @FXML
    private Button btnLogin;
    @FXML
    private Button bthSignUp;
    @FXML
    private Button btnExit;
    @FXML
    private TextField txUserID;
    @FXML
    private PasswordField txPass;
    @FXML
    private Label lbLoginMessage;

    public void setBtnExit(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void setBtnLogin(ActionEvent event) {
        if (txUserID.getText().isBlank()==false&&txPass.getText().isBlank() ==false) {
validateLogin();

        } else {
            lbLoginMessage.setText("Please enter User ID  or Password !!!" );

        }
    }

    public void validateLogin() {

    }
}
