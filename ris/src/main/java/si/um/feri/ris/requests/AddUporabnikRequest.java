package si.um.feri.ris.requests;

public class AddUporabnikRequest {

    private UporabnikDetails details;

    private int telefon;
    private int emso;
    private int davcnaStevilka;

    public AddUporabnikRequest() {
    }

    public AddUporabnikRequest(UporabnikDetails details,
                               int telefon,
                               int emso,
                               int davcnaStevilka) {
        this.details = details;
        this.telefon = telefon;
        this.emso = emso;
        this.davcnaStevilka = davcnaStevilka;
    }

    public UporabnikDetails getDetails() {
        return details;
    }

    public void setDetails(UporabnikDetails details) {
        this.details = details;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public int getEmso() {
        return emso;
    }

    public void setEmso(int emso) {
        this.emso = emso;
    }

    public int getDavcnaStevilka() {
        return davcnaStevilka;
    }

    public void setDavcnaStevilka(int davcnaStevilka) {
        this.davcnaStevilka = davcnaStevilka;
    }
}
