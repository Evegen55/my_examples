package JavaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Evgenii_Lartcev (created on 10/11/2016).
 */
public class HelloJavaFXWithButtonAndEvents extends Application implements EventHandler<ActionEvent> {

    private Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window with button");

        button = new Button();
        button.setText("BIG BUTTON");

        //handle event
        button.setOnAction(this);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 200, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        //do when event is done
        if (event.getSource() == button) {
            System.out.println("asdfhsd;fgjsdaf;sdjif;o");
        }
    }

    //now, it is necessary for handle events!
    public static void main(String[] args) {
        launch(args);
    }
}
