package GUI.controler;

import BDD.DAO.DAOComptabilite;
import BDD.DAO.DAOPatient;
import BDD.object.Facture;
import BDD.object.Patient;
import GUI.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class PatientControl {

    private ObservableList<Patient> PatientData = FXCollections.observableArrayList();

    @FXML
    private TableView<Patient> patientListView;

    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonAddPatient;

    @FXML
    private void initialize() {
        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("sample", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonAddPatient.setOnAction((event) -> {
            Tools.loadWindow("AjouterPatient", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });

        // permet de "lier" les données au tableau

        // rempli l'observableList de données
        DAOPatient daoPatient = new DAOPatient();
        List<Patient> listePatient = daoPatient.findAll();
        for (Patient patient : listePatient)
        {
            PatientData.add(patient);
        }

        // seule fonction utile pour remplir le tableau graphique
        patientListView.getItems().addAll(PatientData);
    }
}
