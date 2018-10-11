package edu.matc.persistence;

import edu.matc.entity.HikingTrails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class HikingTrailsDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<HikingTrails> getAllHikingTrails() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrails> query = builder.createQuery(HikingTrails.class);
        Root<HikingTrails> root = query.from(HikingTrails.class);
        List<HikingTrails> HikingTrails = session.createQuery(query).getResultList();
        session.close();
        return(HikingTrails);
    }

    public List<HikingTrails> getHikingTrailsByTrailHeadName(String trailHeadName) {

        logger.debug("Searching for {}" + trailHeadName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrails> query = builder.createQuery(HikingTrails.class);
        Root<HikingTrails> root = query.from(HikingTrails.class);
        Expression<String> propertyPath = root.get("trailHeadName");
        query.where(builder.like(propertyPath, "%" + trailHeadName + "%"));
        List<HikingTrails> HikingTrails = session.createQuery(query).getResultList();
        session.close();
        return(HikingTrails);
    }

    /**
     * Gets a HikingTrails by id
     * @return a HikingTrails
     */

    public HikingTrails getById(int id) {

        Session session = sessionFactory.openSession();
        HikingTrails HikingTrails = session.get(HikingTrails.class, id);
        session.close();
        return HikingTrails;
    }


    /**
     * update HikingTrails
     * @param HikingTrails  HikingTrails to be inserted or updated
     */
    public void saveOrUpdate(HikingTrails HikingTrails) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(HikingTrails);
        session.close();
    }

    /**
     * update HikingTrails
     * @param HikingTrails  HikingTrails to be inserted or updated
     */
    public int insert(HikingTrails HikingTrails) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(HikingTrails);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a HikingTrails
     * @param HikingTrails HikingTrails to be deleted
     */
    public void delete(HikingTrails HikingTrails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(HikingTrails);
        transaction.commit();
        session.close();
    }


    /** Return a list of all HikingTrails
     *
     * @return All HikingTrails
     */
    public List<HikingTrails> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrails> query = builder.createQuery( HikingTrails.class );
        Root<HikingTrails> root = query.from( HikingTrails.class );
        List<HikingTrails> HikingTrails = session.createQuery( query ).getResultList();

        logger.debug("The list of HikingTrails " + HikingTrails);
        session.close();

        return HikingTrails;
    }

    /**
     * Get HikingTrails by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<HikingTrails> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for HikingTrails with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrails> query = builder.createQuery( HikingTrails.class );
        Root<HikingTrails> root = query.from( HikingTrails.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<HikingTrails> HikingTrails = session.createQuery( query ).getResultList();

        session.close();
        return HikingTrails;
    }

    /**
     * Get HikingTrails by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<HikingTrails> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for HikingTrails with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrails> query = builder.createQuery( HikingTrails.class );
        Root<HikingTrails> root = query.from( HikingTrails.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<HikingTrails> HikingTrails = session.createQuery( query ).getResultList();
        session.close();
        return HikingTrails;
    }

}
