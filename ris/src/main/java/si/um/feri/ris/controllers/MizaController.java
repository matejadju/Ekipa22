package si.um.feri.ris.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import si.um.feri.ris.models.Miza;
import si.um.feri.ris.service.MizaService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/miza")
public class MizaController {

    private final MizaService mizaService;

    public MizaController(MizaService mizaService) {
        this.mizaService = mizaService;
    }

    @GetMapping
    public List<Miza> getAll() {
        return mizaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Miza> getById(@PathVariable Long id) {
        return mizaService.getById(id);
    }

    @PostMapping("/add")
    public Miza createMiza(@RequestBody Miza miza) {
        if (miza == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Miza is null!");
        }
        return mizaService.createMiza(miza);
    }

    @GetMapping("/dvap/{status}/{tipMizeMizaId}")
    public List<Miza> getByStatusAndTipMizeId(
            @PathVariable boolean status,
            @PathVariable Long tipMizeMizaId
    ) {
        return mizaService.findByStatusAndTipMizeId(status, tipMizeMizaId);
    }

    @PutMapping("/{id}")
    public void updateMiza(@PathVariable Long id, @RequestBody Miza novaMiza) {
        mizaService.updateMiza(id, novaMiza);
    }

    @DeleteMapping("/del/{id}")
    public void deleteMiza(@PathVariable Long id) {
        mizaService.deleteMiza(id);
    }

    @GetMapping("/MizePoSteviluOseba/{steviloOseb}")
    public List<Miza> dobaviStolove(@PathVariable int steviloOseb) {
        return mizaService.pronadjiStoloveSaViseOdOdredjenogBrojaOsoba(steviloOseb);
    }

    @GetMapping("/status/{status}")
    public List<Miza> findByStatus(@PathVariable boolean status) {
        return mizaService.findByStatus(status);
    }

    @GetMapping("/imemnad/{naziv}")
    public List<Miza> findByTipMize(@PathVariable String naziv) {
        return mizaService.findByTipMize(naziv);
    }

    @GetMapping("/stevo/{status}")
    public List<Miza> findByStevOseb(@PathVariable boolean status) {
        return mizaService.findByStevOseb(status);
    }

    @GetMapping("/stevm/{steviloMiz}")
    public List<Miza> findByStevMiz(@PathVariable int steviloMiz) {
        return mizaService.findByStevMiz(steviloMiz);
    }
}
