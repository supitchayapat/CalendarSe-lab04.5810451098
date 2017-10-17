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


public class dbshowController implements Initializable {
    @FXML
    private TableView db ;
    JdbcSQLiteConnection dbconnect = new JdbcSQLiteConnection();
    ObservableList<Dbshow> listdb  = dbconnect.loadDB();
    private int one;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Dbshow> data = FXCollections.observableArrayList();
        data = listdb;
        db.setItems( data );
    }
    @FXML
    private Button Back;
    @FXML
    public void handback(ActionEvent event){
        javafx.scene.control.Button b = (javafx.scene.control.Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Mainn.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 830, 633));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    @FXML
    private Button delete;
    @FXML
    private TextField fiew;
    @FXML
    public void handdelete(ActionEvent event){
        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
        Integer one = new Integer(fiew.getText());
        insert.deleteDB( one );
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

}
