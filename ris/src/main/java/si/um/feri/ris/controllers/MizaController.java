//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//iimport java.util.List;
//
//@RestController
//@RequestMapping("/api/mize")
//public class MizaController {
//
//    private final MizaService mizaService;
//
//    @Autowired
//    public MizaController(MizaService mizaService) {
//        this.mizaService = mizaService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Miza>> getAllMize() {
//        List<Miza> mize = mizaService.getAllMize();
//        return ResponseEntity.ok(mize);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Miza> getMizaById(@PathVariable Long id) {
//        Miza miza = mizaService.getMizaById(id);
//        if (miza != null) {
//            return ResponseEntity.ok(miza);
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<String> addMiza(@RequestBody Miza miza) {
//        mizaService.addMiza(miza);
//        return ResponseEntity.ok("Miza added successfully");
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<String> updateMiza(@PathVariable Long id, @RequestBody Miza updatedMiza) {
//        if (mizaService.updateMiza(id, updatedMiza)) {
//            return ResponseEntity.ok("Miza updated successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteMiza(@PathVariable Long id) {
//        if (mizaService.deleteMiza(id)) {
//            return ResponseEntity.ok("Miza deleted successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @GetMapping("/custom-query")
//    public ResponseEntity<List<Miza>> customQuery(@RequestParam("param1") String param1, @RequestParam("param2") String param2) {
//        List<Miza> result = mizaService.customQuery(param1, param2);
//        return ResponseEntity.ok(result);
//    }
//}
