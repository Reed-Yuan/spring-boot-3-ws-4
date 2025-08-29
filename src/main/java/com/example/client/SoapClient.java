package com.example.client;

import com.example.model.User;
import com.example.service.UserService;

/**
 * Example SOAP client for consuming the UserService web service
 * This class demonstrates how to use the web service directly
 */
public class SoapClient {

    public static void main(String[] args) {
        try {
            // Create service instance directly
            UserService service = new UserService();

            // Test getUser operation
            System.out.println("Testing getUser operation...");
            User user = service.getUser("123");
            System.out.println("Retrieved user: " + user);

            // Test getAllUsers operation
            System.out.println("\nTesting getAllUsers operation...");
            User[] users = service.getAllUsers();
            System.out.println("Total users: " + users.length);
            for (User u : users) {
                System.out.println("User: " + u);
            }

            // Test createUser operation
            System.out.println("\nTesting createUser operation...");
            User newUser = new User("999", "Test User", "test@example.com");
            String result = service.createUser(newUser);
            System.out.println("Result: " + result);

        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
