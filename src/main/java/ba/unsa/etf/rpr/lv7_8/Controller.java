package ba.unsa.etf.rpr.lv7_8;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

    private KorisniciModel model;


    public ImageView closeIconID;
    public ListView<Korisnik> listaID;
    public Button endBtnID;
    public TextField txtFldNameID;
    public TextField txtFldLastNameID;
    public TextField txtFldMailID;
    public TextField txtFldUsernameID;
    public PasswordField txtFldPasswordID;

    private SimpleStringProperty name;
    private SimpleStringProperty lastName;
    private SimpleStringProperty email;
    private SimpleStringProperty userName;
    private SimpleStringProperty password;




    public Controller(KorisniciModel m){
        model =m;
        name=new SimpleStringProperty();
        lastName=new SimpleStringProperty();
        email=new SimpleStringProperty();
        userName=new SimpleStringProperty();
        password=new SimpleStringProperty();

    }




    @FXML
    public void initialize(){
        txtFldNameID.textProperty().bindBidirectional(name);
        txtFldLastNameID.textProperty().bindBidirectional(lastName);
        txtFldMailID.textProperty().bindBidirectional(email);
        txtFldUsernameID.textProperty().bindBidirectional(userName);
        txtFldPasswordID.textProperty().bindBidirectional(password);


        if(model !=null) {
            listaID.setItems(model.getKorisnici());
        }

        model.trenutniKorisnikProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (oldKorisnik != null) {
                txtFldNameID.textProperty().unbindBidirectional(
                        oldKorisnik.nameProperty() );
                txtFldLastNameID.textProperty().unbindBidirectional(
                        oldKorisnik.lastNameProperty() );
                txtFldMailID.textProperty().unbindBidirectional(
                        oldKorisnik.emailProperty() );
                txtFldUsernameID.textProperty().unbindBidirectional(
                        oldKorisnik.userNameProperty() );
                txtFldPasswordID.textProperty().unbindBidirectional(
                        oldKorisnik.passwordProperty() );
            }
            if (newKorisnik == null) {
                txtFldNameID.setText("");
                txtFldLastNameID.setText("");
                txtFldMailID.setText("");
                txtFldUsernameID.setText("");
                txtFldPasswordID.setText("");



            }
            else {
                txtFldNameID.textProperty().bindBidirectional(
                        newKorisnik.nameProperty() );
                txtFldLastNameID.textProperty().bindBidirectional(
                        newKorisnik.lastNameProperty() );
                txtFldMailID.textProperty().bindBidirectional(
                        newKorisnik.emailProperty() );
                txtFldUsernameID.textProperty().bindBidirectional(
                        newKorisnik.userNameProperty() );
                txtFldPasswordID.textProperty().bindBidirectional(
                        newKorisnik.passwordProperty() );
            }
        });






    }


    public void akcijaClose(MouseEvent mouseEvent) {
        Stage stage = (Stage) closeIconID.getScene().getWindow();
        stage.close();
    }

    public void akcijaButtonIzlaz(ActionEvent actionEvent) {
        Stage stage = (Stage) endBtnID.getScene().getWindow();
        stage.close();
    }

    public void akcijaButtonDodaj(ActionEvent actionEvent) {
        listaID.refresh();
        Korisnik noviKorisnik=new Korisnik("","","","","");
        model.setTrenutniKorisnik(noviKorisnik);
        txtFldNameID.clear();
        txtFldLastNameID.clear();
        txtFldMailID.clear();
        txtFldUsernameID.clear();
        txtFldPasswordID.clear();

        model.getKorisnici().add(noviKorisnik);

        // Osvježavanje liste (ako je potrebno)
        listaID.refresh();
    }

    public void akcijaIzborKorisnikaID(MouseEvent mouseEvent) {
        listaID.refresh();
        model.setTrenutniKorisnik(listaID.getSelectionModel().getSelectedItem());
        if(model.getTrenutniKorisnik().getName()=="Saban"){
            System.out.println("Izabran Saban");
        }
        else if(model.getTrenutniKorisnik().getName()=="Adil"){
            System.out.println("Izabran Adil");
        }
    }
}