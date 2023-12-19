package ba.unsa.etf.rpr;

public class Drzava {
    private int id;
    private String naziv;
    private int glavniGradId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGlavniGradId() {
        return glavniGradId;
    }

    public void setGlavniGradId(int glavniGradId) {
        this.glavniGradId = glavniGradId;
    }

    public Drzava(int id, String naziv, int glavniGradId) {
        this.id = id;
        this.naziv = naziv;
        this.glavniGradId = glavniGradId;
    }
}
