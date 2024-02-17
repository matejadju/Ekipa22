package si.um.feri.ris.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.models.Recenzija;
import si.um.feri.ris.models.Uporabnik;

import java.util.List;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Long> {


    @Query("SELECT r FROM Recenzija r JOIN fetch r.klub_recenzija k WHERE r.ocena < :ocena")
    List<Recenzija> findNaziveKlubovaZaRecenzijeSaOcenomManjomOd(int ocena);

    @Query("SELECT r FROM Recenzija r JOIN fetch r.uporabnik_recenzije u WHERE r.ocena = :ocena")
    List<Recenzija> findImeIPrezime(int ocena);

    @Query("SELECT r FROM Recenzija r JOIN FETCH r.uporabnik_recenzije u JOIN FETCH r.klub_recenzija k WHERE r.ocena > :ocena")
    List<Recenzija> findByOcenaGreaterThan(int ocena);
}