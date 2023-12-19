package ba.unsa.etf.rpr;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;


import java.sql.*;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GeografijaDAO {

    private ObservableList<Grad> gradoviKolekcija = FXCollections.observableArrayList();
    private ObjectProperty<Grad> trenutniGrad = null;


    private static GeografijaDAO instance=null;
    private Connection conn;
    private PreparedStatement stmt;

    private GeografijaDAO(){
        try{
            conn=DriverManager.getConnection("jdbc:sqlite:resources/db/baza.db");


            stmt=conn.prepareStatement("SELECT * FROM grad");
            ResultSet rezultat=stmt.executeQuery();


            while (rezultat.next()){
                Grad g=new Grad(rezultat.getInt(1),rezultat.getString(2),rezultat.getInt(3),rezultat.getInt(4));
                gradoviKolekcija.add(g);
                if (trenutniGrad == null) trenutniGrad = new SimpleObjectProperty<Grad>(g);
            }

        }
        catch (SQLException e){
            regenerisiBazu();
            try{
                stmt=conn.prepareStatement("SELECT * FROM grad");
                ResultSet rezultat=stmt.executeQuery();


                while (rezultat.next()){
                    Grad g=new Grad(rezultat.getInt(1),rezultat.getString(2),rezultat.getInt(3),rezultat.getInt(4));
                    gradoviKolekcija.add(g);
                    if (trenutniGrad == null) trenutniGrad = new SimpleObjectProperty<Grad>(g);
                }

            }catch (SQLException e1) {
                System.out.println("Neuspjesno citanje iz baze: " + e1.getMessage());
            }
        }
        if (trenutniGrad == null) trenutniGrad = new SimpleObjectProperty<>();
    }

    private void regenerisiBazu() {
        try (Statement statement = conn.createStatement()) {
            // Kreiraj tabele
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS grad (" +
                    "id INT PRIMARY KEY," +
                    "naziv TEXT," +
                    "broj_stanovnika INT," +
                    "drzava INT)");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS drzava (" +
                    "id INT PRIMARY KEY," +
                    "naziv TEXT," +
                    "glavni_grad INT)");

            // Popuni podacima za drzave
            statement.executeUpdate("INSERT INTO drzava (id, naziv, glavni_grad) VALUES (1, 'Francuska', 1)");
            statement.executeUpdate("INSERT INTO drzava (id, naziv, glavni_grad) VALUES (2, 'Velika Britanija', 2)");
            statement.executeUpdate("INSERT INTO drzava (id, naziv, glavni_grad) VALUES (3, 'Austrija', 3)");

            // Popuni podacima za gradove
            statement.executeUpdate("INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (1, 'Pariz', 2200000, 1)");
            statement.executeUpdate("INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (2, 'London', 8900000, 2)");
            statement.executeUpdate("INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (3, 'Beč', 1890000, 3)");
            statement.executeUpdate("INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (4, 'Manchester', 545000, 2)");
            statement.executeUpdate("INSERT INTO grad (id, naziv, broj_stanovnika, drzava) VALUES (5, 'Graz', 291000, 3)");

        } catch (SQLException e) {
            System.out.println("Neuspjesno regenerisanje baze: " + e.getMessage());
        }
    }

    public static GeografijaDAO getInstance(){
        if(instance==null){
            instance=new GeografijaDAO();
        }
        return instance;
    }

    public Grad glavniGrad(String ime_drzave){

        String upit="SELECT * FROM grad, drzava WHERE grad.id=drzava.glavni_grad AND drzava.naziv=?";

        try{
            PreparedStatement stmt=conn.prepareStatement(upit);
            stmt.setString(1,ime_drzave);
            ResultSet rezultat=stmt.executeQuery();

            while (rezultat.next()){
                return new Grad(rezultat.getInt(1),rezultat.getString(2),rezultat.getInt(3),rezultat.getInt(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public void obrisiDrzavu(String ime_drzave){
        String upit1="DELETE FROM grad WHERE drzava=(SELECT drzava.id FROM drzava WHERE drzava.naziv=?)";
        String upit2="DELETE FROM drzava WHERE drzava.naziv=?";

        try{
            PreparedStatement stmt1=conn.prepareStatement(upit1);
            PreparedStatement stmt2=conn.prepareStatement(upit2);

            conn.setAutoCommit(false);


            stmt1.setString(1,ime_drzave);
            stmt1.executeUpdate();
            stmt2.setString(1,ime_drzave);
            stmt2.executeUpdate();





            conn.commit();


        }catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            }
            catch (SQLException e1){
                e1.printStackTrace();
            }

        }

    }



    public List<Grad> gradovi(){
        gradoviKolekcija.sort(Comparator.comparingInt(Grad::getBrojStanovnika).reversed());
        return gradoviKolekcija;
    }

    public void dodajGrad(Grad noviGrad){
        int noviId=noviGrad.getId();
        String noviNaziv=noviGrad.getNaziv();
        int noviBrojStanovnika=noviGrad.getBrojStanovnika();
        int noviDrzava=noviGrad.getDrzava();

        String upit="INSERT INTO grad(id,naziv,broj_stanovnika,drzava) VALUES (?,?,?,?)";

        try {
            PreparedStatement stmt=conn.prepareStatement(upit);
            conn.setAutoCommit(false);
            stmt.setInt(1,noviId);
            stmt.setString(2,noviNaziv);
            stmt.setInt(3,noviBrojStanovnika);
            stmt.setInt(4,noviDrzava);

            stmt.executeUpdate();

            conn.commit();



        }catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    public void dodajDrzavu(Drzava novaDrzava){
        int noviId=novaDrzava.getId();
        String noviNaziv=novaDrzava.getNaziv();
        int noviGlavniGrad= novaDrzava.getGlavniGradId();

        String upit="INSERT INTO drzava(id,naziv,glavni_grad) VALUES (?,?,?)";

        try {
            PreparedStatement stmt=conn.prepareStatement(upit);
            conn.setAutoCommit(false);
            stmt.setInt(1,noviId);
            stmt.setString(2,noviNaziv);
            stmt.setInt(3,noviGlavniGrad);

            stmt.executeUpdate();

            conn.commit();



        }catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    public void izmijeniGrad(Grad noviGrad){
        int ID=noviGrad.getId();
        System.out.println("Unesite nove podatke izabrani grad: ("+noviGrad.getNaziv()+")");
        Scanner ulaz=new Scanner(System.in);
       String noviNaziv;
       System.out.println("Unesite novi naziv: ");
       noviNaziv=ulaz.nextLine();
       int noviBrojStanovnika;
       System.out.println("Unesite novi broj stanovnika: ");
       noviBrojStanovnika=ulaz.nextInt();
       int novaDrzava;
       System.out.println("Unesite novi ID drzave: ");
       novaDrzava=ulaz.nextInt();

       String upit="UPDATE grad SET naziv=?,broj_stanovnika=?,drzava=? WHERE id=?";

       try {
           PreparedStatement stnt=conn.prepareStatement(upit);


           stnt.setString(1,noviNaziv);
           stnt.setInt(2,noviBrojStanovnika);
           stnt.setInt(3,novaDrzava);
           stnt.setInt(4,ID);

           stnt.executeUpdate();



       }catch (SQLException e){
           e.printStackTrace();

       }
    }

    public Drzava nadjiDrzavu(String ime_drzave){

        String upit="SELECT * FROM drzava WHERE drzava.naziv=?";

        try{
            PreparedStatement stmt=conn.prepareStatement(upit);
            stmt.setString(1,ime_drzave);
            ResultSet rezultat=stmt.executeQuery();

            while (rezultat.next()){
                return new Drzava(rezultat.getInt(1),rezultat.getString(2),rezultat.getInt(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public Drzava nadjiDrzavuPoId(int idDrzave){

        String upit="SELECT * FROM drzava WHERE drzava.id=?";

        try{
            PreparedStatement stmt=conn.prepareStatement(upit);
            stmt.setInt(1,idDrzave);
            ResultSet rezultat=stmt.executeQuery();

            while (rezultat.next()){
                return new Drzava(rezultat.getInt(1),rezultat.getString(2),rezultat.getInt(3));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

}
