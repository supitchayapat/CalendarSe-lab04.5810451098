import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Search {
    public void btnCreat(ActionEvent event) {
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

    public void btnBack(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource( "Mainn.fxml" ));
        try {
            stage.setScene(new Scene(loader.load(), 1090, 700));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    @FXML
    private TextField searchTextField;
    static ObservableList eventSearch = FXCollections.observableArrayList();
//    public void handleSearchEvent(ActionEvent event) throws IOException {
//        eventSearch = HomePageController.loads.searchEvent(searchTextField.getText());
//        this.handleGotoSearchEvent(event);

    public void btnSearch(ActionEvent event) throws IOException {
        eventSearch = MainContro.loads.searchEvent(searchTextField.getText());
        System.out.println(eventSearch);
        this.windowSearch(event);
    }

    public void windowSearch(ActionEvent event) throws IOException{
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader( getClass().getResource( "showSearch.fxml" ) );
        stage.setScene( new Scene( loader.load(), 1090, 700 ) );
        stage.show();
    }
}