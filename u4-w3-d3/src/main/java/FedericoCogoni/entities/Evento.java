package FedericoCogoni.entities;

import FedericoCogoni.enums.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "eventi")

public class Evento {

    @Id
    @GeneratedValue
    private UUID id;
    private String titolo;
    private LocalDate data_evento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoEvento evento;
    private int numero_massimo_partecipanti;
    @ManyToOne
    @JoinColumn(name = "id_location")
    private Location location;
    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> lista_partecipazioni;

    public Evento () {}

    public Evento(String titolo, LocalDate data_evento, String descrizione, TipoEvento evento, int numero_massimo_partecipanti, Location id_location) {
        this.titolo = titolo;
        this.data_evento = data_evento;
        this.descrizione = descrizione;
        this.evento = evento;
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData_evento() {
        return data_evento;
    }

    public void setData_evento(LocalDate data_evento) {
        this.data_evento = data_evento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getEvento() {
        return evento;
    }

    public void setEvento(TipoEvento evento) {
        this.evento = evento;
    }

    public int getNumero_massimo_partecipanti() {
        return numero_massimo_partecipanti;
    }

    public void setNumero_massimo_partecipanti(int numero_massimo_partecipanti) {
        this.numero_massimo_partecipanti = numero_massimo_partecipanti;
    }

    public Location getIlocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", data_evento=" + data_evento +
                ", descrizione='" + descrizione + '\'' +
                ", evento=" + evento +
                ", numero_massimo_partecipanti=" + numero_massimo_partecipanti +
                ", location=" + location +
                '}';
    }
}
