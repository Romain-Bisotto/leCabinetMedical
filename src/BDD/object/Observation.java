package BDD.object;

import java.sql.Date;

public class Observation {
    private int numPatient;
    private Date date;
    private String remarque;

    public Observation(Date date, String remarque) {
        this.numPatient = 0;
        this.date = date;
        this.remarque = remarque;
    }
}
