import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;


public class ShowSearch {
    @FXML
    private TableView tableView;

    public void initialize(){
        tableView.setItems( Search.eventSearch );
    }
    public void handback(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "Search.fxml" ));
        try {
            stage.setScene(new Scene(loader.load(), 1090, 700));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}
