package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.MizaRepository;
import si.um.feri.ris.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MizaService {
    @Autowired
    private MizaRepository mizaRepository;
    @ResponseBody
    public List<Miza> getAll() {
        return (List<Miza>) mizaRepository.findAll();
    }

    @ResponseBody
    public Optional<Miza> getById(Long id){
        return mizaRepository.findById(id);
    }
    @PostMapping
    public Miza createMiza(Miza miza){
        return mizaRepository.save(miza);
    }
    public void updateMiza(Long id, Miza novaMiza) {
        if (mizaRepository.existsById(id)) {
            novaMiza.setIdmiza(id);
            mizaRepository.save(novaMiza);
        }
    }

    public void deleteMiza(Long id) {
        mizaRepository.deleteById(id);
    }


}
