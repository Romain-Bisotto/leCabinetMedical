package GUI;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Tools {

    public static FXMLLoader loadWindow(String nameWindows, Stage window, int width, int height) {
        try {
            FXMLLoader loader = new FXMLLoader(Tools.class.getResource("fxml/" + nameWindows + ".fxml"));
            Pane page = (Pane) loader.load();
            Scene nouvelleFenetre2 = new Scene(page,width,height);
            window.setScene(nouvelleFenetre2);
            window.setResizable(false);
            return loader;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}