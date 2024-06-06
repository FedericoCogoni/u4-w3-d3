package FedericoCogoni;

import FedericoCogoni.dao.eventoDAO;
import FedericoCogoni.dao.locationDAO;
import FedericoCogoni.entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d3");
    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        locationDAO sd = new locationDAO(em);
        Location location1 = new Location("prova1", "cagliari");
        Location location2 = new Location("prova2", "cagliari");
        //sd.save(location1);
        //sd.save(location2);
    }
}
