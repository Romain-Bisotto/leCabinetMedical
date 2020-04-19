package GUI.controler;

import GUI.Tools;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AgendaControl {
    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonAddRdv;

    @FXML
    private void initialize() {
        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("sample", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonAddRdv.setOnAction((event) -> {
            Tools.loadWindow("AjouterRendezVous", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
    }
}
