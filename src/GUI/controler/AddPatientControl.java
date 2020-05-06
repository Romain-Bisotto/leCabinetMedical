package GUI.controler;

import BDD.DAO.DAOPatient;
import BDD.object.Patient;
import GUI.Tools;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Date;

public class AddPatientControl {

    @FXML
    private Label echec;

    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonValide;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldPrenom;

    @FXML
    private TextField fieldSexe;

    @FXML
    private DatePicker dateNaissance;

    @FXML
    private TextField fieldTel;

    @FXML
    private TextField fieldAdresse;

    @FXML
    private TextField fieldNumSecu;

    @FXML
    private TextField fieldProfession;

    @FXML
    private TextField fieldValide;

    @FXML
    private void initialize() {
        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("Patient", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonValide.setOnAction((event) -> {
            echec.setVisible(false);
            if(!fieldNom.getText().equals("") && !fieldPrenom.getText().equals("") && dateNaissance.getValue() != null) {
                Patient p = new Patient(fieldNom.getText(), fieldPrenom.getText(), Date.valueOf(dateNaissance.getValue()), fieldSexe.getText(), fieldTel.getText(), fieldAdresse.getText(), fieldNumSecu.getText(), fieldValide.getText(), fieldProfession.getText());
                DAOPatient daoPatient = new DAOPatient();
                daoPatient.insertPatient(p);
            }
            else {
                echec.setVisible(true);
            }
            fieldNom.setText("");
            fieldPrenom.setText("");
            dateNaissance.setValue(null);
            fieldSexe.setText("");
            fieldTel.setText("");
            fieldAdresse.setText("");
            fieldNumSecu.setText("");
            fieldValide.setText("");
            fieldProfession.setText("");
        });
        fieldTel.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fieldTel.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    }
}
