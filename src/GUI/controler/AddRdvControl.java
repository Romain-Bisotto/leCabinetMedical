package GUI.controler;

import BDD.DAO.DAOAgenda;
import BDD.object.RendezVous;
import GUI.Tools;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.List;

public class AddRdvControl {

    @FXML
    private Label free;

    @FXML
    private Label valide;

    @FXML
    private Label noNumPat;

    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonValide;

    @FXML
    private ComboBox comboHeure;

    @FXML
    private DatePicker date;

    @FXML
    private TextField fieldNumPatient;

    @FXML
    private TextField fieldMotif;


    @FXML
    private void initialize() {
        comboHeure.getItems().addAll(
                "08h00",
                "08h30",
                "09h00",
                "09h30",
                "10h00",
                "10h30",
                "11h00",
                "11h30",
                "12h00",
                "12h30",
                "13h00",
                "13h30",
                "14h00",
                "14h30",
                "15h00",
                "15h30",
                "16h00",
                "16h30",
                "17h00",
                "17h30",
                "18h00"
        );

        comboHeure.getSelectionModel().selectFirst();

        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("Agenda", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonValide.setOnAction((event) -> {
            noNumPat.setVisible(false);
            free.setVisible(false);
            valide.setVisible(false);
            fieldNumPatient.setStyle("-fx-border-color: black; -fx-background-radius: 22px; -fx-border-radius: 22px;");
            if (date.getValue() != null) {
                DAOAgenda daoAgendaTest = new DAOAgenda();
                List<RendezVous> listeRdv = daoAgendaTest.returnRdv("SELECT DateRdv, Heure, NumPatient, Motif FROM Agenda WHERE DateRdv = '"
                        + Date.valueOf(date.getValue()) + "' AND Heure = '" + comboHeure.getValue() + "';");
                if (listeRdv != null && listeRdv.size() == 0) {
                    if(fieldNumPatient.getText().equals("")){
                        noNumPat.setVisible(true);
                        fieldNumPatient.setStyle("-fx-border-color: red; -fx-background-radius: 22px; -fx-border-radius: 22px;");
                    }
                    else {
                        valide.setVisible(true);
                        RendezVous rdv = new RendezVous(Date.valueOf(date.getValue()), String.valueOf(comboHeure.getValue()), Integer.valueOf(fieldNumPatient.getText()), fieldMotif.getText());
                        DAOAgenda daoAgenda = new DAOAgenda();
                        daoAgenda.insertRendezVous(rdv);
                    }
                }
                else {
                    free.setVisible(true);
                }
            }
            else{
                free.setVisible(true);
            }
            fieldMotif.setText("");
            fieldNumPatient.setText("");
            date.setValue(null);
            comboHeure.setValue("08h00");
        });
        fieldNumPatient.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fieldNumPatient.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}
