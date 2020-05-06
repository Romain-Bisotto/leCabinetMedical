package GUI.controler;

import BDD.DAO.DAOObservation;
import BDD.DAO.DAOPatient;
import BDD.object.ObservationS;
import BDD.object.PatientS;
import GUI.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class DossierMedicalControl {
    public static int numPatient;

    private ObservableList<PatientS> patientSData = FXCollections.observableArrayList();

    private ObservableList<ObservationS> observationSData = FXCollections.observableArrayList();

    @FXML
    private TableView<PatientS> patientListView;

    @FXML
    private TableView<ObservationS> observationListView;

    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonAddCerti;

    @FXML
    private Button buttonAddOrdo;

    @FXML
    private Button buttonAddComm;

    @FXML
    private void initialize() {
        observationListView.setVisible(false);
        buttonAddOrdo.setVisible(false);
        buttonAddComm.setVisible(false);
        buttonAddCerti.setVisible(false);
        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("sample", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonAddCerti.setOnAction((event) -> {
            Tools.loadWindow("AjouterCerti", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonAddOrdo.setOnAction((event) -> {
            Tools.loadWindow("AjouterOrdo", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonAddComm.setOnAction((event) -> {
            Tools.loadWindow("AjouterComm", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        patientListView.setOnMouseClicked((event) -> {
            observationListView.setVisible(true);
            buttonAddOrdo.setVisible(true);
            buttonAddComm.setVisible(true);
            buttonAddCerti.setVisible(true);
            numPatient = patientListView.getSelectionModel().getSelectedItem().getNumPatient();

            observationListView.getItems().clear();
            observationSData.clear();
            DAOObservation daoObservation = new DAOObservation();
            List<ObservationS> listeObservationS = daoObservation.returnObsS("SELECT Date, Type, Remarque " +
                    "FROM Observation WHERE NumPatient = " + numPatient + ";");
            for (ObservationS observationS : listeObservationS)
            {
                observationSData.add(observationS);
            }

            observationListView.getItems().addAll(observationSData);
        });

        DAOPatient daoPatient = new DAOPatient();
        List<PatientS> listePatientS = daoPatient.returnPatientS("SELECT Nom, Prenom, NumPatient " +
                "FROM Patient;");
        for (PatientS patientS : listePatientS)
        {
            patientSData.add(patientS);
        }

        patientListView.getItems().addAll(patientSData);
    }
}
