package BDD.DAO;

import BDD.ConnexionUnique;
import BDD.object.Observation;
import BDD.object.ObservationS;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DAOObservation {
    private Connection conn;
    private Statement stmt;

    public DAOObservation() {
        try {
            conn = ConnexionUnique.getInstance().getConnection();
            stmt = conn.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        }
    }

    public List<ObservationS> findAll() {
        String req = "SELECT Date, Type, Remarque" +
                "FROM Observation;";
        return returnObsS(req);
    }

    public void insertObservation (Observation observation){
        try {
            String req = "INSERT INTO Observation (Date, Type, Remarque, NumPatient) " +
                    "VALUES ('" + observation.getDate() + "', '" + observation.getType() + "', '" + observation.getRemarque() + "', '" + observation.getNumPatient() + "')";
            stmt.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ObservationS> returnObsS(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<ObservationS> TObs = new ArrayList<>();
            java.util.Date date;
            while (rset.next()) {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(rset.getString("Date"));
                TObs.add(new ObservationS(new Date(date.getTime()),rset.getString("Type"), rset.getString("Remarque")));
            }
            return TObs;
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
}