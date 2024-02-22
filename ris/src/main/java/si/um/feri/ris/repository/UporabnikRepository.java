package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.um.feri.ris.models.Uporabnik;

import java.util.List;

public interface UporabnikRepository extends JpaRepository<Uporabnik, Integer> {

    @Query("SELECT u FROM Uporabnik u WHERE u.email = :email AND u.geslo = :geslo")
    List<Uporabnik> findByEmailAndGeslo(String email, String geslo);

    @Query("SELECT u from Uporabnik u where u.email = :email")
    Uporabnik findByEmail(String email);
}
