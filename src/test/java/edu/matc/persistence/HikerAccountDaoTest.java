package edu.matc.persistence;

import edu.matc.entity.HikerAccount;
import edu.matc.entity.HikingTrails;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikerAccountDaoTest {

    HikerAccountDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new HikerAccountDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getAllHikerAccountsSuccess() {
        List<HikerAccount> hikerAccounts = dao.getAllHikerAccounts();
        assertEquals(6, hikerAccounts.size());
    }

    @Test
    void getHikerAccountsByLastNameSuccess() {
        List<HikerAccount> hikerAccounts = dao.getHikerAccountsByLastName("c");
        assertEquals(3, hikerAccounts.size());
    }

    @Test
    void getByIdSuccess() {
        HikerAccount retrievedHikerAccount = dao.getById(1);
        assertNotNull(retrievedHikerAccount);
        assertEquals("Joe", retrievedHikerAccount.getFirstName());
    }

    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        HikerAccount newHiker = new HikerAccount("Fred", "Flintstone", "Madison", "WI","emailaddress1@hotmail.com",2);
        int id = dao.insert(newHiker);
        assertNotEquals(0, id);
        HikerAccount insertedHikerAccount = dao.getById(id);
        assertNotNull(insertedHikerAccount);
        assertEquals("Fred", insertedHikerAccount.getFirstName());
    }

    /**
     * Verify successful insert of a user and an order
     */
    /**@Test
    void insertWithOrderSuccess() {

        String hikingTrailName = "Trail2";
        HikerAccount newHiker = new HikerAccount("Barney", "Rubble", "Madison", "WI","emailaddress2@hotmail.com",2);
        HikingTrails hikingTrail = new HikingTrails(hikingTrailName, newHiker);

        newHiker.addHikingTrail(hikingTrail);

        int id = dao.insert(newHiker);

        assertNotEquals(0, id);
        HikerAccount insertedHiker = dao.getById(id);
        assertNotNull(insertedHiker);
        assertEquals("Fred", insertedHiker.getFirstName());
        assertEquals(1, insertedHiker.getHikingTrails().size());*/
}