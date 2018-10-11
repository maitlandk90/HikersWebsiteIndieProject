package edu.matc.persistence;

import edu.matc.entity.HikingTrails;
import edu.matc.entity.HikerAccount;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTrailsDaoTest {

    HikingTrailsDao dao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {
        dao = new HikingTrailsDao();

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getAllHikingTrailsSuccess() {
        List<HikingTrails> HikingTrails = dao.getAllHikingTrails();
        assertEquals(1, HikingTrails.size());
    }

    @Test
    void getByIdSuccess() {
        HikingTrails retrievedHikingTrails = dao.getById(2);
        assertNotNull(retrievedHikingTrails);
        assertEquals("TrailHead1", retrievedHikingTrails.getTrailHeadName());
    }

    /**
     * Verifies a HikingTrails is returned correctly based on id search
     */
    @Test
    void getByIdVerifyHikerAccountSuccess() {
        HikingTrails retrievedHikingTrails = dao.getById(2);
        assertNotNull(retrievedHikingTrails);
        assertEquals("TrailHead1", retrievedHikingTrails.getTrailHeadName());
    }

    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        HikerAccountDao HikerAccountDao = new HikerAccountDao();
        HikerAccount HikerAccount = HikerAccountDao.getById(1);
        HikingTrails newHikingTrail = new HikingTrails( "Trailhead1", "long trail", 1, 5, 4, "Trees", "Greate for kids", HikerAccount);
        HikerAccount.addHikingTrail(newHikingTrail);

        int id = dao.insert(newHikingTrail);

        assertNotEquals(0, id);
        HikingTrails insertedHikingTrails = dao.getById(id);
        assertNotNull(insertedHikingTrails);
        assertEquals("Trailhead1", insertedHikingTrails.getTrailHeadName());
        assertNotNull(insertedHikingTrails.getHikerAccount());

    }

    /**
     * Verify successful delete of HikingTrails
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verify successful update of HikingTrails
     */
    @Test
    void updateSuccess() {
        String newTrailHeadName = "TrailHead3";
        HikingTrails HikingTrailsToUpdate = dao.getById(3);
        HikingTrailsToUpdate.setTrailHeadName(newTrailHeadName);
        dao.saveOrUpdate(HikingTrailsToUpdate);
        HikingTrails retrievedHikingTrails = dao.getById(3);
        assertEquals(newTrailHeadName, retrievedHikingTrails.getTrailHeadName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<HikingTrails> HikingTrails = dao.getByPropertyEqual("trailHeadName", "TrailHead1");
        assertEquals(1, HikingTrails.size());
        assertEquals(2, HikingTrails.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<HikingTrails> HikingTrails = dao.getByPropertyLike("description", "t");
        assertEquals(3, HikingTrails.size());
    }
}