package si.um.feri.ris.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.um.feri.ris.models.Recenzija;
import si.um.feri.ris.service.RecenzijaService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recenzije")
public class RecenzijaController {

    private final RecenzijaService recenzijaService;

    public RecenzijaController(RecenzijaService recenzijaService) {
        this.recenzijaService = recenzijaService;
    }

    @GetMapping("/imeocena/{ocena}")
    public List<Recenzija> getNaziviKlubovaZaRecenzijeSaOcenomManjomOd(
            @PathVariable int ocena
    ) {
        return recenzijaService.findNaziveKlubovaZaRecenzijeSaOcenomManjomOd(ocena);
    }

    @GetMapping("/imepriimek/{ocena}")
    public List<Recenzija> findImeIPrezime(@PathVariable int ocena) {
        return recenzijaService.findImeIPrezime(ocena);
    }

    @GetMapping("/ocena/{ocena}")
    public List<Recenzija> findByOcena(@PathVariable int ocena) {
        return recenzijaService.findByOcena(ocena);
    }
}
