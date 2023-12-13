package ba.unsa.etf.rpr.lv7_8;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
public class TestFX {

    private static KorisniciModel model=new KorisniciModel();

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(getClass().getResource("/fxml/Korisnici.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @BeforeAll
    public static void napuni(){
        model.getKorisnici().add(new Korisnik("Saban","Zolj","szolj1@etf.unsa.ba","szolj1","113456"));
        model.getKorisnici().add(new Korisnik("Adil","Tutun","atutun1@etf.unsa.ba","atutun1","113456"));
        model.getKorisnici().add(new Korisnik("Amer","Dautovic","adautovic1@etf.unsa.ba","adautovic1","113456"));

    }

    @Test
    public void ime(FxRobot robot){
        //assertNotNull(robot.lookup("#listaID").queryListView());

        // Simulirajte klik na prvi element u ListView-u
        //robot.clickOn("#listaID").clickOn(String.valueOf(0));
    }
}
