package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.service.UporabnikService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {
    private final UporabnikService uporabnikService;

    @Autowired
    public UporabnikController(UporabnikService uporabnikService) {
        this.uporabnikService = uporabnikService;
    }

    @GetMapping
    public List<Uporabnik> getALL(){
        return uporabnikService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> getById(@PathVariable("id") Integer id){
        return uporabnikService.getById(id);
    }
}
