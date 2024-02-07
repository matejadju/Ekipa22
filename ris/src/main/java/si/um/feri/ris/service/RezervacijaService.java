package si.um.feri.ris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Rezervacija;
import si.um.feri.ris.repository.RezervacijaRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RezervacijaService {
    @Autowired
    private RezervacijaRepository rezervacijaRepository;

    public List<Rezervacija> getAll(){
        return (List<Rezervacija>) rezervacijaRepository.findAll();
    }

    public Optional<Rezervacija> getById(Long id){
        return rezervacijaRepository.findById(id);
    }


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

    public List<Rezervacija> dohvatiRezervacije(int stevOseb) {
        LocalDateTime pocetak = LocalDateTime.of(2024, 1, 1, 0, 0);
        Timestamp pocetakTimestamp = Timestamp.valueOf(pocetak);
        return rezervacijaRepository.findRezervacijaByDatumAndSteviloOseb(stevOseb, pocetakTimestamp);
    }


}
