package ba.unsa.etf.rpr.lv7_8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        KorisniciModel korisniciModel = new KorisniciModel();
        korisniciModel.napuni();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Korisnici.fxml"));
            Controller controller = new Controller(korisniciModel);
            loader.setController(controller);
            Parent root = loader.load();

            stage.setTitle("Korisnici");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
            //stage.setScene(new Scene(root, 700, 400));

            stage.initStyle(StageStyle.UNDECORATED);
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon_logo.png")));

            stage.setMinWidth(700);
            stage.setMinHeight(400);
            stage.setResizable(true);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // Obradite izuzetak prema potrebi, npr. prikažite poruku o grešci i izađite na prikladan način.
        }
    }

    public static void main(String[] args) {
        launch();
    }
}