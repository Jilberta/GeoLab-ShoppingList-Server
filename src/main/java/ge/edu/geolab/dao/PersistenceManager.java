package ge.edu.geolab.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

    private static final Logger logger = LoggerFactory.getLogger(PersistenceManager.class.getName());
    private static final PersistenceManager instance = new PersistenceManager();

    private EntityManagerFactory emf;

    public static PersistenceManager getInstance() {
        return instance;
    }

    private PersistenceManager() {
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public EntityManagerFactory openEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("PU");
            logger.info("-- PersistenceContext initialized");
        }
        return emf;
    }

    public void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            logger.info("-- PersistenceContext destroyed");
        }
    }
}
