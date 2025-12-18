package si.um.feri.ris.service;

import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.DogodekRepository;
import si.um.feri.ris.repository.KlubRepository;
import si.um.feri.ris.repository.UporabnikRepository;
import si.um.feri.ris.requests.AddDogodekRequest;

import java.util.List;

@Service
public class DogodekService {

    private final DogodekRepository dogodekRepository;
    private final KlubRepository klubRepository;
    private final UporabnikRepository uporabnikRepository;

    public DogodekService(
            DogodekRepository dogodekRepository,
            KlubRepository klubRepository,
            UporabnikRepository uporabnikRepository
    ) {
        this.dogodekRepository = dogodekRepository;
        this.klubRepository = klubRepository;
        this.uporabnikRepository = uporabnikRepository;
    }

    public Dogodek save(AddDogodekRequest request) {
        Klub klub = klubRepository
                .findById((long) request.getKlubDogodek())
                .orElseThrow(() -> new IllegalArgumentException("Klub not found"));

        Uporabnik uporabnik = uporabnikRepository
                .findById((int) request.getUporabnik())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Dogodek dogodek = DogodekMapper.fromRequest(request, klub, uporabnik);

        return dogodekRepository.saveAndFlush(dogodek);
    }

    public List<Dogodek> findByCenaVstopnice(int cenaVstopnice) {
        return dogodekRepository.findAllByCenaVstopnice(cenaVstopnice);
    }

    public List<Dogodek> findBySteviloMiz(int steviloMiz) {
        return dogodekRepository.findAllBySteviloMiz(steviloMiz);
    }

    public List<Dogodek> findAllByOdobren() {
        return dogodekRepository.findAllByOdobren();
    }

    public List<Dogodek> findByUporabnikId(int uporabnikId) {
        return dogodekRepository.findByidu(uporabnikId);
    }
}
