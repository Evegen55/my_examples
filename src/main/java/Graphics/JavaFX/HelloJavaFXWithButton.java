package Graphics.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Evegen (create on 11.10.2016).
 */
public class HelloJavaFXWithButton extends Application {

    private Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window with button");

        button = new Button();
        button.setText("BIG BUTTON");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 200, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    //this is no necessary need - try t comment it
//    public static void main(String[] args) {
//        launch(args);
//    }
}
