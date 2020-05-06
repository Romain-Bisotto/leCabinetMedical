package BDD.DAO;

import BDD.ConnexionUnique;
import BDD.object.Facture;
import BDD.object.Patient;
import BDD.object.PatientS;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

    public List<Patient> findAll() {
        String req = "SELECT Nom, Prenom, Naissance, Sexe, Tel, Adresse, NumSecu, valide, Profession, NumPatient " +
                "FROM Patient;";
        return returnPatient(req);
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

    public List<Patient> returnPatient(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<Patient> TPat = new ArrayList<>();
            java.util.Date naissance;
            while (rset.next()) {
                naissance = new SimpleDateFormat("yyyy-MM-dd").parse(rset.getString("Naissance"));
                TPat.add( new Patient(rset.getString("Nom"), rset.getString("Prenom"),new Date(naissance.getTime()),
                        rset.getString("Sexe"), rset.getString("Tel"),
                         rset.getString("Adresse"), rset.getString("NumSecu"), rset.getString("Valide"), rset.getString("Profession"), rset.getInt("NumPatient")));
            }
            return TPat;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
    public List<PatientS> returnPatientS(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<PatientS> TPatS = new ArrayList<>();
            while (rset.next()) {
                TPatS.add( new PatientS(rset.getString("Nom"), rset.getString("Prenom"),rset.getInt("NumPatient")));
            }
            return TPatS;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
    public List<String> returnInfoPatient(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<String> TPat = new ArrayList<>();
            TPat.add(rset.getString("Nom"));
            TPat.add(rset.getString("Prenom"));
            TPat.add(rset.getString("Naissance"));
            TPat.add(rset.getString("NumSecu"));
            return TPat;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
}
