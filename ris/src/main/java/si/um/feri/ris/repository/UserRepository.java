package si.um.feri.ris.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import si.um.feri.ris.models.Uporabnik;
import si.um.feri.ris.models.Vrsta;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Uporabnik, Long> {

    @Query("INSERT INTO Uporabnik (ime, priimek, email, vrsta, geslo, davcnaStevilka, emso) " +
            "VALUES (:ime, :priimek, :email, :vrsta, :geslo, :davcnaStevilka, :emso)")
    @Modifying
    @Transactional
    void insertUporabnik(@Param("ime") String ime,
                         @Param("priimek") String priimek,
                         @Param("email") String email,
                         @Param("vrsta") Vrsta vrsta,
                         @Param("geslo") String geslo,
                         @Param("davcnaStevilka") int davcnaStevilka,
                         @Param("emso") int emso);

    Uporabnik findByEmail(String email);

    @Query("SELECT u FROM Uporabnik u WHERE u.priimek LIKE CONCAT(:priimekPrefix, '%') AND u.ime LIKE CONCAT(:imePrefix, '%') AND u.email LIKE CONCAT(:emailPrefix, '%')")
    List<Uporabnik> findByPriimekAndImeAndEmail(@Param("priimekPrefix") String priimekPrefix, @Param("imePrefix") String imePrefix, @Param("emailPrefix") String emailPrefix);
}