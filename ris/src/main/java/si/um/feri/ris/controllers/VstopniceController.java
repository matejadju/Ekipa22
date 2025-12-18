package si.um.feri.ris.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import si.um.feri.ris.models.Vstopnice;
import si.um.feri.ris.service.VstopniceService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/vstopnica")
public class VstopniceController {

    private final VstopniceService vstopniceService;

    public VstopniceController(VstopniceService vstopniceService) {
        this.vstopniceService = vstopniceService;
    }

    @GetMapping("/UporabnikPoCeni/{cena}")
    public List<Vstopnice> dobaviKorisnike(@PathVariable int cena) {
        return vstopniceService.pronadjiKorisnikeSaCenomVstopnice(cena);
    }

    @GetMapping("/cena/{cena}")
    public List<Vstopnice> findByCena(@PathVariable float cena) {
        return vstopniceService.findByCena(cena);
    }
}
