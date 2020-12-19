package uppgift5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/18/2020
 */
public class ChangePasswordController implements Initializable {
    public Path path = Path.of("src/uppgift5/Resources/TempUser.txt");
    public XmlController xmlController = new XmlController();
    @FXML
    private Label lbUserLogon;
    @FXML
    private PasswordField txNewPassword;
    @FXML
    private Button btnChangePassword;
    @FXML
    private TextArea txMessage;
    public String data = null;

    public void loadUser() throws FileNotFoundException {
        //get login user
        File file = new File(String.valueOf(path));
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            data = reader.nextLine();
        }
        lbUserLogon.setText("You are login as:  " + data);
    }

    public void setBtnChangePassword(ActionEvent event) throws IOException, ParserConfigurationException, SAXException, TransformerException, XPathExpressionException {

        //replace password with new Password
        xmlController.updatePasswordInXML(data, txNewPassword.getText());
        txNewPassword.clear();
        System.out.println("You change password successfully.Please Login with new Password.");
        //Redirect toward Login.
        towardLoginView(event);
    }

    public void towardLoginView(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        Scene loginView = new Scene(loginParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginView);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txMessage.setText("After you set New Password ,You will redirected to Login Page. ");
        try {
            loadUser();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
