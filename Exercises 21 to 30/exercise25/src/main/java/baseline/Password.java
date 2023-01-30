/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */


package baseline;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    public boolean hasNumber(String password) {
        //Reads password for any numbers. Returns whether it does.
        Pattern number = Pattern.compile("[0-9]");
        Matcher hasNumber = number.matcher(password);
        return hasNumber.find();
    }

    public boolean hasLetter(String password) {
        //Reads password for any letters. Returns whether it does.
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Matcher hasLetter = letter.matcher(password);
        return hasLetter.find();
    }

    public boolean hasSpecial(String password) {
        //Reads password for any special characters. Returns whether it does.
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(password);
        return hasSpecial.find();
    }

    private int greaterPasswordAssigner(boolean number, boolean letter, boolean special) {
        //Returns a number based on various circumstances of a password greater than eight characters.
        //Used only in passwordValidator(password) and for organization.

        //Whereas 0 = "unknown", 1 = "very weak", 2 = "weak", 3 = "strong", 4 = "very strong":
            if (number && letter && special)
                return 4;
            else if ((number && special) || (letter && special))
                return 0;
            else if (number && letter)
                return 3;
            else
                return 0;
    }

    private int lesserPasswordAssigner(boolean number, boolean letter, boolean special) {
        //Returns a number based on various circumstances of a password lesser than eight characters.
        //Used only in passwordValidator(password) and for organization.

        //Whereas 0 = "unknown", 1 = "very weak", 2 = "weak", 3 = "strong", 4 = "very strong":
            if (special || (number && letter))
                return 0;
            else if (number)
                return 1;
            else if (letter)
                return 2;
            else
                return 0;
    }

    public int passwordValidator(String password) {
        //Returns a number based on the criteria identified in the password strength indicator:
            //0: If a password does not meet any of the following rules, then report it as a password of unknown strength.
            //1: A very weak password contains only numbers and is fewer than eight characters.
            //2: A weak password contains only letters and is fewer than eight characters.
            //3: A strong password contains letters and at least one number and is at least eight characters.
            //4: A very strong password contains letters, numbers, and special characters and is at least eight characters.

        boolean number = hasNumber(password);
        boolean letter = hasLetter(password);
        boolean special = hasSpecial(password);

        if (password.length() >= 8)
            return greaterPasswordAssigner(number, letter, special);
        else
            return lesserPasswordAssigner(number, letter, special);
    }
}