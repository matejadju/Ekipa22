package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.repository.KlubRepository;
import java.util.List;
import java.util.Optional;

@Service
public class KlubService {

    private final KlubRepository klubRepository;

    @Autowired
    public KlubService(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    public List<Klub> dohvatiSveKlubove() {
        return klubRepository.findAll();
    }

    public Optional<Klub> dohvatiKlubPoId(Long id) {
        return klubRepository.findById(id);
    }

    public Klub spremiKlub(Klub klub) {
        return klubRepository.save(klub);
    }

    public void azurirajKlub(Long id, Klub noviKlub) {
        if (klubRepository.existsById(id)) {
            noviKlub.setIdklub(id);
            klubRepository.save(noviKlub);
        }
    }

    public void obrisiKlub(Long id) {
        klubRepository.deleteById(id);
    }
}