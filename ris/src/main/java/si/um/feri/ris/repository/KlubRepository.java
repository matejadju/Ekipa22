package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.um.feri.ris.models.Klub;

import java.util.List;


public interface KlubRepository extends JpaRepository<Klub, Long> {

    @Query("SELECT k FROM Klub k WHERE k.status = true AND k.tip_kluba.idTipKluba = 1")
    List<Klub> findByStatusAndTipKlubaId(boolean status);
}