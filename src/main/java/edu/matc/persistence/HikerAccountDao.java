package edu.matc.persistence;

import edu.matc.entity.HikerAccount;
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

public class HikerAccountDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<HikerAccount> getAllHikerAccounts() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikerAccount> query = builder.createQuery(HikerAccount.class);
        Root<HikerAccount> root = query.from(HikerAccount.class);
        List<HikerAccount> hikerAccounts = session.createQuery(query).getResultList();
        session.close();
        return(hikerAccounts);
    }

    public List<HikerAccount> getHikerAccountsByLastName(String lastName) {

        logger.debug("Searching for {}" + lastName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikerAccount> query = builder.createQuery(HikerAccount.class);
        Root<HikerAccount> root = query.from(HikerAccount.class);
        Expression<String> propertyPath = root.get("lastName");
        query.where(builder.like(propertyPath, "%" + lastName + "%"));
        List<HikerAccount> hikerAccounts = session.createQuery(query).getResultList();
        session.close();
        return(hikerAccounts);
    }

    /**
     * Gets a hiker account by id
     * @return a hiker account
     */

    public HikerAccount getById(int id) {

        Session session = sessionFactory.openSession();
        HikerAccount hikerAccount = session.get(HikerAccount.class, id);
        session.close();
        return hikerAccount;
    }


    /**
     * update hiker account
     * @param hikerAccount  Hiker Account to be inserted or updated
     */
    public void saveOrUpdate(HikerAccount hikerAccount) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(hikerAccount);
        session.close();
    }

    /**
     * update hiker acccount
     * @param hikerAccount  Hiker account to be inserted or updated
     */
    public int insert(HikerAccount hikerAccount) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(hikerAccount);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a hiker account
     * @param hikerAccount Hiker account to be deleted
     */
    public void delete(HikerAccount hikerAccount) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(hikerAccount);
        transaction.commit();
        session.close();
    }


    /** Return a list of all hiker accounts
     *
     * @return All hiker accounts
     */
    public List<HikerAccount> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikerAccount> query = builder.createQuery( HikerAccount.class );
        Root<HikerAccount> root = query.from( HikerAccount.class );
        List<HikerAccount> hikerAccounts = session.createQuery( query ).getResultList();

        logger.debug("The list of hiker accounts " + hikerAccounts);
        session.close();

        return hikerAccounts;
    }

    /**
     * Get hiker account by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<HikerAccount> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for hiker account with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikerAccount> query = builder.createQuery( HikerAccount.class );
        Root<HikerAccount> root = query.from( HikerAccount.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<HikerAccount> hikerAccounts = session.createQuery( query ).getResultList();

        session.close();
        return hikerAccounts;
    }

    /**
     * Get hiker account by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<HikerAccount> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for hiker account with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikerAccount> query = builder.createQuery( HikerAccount.class );
        Root<HikerAccount> root = query.from( HikerAccount.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<HikerAccount> hikerAccounts = session.createQuery( query ).getResultList();
        session.close();
        return hikerAccounts;
    }

}