/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solutions
 *  Copyright 2021 Zander Preston
 */

package baseline;

public class EmployeeValidator {

    private final String firstName;
    private final String lastName;
    private final String zipcode;
    private final String id;

    EmployeeValidator(String firstName, String lastName, String zipcode, String id) {
        //Constructor to take in the first name, last name, zipcode, and id
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.id = id;
    }

    public String validateFirst() {
        //Validates the first name, making sure it is at least 2 characters long and is filled in.
        StringBuilder temp = new StringBuilder();

        if (firstName.length() < 2)
            temp.append("The first name must be at least 2 characters long.\n");
        if (firstName.equals(""))
            temp.append("The first name must be filled in.\n");

        return String.valueOf(temp);
    }

    public String validateLast() {
        //Validates the last name, making sure it is at least 2 characters long and is filled in.
        StringBuilder temp = new StringBuilder();

        if (lastName.length() < 2)
            temp.append("The last name must be at least 2 characters long.\n");
        if (lastName.equals(""))
            temp.append("The last name must be filled in.\n");

        return String.valueOf(temp);
    }

    public String validateZip() {
        //Validates the zipcode, making sure it is at least 5 characters long and is numerical.
        StringBuilder temp = new StringBuilder();

        if (!zipcode.matches("\\d{5}"))
            temp.append("The zipcode must be a 5 digit number.\n");
        if (zipcode.equals(""))
            temp.append("The zipcode must be filled in.\n");

        return String.valueOf(temp);
    }

    public String validateID() {
        //Validates the employee id, making sure it is in the format AA-1234
        StringBuilder temp = new StringBuilder();

        if (!id.matches("[a-zA-Z]{2}-[0-9]{4}"))
            temp.append("The employee ID must be in the format of AA-1234.\n");
        if (id.equals(""))
            temp.append("The employee ID must be filled in.\n");

        return String.valueOf(temp);
    }

    public String validateInput() {
        //Appends all the errors to a string. If there are no errors, appends a "no error" message.
        String temp = validateFirst() + validateLast() + validateZip() + validateID();
        if (temp.equals(""))
            temp = "There were no errors found.";
        return temp;
    }
}
