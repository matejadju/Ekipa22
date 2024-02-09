package si.um.feri.ris.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.AddDogodekRequest;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.service.DogodekService;
import si.um.feri.ris.service.KlubService;

import java.util.List;

@RestController
@RequestMapping("/dogodek")
public class DogodekController {

    private final DogodekService dogodekService;
    @Autowired
    public DogodekController(DogodekService dogodekService) {
        this.dogodekService = dogodekService;
    }

    @GetMapping("/joj/{odobren}/{cenaVstopnice}")
    public List<Dogodek> findBydog(@PathVariable boolean odobren, @PathVariable Float cenaVstopnice) {
        return dogodekService.findBydog(odobren, cenaVstopnice);
    }

    @GetMapping("/cena/{cenaVstopnice}")
    public List<Dogodek> findByCena(@PathVariable Float cenaVstopnice){
        return dogodekService.findByCenaVstopnice(cenaVstopnice);
    }

   @PostMapping
    public Dogodek findByCena(@RequestBody AddDogodekRequest dogodek){
        return dogodekService.save(dogodek);
    }

    @GetMapping("/stmiz/{steviloMiz}")
    public List<Dogodek> findBySteviloMiz(@PathVariable int steviloMiz){
        return dogodekService.findBySteviloMiz(steviloMiz);
    }

}
