package Graphics.JavaFX;/**
 * @author (created on 7/10/2017).
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.logging.Logger;

public class HelloJavaFxPlayer extends Application {

    private Logger logger = Logger.getLogger(HelloJavaFxPlayer.class.getName());

    public HelloJavaFxPlayer() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        logger.info("Inside start method");
        final Group group = new Group();

        final File file = new File("src/main/resources/GoPro_Diving_with_Ocean_Hounds/GoPro_Diving_with_Ocean_Hounds_126k.m4a");
        final String absolutePath = file.toURI().getPath();

        final Media mediaSoundM4a = new Media("file:///" + absolutePath);
        logger.info("mediaSoundM4a opened " + mediaSoundM4a.getSource());
        final MediaPlayer mediaPlayer = new MediaPlayer(mediaSoundM4a);
        final MediaView mediaView = new MediaView(mediaPlayer);
        group.getChildren().add(mediaView);
        final Scene scene = new Scene(group, 800, 100, Color.BLACK);

        primaryStage.setTitle("Window with player");
        primaryStage.setScene(scene);
        primaryStage.show();
        logger.info("Start to play");
        mediaPlayer.play();
        logger.info("Now playing");
    }
}
