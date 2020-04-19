package BDD.DAO;

import BDD.ConnexionUnique;
import BDD.object.Facture;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOComptabilite {
    private Connection conn;
    private Statement stmt;

    public DAOComptabilite() {
        try {
            conn = ConnexionUnique.getInstance().getConnection();
            stmt = conn.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
        }
    }

    public List<Facture> findAll() {
        String req = "SELECT * " +
                "FROM ETUDIANT ";
        return returnCompta(req);
    }

    private List<Facture> returnCompta(String req) {
        try {
            ResultSet rset = stmt.executeQuery(req);
            ArrayList<Facture> TFac = new ArrayList<Facture>();
            while (rset.next()) {
                TFac.add( new Facture(rset.getString("TYPE"), rset.getString("ACTION"),
                        rset.getDouble("MONTANT"),rset.getString("DETAIL"),
                        rset.getString("PATH"), rset.getDate("DATE")));
            }

            return TFac;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "\n");
            return null;
        }
    }
}
