package si.um.feri.ris.controllers;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Dogodek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iddogodek;
}