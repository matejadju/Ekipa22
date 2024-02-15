package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;
import si.um.feri.ris.repository.UporabnikRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UporabnikService {

    @Autowired
    private UporabnikRepository uporabnikRepository;



    @ResponseBody
    public List<Uporabnik> getAll() {
        return (List<Uporabnik>) uporabnikRepository.findAll();
    }

    @ResponseBody
    public Optional<Uporabnik> getById(int id){
        return uporabnikRepository.findById(id);
    }

    public Uporabnik novUporabnik(Uporabnik uporabnik) {
        return uporabnikRepository.saveAndFlush(uporabnik);
    }
}
