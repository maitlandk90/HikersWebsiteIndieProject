package edu.matc.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HikerAccountTest {

    @Test
    void getAge() {
        // create the object that has the method that I want to test
        HikerAccount hikerAccount = new HikerAccount();

        // set birthdate for the user
        LocalDate birthdate = LocalDate.parse("1968-01-01");
        hikerAccount.setDateOfBirth(birthdate);

        // create a variable for the expected value
        int expectedAge = 50;

        // call the method and get the actual value
        int actualAge = hikerAccount.getAge();

        // compare the two, pass or fail
        assertEquals(expectedAge, actualAge);
    }
}
