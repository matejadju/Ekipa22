package si.um.feri.ris.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddUporabnikRequest;
import si.um.feri.ris.service.UporabnikService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    public List<Uporabnik> getALL() {
        return uporabnikService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Uporabnik> getById(@PathVariable("id") Integer id) {
        return uporabnikService.getById(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public Uporabnik addUporabnik(@RequestBody AddUporabnikRequest uporabnik) {
        return uporabnikService.save(uporabnik);
    }

    @PostMapping("/login/{email}/{geslo}")
    public String login(@PathVariable String email, @PathVariable String geslo, HttpServletResponse response) throws Exception {
        Uporabnik u = uporabnikService.authenticate(email, geslo);
            if (u != null) {
                String userInfoJson = "{\"email\": \"" + u.getEmail() + "\", \"id\": " + u.getIdUporabnik() + ", \"vrsta\": \"" + u.getVrsta() + "\"}";
                String encodedUserInfo = URLEncoder.encode(userInfoJson, "UTF-8");

                Cookie cookie = new Cookie("uporabnik", encodedUserInfo);
                cookie.setMaxAge(3600);
                cookie.setPath("/");
                response.addCookie(cookie);

                return "Uspesna prijava";
            } else {
                return "Prijava ni uspela! Uporabnik ni najden";
            }
    }
}
