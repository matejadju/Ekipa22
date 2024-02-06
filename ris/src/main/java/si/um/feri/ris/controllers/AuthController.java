package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.service.UserService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "", allowedHeaders = "*")
@RestController
@RequestMapping("/uporabnik")
public class AuthController {
    private  final  UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<Uporabnik> all(){
        return userService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Uporabnik> all(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/novUporabnik")
    public @ResponseBody Uporabnik newUporabnik(@RequestBody Uporabnik uporabnik) {
        return userService.novUporabnik(uporabnik);
    }

    @PostMapping("/registracija")
    public ResponseEntity<String> registerUser(@RequestBody Uporabnik uporabnik) {
        userService.registerUser(uporabnik.getIme(), uporabnik.getPriimek(), uporabnik.getEmail(),
                uporabnik.getVrsta(), uporabnik.getGeslo(),
                uporabnik.getDavcnaStevilka(), uporabnik.getEmso());
        return ResponseEntity.ok("Registration successful");
    }
}
