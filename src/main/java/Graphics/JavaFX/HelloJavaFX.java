package Graphics.JavaFX;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Evegen (create on 10.10.2016).
 */
public class HelloJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
    }

    //this is no necessary need - try t comment it
    public static void main(String[] args) {
        launch(args);
    }
}
