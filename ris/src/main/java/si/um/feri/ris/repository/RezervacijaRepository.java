package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import si.um.feri.ris.models.Rezervacija;

public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {
}
