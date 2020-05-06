package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionUnique
{
    // Chaine de connexion     jdbc:sqlite:./BDD/biblio.db     "jdbc:sqlite:C:\\Users\\Romain\\Desktop\\leCabinetMedical\\baseDeDonne.db";
    private static final String CONNECT_URL = "jdbc:sqlite:./baseDeDonne.db";
    private static ConnexionUnique instance = null;
    private Connection connection;

    private ConnexionUnique()
    {
        try {
            connection = DriverManager.getConnection(CONNECT_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnexionUnique getInstance() {
        if (instance == null)
            instance = new ConnexionUnique();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
