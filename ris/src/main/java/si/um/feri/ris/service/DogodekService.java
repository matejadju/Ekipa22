package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.AddDogodekRequest;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.repository.DogodekRepository;
import si.um.feri.ris.repository.KlubRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DogodekService {


    private final DogodekRepository dogodekRepository;
    private final KlubRepository klubRepository;

    @Autowired
    public DogodekService(DogodekRepository dogodekRepository, KlubRepository klubRepository) {
        this.dogodekRepository = dogodekRepository;
        this.klubRepository = klubRepository;
    }

    public List<Dogodek> findBydog(boolean odobren, Float cenaVstopnice) {
        return dogodekRepository.findBydog(odobren, cenaVstopnice);
    }

    public List<Dogodek> findByCenaVstopnice(Float cenaVstopnice){
        return dogodekRepository.findAllByCenaVstopnice(cenaVstopnice);
    }

    public Dogodek save(AddDogodekRequest dogodek) {
        Dogodek d = new Dogodek();
        d.setDatum(dogodek.getDatum());
        Optional<Klub> k = klubRepository.findById((long) dogodek.getKlubDogodek());
        if (k.isPresent()) {
            d.setKlub_dogodek(k.get());
        }
        d.setNaziv(dogodek.getNaziv());
        d.setOdobren(false);
        d.setOpis(dogodek.getOpis());
        d.setCenaVstopnice(dogodek.getCenaVstopnice());
        d.setSteviloVstopnica(dogodek.getSteviloVstopnic());
        return dogodekRepository.saveAndFlush(d);
    }

    public List<Dogodek> findBySteviloMiz(int steviloMiz){
        return dogodekRepository.findAllBySteviloMiz(steviloMiz);
    }
}
