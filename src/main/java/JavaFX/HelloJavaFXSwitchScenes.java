package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author Evgenii_Lartcev (created on 10/14/2016).
 */
public class HelloJavaFXSwitchScenes extends Application {
    private Stage window;
    private Scene scene1;
    private Scene scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Label label1 = new Label("Welcome to scene1");
        Button button1 = new Button("Go to Scene 2");
        button1.setOnAction(event -> window.setScene(scene2));
        // TODO: 10/14/2016  
    }
}
