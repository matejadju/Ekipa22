package si.um.feri.ris.service;

import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddDogodekRequest;
import si.um.feri.ris.requests.DogodekDetails;

public final class DogodekMapper {

    public static Dogodek fromRequest(
            AddDogodekRequest request,
            Klub klub,
            Uporabnik uporabnik
    ) {
        Dogodek d = new Dogodek();

        DogodekDetails details = request.getDetails();

        d.setDatum(details.getDatum());
        d.setNaziv(details.getNaziv());
        d.setOpis(details.getOpis());
        d.setCenaVstopnice(details.getCenaVstopnice());
        d.setSteviloVstopnica(details.getSteviloVstopnica());
        d.setSteviloMiz(request.getSteviloMiz());
        d.setOdobren(details.isOdobren());

        d.setKlubDogodek(klub);
        d.setUporabnikDogodek(uporabnik);

        return d;
    }

    private DogodekMapper() {}
}
