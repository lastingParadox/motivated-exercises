/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */


package baseline;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {
    @Test
    void hasNumberTest() {
        Password validator = new Password();

        String password = "batbatman24!";

        boolean actual = validator.hasNumber(password);

        assertTrue(actual);
    }

    @Test
    void hasLetterTest() {
        Password validator = new Password();

        String password = "batbatman24!";

        boolean actual = validator.hasLetter(password);

        assertTrue(actual);
    }

    @Test
    void hasSpecialTest() {
        Password validator = new Password();

        String password = "batbatman24!";

        boolean actual = validator.hasSpecial(password);

        assertTrue(actual);
    }

    @ParameterizedTest
    @CsvSource({"batbatman24!,4", "batbatman24,3", "batman,2", "1337,1", "j0k3r,0"})
    void passwordValidatorTest(String password, int expected) {
        Password validator = new Password();
        int actual = validator.passwordValidator(password);
        assertEquals(expected, actual);
    }}