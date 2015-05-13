package ge.edu.geolab.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDao {

    private EntityManager _enEntityManager;

    public UserDao(EntityManager em) {
        _enEntityManager = em;
    }

    public List selectEntries(int pageNumber) {
        int pageSize = 100;
        Query qc = _enEntityManager.createQuery("from User");
        qc.setFirstResult(pageNumber * pageSize);
        qc.setMaxResults(pageSize);
        return qc.getResultList();
    }
}
