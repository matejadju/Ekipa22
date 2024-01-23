package si.um.feri.ris.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import si.um.feri.ris.models.Rezervacija;

import java.util.List;

public interface RezervacijaRepository extends CrudRepository<Rezervacija ,Long> {

    @Query("SELECT r FROM Rezervacija r " +
            "JOIN r.mize m " +
            "JOIN m.tip_mize_miza tm " +
            "JOIN m.dogodek_miza d " +
            "WHERE d.steviloVstopnica > 20 " +
            "AND tm.id = 3 " +
            "AND d.cenaVstopnice > 10")
    List<Rezervacija> getRezervacijeSaUvjetima();
}
