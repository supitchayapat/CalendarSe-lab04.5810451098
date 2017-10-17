import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Tableshow {

    private    SimpleStringProperty rWord;
    private   SimpleStringProperty rPartOfSpeech;
    private   SimpleStringProperty rMeaning;
    private   SimpleStringProperty rExample;




    public Tableshow(String rWord, String rPartOfSpeech, String rMeaning, String rExample) {
        this.rWord = new SimpleStringProperty(rWord);
        this.rPartOfSpeech = new SimpleStringProperty(rPartOfSpeech);
        this.rMeaning = new SimpleStringProperty(rMeaning);
        this.rExample = new SimpleStringProperty(rExample);
    }

    public Tableshow() {
    }


    public String getRWord() {
        return rWord.get();
    }



    public String getRPartOfSpeech() {
        return rPartOfSpeech.get();
    }



    public String getRMeaning() {
        return rMeaning.get();
    }



    public String getRExample() {
        return rExample.get();
    }




    public  void setRWord(String v){

        this.rWord = new SimpleStringProperty(v);
    }
    public void setRPartOfSpeech(String v) {

        this.rPartOfSpeech = new SimpleStringProperty(v);
    }

    public void setRMeaning(String v) {

        this.rMeaning = new SimpleStringProperty(v);
    }

    public void setRExample(String v) {

        this.rExample = new SimpleStringProperty(v);
    }
}
