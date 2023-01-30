/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.util.List;
import java.util.Random;

public class Password {

    private final List<Character> alphabetList;
    private final List<Character> specialList;
    private final List<Integer> numberList;

    Random random = new Random();

    Password(List<Character> alphabet, List<Character> special, List<Integer> numbers) {
        //Password Constructor
        alphabetList = alphabet;
        specialList = special;
        numberList = numbers;
    }

    public String createPassword(int minLength, int numSpecial, int numNumbers) {
        //Creates a randomly generated password with the constraints provided.

        //The number of letters must at least match the number of numbers and special characters.
        int numCharacters = Math.max(2 * (numSpecial + numNumbers), minLength);

        int roll;
        int specialCnt = 0;
        int numCnt = 0;
        StringBuilder password = new StringBuilder();

        //Password building loop
        while(true) {
            //Breaks the loop if the special count equals the number of special characters,
            //  the number count equals the number of digits, and the length is greater than or equal to
            //  the minimum length.
            if(specialCnt == numSpecial && numCnt == numNumbers && password.length() >= numCharacters)
                break;
            else {
                roll = random.nextInt(3);
                //0 = special character is input
                if(roll == 0 && specialCnt != numSpecial) {
                    specialCnt++;
                    password.append(specialList.get(random.nextInt(specialList.size())));
                }
                //1 = number is input
                else if(roll == 1 && numCnt != numNumbers) {
                    numCnt++;
                    password.append(numberList.get(random.nextInt(numberList.size())));
                }
                //2 = letter is input
                else
                    password.append(alphabetList.get(random.nextInt(alphabetList.size())));
            }
        }

        return String.valueOf(password);
    }
}
