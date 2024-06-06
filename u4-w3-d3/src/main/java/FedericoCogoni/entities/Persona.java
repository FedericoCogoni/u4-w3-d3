package FedericoCogoni.entities;


import FedericoCogoni.enums.Sesso;
import FedericoCogoni.enums.Stato;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue
    @OneToMany
    @JoinColumn(name = "persona")
    private UUID id;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate anno_di_nascita;
    @OneToMany(mappedBy = "persona")
    private List<Partecipazione> lista_partecipazioni;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

}
