package si.um.feri.ris.service;

import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.repository.MizaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MizaService {

    private final MizaRepository mizaRepository;

    public MizaService(MizaRepository mizaRepository) {
        this.mizaRepository = mizaRepository;
    }

    public List<Miza> getAll() {
        return (List<Miza>) mizaRepository.findAll();
    }

    public Optional<Miza> getById(Long id) {
        return mizaRepository.findById(id);
    }

    // 🔧 NAMING FIX (PMD)
    public List<Miza> findByStatusAndTipMizeId(boolean status, Long tipMizeMizaId) {
        return mizaRepository.findByStatusAndTipMizeId(status, tipMizeMizaId);
    }

    public Miza createMiza(Miza miza) {
        if (miza == null) {
            throw new IllegalArgumentException("Miza is null!");
        }
        return mizaRepository.save(miza);
    }

    public void updateMiza(Long id, Miza novaMiza) {
        if (mizaRepository.existsById(id)) {
            novaMiza.setIdMiza(id);
            mizaRepository.save(novaMiza);
        }
    }

    public void deleteMiza(Long id) {
        mizaRepository.deleteById(id);
    }

    public List<Miza> pronadjiStoloveSaViseOdOdredjenogBrojaOsoba(int steviloOseb) {
        return mizaRepository.pronadjiStoloveSaViseOdOdredjenogBrojaOsoba(steviloOseb);
    }

    public List<Miza> findByStatus(boolean status) {
        return mizaRepository.findAllByStatus(status);
    }

    public List<Miza> findByTipMize(String naziv) {
        return mizaRepository.findByTipMize(naziv);
    }

    public List<Miza> findByStevOseb(boolean status) {
        return mizaRepository.findByStevOseb(status);
    }

    public List<Miza> findByStevMiz(int steviloMiz) {
        return mizaRepository.findByStevMiz(steviloMiz);
    }
}
