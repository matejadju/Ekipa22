package si.um.feri.ris.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import si.um.feri.ris.models.Klub;
import si.um.feri.ris.repository.KlubRepository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class KlubService {

    private final KlubRepository klubRepository;

    @Autowired
    public KlubService(KlubRepository klubRepository) {
        this.klubRepository = klubRepository;
    }

    public List<Klub> dohvatiSveKlubove() {
        return klubRepository.findAll();
    }

    public Optional<Klub> dohvatiKlubPoId(Long id) {
        return klubRepository.findById(id);
    }

    public Klub spremiKlub(Klub klub) {
        return klubRepository.save(klub);
    }

    public void azurirajKlub(Long id, Klub noviKlub) {
        if (klubRepository.existsById(id)) {
            noviKlub.setIdKlub(id);
            klubRepository.save(noviKlub);
        }
    }

    public void obrisiKlub(Long id) {
        klubRepository.deleteById(id);
    }

    public List<Klub> dohvatiAktivneKluboveZaTipKluba(boolean status) {
        return klubRepository.findByStatusAndTipKlubaId(status);
    }
    public void createKlubAndGeneratePdf(Klub klub) throws DocumentException {
        // Save the klub to the database
        Klub savedKlub = klubRepository.save(klub);

        // Generate PDF with klub data
        ByteArrayOutputStream pdfStream = generatePdfForKlub(savedKlub);

        // Save or send the PDF as needed
        // For example, you can save it to a file or send it via email
        // For demonstration purposes, let's just print the PDF content
        System.out.println("Generated PDF content: " + pdfStream.toString());
    }

    private ByteArrayOutputStream generatePdfForKlub(Klub klub) throws DocumentException {
        // Create PDF content based on klub data
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Write klub data to the PDF
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        Paragraph paragraph = new Paragraph("Klub Details", boldFont);
        document.add(paragraph);
        document.add(new Paragraph("Name: " + klub.getNaziv()));
        document.add(new Paragraph("Location: " + klub.getAdresa()));
        // Add more klub data as needed

        document.close();
        return outputStream;
    }

    public List<Klub> findByStatus(){
        return klubRepository.findByStatus();
    }

    public ResponseEntity<Klub> updateStatus(Long id){
        return klubRepository.updateKlubStatus(id);
    }
}
