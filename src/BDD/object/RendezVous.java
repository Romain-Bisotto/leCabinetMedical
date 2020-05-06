package BDD.object;

import java.sql.Date;

public class RendezVous {
    private Date date;
    private String heure;
    private int numPatient;
    private String motif;

    public RendezVous(Date date,String heure, int numPatient, String motif) {
        this.date = date;
        this.heure = heure;
        this.numPatient = numPatient;
        this.motif = motif;
    }

    public String getHeure() {
        return heure;
    }

    public Date getDate() {
        return date;
    }

    public int getNumPatient() {
        return numPatient;
    }

    public String getMotif() {
        return motif;
    }

}
