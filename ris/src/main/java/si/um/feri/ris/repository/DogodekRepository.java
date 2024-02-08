package si.um.feri.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.um.feri.ris.models.Dogodek;
import si.um.feri.ris.models.Klub;

import java.util.List;

public interface DogodekRepository extends JpaRepository<Dogodek, Long> {


    @Query("SELECT d FROM Dogodek d WHERE d.steviloMiz > 5 AND d.odobren = true AND d.cenaVstopnice < 20.0 ")
    List<Dogodek> findBydog(boolean odobren, Float cenaVstopnice);

}