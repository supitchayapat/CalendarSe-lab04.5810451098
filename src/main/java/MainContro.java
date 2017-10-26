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
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "DBSHOW.fxml" ));
        try {
            stage.setScene(new Scene(loader.load(), 1090, 700));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private Button creat;
    @FXML
    public void hancreatapp(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "sample.fxml" ));
        try {
            stage.setScene(new Scene(loader.load(), 1090, 700));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


    public void onActionButtonTwo(ActionEvent event) {
    }

    public void onActionButtonFive(ActionEvent event) {
    }

    public void onActionButtonThree(ActionEvent event) {
    }

    public void onActionButtonSix(ActionEvent event) {
    }

    public void onActionButtonOne(ActionEvent event) {
    }

    public void onActionButtonFour(ActionEvent event) {
    }
}
