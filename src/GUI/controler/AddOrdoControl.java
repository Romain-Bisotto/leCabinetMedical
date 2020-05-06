package GUI.controler;

import BDD.DAO.DAOObservation;
import BDD.DAO.DAOPatient;
import BDD.object.Observation;
import BDD.object.Patient;
import GUI.Tools;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Date;

public class AddOrdoControl {
    @FXML
    private Button buttonValide;

    @FXML
    private Button buttonRetour;

    @FXML
    private TextField fieldOrdo;

    @FXML
    private void initialize() {

        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("DossierMedical", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonValide.setOnAction((event) -> {
            if(!fieldOrdo.getText().equals("")) {
                java.util.Date dateN = new java.util.Date();
                Date date = new Date(dateN.getTime());
                Observation o = new Observation(date, "Ordonnance", fieldOrdo.getText(), DossierMedicalControl.numPatient);
                DAOObservation daoObservation = new DAOObservation();
                daoObservation.insertObservation(o);
                fieldOrdo.setText("");
            }
        });
    }
}
