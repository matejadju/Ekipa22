package si.um.feri.ris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;
import si.um.feri.ris.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(String ime, String priimek, String email, Vrsta vrsta,
                             String geslo, int davcnaStevilka, int emso) {



        Uporabnik existingUser = userRepository.findByEmail(email);
        if (existingUser != null) {
            throw new RuntimeException("Email already exists");
        }

        userRepository.insertUporabnik(ime, priimek, email, vrsta, geslo, davcnaStevilka, emso);
    }

    @ResponseBody
    public List<Uporabnik> getAll() {
        return (List<Uporabnik>) userRepository.findAll();
    }

    @ResponseBody
    public Optional<Uporabnik> getById(int id){
        return userRepository.findById(id);
    }

    public Uporabnik novUporabnik(Uporabnik uporabnik) {
        return userRepository.saveAndFlush(uporabnik);
    }
}
