package GUI.controler;

import BDD.DAO.DAOObservation;
import BDD.DAO.DAOPatient;
import BDD.object.Observation;
import BDD.object.PatientS;
import GUI.Tools;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.List;

public class AddCertiControl {

    @FXML
    private Button buttonValide;

    @FXML
    private Button buttonRetour;

    @FXML
    private ComboBox comboCerti;

    @FXML
    private TextField fieldApte;

    @FXML
    private ComboBox comboApte;

    @FXML
    private TextField fieldRepos;

    @FXML
    private DatePicker dateDisD;

    @FXML
    private DatePicker dateDisF;

    @FXML
    private Pane paneCerti;

    @FXML
    private Label nomCerti;

    @FXML
    private Label naissanceCerti;

    @FXML
    private Label CINCerti;

    @FXML
    private Label textCerti;


    @FXML
    private void initialize() {
        comboCerti.getItems().addAll(
                "Rien",
                "Aptitude",
                "Repos",
                "Dispense"
        );
        comboCerti.getSelectionModel().selectFirst();
        comboApte.getItems().addAll(
                "Apte",
                "Pas apte"
        );
        comboApte.getSelectionModel().selectFirst();

        dateDisD.setPromptText("Date de début");
        dateDisF.setPromptText("Date de fin");

        DAOPatient daoPatient = new DAOPatient();
        List<String> info = daoPatient.returnInfoPatient("SELECT Nom, Prenom, Naissance, NumSecu " +
                "FROM Patient WHERE NumPatient = " + DossierMedicalControl.numPatient);
        nomCerti.setText(info.get(0) + " " + info.get(1));
        naissanceCerti.setText("Né(e) le " + info.get(2));
        CINCerti.setText("CIN : " + info.get(3));

        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("DossierMedical", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        comboCerti.setOnAction((event) -> {
            fieldApte.setVisible(false);
            comboApte.setVisible(false);
            fieldRepos.setVisible(false);
            dateDisD.setVisible(false);
            dateDisF.setVisible(false);
            if(comboCerti.getValue().equals("Aptitude")){
                fieldApte.setVisible(true);
                comboApte.setVisible(true);
            }
            else if(comboCerti.getValue().equals("Repos")){
                fieldRepos.setVisible(true);
            }
            else if(comboCerti.getValue().equals("Dispense")){
                dateDisD.setVisible(true);
                dateDisF.setVisible(true);
            }
        });

        buttonValide.setOnAction((event) -> {
            paneCerti.setVisible(false);
            naissanceCerti.setVisible(false);
            CINCerti.setVisible(false);
            if(comboCerti.getValue().equals("Aptitude")) {
                java.util.Date dateN = new java.util.Date();
                Date date = new Date(dateN.getTime());
                Observation o = new Observation(date, comboCerti.getValue() + "", comboApte.getValue() + " à " + fieldApte.getText(), DossierMedicalControl.numPatient);
                DAOObservation daoObservation = new DAOObservation();
                daoObservation.insertObservation(o);
                paneCerti.setVisible(true);
                naissanceCerti.setVisible(true);
                CINCerti.setVisible(true);
                textCerti.setText(comboApte.getValue() + " à " + fieldApte.getText());
            }
            else if (comboCerti.getValue().equals("Repos")){
                java.util.Date dateN = new java.util.Date();
                Date date = new Date(dateN.getTime());
                Observation o = new Observation(date, comboCerti.getValue() + "", "A droit à " + fieldRepos.getText() + " jours de repos", DossierMedicalControl.numPatient);
                DAOObservation daoObservation = new DAOObservation();
                daoObservation.insertObservation(o);
                paneCerti.setVisible(true);
                textCerti.setText("A droit à " + fieldRepos.getText() + " jours de repos");
            }
            else if (comboCerti.getValue().equals("Dispense")){
                java.util.Date dateN = new java.util.Date();
                Date date = new Date(dateN.getTime());
                Observation o = new Observation(date, comboCerti.getValue() + "", "Est dispensé du " + Date.valueOf(dateDisD.getValue()) + " au " + Date.valueOf(dateDisF.getValue()), DossierMedicalControl.numPatient);
                DAOObservation daoObservation = new DAOObservation();
                daoObservation.insertObservation(o);
                paneCerti.setVisible(true);
                textCerti.setText("Est dispensé du " + Date.valueOf(dateDisD.getValue()) + " au " + Date.valueOf(dateDisF.getValue()));
            }
            comboCerti.setValue("Rien");
            fieldApte.setText("");
            comboApte.setValue("apte");
            fieldRepos.setText("");
            dateDisD.setValue(null);
            dateDisF.setValue(null);
        });

        fieldRepos.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fieldRepos.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}