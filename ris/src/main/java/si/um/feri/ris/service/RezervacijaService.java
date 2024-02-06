package si.um.feri.ris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import si.um.feri.ris.models.Rezervacija;
import si.um.feri.ris.repository.RezervacijaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaService {
    @Autowired
    private RezervacijaRepository rezervacijaRepository;
    @ResponseBody
    public List<Rezervacija> getAll(){
        return (List<Rezervacija>) rezervacijaRepository.findAll();
    }

    @ResponseBody
    public Optional<Rezervacija> getById(Long id){
        return rezervacijaRepository.findById(id);
    }

    @PostMapping
    public Rezervacija createRezervacija(Rezervacija rezervacija){
        return rezervacijaRepository.save(rezervacija);
    }

    public void updateRezervacija(Long id, Rezervacija novaRezervacija){
        if (rezervacijaRepository.existsById(id)){
            novaRezervacija.setIdRezervacija(id);
            rezervacijaRepository.save(novaRezervacija);
        }
    }

    public void deleteRezervacija(Long id){
        rezervacijaRepository.deleteById(id);
    }
}
