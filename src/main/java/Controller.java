import com.sun.org.omg.CORBA.Initializer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    }

    @FXML
    public void handleClearbuttnClear(ActionEvent e) {
        textone.setText( new String( "" ) );
        texttwo.setText( new String( "" ) );

    }

    @FXML
    public void handleClearbuttntwoClear(ActionEvent event) {
        textone.setText( new String( "" ) );

        texttwo.setText( new String( "" ) );

    }

    @FXML
    private Label datelabel;
    @FXML
    private Label labelmain;
    @FXML
    private Label labelsub;
//    addeventdaily eventspeacial = new addeventdaily();

    @FXML

    public void handAddEvent(ActionEvent event) {
        System.out.println();

        String onetext = new String( textone.getText() );
        String twotext = new String( texttwo.getText() );
        String datevalu = new String( String.valueOf( datePicker.getValue() ) );
        datelabel.setText( new String( datevalu ) );
        labelmain.setText( new String( twotext ) );
        labelsub.setText( new String( onetext ) );
//        eventspeacial.datepickevent();
//        eventspeacial.typeevent();


        String getvaluess = String.format( datevalu );
        String ds = String.valueOf( getvaluess );
        String[] getvalue = ds.split( "-" );
        int dates;
        int yearss;
        int months;
        dates = Integer.parseInt( getvalue[2] );
        yearss = Integer.parseInt( getvalue[0] );
        months = Integer.parseInt( getvalue[1] );
        int year = yearss;
        if (choosebox.getValue().equals( "Every Month" )) {
            for (int k = 1; k <=  2; k++) {
                for (int i = months - 1; i <= 11; i++) {
                    if (dates == 31) {
                        if ((months == 1) || (months == 2) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                            datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( onetext, twotext, datevalu, id );
                            months = months + 1;
                        } else {
                            months = months + 1;
                        }
                    } else if ((dates == 29) || (dates == 30)) {
                        if (months == 2) {
                            months = months + 1;

                        } else {
                            datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( onetext, twotext, datevalu, id );
                            months = months + 1;
                        }
                    } else {
                        datevalu = yearss + "-" + months + "-" + dates;
                        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                        int id = insert.getCreateID();
                        insert.saveDB( onetext, twotext, datevalu, id );
                        months = months + 1;
                    }
                }
                months = 2;
                yearss = yearss + 1;
            }
        } else if (choosebox.getValue().equals( "Every Day" )) {
            for (int k = 1; k <= 2; k++) {
                for (int i = months; months <= 12; ) {
                    if (dates == 31) {
                        if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                            datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( onetext, twotext, datevalu, id );
                            dates = 7;
                            months = months + 1;
                        } else if ((!(months == 1) && !(months == 3) && !(months == 5) && !(months == 7) && !(months == 8) && !(months == 10) && !(months == 12))) {
                            if (!(months == 2)) {
                                dates = 3;
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = dates + 7;
                                months = months + 1;
                            } else {
                                dates = 1;
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = 6;
                                months = months + 1;
                            }
                        }

                    } else if (dates == 30) {
                        if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                            datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( onetext, twotext, datevalu, id );
                            dates = 6;
                            months = months + 1;
                        } else if ((!(months == 1) && !(months == 3)) && !(months == 5) && !(months == 7) && !(months == 8) && !(months == 10) && !(months == 12)) {
                            if (!(months == 2)) {
                                dates = 2;
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = dates + 7;
                                months = months + 1;
                            } else {
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = 7;
                                months = months + 1;

                            }

                        }
                    } else if (dates == 29) {
                        if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                            datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( onetext, twotext, datevalu, id );
                            dates = 5;
                            months = months + 1;
                        } else if ((!(months == 1) && !(months == 3) && !(months == 5) && !(months == 7) && !(months == 8) && !(months == 10) && !(months == 12))) {
                            if (!(months == 2)) {
                                dates = 1;
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = dates + 7;
                                months = months + 1;
                            } else {
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = 6;
                                months = months + 1;

                            }
                        }
                    } else {
                        if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                            datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( onetext, twotext, datevalu, id );
                            dates = dates + 7;
                            if (dates > 31) {
                                dates = dates - 7;
                                int delete = 31 - dates;
                                delete = 7 - delete;
                                dates = delete;
                                months = months + 1;
                            } else if (dates < 31) {
                                System.out.println( dates );
                            }
                        } else if ((!(months == 1) && !(months == 3) && !(months == 5) && !(months == 7) && !(months == 8) && !(months == 10) && !(months == 12))) {
                            if (!(months == 2)) {
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = dates + 7;
                                if (dates > 28) {
                                    dates = dates - 7;
                                    int delete = 28 - dates;
                                    delete = 7 - delete;
                                    dates = delete;
                                    months = months + 1;
                                } else if (dates < 28) {
                                }
                            } else {
                                datevalu = yearss + "-" + months + "-" + dates;
                                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                                int id = insert.getCreateID();
                                insert.saveDB( onetext, twotext, datevalu, id );
                                dates = dates + 7;
                                if (dates > 30) {
                                    dates = dates - 7;
                                    int delete = 30 - dates;
                                    delete = 7 - delete;
                                    dates = delete;
                                    months = months + 1;
                                } else if (dates < 30) {
                                }

                            }
                        }
                    }

                }
                yearss = yearss + 1;
                months = 1;


            }
        } else if (choosebox.getValue().equals( "Every Year" )) {
            for (int k = year; k <= year + 5; k++) {
                datevalu = yearss + "-" + months + "-" + dates;
                JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                int id = insert.getCreateID();
                insert.saveDB( onetext, twotext, datevalu, id );
                yearss = yearss + 1;
            }

        }
    }


    @FXML
    private Button clear;

    @FXML
    public void handclear(ActionEvent event) {
        datelabel.setText( "  " );
        labelmain.setText( "  " );
        labelsub.setText( "  " );
        labelmain.getText();
        labelsub.getText();
        labelsub.getText();
        datelabel.setText( "  " );
        labelmain.setText( "  " );
        labelsub.setText( "  " );
        datelabel.setText( "  " );
        labelmain.setText( "  " );
        labelsub.setText( "  " );
        datelabel.setText( "  " );
        labelmain.setText( "  " );
        labelsub.setText( "  " );

    }


    @FXML
    private Button viewDB;

    @FXML
    public void handviewdb(ActionEvent event) {
        javafx.scene.control.Button b = (javafx.scene.control.Button) event.getSource();
        Stage stage = (Stage) b.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader( getClass().getResource( "DBSHOW.fxml" ) );
        try {
            stage.setScene( new Scene( loader.load(), 601, 450 ) );
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    String getvalue;

    @FXML
    public ChoiceBox<String> choosebox;

    @FXML
    public void handaddweek(ActionEvent event) {
        getvalue = choosebox.getValue();
        System.out.println( choosebox.getValue() );

    }


}
