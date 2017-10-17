package calendar;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Dbshow {
    private final SimpleStringProperty Date = new SimpleStringProperty( "" );
    private final SimpleStringProperty Topic = new SimpleStringProperty( "" );
    private final SimpleStringProperty main = new SimpleStringProperty( "" );
    private final SimpleIntegerProperty ID = new SimpleIntegerProperty( 0 );
    public Dbshow(){
        this("" ,"","",0);
    }

    public String getDate() {
        return Date.get();
    }



    public void setDate(String date) {
        this.Date.set( date );
    }

    public String getTopic() {
        return Topic.get();
    }



    public void setTopic(String topic) {
        this.Topic.set( topic );
    }

    public String getMain() {
        return main.get();
    }



    public void setMain(String main) {
        this.main.set( main );
    }

    public int getID() {
        return ID.get();
    }


    public void setID(int ID) {
        this.ID.set( ID );
    }

    public Dbshow(String one, String two, String three, int four){
        setDate( one );
        setID( four );
        setTopic( two );
        setMain( three );

    }



}
