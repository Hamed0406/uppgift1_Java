package uppgift5.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/18/2020
 */
public class ChangePasswordController {
    public Path path = Path.of("src/uppgift5/Resources/TempUser.txt");
    @FXML
    private Label lbUserLogon;
    @FXML
    private PasswordField txNewPassword;
    @FXML
    private Button btnChangePassword;
    //implements Initializable
    @FXML
    private TextArea txMessage;

    public void loadUser() throws FileNotFoundException {
        File file = new File(String.valueOf(path));
        Scanner reader = new Scanner(file);
        String data = null;
        while (reader.hasNextLine()) {
            data = reader.nextLine();
        }
        lbUserLogon.setText("You are login as:  " + data);
    }
  /*  @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadUser();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}
