package si.um.feri.ris.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class EmailSendController {
    private EmailService emailService;

    public EmailSendController(EmailService emailService) {
        this.emailService = emailService;
    }