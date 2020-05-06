package GUI.controler;

import BDD.DAO.DAOComptabilite;
import BDD.object.Facture;
import GUI.Tools;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Date;

public class AddFacControl {

    @FXML
    private Button buttonRetour;

    @FXML
    private Label echecFeedBack;

    @FXML
    private Label valideFeedBack;

    @FXML
    private ComboBox comboType;

    @FXML
    private Button buttonValide;

    @FXML
    private TextField fieldAction;

    @FXML
    private TextField fieldDetail;

    @FXML
    private TextField fieldMontant;

    @FXML
    private DatePicker date;

    @FXML
    private TextField fieldJustificatif;


    @FXML
    private void initialize() {
        comboType.getItems().addAll(
                "gain",
                "perte"
        );

        comboType.getSelectionModel().selectFirst();


        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("Comptabilite", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonValide.setOnAction((event) -> {
            echecFeedBack.setVisible(false);
            valideFeedBack.setVisible(false);
            date.setStyle("-fx-border-color: black; -fx-background-radius: 22px; -fx-border-radius: 22px;");
            fieldMontant.setStyle("-fx-border-color: black; -fx-background-radius: 22px; -fx-border-radius: 22px;");
            if (!(fieldMontant.getText().equals("")) && !(date.getValue() == null)) {
                Facture f = new Facture(String.valueOf(comboType.getValue()), fieldAction.getText(), fieldDetail.getText(), Double.valueOf(fieldMontant.getText()), Date.valueOf(date.getValue()), fieldJustificatif.getText());
                DAOComptabilite daoComptabilite = new DAOComptabilite();
                daoComptabilite.insertFacture(f);
                valideFeedBack.setVisible(true);
            }
            else {
                fieldMontant.setStyle("-fx-border-color: red; -fx-background-radius: 22px; -fx-border-radius: 22px;");
                date.setStyle("-fx-border-color: red; -fx-background-radius: 22px; -fx-border-radius: 22px;");
                echecFeedBack.setVisible(true);
            }
            comboType.setValue("gain");
            fieldAction.setText("");
            fieldDetail.setText("");
            fieldMontant.setText("");
            date.setValue(null);
            fieldJustificatif.setText("");
        });

        fieldMontant.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    fieldMontant.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}

