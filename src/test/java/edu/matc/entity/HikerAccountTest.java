package edu.matc.entity;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HikerAccountTest {

    @Test
    void getEmailAddress() {
        // create the object that has the method that I want to test
        HikerAccount hikerAccount = new HikerAccount();

        // set the email address of the hiker
        String emailAddress = "kskippy77@hotmail.com";
        hikerAccount.setEmailAddress(emailAddress);

        // create a variable for the expected value
        String expectedEmailAddress = "kskippy77@hotmail.com";

        // call the method and get the actual value"
        String actualEmailAddress = hikerAccount.getEmailAddress();

        // compare the two, pass or fail
        assertEquals(expectedEmailAddress, actualEmailAddress);
    }
}
