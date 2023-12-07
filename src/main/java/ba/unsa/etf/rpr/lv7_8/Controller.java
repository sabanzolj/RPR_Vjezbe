package ba.unsa.etf.rpr.lv7_8;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {


    public ImageView closeIconID;
    public ListView listaID;
    public Button endBtnID;

    @FXML
    public void initialize(){




    }


    public void akcijaClose(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeIconID.getScene().getWindow();
        stage.close();
    }

    public void akcijaButtonIzlaz(ActionEvent actionEvent) {
        Stage stage = (Stage) endBtnID.getScene().getWindow();
        stage.close();
    }
}