package si.um.feri.ris.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.um.feri.ris.models.Dogodek;
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

}
