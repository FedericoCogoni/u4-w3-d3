package FedericoCogoni.dao;

import FedericoCogoni.entities.Evento;
import FedericoCogoni.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class eventoDAO {
    private final EntityManager em;

    public eventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Evento evento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(evento);
            transaction.commit();
            System.out.println("Evento - " + evento.getTitolo() + " - creato!");
        } catch (Exception e) {
            System.out.println((e.getMessage()));
        }
    }

    public Evento findById(UUID id) {
        return em.find(Evento.class, id);

    }

    public void deleteById (UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            Evento found = em.find(Evento.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Evento eliminato");
            } else System.out.println("Evento non trovato");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }}