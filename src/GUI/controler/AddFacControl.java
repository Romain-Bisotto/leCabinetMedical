package GUI.controler;

import GUI.Tools;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddFacControl {

    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonValide;

    @FXML
    private void initialize() {
        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("Comptabilite", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
    }
}

