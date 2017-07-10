package Graphics.JavaFX;

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

/**
 * @author (created on 7/10/2017).
 */
public class HelloJavaFxVideoPlayer extends Application {

    private Logger logger = Logger.getLogger(HelloJavaFxVideoPlayer.class.getName());

    private File videoFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.info("Inside start method");
        final Group group = new Group();
        videoFile = new File("src/main/resources/GoPro_Diving_with_Ocean_Hounds/GoPro_Diving_with_Ocean_Hounds_hd1080.mp4");
        final Media media_mp4 = new Media("file:///" + videoFile.toURI().getPath());

        logger.info("media_mp4 opened " + media_mp4.getSource());
        final MediaPlayer mediaPlayer = new MediaPlayer(media_mp4);
        final MediaView mediaView = new MediaView(mediaPlayer);
        group.getChildren().add(mediaView);
        final Scene scene = new Scene(group, media_mp4.getWidth(), media_mp4.getHeight(), Color.BLACK);

        primaryStage.setTitle("Window with video player");
        primaryStage.setScene(scene);
        primaryStage.show();
        logger.info("Start to play");
        mediaPlayer.play();
        logger.info("Now playing");
    }
}
