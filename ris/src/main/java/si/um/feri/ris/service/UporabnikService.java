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

    public void registerUser(String ime, String priimek, String email, Vrsta vrsta,
                             String geslo, int davcnaStevilka, int emso) {



        Uporabnik existingUser = uporabnikRepository.findByEmail(email);
        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }

        uporabnikRepository.insertUporabnik(ime, priimek, email, vrsta, geslo, davcnaStevilka, emso);
    }

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
