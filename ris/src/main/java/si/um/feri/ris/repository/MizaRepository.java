package si.um.feri.ris.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;

import java.util.List;


public interface MizaRepository extends JpaRepository<Miza, Long> {




    @Query("SELECT m FROM Miza m WHERE m.status = :status AND m.tip_mize_miza.id = :tip_mize_miza_id")
    List<Miza> findByStatusAndTipMizeId(boolean status, Long tip_mize_miza_id);


}

