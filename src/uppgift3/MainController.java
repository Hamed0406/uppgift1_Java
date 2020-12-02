package uppgift3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

import javax.imageio.IIOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 11/29/2020
 */
public class MainController implements Initializable {

    @FXML
    private Label lblTime;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnReset;
    @FXML
    private TableView<TimeHistory> tblTimerHistory;
    @FXML
    private TableColumn<TimeHistory, String> timeStampData;
    @FXML
    private TableColumn<TimeHistory, String> lastTimeData;
    private boolean timeFlagStart = true;
    private Timeline timeline;
    private int min = 0, sec = 0, milliS = 0;
    private String lastTime;
    private String timeStamp;


    public void exit(ActionEvent event) throws IIOException {
        System.exit(0);

    }


    public void changeTime(Label lblTime) {
        if (milliS == 1000) {
            sec++;
            milliS = 0;
        }
        if (sec == 60) {
            min++;
            sec = 0;
        }
        lblTime.setText((((min / 10) == 0) ? "0" : "") + min + ":"
                + (((sec / 10) == 0) ? "0" : "") + sec + ":"
                + (((milliS / 10) == 0) ? "00" : (((milliS / 100) == 0) ? "0" : "")) + milliS++ + " Secs");
        lastTime = lblTime.getText();
    }

    public void start() {
        lblTime.setText("00:00:000");
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                changeTime(lblTime);
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (timeFlagStart) {
                    timeline.play();
                    timeFlagStart = false;
                    btnStart.setText("Stop");
                } else {
                    timeline.pause();
                    timeFlagStart = true;
                    btnStart.setText("Start");
                    timeStamp = java.time.LocalDateTime.now().toString();
                    //TODO Popout time stamp and Last Time in Tableview.
                    TimeHistory timeHistory = new TimeHistory(timeStamp, lastTime);
                    System.out.println(timeHistory);
                     ObservableList<TimeHistory> list = FXCollections.observableArrayList(
                            new TimeHistory(timeStamp, lastTime)
                    );


                }
            }
        });


    }


    public void reset(ActionEvent event) {
        min = 0;
        sec = 0;
        milliS = 0;
        timeline.pause();
        lblTime.setText("00:00:000");
        if (!timeFlagStart) {
            timeFlagStart = true;
            btnStart.setText("Start");
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle,ObservableList list) {
        timeStampData.setCellValueFactory(new PropertyValueFactory<TimeHistory, String>("timeStampData"));
        lastTimeData.setCellValueFactory(new PropertyValueFactory<TimeHistory, String>("lastTimeData"));
        tblTimerHistory.setItems(list);

    }
}











