package Graphics.JavaFX;

import Graphics.JavaAWT.JavaExampleColorChooser;
import Graphics.JavaAWT.OptionalPane;
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

    private Button buttonForChoosingColor;
    private Button buttonForJPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window with buttonForChoosingColor");

        buttonForChoosingColor = new Button();
        buttonForJPane = new Button();
        buttonForChoosingColor.setText("Choose color");
        buttonForJPane.setText("Input password");

        //handle event
        buttonForChoosingColor.setOnAction(this);
        buttonForJPane.setOnAction(this);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(buttonForChoosingColor);

        //stackPane.getChildren().add(buttonForJPane); // TODO: 11/3/2016  

        Scene scene = new Scene(stackPane, 200, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        //do when event is done
        if (event.getSource() == buttonForChoosingColor) {
            new JavaExampleColorChooser("Java Color Chooser");
        }
        if (event.getSource() == buttonForJPane) {
            OptionalPane.main(new String[]{});
        }
    }

    //now, it is necessary for handle events!
    public static void main(String[] args) {
        launch(args);
    }
}
