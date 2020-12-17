package uppgift5.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/16/2020
 */
public class AccountViewController {
    public Path path = Path.of("src/uppgift5/Resources/TempUser.txt");

    public String logonUser;

    String balance;
    @FXML
    private Label lbLogonUser;
    @FXML
    private Button btnExt;
    @FXML
    private Button btnLodUs;


    public void loadUser(ActionEvent event) throws FileNotFoundException {
        File myObj = new File(String.valueOf(path));
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            logonUser = data;
            System.out.println(data);


        }

        myReader.close();

        System.out.println(logonUser);

        lbLogonUser.setText(logonUser);

    }
}
