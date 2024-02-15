package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;
import si.um.feri.ris.repository.*;
import si.um.feri.ris.requests.AddUporabnikRequest;

import java.util.List;
import java.util.Optional;

@Service
public class UporabnikService {

    @Autowired
    private UporabnikRepository uporabnikRepository;
    private final KlubRepository klubRepository;
    private final RezervacijaRepository rezervacijaRepository;

    private final DogodekRepository dogodekRepository;
    private final RecenzijaRepository recenzijaRepository;

    private final VstopniceRepository vstopniceRepository;

    public UporabnikService(UporabnikRepository uporabnikRepository, KlubRepository klubRepository, RezervacijaRepository rezervacijaRepository, DogodekRepository dogodekRepository, RecenzijaRepository recenzijaRepository, VstopniceRepository vstopniceRepository) {
        this.uporabnikRepository = uporabnikRepository;
        this.klubRepository = klubRepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.dogodekRepository = dogodekRepository;
        this.recenzijaRepository = recenzijaRepository;
        this.vstopniceRepository = vstopniceRepository;
    }

    @ResponseBody
    public List<Uporabnik> getAll() {
        return (List<Uporabnik>) uporabnikRepository.findAll();
    }

    @ResponseBody
    public Optional<Uporabnik> getById(int id){
        return uporabnikRepository.findById(id);
    }

    public Uporabnik save(AddUporabnikRequest uporabnik){
        Uporabnik u =new Uporabnik();
        u.setIme(uporabnik.getIme());
        u.setPriimek(uporabnik.getPriimek());
        u.setEmail(uporabnik.getEmail());
        u.setGeslo(uporabnik.getGeslo());
        u.setVrsta(uporabnik.getVrsta());
        u.setTelefon(uporabnik.getTelefon());
        u.setEmso(uporabnik.getEmso());
        u.setDavcnaStevilka(uporabnik.getDavcnaStevilka());

        return uporabnikRepository.saveAndFlush(u);
    }
}
