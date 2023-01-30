/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Solution40Test {
    Solution40 test = new Solution40();

    @Test
    void createMapTest() {
        Map<String, String> expected = new HashMap<>();

        expected.put("first_name", "Bruce");
        expected.put("last_name", "Wayne");
        expected.put("position", "Batman");
        expected.put("sd", "Crime Alley");

        Map<String, String> actual = test.createMap("Bruce", "Wayne",
                "Batman", "Crime Alley");

        assertEquals(expected, actual);
    }

    @Test
    void sortMapTest() {
        List<Map<String, String>> actual = new ArrayList<>();

        Map<String, String> temp = test.createMap("Bruce", "Wayne",
                "Batman", "Crime Alley");
        actual.add(temp);

        temp = test.createMap("Harvey", "Dent", "Lawyer", "Two Face");
        actual.add(temp);

        temp = test.createMap("Harley", "Quinn", "Psychologist", "The Joker");
        actual.add(temp);

        test.sortList(actual);

        assertEquals("Dent", actual.get(0).get("last_name"));
        assertEquals("Quinn", actual.get(1).get("last_name"));
        assertEquals("Wayne", actual.get(2).get("last_name"));

    }

    @Test
    void mapContainsTest() {
        List<Map<String, String>> actualList = new ArrayList<>();

        Map<String, String> temp = test.createMap("Bruce", "Wayne",
                "Batman", "Crime Alley");
        actualList.add(temp);

        temp = test.createMap("Harvey", "Dent", "Lawyer", "Girlfriend Explosion");
        actualList.add(temp);

        temp = test.createMap("Harley", "Quinn", "Psychologist", "The Joker");
        actualList.add(temp);

        temp = test.createMap("Joker", "Hardeharhar", "Terrorist", "Ace Chemical Plant");
        actualList.add(temp);

        test.sortList(actualList);

        String response = "har";
        int actual = 0;
        for (Map<String, String> character : actualList) {
            if (character.get("last_name").toLowerCase().contains(response) ||
                    character.get("first_name").toLowerCase().contains(response)) {
                actual++;
            }
        }

        int expected = 3;

        assertEquals(expected, actual);

    }

}