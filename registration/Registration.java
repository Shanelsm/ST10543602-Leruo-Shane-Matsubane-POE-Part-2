/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registration;

/**
 *
 * @author Student
 */
import java.util.Scanner;
public class Registration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();
        
        String username = "";
        String password = "";
        String cellPhoneNumber = "";
        System.out.println("==== REGISTRATION ====");
        
        //Stores first & last name for welcome message.
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();
        
        //Get users input.
        while(true){
        System.out.print("Enter username: ");
        username = input.nextLine();
        boolean usernameValid = login.checkUsername(username);  
        if (!usernameValid) {
        System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        } 
        else {
        System.out.println("Username successfully captured.");
        break;
            }
        }
        
        while(true){
        System.out.print("Enter password: ");
        password = input.nextLine();
        boolean passwordValid = login.checkPasswordComplexity(password);
        if (!passwordValid) {
        System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        } 
        else {
        System.out.println("Password successfully captured.");
        break;
            }
        }
        
        while(true){
        System.out.print("Enter cellphone number: ");
        cellPhoneNumber = input.nextLine();
        boolean cellPhoneNumberValid = login.checkCellPhoneNumber(cellPhoneNumber);
        if (!cellPhoneNumberValid) {
        System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
        } 
        else {
        System.out.println("Cell number successfully captured.");
        break;
            }
        }

        //Call register method to save user & show final registration.
        String registrationMessage = login.registerUser(username, password, cellPhoneNumber);
  
        System.out.println();
        System.out.println(registrationMessage);
        System.out.println();
        System.out.println("==== LOGIN ====");
        
        System.out.print("Enter username to login: ");
        String loginUsername = input.nextLine();
        System.out.print("Enter password to login: ");
        String loginPassword = input.nextLine();
        
        boolean loginSuccess = login.loginUser(username, password, loginUsername, loginPassword);
        
        String loginStatus = login.returnLoginStatus(loginSuccess, firstName, lastName);
        System.out.println(loginStatus);
        
          if (loginSuccess) {
            System.out.println("\n==== QUICKCHAT ====");
            System.out.println("Welcome to QuickChat.");

            System.out.print("How many messages do you wish to enter? : ");
            int totalToEnter = Integer.parseInt(input.nextLine());
            int sentCount = 0;
            int choice = 0;

            while (choice != 3) {
                if (sentCount >= totalToEnter && totalToEnter != 0) {
                    System.out.println("Message limit reached: " + totalToEnter);
                    System.out.println("Total messages sent: " + Message.totalMessages);
                    break;
                }

                System.out.println("\nMenu:\n1) Send Messages\n2) Show recently sent messages\n3) Quit");
                System.out.print("Enter choice: ");
                choice = Integer.parseInt(input.nextLine());

                if (choice == 1) {
                    System.out.print("Enter Recipient (with + and max 12 chars): ");
                    String recipient = input.nextLine();
                    System.out.print("Enter Message: ");
                    String messageText = input.nextLine();

                    Message msg = new Message(recipient, messageText, sentCount);

                    System.out.println(msg.checkRecipientCell());
                    if (!msg.checkRecipientCell().contains("successfully")) continue;

                    String lengthCheck = msg.checkMessageLength();
                    System.out.println(lengthCheck);
                    if (lengthCheck.contains("less than 250")) continue;

                    System.out.println("\n--- Full Details ---");
                    System.out.println(msg.printMessages());

                    System.out.println("\n1) Send Message\n2) Disregard Message\n3) Store Message to send later");
                    System.out.print("Choose: ");
                    int sendOption = Integer.parseInt(input.nextLine());
                    
                    String result = msg.SentMessage(sendOption);
                    System.out.println(result);

                    if (sendOption == 1) {
                        sentCount++;
                    } else if (sendOption == 2) {
                        System.out.print("Press 0 to delete: ");
                        int del = Integer.parseInt(input.nextLine());
                        if (del == 0) System.out.println("Message deleted.");
                    }
                } 
                else if (choice == 2) {
                    System.out.println("Coming Soon.");
                } 
                else if (choice == 3) {
                    System.out.println("Quitting. Total messages sent: " + Message.totalMessages);
                    break;
               }
           }
        }
    }
}