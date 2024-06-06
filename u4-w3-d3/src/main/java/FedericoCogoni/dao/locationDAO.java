package FedericoCogoni.dao;



import FedericoCogoni.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class locationDAO {
    private final EntityManager em;

    public locationDAO(EntityManager em) {
        this.em = em;
    }

    public void save (Location location){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(location);
            transaction.commit();
            System.out.println("Location - " + location.getNome() + " - creata!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Location findById(UUID id) {
        return em.find(Location.class, id);

    }

    public void deleteById (UUID id) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            Location found = em.find(Location.class, id);
            if (found != null) {
                em.remove(found);
                t.commit();
                System.out.println("Location eliminata");
            } else System.out.println("Location non trovata");


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
