package si.um.feri.ris.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;

import java.util.List;

public interface UporabnikRepository extends JpaRepository<Uporabnik, Integer> {

    @Query("SELECT u FROM Uporabnik u WHERE u.email = :email AND u.geslo = :geslo")
    List<Uporabnik> findByEmail(String email,  String geslo);
}
