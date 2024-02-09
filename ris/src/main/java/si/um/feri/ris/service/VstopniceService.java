package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vstopnice;
import si.um.feri.ris.repository.MizaRepository;
import si.um.feri.ris.repository.UserRepository;
import si.um.feri.ris.repository.VstopniceRepository;

import java.util.List;
import java.util.Optional;
@Service
public class VstopniceService {
    @Autowired
    private VstopniceRepository vstopniceRepository;

    public List<Vstopnice> pronadjiKorisnikeSaCenomVstopnice(int cena) {
        return vstopniceRepository.pronadjiKorisnikeSaCenomVstopnice(cena);
    }

    public List<Vstopnice> findByCena(float cena){
        return vstopniceRepository.findAllByCena(cena);
    }

}
