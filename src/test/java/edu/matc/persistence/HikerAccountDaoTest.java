package edu.matc.persistence;

import edu.matc.entity.HikerAccount;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}