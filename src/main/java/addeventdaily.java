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

    private String one = "";
    private String two = "";

    public void typeevent(String boox, String onetext, String twotext) {
        one = onetext;
        two = twotext;
        if (boox.equals( "Every Month" )) {
            eventmonth();
        } else if (boox.equals( "Every Week" )) {
            eventdays();
        } else if (boox.equals( "Every Year" )) {
            eventyears();
        } else if (boox.equals( "Noting" )) {
            returndate( yearss, months, dates );
            dbadd( one, two );
        }

    }

    public boolean checkmonth(int monthss) {
        return ((monthss == 1) || (monthss == 3) || (monthss == 5) || (monthss == 7) || (monthss == 8) || (monthss == 10) || (monthss == 12));

    }


    public void eventyears() {
        getDates();
        getMonths();
        getYearss();
        for (int k = 1; k <= 10; k++) {
            textcalendar.datevalu = yearss + "-" + months + "-" + dates;
            dbadd( one, two);
;
            yearss = yearss + 1;
        }

    }

    public void returndate(Integer yearsss, Integer monthss, Integer datess) {
        textcalendar.datevalu = yearsss + "-" + monthss + "-" + datess;
    }

    public void dbadd(String one, String two) {
        JdbcSQLiteConnection insert = new JdbcSQLiteConnection();
        int id = insert.getCreateID();
        insert.saveDB( textcalendar.datevalu, one, two, id );
    }

    public void eventdays() {
        for (int k = 1; k <= 2; k++) {
            for (int i = months; months <= 12; ) {
                if (dates == 31) {
                    if (checkmonth( months )) {
                        returndate( yearss, months, dates );
                        dbadd( one, two);
;
                        dates = 7;
                        months = months + 1;
                    } else if (!(checkmonth( months ))) {
                        if ((months == 2)) {
                            dates = 3;
                            returndate( yearss, months, dates );
                            dbadd( one, two);
;
                            dates = dates + 7;
                            months = months + 1;
                        } else {
                            dates = 1;
                            returndate( yearss, months, dates );
                            dbadd( one, two );
                            dates = 6;
                            months = months + 1;
                        }
                    }

                } else if (dates == 30) {
                    if ((checkmonth( months ))) {
                        returndate( yearss, months, dates );
                        dbadd( one, two );
                        dates = 6;
                        months = months + 1;
                    } else if (!(checkmonth( months ))) {
                        if ((months == 2)) {
                            dates = 2;
                            returndate( yearss, months, dates );
                            dbadd( one, two );
                            dates = dates + 7;
                            months = months + 1;
                        } else {
                            returndate( yearss, months, dates );
                            dbadd( one, two );

                            dates = 7;
                            months = months + 1;

                        }
                    }
                } else if (dates == 29) {
                    if ((checkmonth( months ))) {
                        returndate( yearss, months, dates );
                        dbadd( one, two );

                        dates = 5;
                        months = months + 1;
                    } else if (!(checkmonth( months ))) {
                        if ((months == 2)) {
                            dates = 1;
                            returndate( yearss, months, dates );
                            dbadd( one, two);
;
                            dates = dates + 7;
                            months = months + 1;
                        } else {
                            returndate( yearss, months, dates );
                            dbadd( one, two);
;
                            dates = 6;
                            months = months + 1;
                        }
                    }
                } else {
                    if ((checkmonth( months ))) {
                        returndate( yearss, months, dates );
                        dbadd( one, two);
;
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
                    } else if (!(checkmonth( months ))) {
                        if ((months == 2)) {
                            returndate( yearss, months, dates );
                            dbadd( one, two);
;
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
                            returndate( yearss, months, dates );
                            dbadd( one, two);
;
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
            for (int i = months; i <= 12; i++) {
                if (dates == 31) {
                    if ((checkmonth( months ))) {
                        returndate( yearss, months, dates );
                        dbadd( one, two);
;
                        months = months + 1;
                    } else {
                        months = months + 1;
                    }
                } else if ((dates == 29) || (dates == 30)) {
                    if (months == 2) {
                        months = months + 1;

                    } else {
                        returndate( yearss, months, dates );
                        dbadd( one, two);
;
                        months = months + 1;
                    }
                } else {
                    returndate( yearss, months, dates );
                    dbadd( one, two );
                    months = months + 1;
                }
            }
            months = 1;
            yearss = yearss + 1;
        }

    }

}



