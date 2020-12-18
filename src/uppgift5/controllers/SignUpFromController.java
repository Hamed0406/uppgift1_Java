package uppgift5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import uppgift5.models.User;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/14/2020
 */
public class SignUpFromController {
    @FXML
    private Button btnTologin;
    public static final String xmlFilePath = "src\\uppgift5\\XMLUserDataBase.xml";
    public List<User> list=new ArrayList<>();
    //To load first to have all users .
    public XmlController xmlController = new XmlController();
    @FXML
    private Button btnSgnUp;
    @FXML
    private TextField txFirstName;
    @FXML
    private TextField txLastName;
    @FXML
    private TextField txUserID;
    @FXML
    private PasswordField txPassword;

    String path =("src\\uppgift5\\Resources\\");

    public void setBtnTologin(ActionEvent event) throws IOException {
        Parent loginParent = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));

        Scene loginView = new Scene(loginParent);
//Get stage Information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginView);
        window.show();
    }

    public void signUpUser(ActionEvent event) throws ParserConfigurationException, TransformerException, SAXException, IOException {
        //TODO load list from XML
        //get new user

        User user = new User(txFirstName.getText(), txLastName.getText(), txUserID.getText(), txPassword.getText(), "0");
        //TODO creat xml file for a user
        fileCreator(txUserID.getText());
        loadfromXMl(list);
        //clear fields
        txFirstName.clear();
        txLastName.clear();
        txUserID.clear();
        txPassword.clear();
        list.add(user);
       xmlController.writeUserToXMl(list);
    }

    public void loadfromXMl(List<User> list) throws IOException, SAXException, ParserConfigurationException {

        list.clear();
        String firstNameT = null;
        String lastNameT = null;
        String userIDT = null;
        String paswordT = null;
        String balanceT = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();


        Document xmlDOc = documentBuilder.parse(xmlFilePath);
        //read array of user elements
        NodeList personList = xmlDOc.getElementsByTagName("user");


        for (int i = 0; i < personList.getLength(); i++) {
            org.w3c.dom.Node p = personList.item(i);
            if (p.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element user = (Element) p;
                String ID = user.getAttribute("ID");
                NodeList nameList = user.getChildNodes();
                firstNameT = user.getElementsByTagName("firstName").item(0).getTextContent();
                lastNameT = user.getElementsByTagName("lastName").item(0).getTextContent();
                userIDT = user.getElementsByTagName("userID").item(0).getTextContent();
                paswordT = user.getElementsByTagName("password").item(0).getTextContent();
                balanceT = user.getElementsByTagName("balance").item(0).getTextContent();


                User tempU = new User(firstNameT, lastNameT, userIDT, paswordT, balanceT);
                list.add(tempU);

            }


        }
    }

    public void fileCreator(String userNameID) throws IOException {


        if (!checkFile(userNameID))
            try {
                File file = new File(path + userNameID + ".xml");
                if (file.createNewFile()) {
                    System.out.println(userNameID + "had been created");
                    BankAccountController bankAccountController=new BankAccountController();
                    bankAccountController.openAccount(userNameID);
                }
            } catch (IOException e) {
                e.printStackTrace();

                e.getCause();
            } catch (TransformerException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
    }

    private Boolean checkFile(String checkUserID) {
        File tmpDir = new File(path + checkUserID + ".xml");
        boolean exists = tmpDir.exists();
        return exists;
    }

}
