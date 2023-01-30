/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    Solution37 testLister = new Solution37();

    List<Character> alphabet = testLister.createAlphabet();
    List<Character> specialList = testLister.createSpecialList();
    List<Integer> numList = testLister.createNumberList();

    Password test = new Password(alphabet, specialList, numList);

    @Test
    void createPasswordTest() {

        String actualPass = test.createPassword(8, 1, 1);

        int actual = 0;
        if (actualPass.matches(".*\\d.*"))
            actual++;
        if (actualPass.matches(".*[a-zA-Z].*"))
            actual++;
        if (actualPass.matches(".*[*.!@#$%^&(){}\\[\\]:\";'<>,?/~`_+\\-=|].*"))
            actual++;
        if (actualPass.length() >= 8)
            actual++;
        int expected = 4;

        assertEquals(expected, actual);
    }
}