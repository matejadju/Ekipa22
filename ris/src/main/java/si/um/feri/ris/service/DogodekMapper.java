package si.um.feri.ris.service;

import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddDogodekRequest;

public final class DogodekMapper {

    public static Dogodek fromRequest(
            AddDogodekRequest request,
            Klub klub,
            Uporabnik uporabnik
    ) {
        Dogodek d = new Dogodek();
        d.setDatum(request.getDatum());
        d.setNaziv(request.getNaziv());
        d.setOpis(request.getOpis());
        d.setCenaVstopnice(request.getCenaVstopnice());
        d.setSteviloVstopnica(request.getSteviloVstopnica());
        d.setSteviloMiz(request.getSteviloMiz());
        d.setOdobren(false);

        d.setClubDoggone(klub);
        d.setUporabnikDogodek(uporabnik);

        return d;
    }

    private DogodekMapper() {}
}
