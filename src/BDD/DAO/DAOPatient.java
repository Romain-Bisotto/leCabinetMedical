package BDD.DAO;

import BDD.ConnexionUnique;
import BDD.object.Patient;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPatient {
    private Connection conn;
    private Statement stmt;

    public DAOPatient() {
        try {
            conn = ConnexionUnique.getInstance().getConnection();
            stmt = conn.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        }
    }

    public void insertPatient(Patient patient) {
        try {
            String req = "INSERT INTO Patient (Nom, Prenom, Naissance, Sexe, Tel, Adresse, NumSecu, Valide, Profession) " +
                    "VALUES ('" + patient.getNom() + "', '" + patient.getPrenom() + "', '" + patient.getNaissance() + "', '" + patient.getSexe() + "', '" + patient.getTel() + "', '" + patient.getAdresse() + "', '" + patient.getNumSecu() + "', '" + patient.getValide() + "', '" + patient.getProfession() + "')";
            stmt.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
