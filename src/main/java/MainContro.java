import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainContro {
    @FXML
    private Button addle;
    @FXML
    public void han(ActionEvent event) {
        javafx.scene.control.Button b = (javafx.scene.control.Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DBSHOW.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 800, 566));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private Button creat;
    @FXML
    public void hancreatapp(ActionEvent event) {
        javafx.scene.control.Button b = (javafx.scene.control.Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 800, 566));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }




}
