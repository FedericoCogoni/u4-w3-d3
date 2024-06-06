package FedericoCogoni.entities;


import FedericoCogoni.enums.Sesso;
import FedericoCogoni.enums.Stato;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "partecipazione")
public class Partecipazione {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @Enumerated(EnumType.STRING)
    private Stato stato;

}
