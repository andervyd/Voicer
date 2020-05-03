package by.andervyd;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


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

    @FXML
    void initialize() {

        buttonClose.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<Event>() {
            public void handle(Event event) {
                buttonClose.getScene().getWindow().hide();
            }
        });

    }
}
