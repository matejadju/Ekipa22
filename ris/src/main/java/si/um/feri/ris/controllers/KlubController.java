package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.service.KlubService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/klub")
public class KlubController {

    private final KlubService klubService;

    @Autowired
    public KlubController(KlubService klubService) {
        this.klubService = klubService;
    }

    @GetMapping
    public List<Klub> dohvatiSveKlubove() {
        return klubService.dohvatiSveKlubove();
    }

    @GetMapping("/{id}")
    public Optional<Klub> dohvatiKlub(@PathVariable Long id) {
        return klubService.dohvatiKlubPoId(id);
    }

    @PostMapping
    public Klub spremiKlub(@RequestBody Klub klub) {
        return klubService.spremiKlub(klub);
    }

    @PutMapping("/{id}")
    public void azurirajKlub(@PathVariable Long id, @RequestBody Klub noviKlub) {
        klubService.azurirajKlub(id, noviKlub);
    }

    @DeleteMapping("/{id}")
    public void obrisiKlub(@PathVariable Long id) {
        klubService.obrisiKlub(id);
    }
}