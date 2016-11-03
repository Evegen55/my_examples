package Graphics.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        Label label_1 = new Label("Welcome to scene1");
        Button button_1 = new Button("Go to Scene 2");
        button_1.setOnAction(event -> window.setScene(scene2));

        //layout 1 children are laid out in vertical column
        VBox layout_1 = new VBox(20);
        layout_1.getChildren().addAll(label_1, button_1);
        scene1 = new Scene(layout_1, 200, 200);

        Button button_2 = new Button("Go to Scene 1");
        button_2.setOnAction(event -> window.setScene(scene1));

        //layout 2
        StackPane layout_2 = new StackPane();
        layout_2.getChildren().add(button_2);
        scene2 = new Scene(layout_2, 600, 600);

        window.setScene(scene2);
        window.show();
    }
}
