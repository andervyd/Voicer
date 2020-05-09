package by.andervyd;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import java.io.File;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ImageView buttonClose;
    @FXML
    private ImageView buttonPlayPause;
    @FXML
    private ImageView openFile;
/*
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ImageView buttonExpand;
    @FXML
    private ImageView buttonCollapse;
    @FXML
    private Button closeTest;
*/

    @FXML
    private Label labelNameVideo;

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private String filePath;

    public static boolean buttonTrue;



    @FXML
    void initialize() {

        openFile.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a File (*.mp4)", "*.mp4");
                fileChooser.getExtensionFilters().add(filter);
                File file = fileChooser.showOpenDialog(null);
                filePath = file.toURI().toString();

                if(filePath != null) {
                    Media media = new Media(filePath);
                    mediaPlayer = new MediaPlayer(media);
                    mediaView.setMediaPlayer(mediaPlayer);

                    labelNameVideo.setText(file.toString());

                    DoubleProperty width = mediaView.fitWidthProperty();
                    DoubleProperty height = mediaView.fitHeightProperty();

                    width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
                    height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

                    mediaPlayer.play();
                    }
            }
        });


        // Close windows on click
        buttonClose.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            public void handle(Event event) {
                buttonClose.getScene().getWindow().hide();
            }
        });

        // on PLAY and on PAUSE (change image)
        buttonPlayPause.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            ImageView image1 = new ImageView(new Image("/images/play.png",70,70,false,true));
            ImageView image2 = new ImageView(new Image("/images/pause.png",70,70,false,true));

            @Override
            public void handle(MouseEvent event) {
                if (buttonTrue) {
                    System.out.println("OM");
                    buttonPlayPause.setImage(image1.getImage());
                    buttonTrue = false;
                } else {
                    buttonTrue = true;
                    buttonPlayPause.setImage(image2.getImage());
                }
                event.consume();
            }
        });
    }
}
