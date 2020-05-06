package GUI.controler;

import BDD.DAO.DAOAgenda;
import BDD.object.RendezVous;
import GUI.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class AgendaControl {

    private ObservableList<RendezVous> rdvData = FXCollections.observableArrayList();

    @FXML
    private TableView<RendezVous> rdvListView;

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


        DAOAgenda daoAgenda = new DAOAgenda();
        List<RendezVous> listeRdv = daoAgenda.findAll();
        for (RendezVous  rendezVous: listeRdv)
        {
            rdvData.add(rendezVous);
        }


        rdvListView.getItems().addAll(rdvData);
    }
}
