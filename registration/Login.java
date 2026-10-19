/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registration;

/**
 *
 * @author Student
 */
public class Login {
    // Username validation
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password validation
    public boolean checkPasswordComplexity(String password) {

        String capital = ".*[A-Z].*";
        String small = ".*[a-z].*";
        String special = ".*[!@#$%^&*(),.?\":{}|<>].*";
        String digit = ".*\\d.*";

        return password.length() >= 8
                && password.matches(capital)
                && password.matches(small)
                && password.matches(special)
                && password.matches(digit);
    }

    // Cellphone number validation
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber.length() == 12 && cellPhoneNumber.startsWith("+27")) {
            int fourthDigit = Character.getNumericValue(cellPhoneNumber.charAt(3));
            return fourthDigit >= 6 && fourthDigit <= 8;
        }
        if (cellPhoneNumber.length() == 10 && cellPhoneNumber.startsWith("0")){
            int secondDigit = Character.getNumericValue(cellPhoneNumber.charAt(1));
            return secondDigit >= 6 && secondDigit <= 8;
        }
        return false;
    }

    // Register user
    public String registerUser(
            String username,
            String password,
            String phone) {

        if (checkUsername(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(phone)) {
            return "User is successfully registered";
        }
        return "User registration failed";
    }

    // Login validation
    public boolean loginUser(
            String storedUsername,
            String storedPassword,
            String enteredUsername,
            String enteredPassword) {
        return storedUsername.equals(enteredUsername)
                && storedPassword.equals(enteredPassword);
    }

    // Login status
    public String returnLoginStatus(
            boolean loginStatus,
            String firstName,
            String lastName) {
        if (loginStatus) {
            return "Welcome "+ firstName + " " + lastName+ ", it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}

