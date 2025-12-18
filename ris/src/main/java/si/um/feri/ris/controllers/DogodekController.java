package si.um.feri.ris.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.requests.AddDogodekRequest;
import si.um.feri.ris.service.DogodekService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/dogodek")
public class DogodekController {

    private final DogodekService dogodekService;

    public DogodekController(DogodekService dogodekService) {
        this.dogodekService = dogodekService;
    }

    @GetMapping("/cena/{cenaVstopnice}")
    public List<Dogodek> findByCena(@PathVariable int cenaVstopnice) {
        return dogodekService.findByCenaVstopnice(cenaVstopnice);
    }

    @PostMapping("/add")
    public Dogodek createDogodek(@RequestBody AddDogodekRequest dogodek) {
        return dogodekService.save(dogodek);
    }

    @GetMapping("/stmiz/{steviloMiz}")
    public List<Dogodek> findBySteviloMiz(@PathVariable int steviloMiz) {
        return dogodekService.findBySteviloMiz(steviloMiz);
    }

    @GetMapping("/odobren")
    public List<Dogodek> findAllByOdobren() {
        return dogodekService.findAllByOdobren();
    }

    @GetMapping("/{uporabnikId}")
    public List<Dogodek> findByUporabnikId(@PathVariable int uporabnikId) {
        return dogodekService.findByUporabnikId(uporabnikId);
    }
}
