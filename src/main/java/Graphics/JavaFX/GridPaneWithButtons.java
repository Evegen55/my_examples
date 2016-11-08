package Graphics.JavaFX;

import Graphics.JavaAWT.JavaExampleColorChooser;
import Graphics.JavaAWT.OptionalPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Evgenii_Lartcev (created on 11/8/2016).
 */
public class GridPaneWithButtons extends Application implements EventHandler<ActionEvent> {

    private Button buttonForChoosingColor;
    private Button buttonForJPane;

    @Override
    public void start(final Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window with buttons");

        buttonForChoosingColor = new Button();
        buttonForJPane = new Button();
        buttonForChoosingColor.setText("Choose color");
        buttonForJPane.setText("Input passwd");

        //handle event
        buttonForChoosingColor.setOnAction(this);
        buttonForJPane.setOnAction(this);

        //GridPane allows you to create a flexible grid of rows and columns and position each node in exact place.
        final GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.add(buttonForChoosingColor, 0, 0);
        gridPane.add(buttonForJPane, 1, 2);
        gridPane.setStyle("-fx-background-color: #87CEFA;");
        final Scene scene = new Scene(gridPane, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void handle(final ActionEvent event) {
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
