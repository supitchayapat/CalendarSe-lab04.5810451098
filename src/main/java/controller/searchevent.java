package controller;

import calendar.Dbshow;
import controller.JdbcSQLiteConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class searchevent implements Initializable{
    JdbcSQLiteConnection dbconnect = new JdbcSQLiteConnection();
    ObservableList<Dbshow> listdb  = dbconnect.loadDB();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Dbshow> data = FXCollections.observableArrayList();
        data = listdb;
    }
}
