package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Recenzija;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.service.RecenzijaService;

import java.util.List;

@RestController
@RequestMapping("/recenzije")
public class RecenzijaController {
    @Autowired
    private RecenzijaService recenzijaService;

    public RecenzijaService getRecenzijaService() {
        return recenzijaService;
    }

    @GetMapping("/imeocena/{ocena}")
    public List<Recenzija> getNaziviKlubovaZaRecenzijeSaOcenomManjomOd(@PathVariable int ocena) {
        return recenzijaService.findNaziveKlubovaZaRecenzijeSaOcenomManjomOd(ocena);
    }
    @GetMapping("/imepriimek/{ocena}")
    public List<Recenzija> findImeIPrezime(@PathVariable int ocena) {
        return recenzijaService.findImeIPrezime(ocena);
    }

    @GetMapping("/ocena-veca-od/{ocena}")
    public List<Recenzija> findRecenzijeSaOcenomVećomOd(@PathVariable int ocena) {
        return recenzijaService.findRecenzijeSaOcenomVećomOd(ocena);
    }
}
