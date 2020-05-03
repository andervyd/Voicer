package by.andervyd;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ImageView buttonClose;
    @FXML
    private ImageView buttonExpand;
    @FXML
    private ImageView buttonCollapse;
    @FXML
    private Label labelNameVideo;
    @FXML
    private ImageView buttonPlayPause;
    @FXML
    private Button closeTest;


    public static boolean buttonTrue;

    @FXML
    void initialize() {

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
