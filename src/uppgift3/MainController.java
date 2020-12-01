package uppgift3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import javax.imageio.IIOException;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 11/29/2020
 */
public class MainController {

    @FXML
    private Label lblTime;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnReset;
    private boolean timeFlagStart = true;
    private Timeline timeline;
    private int min = 0, sec = 0, milliS = 0;


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


}











