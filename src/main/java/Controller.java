import com.sun.org.omg.CORBA.Initializer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Controller implements Initializable {
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
    }

    @FXML
    public void handleClearbuttnClear(ActionEvent e) {
        textone.setText( new String( "" ) );
    }

    @FXML
    public void handleClearbuttntwoClear(ActionEvent event) {
        texttwo.setText( new String("") );

    }
    @FXML
    private Label datelabel;
    @FXML
    private Label labelmain;
    @FXML
    private Label labelsub;
    @FXML

    public void handAddEvent(ActionEvent event) {
        String onetext = new String(textone.getText());
        String twotext = new String(texttwo.getText());
        String datevalu = new String( String.valueOf( datePicker.getValue() ) );
        datelabel.setText( new String(datevalu) );
        labelmain.setText(new String(twotext));
        labelsub.setText(new String(onetext));
        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
        int id = insert.getCreateID();
        insert.saveDB(onetext, twotext, datevalu, id);

    }

    @FXML
    private Button viewDB;
    @FXML
    public void handviewdb(ActionEvent event){
        javafx.scene.control.Button b = (javafx.scene.control.Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DBSHOW.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 601, 450));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }



}
