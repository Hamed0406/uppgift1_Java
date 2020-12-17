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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import uppgift5.models.AuthenticationModel;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;


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
    Path path = Path.of("src/uppgift5/Resources/TempUser.txt");
    public static final String xmlFilePath = "src\\uppgift5\\XMLUserDataBase.xml";
XmlController xmlController=new XmlController();

    public String getSearchUser() {
        return searchUser;
    }

    public String searchPassword;

    public void setSearchUser(String searchUser) {
        this.searchUser = searchUser;
    }


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
            if (validateLogin(authenticationLogin)) {
                getValidatedUser(searchUser);
                fromLoginToAccountView(event);
            } else
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

    public void fromLoginToSignUpForm(ActionEvent event) throws IOException, TransformerException, ParserConfigurationException {
//TODO change Scene to SignUP from.
        //TODO check if XMLUserDataBase.xml exists if is not creat with admin.
      if(  !checkFile())
      {
          creatXMLAndAdmin();
          System.out.println("files is ncreated ");
      }
        Parent formViewParent = FXMLLoader.load(getClass().getResource("../views/SignUpFormView.fxml"));
        Scene formViewScene = new Scene(formViewParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(formViewScene);
        window.show();
    }

    private Boolean checkFile() {
        File tmpDir = new File(xmlFilePath);
        boolean exists = tmpDir.exists();
        return exists;
    }

    public void creatXMLAndAdmin() throws ParserConfigurationException, TransformerException {
        // creat DocumentBuilder
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        //Document
        Document xmlDoc = documentBuilder.newDocument();
        //Build XML Element and text nodes
        Element rootElement = xmlDoc.createElement("users");
        Element mainElement = xmlDoc.createElement("user");


        rootElement.appendChild(xmlController.setUser(0,"Admin","Admin","Admin","Admin","0",xmlDoc));

        xmlDoc.appendChild(rootElement);

        //Set output format
        //Declare the  file
        //Declare the fileOutPutStream
        //Creat XMLSerializer the XMl data with
        //The specified output format
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(xmlDoc);
        StreamResult streamResult = new StreamResult(new File(xmlFilePath));
        transformer.transform(domSource, streamResult);


    }

    public void fromLoginToAccountView(ActionEvent event) throws IOException {

        Parent formViewParent = FXMLLoader.load(getClass().getResource("../views/AccountView.fxml"));
        Scene formViewScene = new Scene(formViewParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(formViewScene);
        window.show();
    }

    public void getValidatedUser(String toRegister) throws IOException {


        try {
            File file = new File(String.valueOf(path));
            if (file.createNewFile())
                System.out.println("Data had been Transferred ");
            FileWriter myWriter = new FileWriter(String.valueOf(path));
            myWriter.write(toRegister);
            myWriter.close();
        } catch (IOException e) {
            e.getCause();
        }
    }

}
