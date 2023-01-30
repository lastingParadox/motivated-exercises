/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution37Test {

    Solution37 test = new Solution37();

    @Test
    void createAlphabet() {
        Character[] expectedArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S',
                                     'T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l',
                                     'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        List<Character> expected = new ArrayList<>();
        Collections.addAll(expected, expectedArray);

        List<Character> actual = test.createAlphabet();

        assertEquals(expected, actual);
    }

    @Test
    void createSpecialList() {
        Character[] expectedArray = {'!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=',
                                     '>','?','@','[','\\',']','^','_','`','{','|','}','~'};
        List<Character> expected = new ArrayList<>();
        Collections.addAll(expected, expectedArray);

        List<Character> actual = test.createSpecialList();

        assertEquals(expected, actual);
    }

    @Test
    void createNumberList() {
        Integer[] expectedArray = {0,1,2,3,4,5,6,7,8,9};

        List<Integer> expected = new ArrayList<>();
        Collections.addAll(expected, expectedArray);

        List<Integer> actual = test.createNumberList();

        assertEquals(expected, actual);
    }

}