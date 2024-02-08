package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.repository.DogodekRepository;

import java.util.List;

@Service
public class DogodekService {


    private final DogodekRepository dogodekRepository;

    @Autowired
    public DogodekService(DogodekRepository dogodekRepository) {
        this.dogodekRepository = dogodekRepository;
    }

    public List<Dogodek> findBydog(boolean odobren, Float cenaVstopnice) {
        return dogodekRepository.findBydog(odobren, cenaVstopnice);
    }
}
