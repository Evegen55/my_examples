package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Evgenii_Lartcev (created on 10/14/2016).
 */
public class HelloJavaFXWithLambdas extends Application {

    private Button button;

    //now, it is necessary for handle events!
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window with button");

        button = new Button();
        button.setText("BIG BUTTON WITH LAMBDAS");

        //handle event
        button.setOnAction(event -> {
            System.out.println("asfgkasjdglkjsfg;oasdifhpo");
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 200, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
