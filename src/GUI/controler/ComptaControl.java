package GUI.controler;

import BDD.DAO.DAOComptabilite;
import BDD.object.Facture;
import GUI.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class ComptaControl {

    private ObservableList<Facture> FactureData = FXCollections.observableArrayList();

    @FXML
    private TableView<Facture> factureListView;

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


        DAOComptabilite daoCompta = new DAOComptabilite();
        List<Facture> listeFacture = daoCompta.findAll();
        for (Facture facture : listeFacture)
        {
            FactureData.add(facture);
        }

        factureListView.getItems().addAll(FactureData);
    }
}
