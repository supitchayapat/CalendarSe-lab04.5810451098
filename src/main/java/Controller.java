import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {
//    @FXML
//    private TableView db ;
//    controller.JdbcSQLiteConnection dbconnect = new controller.JdbcSQLiteConnection();
//    ObservableList<controller.Dbshow> listdb  = dbconnect.loadDB();
//    private int one;

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField textone;
    @FXML
    private Button Clicktextone;
    @FXML
    private Button Clicktexttwo;
    @FXML
    private TextField texttwo;
    @FXML
    private Button addevent;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    public String datevalu;
    public String onetext;
    public String twotext;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        datePicker.setConverter( new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate t) {
                if (t != null) {
                    return formatter.format( t );
                }
                return null;
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.trim().isEmpty()) {
                    return LocalDate.parse( string, formatter );
                }
                return null;
            }
        } );

        datePicker.setOnAction( (ActionEvent event) -> {
            System.out.println( formatter.format( datePicker.getValue() ) );
        } );
        ObservableList<Dbshow> data = FXCollections.observableArrayList();
        data = listdb;
        db.setItems( data );
    }




    @FXML
    private Label datelabel;
    @FXML
    private Label labelmain;
    @FXML
    private Label labelsub;
    //    controller.addeventdaily eventspeacial = new controller.addeventdaily();
//    @FXML
//    private TableView db;
//    controller.JdbcSQLiteConnection dbconnect = new controller.JdbcSQLiteConnection();
//    ObservableList<controller.Dbshow> listdb = dbconnect.loadDB();
//    private int one;
    @FXML
    private TableView db ;
    JdbcSQLiteConnection dbconnect = new JdbcSQLiteConnection();
    ObservableList<Dbshow> listdb  = dbconnect.loadDB();
    private int one;

    @FXML

    public void handAddEvent(ActionEvent event) {
        addeventdaily eventspeacial = new addeventdaily();
        onetext = textone.getText();
        twotext = texttwo.getText();
        String datevalu = String.valueOf(datePicker.getValue());

        eventspeacial.datepickevent( datevalu );
        eventspeacial.typeevent(valuemenu, onetext, twotext);
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
    public void handClearTable(ActionEvent event){
        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
        insert.cleartableDB();
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

//    @FXML
//    private Button viewDB;
//
//    @FXML
//    public void handviewdb(ActionEvent event) {
//        javafx.scene.control.Button b = (javafx.scene.control.Button) event.getSource();
//        Stage stage = (Stage) b.getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader( getClass().getResource( "DBSHOW.fxml" ) );
//        try {
//            stage.setScene( new Scene( loader.load(), 800, 566 ) );
//            stage.show();
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//
//    }

    String getvalue;

    @FXML
    public ChoiceBox<String> choosebox;

    @FXML
    public void handaddweek(ActionEvent event) {
        getvalue = choosebox.getValue();
        System.out.println( choosebox.getValue() );

    }
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem item1;
    @FXML
    private MenuItem item2;
    @FXML
    private MenuItem item3;
    @FXML
    private MenuItem item4;
    @FXML
    private String valuemenu = "";

    public void menuList(ActionEvent event) {
        if (event.getTarget().equals(item1)) {
            valuemenu = item1.getText();
            menuButton.setText(valuemenu);
        } else if (event.getTarget().equals(item2)) {
            valuemenu = item2.getText();
            menuButton.setText(valuemenu);
        } else if (event.getTarget().equals(item3)){
            valuemenu = item3.getText();
            menuButton.setText(valuemenu);
        }
        else {
            valuemenu = item4.getText();
            menuButton.setText(valuemenu);
        }
    }
    //SearcjhEven
    @FXML
    public void btnSearch(ActionEvent event) {
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
@FXML
    public void btnshowevent(ActionEvent event) {
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

    public void btnAddEvent(ActionEvent event) {
        addeventdaily eventspeacial = new addeventdaily();
        onetext = textone.getText();
        twotext = texttwo.getText();
        String datevalu = String.valueOf(datePicker.getValue());

        eventspeacial.datepickevent( datevalu );
        eventspeacial.typeevent(valuemenu, onetext, twotext);
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
}


