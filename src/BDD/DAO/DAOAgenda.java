package BDD.DAO;

import BDD.ConnexionUnique;
import BDD.object.RendezVous;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOAgenda {
    private Connection conn;
    private Statement stmt;

    public DAOAgenda() {
        try {
            conn = ConnexionUnique.getInstance().getConnection();
            stmt = conn.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        }
    }

    public List<RendezVous> findAll() {
        String req = "SELECT DateRdv, Heure, NumPatient, Motif " +
                "FROM Agenda;";
        return returnRdv(req);
    }

    public void insertRendezVous (RendezVous rendezVous){
        try {
            String req = "INSERT INTO Agenda (DateRdv, Heure, NumPatient, Motif) " +
                    "VALUES ('" + rendezVous.getDate() + "', '" + rendezVous.getHeure() + "', '" + rendezVous.getNumPatient() + "', '" + rendezVous.getMotif() + "')";
            stmt.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<RendezVous> returnRdv(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<RendezVous> TRdv = new ArrayList<>();
            java.util.Date date;
            while (rset.next()) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(rset.getString("DateRdv"));
                TRdv.add(new RendezVous(new Date(date.getTime()),rset.getString("Heure"), rset.getInt("NumPatient"),
                        rset.getString("Motif")));
            }
                return TRdv;
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
                System.out.println(e.getMessage() + "\n");
                return null;
        }
    }
}
