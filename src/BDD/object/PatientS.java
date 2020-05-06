package BDD.object;

public class PatientS {
    private String nom;
    private String prenom;
    private int numPatient;


    public PatientS(String nom, String prenom, int numPatient) {
        this.numPatient = numPatient;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
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

    public void setNumPatient(int numPatient) {
        this.numPatient = numPatient;
    }

    public int getNumPatient() {
        return numPatient;
    }
}
