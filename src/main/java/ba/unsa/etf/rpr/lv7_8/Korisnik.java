package ba.unsa.etf.rpr.lv7_8;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    private SimpleStringProperty name=new SimpleStringProperty("");
    private SimpleStringProperty lastName=new SimpleStringProperty("");
    private SimpleStringProperty email=new SimpleStringProperty("");
    private SimpleStringProperty userName=new SimpleStringProperty("");
    private SimpleStringProperty password=new SimpleStringProperty("");

    public Korisnik(){}

    public Korisnik(String ime,String prezime,String mail,String korisnicko_ime,String sifra){
        name=new SimpleStringProperty(ime);
        lastName=new SimpleStringProperty(prezime);
        email=new SimpleStringProperty(mail);
        userName=new SimpleStringProperty(korisnicko_ime);
        password=new SimpleStringProperty(sifra);

    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        return name.get()+" "+lastName.get()+", "+userName.get();
    }
}
