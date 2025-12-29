package si.um.feri.ris.requests;

public class AddDogodekRequest {

    private DogodekDetails details;

    private int klubDogodek;
    private int steviloMiz;
    private int uporabnik;

    public AddDogodekRequest() {
    }

    public AddDogodekRequest(DogodekDetails details,
                             int klubDogodek,
                             int steviloMiz,
                             int uporabnik) {
        this.details = details;
        this.klubDogodek = klubDogodek;
        this.steviloMiz = steviloMiz;
        this.uporabnik = uporabnik;
    }

    public DogodekDetails getDetails() {
        return details;
    }

    public void setDetails(DogodekDetails details) {
        this.details = details;
    }

    public int getKlubDogodek() {
        return klubDogodek;
    }

    public void setKlubDogodek(int klubDogodek) {
        this.klubDogodek = klubDogodek;
    }

    public int getSteviloMiz() {
        return steviloMiz;
    }

    public void setSteviloMiz(int steviloMiz) {
        this.steviloMiz = steviloMiz;
    }

    public int getUporabnik() {
        return uporabnik;
    }

    public void setUporabnik(int uporabnik) {
        this.uporabnik = uporabnik;
    }
}
