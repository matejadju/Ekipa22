package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.service.UporabnikService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "", allowedHeaders = "*")
@RestController
@RequestMapping
public class AuthController {
    private  final UporabnikService uporabnikService;

    @Autowired
    public AuthController(UporabnikService uporabnikService){
        this.uporabnikService = uporabnikService;
    }

    @GetMapping("/all")
    public List<Uporabnik> all(){
        return uporabnikService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Uporabnik> all(@PathVariable("id") Integer id) {
        return uporabnikService.getById(id);
    }

    @PostMapping("/novUporabnik")
    public @ResponseBody Uporabnik newUporabnik(@RequestBody Uporabnik uporabnik) {
        return uporabnikService.novUporabnik(uporabnik);
    }

    @PostMapping("/registracija")
    public ResponseEntity<String> registerUser(@RequestBody Uporabnik uporabnik) {
        uporabnikService.registerUser(uporabnik.getIme(), uporabnik.getPriimek(), uporabnik.getEmail(),
                uporabnik.getVrsta(), uporabnik.getGeslo(),
                uporabnik.getDavcnaStevilka(), uporabnik.getEmso());
        return ResponseEntity.ok("Registration successful");
    }
}
