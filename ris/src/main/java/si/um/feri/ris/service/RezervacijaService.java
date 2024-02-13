package si.um.feri.ris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Rezervacija;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.repository.MizaRepository;
import si.um.feri.ris.repository.RezervacijaRepository;
import si.um.feri.ris.requests.AddRezervacijaRequest;
import si.um.feri.ris.repository.UserRepository;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
@Service
public class RezervacijaService {
    private final  UserRepository userRrepository;
    private RezervacijaRepository rezervacijaRepository;

    private final MizaRepository mizaRepository;

    public RezervacijaService(UserRepository userRrepository, RezervacijaRepository rezervacijaRepository, MizaRepository mizaRepository) {
        this.userRrepository = userRrepository;
        this.rezervacijaRepository = rezervacijaRepository;
        this.mizaRepository = mizaRepository;
    }

    public List<Rezervacija> getAll() {
        return (List<Rezervacija>) rezervacijaRepository.findAll();
    }

    public Optional<Rezervacija> getById(Long id) {
        return rezervacijaRepository.findById(id);
    }


    public Rezervacija createRezervacija(Rezervacija rezervacija) {
        return rezervacijaRepository.save(rezervacija);
    }

    public void updateRezervacija(Long id, Rezervacija novaRezervacija) {
        if (rezervacijaRepository.existsById(id)) {
            novaRezervacija.setIdRezervacija(id);
            rezervacijaRepository.save(novaRezervacija);
        }
    }

    public void deleteRezervacija(Long id) {
        rezervacijaRepository.deleteById(id);
    }

    public List<Rezervacija> dohvatiRezervacije(int stevOseb) {
        LocalDateTime pocetak = LocalDateTime.of(2024, 1, 1, 0, 0);
        Timestamp pocetakTimestamp = Timestamp.valueOf(pocetak);
        return rezervacijaRepository.findRezervacijaByDatumAndSteviloOseb(stevOseb, pocetakTimestamp);
    }

    public Rezervacija save(AddRezervacijaRequest rezervacija) {
        Rezervacija r = new Rezervacija();
        r.setDatum(rezervacija.getDatum());
        Optional<Uporabnik> u = userRrepository.findById((int) rezervacija.getUporabnik());
        if (u.isPresent()) {
            r.setUporabnik_rezervacija(u.get());
        }
        Optional<Miza> m = mizaRepository.findById((long) rezervacija.getMiza());
        if (m.isPresent()) {
            r.setMize(m.get());
        }
        r.setSteviloOseb(rezervacija.getSteviloOseb());
        r.setPoruka(rezervacija.getPoruka());
        return rezervacijaRepository.saveAndFlush(r);
    }

    private void posaljiEmail(Rezervacija rezervacija) {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        try {
            helper.setTo(rezervacija.getEmail());
            helper.setSubject("Potvrda rezervacije");
            helper.setText("Poštovani " + rezervacija.getIme() + ",\n\nVaša rezervacija je potvrđena.\n\nHvala Vam što ste nas izabrali.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(msg);
    }
    }



