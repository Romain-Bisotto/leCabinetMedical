package BDD.object;

import java.sql.Date;

public class RendezVous {
    private Date date;
    private int numPatient;
    private String motif;

    public RendezVous(Date date, int numPatient, String motif) {
        this.date = date;
        this.numPatient = numPatient;
        this.motif = motif;
    }

    public Date getDate() {
        return date;
    }

    public int getPatient() {
        return numPatient;
    }

    public String getMotif() {
        return motif;
    }

}
