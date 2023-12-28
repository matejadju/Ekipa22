package si.um.feri.ris.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Recenzija;
import si.um.feri.ris.models.Uporabnik;

import java.util.Optional;

public interface RecenzijaRepository extends CrudRepository<Recenzija, Long> {

    @Query("SELECT r.uporabnik_recenzije FROM Recenzija r " +
            "WHERE r.klub_recenzija.naziv = :Niagara " +
            "AND r.ocena = 5 " +
            "AND r.uporabnik_recenzije.ime = :Marko")
    Optional<Uporabnik> findUporabnikByRecenzijaDetails(
            @Param("klubNaziv") String klubNaziv,
            @Param("imeUporabnika") String imeUporabnika
    );
}
