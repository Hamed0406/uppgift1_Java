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
import uppgift4.models.Person;

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
    private String firstName;
    private String lastName;
    private String age;

    //Add Functionality a persson to Table view
    public void addToTable(ActionEvent event) {

//Add a new person
        //Adding to the local string for saving in XML file.
        firstName=tfFirstName.getText();
        lastName=tfLastName.getText();
        age=tfAge.getText();
        list.add(new Person(firstName,lastName ,age ));
//Clear TextFields
        tfFirstName.clear();
        tfLastName.clear();
        tfAge.clear();
        //TODO add a person to XML file
    }

    public void deleteFromTable(ActionEvent event)
    {// get value before deleting .
        firstName=tableView.getSelectionModel().getSelectedItem().getFirstName();
        lastName=tableView.getSelectionModel().getSelectedItem().getLastName();
        age=tableView.getSelectionModel().getSelectedItem().getAge();
        //Delete from table view .
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItem());
        //TODO Delete from XML file
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableView.setItems(list);
    }
}
