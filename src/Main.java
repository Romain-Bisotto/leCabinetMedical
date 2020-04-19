import BDD.ConnexionUnique;
import BDD.DAO.DAOPatient;
import BDD.object.Patient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui/fxml/sample.fxml"));
        //primaryStage.setTitle("");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        Patient p = new Patient("nom", "prenom", new Date(System.currentTimeMillis()), "M", "00251525", "3285 che", "85851485", "cest_quoi", "faignant");
        DAOPatient daoPatient = new DAOPatient();
        daoPatient.insertPatient(p);
    }
}
