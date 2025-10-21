package si.um.feri.ris;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import si.um.feri.ris.controllers.MizaController;
import si.um.feri.ris.models.Miza;
import si.um.feri.ris.repository.MizaRepository;
import si.um.feri.ris.service.MizaService;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = "spring.profiles.active=ci")
@Transactional
public class MizaControllerTest {

    @Autowired
    private MizaController mizaController;

    @Autowired
    private MizaService mizaService;

    @Autowired
    private MizaRepository mizaRepository;

    @BeforeEach
    void setup() {
        mizaRepository.deleteAll();
    }

    @Test void contextLoads() {
        Assertions.assertNotNull(mizaController);
        Assertions.assertNotNull(mizaService);
        Assertions.assertNotNull(mizaRepository);
    }

    // ✅ 1. GET ALL
    @Test
    void testGetAll() {
        System.out.println("=== TEST: getAll ===");

        // ✅ Pozitivan scenario
        Miza m1 = new Miza();
        m1.setStatus(true);
        Miza saved1 = mizaService.createMiza(m1);

        Miza m2 = new Miza();
        m2.setStatus(false);
        Miza saved2 = mizaService.createMiza(m2);

        System.out.println("Vhod: ");
        System.out.println(saved1);
        System.out.println(saved2);

        List<Miza> all = mizaController.getALL();
        System.out.println("Izhod: " + all);
        Assertions.assertEquals(2, all.size());

        // ❌ Negativan scenario — prazna tabela
        mizaRepository.deleteAll();
        List<Miza> emptyList = mizaController.getALL();
        System.out.println("Izhod: " + emptyList);
        Assertions.assertTrue(emptyList.isEmpty());
    }

    // ✅ 2. GET BY ID
    @Test
    void testGetById() {
        System.out.println("=== TEST: getById ===");

        // ✅ Pozitivan scenario
        Miza miza = new Miza();
        miza.setStatus(true);
        Miza saved = mizaService.createMiza(miza);
        System.out.println("Vhod: " + saved);

        Optional<Miza> found = mizaController.getById(saved.getIdMiza());
        System.out.println("Izhod: " + found);
        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals(saved.getIdMiza(), found.get().getIdMiza());

        // ❌ Negativan scenario — ID koji ne postoji
        Optional<Miza> notFound = mizaController.getById(9999L);
        System.out.println("Izhod: " + notFound);
        Assertions.assertFalse(notFound.isPresent());
    }

    // ✅ 3. CREATE
    @Test
    void testCreateMiza() {
        System.out.println("=== TEST: createMiza ===");

        // ✅ Pozitivan scenario
        Miza miza = new Miza();
        miza.setStatus(true);
        Miza created = mizaController.createMiza(miza);
        System.out.println("Vhod: " + created);
        Assertions.assertNotNull(created.getIdMiza());

        // ❌ Negativan scenario — kreiranje null objekta
        Assertions.assertThrows(ResponseStatusException.class, () -> {
            mizaController.createMiza(null);
        });
    }

    // ✅ 4. UPDATE
    @Test
    void testUpdateMiza() {
        System.out.println("=== TEST: updateMiza ===");

        // ✅ Pozitivan scenario
        Miza miza = new Miza();
        miza.setStatus(true);
        Miza saved = mizaService.createMiza(miza);
        System.out.println("Vhod: " + saved);

        Miza update = new Miza();
        update.setStatus(false);
        mizaController.updateMiza(saved.getIdMiza(), update);

        Optional<Miza> updated = mizaService.getById(saved.getIdMiza());
        System.out.println("Izhod: " + updated);
        Assertions.assertTrue(updated.isPresent());
        Assertions.assertFalse(updated.get().isStatus());

        // ❌ Negativan scenario — update nepostojeće mize
        Miza dummy = new Miza();
        dummy.setStatus(true);
        try {
            mizaController.updateMiza(9999L, dummy);
            Assertions.fail("Pri posodobitvi neobstoječe mize se pričakuje napaka!");
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }

    // ✅ 5. DELETE
    @Test
    void testDeleteMiza() {
        System.out.println("=== TEST: deleteMiza ===");

        // ✅ Pozitivan scenario
        Miza miza = new Miza();
        miza.setStatus(true);
        Miza saved = mizaService.createMiza(miza);
        System.out.println("Vhod: " + saved);

        mizaController.deleteMiza(saved.getIdMiza());
        Optional<Miza> deleted = mizaService.getById(saved.getIdMiza());
        System.out.println("Izhod: " + deleted);
        Assertions.assertFalse(deleted.isPresent());

        // ❌ Negativan scenario — brisanje nepostojeće mize
        try {
            mizaController.deleteMiza(9999L);
            Assertions.fail("Pri brisanju neobstoječe mize se pričakuje napaka!");
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
