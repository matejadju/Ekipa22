package si.um.feri.ris.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.UporabnikRepository;
import si.um.feri.ris.requests.AddUporabnikRequest;
import si.um.feri.ris.requests.UporabnikDetails;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UporabnikService {

    private final UporabnikRepository uporabnikRepository;

    public UporabnikService(UporabnikRepository uporabnikRepository) {
        this.uporabnikRepository = uporabnikRepository;
    }

    @ResponseBody
    public List<Uporabnik> getAll() {
        return (List<Uporabnik>) uporabnikRepository.findAll();
    }

    @ResponseBody
    public Optional<Uporabnik> getById(int id) {
        return uporabnikRepository.findById(id);
    }

    public Uporabnik save(AddUporabnikRequest request) {

        Uporabnik u = new Uporabnik();
        UporabnikDetails details = request.getDetails();

        u.setIme(details.getIme());
        u.setPriimek(details.getPriimek());
        u.setEmail(details.getEmail());
        u.setGeslo(details.getGeslo());
        u.setVrsta(details.getVrsta());

        u.setTelefon(request.getTelefon());
        u.setEmso(request.getEmso());
        u.setDavcnaStevilka(request.getDavcnaStevilka());

        return uporabnikRepository.saveAndFlush(u);
    }

    public Uporabnik authenticate(String email, String geslo) {
        List<Uporabnik> u = uporabnikRepository.findByEmailAndGeslo(email, geslo);

        if (!u.isEmpty()) {
            return u.get(0);
        }

        throw new IllegalArgumentException("Not authorised");
    }


    public Uporabnik findByEmailAndGeslo(String email, String geslo) {
        List<Uporabnik> u = uporabnikRepository.findByEmailAndGeslo(email, geslo);
        return u.isEmpty() ? null : u.get(0);
    }

    public List<Uporabnik> findByEmail(String email) {
        return uporabnikRepository.findByEmail(email);
    }

    public void updateProfil(int telefon, Long id) {
        uporabnikRepository.updateProfil(telefon, id);
    }
}
