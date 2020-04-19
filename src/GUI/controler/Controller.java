package GUI.controler;

import GUI.Tools;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button buttonComptabilite;

    @FXML
    private Button buttonAgenda;

    @FXML
    private Button buttonDossierMédical;

    @FXML
    private Button buttonFichePatient;

    @FXML
    private void initialize() {
        buttonComptabilite.setOnAction( (event) -> {
            Tools.loadWindow("Comptabilite", (Stage) ( (Node) event.getSource()).getScene().getWindow(), 900, 600);
        } );
        buttonAgenda.setOnAction( (event) -> {
            Tools.loadWindow("Agenda", (Stage) ( (Node) event.getSource()).getScene().getWindow(), 900, 600);
        } );
    }
}
