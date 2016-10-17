package JavaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Evgenii_Lartcev (created on 10/17/2016).
 */
public class AlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button button = new Button("CLOSE");
        button.setOnAction(e -> window.close());
        VBox layout_1 = new VBox(20);
        layout_1.getChildren().addAll(label, button);
        layout_1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout_1);
        window.setScene(scene);
        window.showAndWait();
    }
}
