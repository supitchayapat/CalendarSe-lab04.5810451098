import javafx.scene.control.ChoiceBox;

public class addeventdaily extends Controller {
    Controller textcalendar = new Controller();
    int dates;
    int yearss;
    int months;
    String check;

    public void datepickevent(String getvaluess) {
        String ds = String.valueOf( getvaluess );
        String[] getvalue = ds.split( "-" );

        dates = Integer.parseInt( getvalue[2] );
        yearss = Integer.parseInt( getvalue[0] );
        months = Integer.parseInt( getvalue[1] );
    }

    public int getDates() {
        return dates;
    }

    public int getYearss() {

        return yearss;
    }

    public int getMonths() {

        return months;
    }

    public void typeevent(ChoiceBox<String> boox) {
        if (boox.getValue().equals( "Every Month" )) {
            eventmonth();
        } else if (boox.getValue().equals( "Every Day" )) {
            eventdays();
        } else if (boox.getValue().equals( "Every Year" )) {
            eventyears();
        } else if(boox.getValue().equals( "Noting" )){
            getDates();
            getMonths();
            getYearss();
            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
            int id = insert.getCreateID();
            insert.saveDB( textcalendar.onetext, textcalendar.twotext, textcalendar.datevalu, id );
        }

    }


    public void eventyears() {
        getDates();
        getMonths();
        getYearss();
        for (int k = 1; k <= 10; k++) {
            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
            int id = insert.getCreateID();
            insert.saveDB( textcalendar.onetext, textcalendar.twotext, textcalendar.datevalu, id );
            yearss = yearss + 1;
        }

    }

    public void dbadd() {
        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
        int id = insert.getCreateID();
        insert.saveDB( textcalendar.onetext, textcalendar.twotext, textcalendar.datevalu, id );
    }

    public void eventdays() {
        for (int k = 1; k <= 2; k++) {
            for (int i = months; months <= 12; ) {
                if (dates == 31) {
                    if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                        textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                        dbadd();
                        dates = 7;
                        months = months + 1;
                    } else if (((months == 2) || (months == 4) || (months == 6) || (months == 9) || (months == 11) )) {
                        if ((months == 2)) {
                            dates = 3;
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            dbadd();
                            dates = dates + 7;
                            months = months + 1;
                        } else {
                            dates = 1;
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            dbadd();
                            dates = 6;
                            months = months + 1;
                        }
                    }

                } else if (dates == 30) {
                    if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                        textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                        dbadd();
                        dates = 6;
                        months = months + 1;
                    } else if (((months == 2) || (months == 4) || (months == 6) || (months == 9) || (months == 11) )) {
                        if ((months == 2)) {
                            dates = 2;
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            dbadd();
                            dates = dates + 7;
                            months = months + 1;
                        } else {
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            dbadd();
                            dates = 7;
                            months = months + 1;

                        }
                    }
                } else if (dates == 29) {
                    if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                        textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                        int id = insert.getCreateID();
                        insert.saveDB( textcalendar.onetext, textcalendar.twotext, textcalendar.datevalu, id );
                        dates = 5;
                        months = months + 1;
                    } else if (((months == 2) || (months == 4) || (months == 6) || (months == 9) || (months == 11) )) {
                        if ((months == 2)) {
                            dates = 1;
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( textcalendar.onetext, textcalendar.twotext, textcalendar.datevalu, id );
                            dates = dates + 7;
                            months = months + 1;
                        } else {
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
                            int id = insert.getCreateID();
                            insert.saveDB( textcalendar.onetext, textcalendar.twotext, textcalendar.datevalu, id );
                            dates = 6;
                            months = months + 1;
                        }
                    }
                } else {
                    if ((months == 1) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                        textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                        dbadd();
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
                    } else if (((months == 2) || (months == 4) || (months == 6) || (months == 9) || (months == 11) )) {
                        if ((months == 2)) {
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            dbadd();
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
                            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                            dbadd();
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
    }

    public void eventmonth() {
        for (int k = 1; k <= 2; k++) {
            for (int i = months ; i <= 12; i++) {
                if (dates == 31) {
                    if ((months == 1) || (months == 2) || (months == 3) || (months == 5) || (months == 7) || (months == 8) || (months == 10) || (months == 12)) {
                        textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                        dbadd();
                        months = months + 1;
                    } else {
                        months = months + 1;
                    }
                } else if ((dates == 29) || (dates == 30)) {
                    if (months == 2) {
                        months = months + 1;

                    } else {
                        textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                        dbadd();
                        months = months + 1;
                    }
                } else {
                    textcalendar.datevalu = yearss + "-" + months + "-" + dates;
                    dbadd();
                    months = months + 1;
                }
            }
            months = 1;
            yearss = yearss + 1;
        }

    }

}



