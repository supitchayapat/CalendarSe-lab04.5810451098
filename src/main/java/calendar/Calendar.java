package calendar;

public class Calendar extends Dbshow {

    private String date;
    private String topic;
    private String main;
    private int id;

    public Calendar(String date, String topic, String main, int id){
        this.date = date;
        this.topic = topic;
        this.main = main;
        this.id = id;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String getMain() {
        return main;
    }

    @Override
    public void setMain(String main) {
        this.main = main;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
