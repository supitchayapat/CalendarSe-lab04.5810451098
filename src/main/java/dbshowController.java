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
import java.util.ArrayList;
import java.util.List;
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
        Button b = (Button) event.getSource();
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
        Button b = (Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DBSHOW.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 1090, 800));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
//    @FXML private  TextField textSearch;
//    public void handleSearchWord(){
//        List list2 = new ArrayList( );
//        String keySearch = textSearch.getText();
//        for (String key : listdb..keySet()){
//            if (key.equals( keySearch )){
//                list2.add( listdb.getDictionary2().get( key ) );
//            }
//        }
//        if (!list2.isEmpty()){
//            ObservableList data = FXCollections.observableArrayList( list2);
//            db.setItems( data );
//        }
//    }

}
