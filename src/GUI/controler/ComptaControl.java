package GUI.controler;

import GUI.Tools;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ComptaControl {

    @FXML
    private Button buttonRetour;

    @FXML
    private Button buttonAddFac;

    @FXML
    private void initialize() {
        buttonRetour.setOnAction((event) -> {
            Tools.loadWindow("sample", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
        buttonAddFac.setOnAction((event) -> {
            Tools.loadWindow("AjouterFacture", (Stage) ((Node) event.getSource()).getScene().getWindow(), 900, 600);
        });
    }
}
