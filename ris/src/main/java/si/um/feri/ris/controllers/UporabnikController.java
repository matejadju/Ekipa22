package si.um.feri.ris.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.requests.AddUporabnikRequest;
import si.um.feri.ris.service.UporabnikService;
import si.um.feri.ris.config.JwtHelper;

import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
public class UporabnikController {
    private final UporabnikService uporabnikService;
    private JwtHelper jwtHelper;

    @Autowired
    public UporabnikController(UporabnikService uporabnikService ) {
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
    public ResponseEntity<Map<String, String>> login(@PathVariable String email, @PathVariable String geslo, HttpServletResponse response) throws Exception {
        Uporabnik u = uporabnikService.authenticate(email, geslo);
        if (u != null) {
            String token = JwtHelper.generateToken(email);
            HttpHeaders headers = new HttpHeaders();
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("message", "Uspesna prijava");
            responseBody.put("token", "Bearer " + token);
            headers.add("Authorization", "Bearer " + token);
            return new ResponseEntity<>(responseBody, headers,HttpStatus.OK);
        } else {
            Map<String, String> responseBody = new HashMap<>();
            responseBody.put("message", "Prijava ni uspela! Uporabnik ni najden");
            return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
        }
    }

}
