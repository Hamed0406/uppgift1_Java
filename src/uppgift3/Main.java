/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 11/25/2020
 */

package uppgift3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // BorderPane root = new BorderPane();
            Button clickMe = new Button("Click me");
            Button exit = new Button("Exit");
            exit.setOnAction(e -> {
                System.out.println("Exit app");

                System.exit(0);

            });//Using Landa expressions to call multiply method.

            VBox root = new VBox();//Layout Vertical box
            root.getChildren().addAll(exit, clickMe);
            Scene scene = new Scene(root, 400, 400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("First APP GUI");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
