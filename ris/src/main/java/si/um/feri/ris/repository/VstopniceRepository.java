package si.um.feri.ris.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;
import si.um.feri.ris.models.Vstopnice;

import java.util.List;

public interface VstopniceRepository extends JpaRepository<Vstopnice, Long> {
    @Query("SELECT u.ime, u.priimek " +
            "FROM Vstopnice v " +
            "JOIN v.uporabnikSet u " +
            "WHERE v.cena = :cena")
    List<Vstopnice> pronadjiKorisnikeSaCenomVstopnice( int cena);
}


