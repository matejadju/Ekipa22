package si.um.feri.ris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Uporabnik> getALL(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> getById(@PathVariable("id") Integer id){
        return userService.getById(id);
    }

    @GetMapping("/uporabnici/{priimekPrefix}/{imePrefix}/{emailPrefix}")
    public List<Uporabnik> findByPriimekAndImeAndEmail(@PathVariable String priimekPrefix, @PathVariable String imePrefix, @PathVariable String emailPrefix) {
        return userService.findByPriimekAndImeAndEmail(priimekPrefix, imePrefix, emailPrefix);
    }

}
