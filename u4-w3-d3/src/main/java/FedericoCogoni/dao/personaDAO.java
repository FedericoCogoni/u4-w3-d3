package FedericoCogoni.dao;


import FedericoCogoni.entities.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class personaDAO {
    private EntityManager em;

    public personaDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Persona persona) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(persona);
            t.commit();
            System.out.println(persona.getNome() + " " + persona.getCognome() + " creato!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Persona findById(long id) {
        return em.find(Persona.class, id);
    }

    public void findByIdAndDelete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Persona found = em.find(Persona.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Persona eliminata");
            } else System.out.println("Persona non trovata");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

