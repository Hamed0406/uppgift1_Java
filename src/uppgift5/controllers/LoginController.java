package uppgift5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


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

    public void login(ActionEvent event) {
        if (txUserID.getText().isBlank()==false&&txPass.getText().isBlank() ==false) {
validateLogin();

        } else {
            lbLoginMessage.setText("Please enter User ID  or Password !!!" );

        }
    }

    public void validateLogin() {

//TODO get result from XML file
        //Validate from input and go to next page


    }

    public void fromLoginToSignUpForm(ActionEvent event) throws IOException {
//TODO change Scene to SignUP from.
        Parent formViewParent= FXMLLoader.load(getClass().getResource("../views/SignUpFormView.fxml"));
        Scene  formViewScene= new Scene(formViewParent);
//Get stage Information
        Stage window=(Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(formViewScene);
        window.show();
    }
}
