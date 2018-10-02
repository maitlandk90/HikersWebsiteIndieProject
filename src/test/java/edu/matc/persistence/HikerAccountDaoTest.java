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
    void getAllUsersSuccess() {
        List<HikerAccount> users = dao.getAllHikerAccounts();
        assertEquals(6, users.size());
    }

    @Test
    void getUsersByLastNameSuccess() {
        List<HikerAccount> users = dao.getHikerAccountsByLastName("c");
        assertEquals(3, users.size());
    }

    @Test
    void getByIdSuccess() {
        HikerAccount retrievedUser = dao.getById(3);
        assertNotNull(retrievedUser);
        assertEquals("Barney", retrievedUser.getFirstName());
    }
}