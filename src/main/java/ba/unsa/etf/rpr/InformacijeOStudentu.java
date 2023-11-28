package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije implements Predstavljiva{
    private String godinaStudija;
    private String brojInexa;

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

    public String getBrojInexa() {
        return brojInexa;
    }

    public void setBrojInexa(String brojInexa) {
        this.brojInexa = brojInexa;
    }

@Override
    public String predstavi(){
        return "Student "+getIme()+" "+getPrezime()+", Broj indexa: "+getBrojInexa()+" , Godina studija: "+getGodinaStudija();

}
}
