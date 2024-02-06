package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import si.um.feri.ris.models.Klub;



public interface KlubRepository extends JpaRepository<Klub, Long> {

}