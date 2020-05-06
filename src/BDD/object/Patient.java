package BDD.object;

import java.sql.Date;

public class Patient {
    private String nom;
    private String prenom;
    private Date naissance;
    private String sexe;
    private String tel;
    private String adresse;
    private String numSecu;
    private String valide;
    private String profession;
    private int numPatient;

    public Patient(String nom, String prenom, Date naissance, String sexe, String tel, String adresse, String numSecu, String valide, String profession) {
        this.numPatient = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.sexe = sexe;
        this.tel = tel;
        this.adresse = adresse;
        this.numSecu = numSecu;
        this.valide = valide;
        this.profession = profession;
    }

    public Patient(String nom, String prenom, Date naissance, String sexe, String tel, String adresse, String numSecu, String valide, String profession, int numPatient) {
        this.numPatient = numPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = naissance;
        this.sexe = sexe;
        this.tel = tel;
        this.adresse = adresse;
        this.numSecu = numSecu;
        this.valide = valide;
        this.profession = profession;
    }

    public Patient(String nom, String prenom, int numPatient) {
        this.numPatient = numPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.naissance = null;
        this.sexe = null;
        this.tel = null;
        this.adresse = null;
        this.numSecu = null;
        this.valide = null;
        this.profession = null;
    }

    public String getNom() {
        return nom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getNaissance() {
        return naissance;
    }

    public void setNaissance(Date naissance) {
        naissance = naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumSecu() {
        return numSecu;
    }

    public void setNumSecu(String numSecu) {
        this.numSecu = numSecu;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public int getNumPatient() {
        return numPatient;
    }

    public void setNumPatient(int numPatient) {
        this.numPatient = numPatient;
    }
}
