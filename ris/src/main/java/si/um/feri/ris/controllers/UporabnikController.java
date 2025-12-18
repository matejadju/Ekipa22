package si.um.feri.ris.controllers;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddUporabnikRequest;
import si.um.feri.ris.service.UporabnikService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/uporabnik")
public class UporabnikController {

    private final UporabnikService uporabnikService;

    public UporabnikController(UporabnikService uporabnikService) {
        this.uporabnikService = uporabnikService;
    }

    @GetMapping
    public List<Uporabnik> getAll() {
        return uporabnikService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> getById(@PathVariable Integer id) {
        return uporabnikService.getById(id);
    }

    @PostMapping("/add")
    public Uporabnik addUporabnik(@RequestBody AddUporabnikRequest uporabnik) {
        return uporabnikService.save(uporabnik);
    }

    @PostMapping("/login/{email}/{geslo}")
    public ResponseEntity<Map<String, String>> login(
            @PathVariable String email,
            @PathVariable String geslo,
            HttpServletResponse response
    ) throws Exception {

        Uporabnik u = uporabnikService.authenticate(email, geslo);

        Map<String, String> responseBody = new HashMap<>();

        if (u != null) {
            responseBody.put("id", String.valueOf(u.getIdUporabnik()));
            responseBody.put("email", u.getEmail());
            responseBody.put("vrsta", u.getVrsta().toString());
            responseBody.put("message", "Uspješna prijava");
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        } else {
            responseBody.put("message", "Neuspješna prijava");
            return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/email/{email}")
    public List<Uporabnik> findByEmail(@PathVariable String email) {
        return uporabnikService.findByEmail(email);
    }

    @PutMapping("/{telefon}/{id}")
    public void updateProfil(@PathVariable int telefon, @PathVariable Long id) {
        uporabnikService.updateProfil(telefon, id);
    }
}
