package uppgift3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 11/29/2020
 */
public class MainController implements Initializable {

    public ObservableList<TimeHistory> list = FXCollections.observableArrayList();//Creat observable Array List for using in table view .
    @FXML
    private Button btnStart;
    @FXML
    private Label lblTime;//Label Shows stopwatch timer.
    @FXML
    private Button btnExit;//Button for exiting app.
    @FXML
    private Button btnReset;//Button for Reset the stopwatch and clean time Table history app.
    @FXML
    private TableView<TimeHistory> tblTimerHistory;//Table view of history timer.
    @FXML
    private TableColumn<TimeHistory, String> timeStampData;//Time stamp att stop Stopwatch.
    @FXML
    private TableColumn<TimeHistory, String> lastTimeData;//Last amount of timer stopwatch.
    @FXML
    private boolean timeFlagStart = true;
    @FXML
    private Label lblClock;
    private Timeline timeline;
    private Timeline clock;

    private int min = 0, sec = 0, milliS = 0;
    private String lastTime;
    private String timeStamp;

    //Exit function .
    public void exit(ActionEvent event) {
        System.exit(0);

    }

    //Stopwatch timer function.
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
                + (((milliS / 10) == 0) ? "00" : (((milliS / 100) == 0) ? "0" : "")) + milliS++);
        lastTime = lblTime.getText();
    }

    //Start Stopwatch function.
    public void start() {

        digitalClock();//Show digital clock after setting the stopwatch.
        lblTime.setText("00:00:000");
        btnStart.setText("Start");//Set Start test to the button.
        //Initialize  timer timeline
        timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> changeTime(lblTime)));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        btnStart.setOnAction(event -> {
            //Start and stop and set logic alternative .
            if (timeFlagStart) {

                timeline.play();
                timeFlagStart = false;
                btnStart.setText("Stop");
            } else {
                timeline.pause();
                timeFlagStart = true;
                btnStart.setText("Start");
                //format time for more convince output.
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String timeStamp = now.format(formatter);
                TimeHistory timeHistory = new TimeHistory(timeStamp, lastTime);
                list.add(timeHistory);//Add Data to the Tableview.


            }
        });


    }

    //Reset and clear history function.
    public void reset(ActionEvent event) {
        min = 0;
        sec = 0;
        milliS = 0;
        timeline.pause();
        lblTime.setText("00:00:000");
        tblTimerHistory.getItems().clear();
        if (!timeFlagStart) {
            timeFlagStart = true;
            btnStart.setText("Start");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeStampData.setCellValueFactory(new PropertyValueFactory<>("timeStampData"));
        lastTimeData.setCellValueFactory(new PropertyValueFactory<>("lastTimeData"));
        tblTimerHistory.setItems(list);

    }

    //Clock function
    public void digitalClock() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblClock.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

}











