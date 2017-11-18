import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class dbshowController {
    @FXML private TableView db;

    ObservableList<Dbshow> listdb = MainContro.loads.loadDB();

    ObservableList<Dbshow> data = FXCollections.observableArrayList();

    public void initialize() {
        data = listdb;
        db.setItems( data );
    }

    @FXML
    private Button Back;

    @FXML
    public void handback(ActionEvent event) {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader( getClass().getResource( "Mainn.fxml" ) );
        try {
            stage.setScene( new Scene( loader.load(), 1090, 700 ) );
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }



//        Button b = (Button) event.getSource();
//        Stage stage = (Stage) b.getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader( getClass().getResource( "Mainn.fxml" ) );
//        try {
//            stage.setScene( new Scene( loader.load(), 1090, 700 ) );
//            stage.show();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }

    }

    @FXML
    private Button delete;
    @FXML
    private TextField fiew;

    @FXML
    public void refreshPag(ActionEvent event) throws IOException {
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader( getClass().getResource( "DBSHOW.fxml" ) );
        stage.setScene( new Scene( loader.load(), 1090, 700 ) );
        stage.show();


//        Button b = (Button) event.getSource();
//        Stage stage = (Stage) b.getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader( getClass().getResource( "DBSHOW.fxml" ) );
//        stage.setScene( new Scene( loader.load(), 1090, 700 ) );
//        stage.show();
    }

    @FXML
    private TextField textSearch;

    public void handleSearchWord(ActionEvent event) throws IOException {
        data  = MainContro.loads.searchEvent( textSearch.getText() );
        System.out.println(data);
        db.setItems( data );

    }

}
