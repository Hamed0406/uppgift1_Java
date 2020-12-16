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
import uppgift5.models.AuthenticationModel;

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
    public String searchUser;
    public String searchPassword;


    public void setBtnExit(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void login(ActionEvent event) throws Exception {

        AuthenticationModel authenticationLogin = new AuthenticationModel();
        if (txUserID.getText().isBlank() == false && txPass.getText().isBlank() == false) {
            searchUser = txUserID.getText();
            searchPassword = txPass.getText();
            authenticationLogin.setPassword(searchPassword);
            authenticationLogin.setUserID(searchUser);
            if (validateLogin(authenticationLogin))
                fromLoginToAccountView(event);
            else
                lbLoginMessage.setText("Wrong UserID/Password!!!");


        } else {
            lbLoginMessage.setText("Please enter User ID  or Password !!!");

        }
    }

    public Boolean validateLogin(AuthenticationModel login) throws Exception {
        Boolean validated = false;
        XmlController xmlController = new XmlController();
        validated = xmlController.searchUser(login);

        return validated;
//TODO get result from XML file
        //Validate from input and go to next page


    }

    public void fromLoginToSignUpForm(ActionEvent event) throws IOException {
//TODO change Scene to SignUP from.
        Parent formViewParent = FXMLLoader.load(getClass().getResource("../views/SignUpFormView.fxml"));
        Scene formViewScene = new Scene(formViewParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(formViewScene);
        window.show();
    }

    public void fromLoginToAccountView(ActionEvent event) throws IOException {
        Parent formViewParent = FXMLLoader.load(getClass().getResource("../views/AccountView.fxml"));
        Scene formViewScene = new Scene(formViewParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(formViewScene);
        window.show();
    }
}
