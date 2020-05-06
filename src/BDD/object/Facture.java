package BDD.object;

import java.sql.Date;

public class Facture {
    private String type;
    private String action;
    private double montant;
    private String detail;
    private  String justificatif;
    private Date date;

    public Facture(String t, String a, String d, double m, Date date, String p){
        this.type = t ;
        this.action = a;
        this.detail = d;
        this.montant = m;
        this.date = date;
        this.justificatif = p;
    }

    public Date getDate() {
        return date;
    }
    public double getMontant() {
        return montant;
    }
    public String getAction() {
        return action;
    }
    public String getDetail() {
        return detail;
    }
    public String getType() {
        return type;
    }
    public String getJustificatif() {
        return justificatif;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setJustificatif(String path) {
        this.justificatif = path;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
