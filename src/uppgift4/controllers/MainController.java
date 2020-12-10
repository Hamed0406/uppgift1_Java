package uppgift4.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import uppgift4.models.Person;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/6/2020
 */
public class MainController implements Initializable {
    public ObservableList<Person> list = FXCollections.observableArrayList();// TODO Load XML files and ADD to Table view.
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, String> ageColumn;
    @FXML
    private TextField tfFirstName;
    @FXML
    private TextField tfLastName;
    @FXML
    private TextField tfAge;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnWriteXML;
    @FXML
    private Button btnLoadXML;
    private String firstName;
    private String lastName;
    private String age;
    public static final String xmlFilePath = "C:\\Users\\Hamed.000\\git\\uppgifttar\\src\\uppgift4\\XMLDataBase.xml";
    public XMLController xmlController = new XMLController();

    //Add Functionality a persson to Table view
    public void addToTable(ActionEvent event) throws TransformerException, ParserConfigurationException {

//Add a new person
        //Adding to the local string for saving in XML file.
        firstName = tfFirstName.getText();
        lastName = tfLastName.getText();
        age = tfAge.getText();
        list.add(new Person(firstName, lastName, age));

        //Clear TextFields
        tfFirstName.clear();
        tfLastName.clear();
        tfAge.clear();
        //Update Xml file with Add
        xmlController.writePersonToXMl(list);
    }

    public void deleteFromTable(ActionEvent event) throws TransformerException, ParserConfigurationException {// get value before deleting .
        firstName = tableView.getSelectionModel().getSelectedItem().getFirstName();
        lastName = tableView.getSelectionModel().getSelectedItem().getLastName();
        age = tableView.getSelectionModel().getSelectedItem().getAge();
        //Delete from table view .
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        //Update Xml file with Deleting
        xmlController.writePersonToXMl(list);

    }

    public void updateTable(ActionEvent event) throws TransformerException, ParserConfigurationException {
        //Edit mood for Table view with double click
        tableView.setEditable(true);
        firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//First name Column edit
        firstNameColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setFirstName(t.getNewValue());
                });


//Last name Column edit

        lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setLastName(t.getNewValue());
                });

//Age  Column edit

        ageColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ageColumn.setOnEditCommit(
                (TableColumn.CellEditEvent<Person, String> t) -> {
                    t.getTableView().getItems().get(
                            t.getTablePosition().getRow()).setAge(t.getNewValue());
                });
        //Update Xml file with Update
        xmlController.writePersonToXMl(list);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableView.setItems(list);
    }


    public void writeToXML(ActionEvent event) throws TransformerException, ParserConfigurationException {

        xmlController.writePersonToXMl(list);
    }

    public void loadFromXML(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        list.clear();
        String firstNameT = null;
        String lastNameT = null;
        String ageT = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document xmlDOc = documentBuilder.parse(xmlFilePath);
        //read array of student elements
        NodeList personList = xmlDOc.getElementsByTagName("person");


        for (int i = 0; i < personList.getLength(); i++) {
            Node p = personList.item(i);
            if (p.getNodeType() == Node.ELEMENT_NODE) {
                Element person = (Element) p;
                String ID = person.getAttribute("ID");
                NodeList nameList = person.getChildNodes();
                firstNameT = person.getElementsByTagName("firstName").item(0).getTextContent();
                lastNameT = person.getElementsByTagName("lastName").item(0).getTextContent();
                ageT = person.getElementsByTagName("age").item(0).getTextContent();
                Person tempP = new Person(firstNameT, lastNameT, ageT);
                list.add(tempP);

            }


        }
     //   System.out.println("Reade XML");
    }


}
