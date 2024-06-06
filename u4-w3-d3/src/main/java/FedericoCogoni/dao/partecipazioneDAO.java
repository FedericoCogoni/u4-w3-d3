package FedericoCogoni.dao;

import FedericoCogoni.entities.Partecipazione;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class partecipazioneDAO {
    private EntityManager em;

    public partecipazioneDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Partecipazione partecipazione) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(partecipazione);
            t.commit();
            System.out.println("Partecipazione all'evento " + Partecipazione.getEvento() + " per la persona " + Partecipazione.getPersona().getCognome() + ", creata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Partecipazione findById(UUID id) {
        return em.find(Partecipazione.class, id);
    }

    public void findByIdAndDelete(UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Partecipazione found = em.find(Partecipazione.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Partecipazione cancellata");
            } else System.out.println("Partecipazione non trovata");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}