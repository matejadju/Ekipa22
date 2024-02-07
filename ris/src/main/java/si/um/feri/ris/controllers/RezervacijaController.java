package si.um.feri.ris.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Rezervacija;
import si.um.feri.ris.service.RezervacijaService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/rezervacija")
public class RezervacijaController {
    private final RezervacijaService rezervacijaService;

    public RezervacijaController(RezervacijaService rezervacijaService) {
        this.rezervacijaService = rezervacijaService;
    }

    @Autowired
    public RezervacijaService getRezervacijaService(){
        return rezervacijaService;
    }

    @GetMapping
    public List<Rezervacija> getALL(){
        return rezervacijaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Rezervacija> getById(@PathVariable("id") Long id){
        return rezervacijaService.getById(id);
    }

    @PostMapping("/add")
    public Rezervacija createRezervacija(@RequestBody Rezervacija rezervacija){
        return rezervacijaService.createRezervacija(rezervacija);
    }

    @PutMapping("/{id}")
    public void updateRezervacija(@PathVariable Long id, @RequestBody Rezervacija novaRezervacija){
        rezervacijaService.updateRezervacija(id, novaRezervacija);
    }

    @DeleteMapping("/del/{id}")
    public void deleteRezervacija(@PathVariable Long id){
        rezervacijaService.deleteRezervacija(id);
    }


}
