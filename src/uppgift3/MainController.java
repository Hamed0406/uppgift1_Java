package uppgift3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 11/29/2020
 */
public class MainController {
    @FXML
    private Label lblTime;
    @FXML
    private Button btnStartStop;
    @FXML
    private Button btnExit;

public void exit(ActionEvent event)
{
    System.exit(0);

}

}
