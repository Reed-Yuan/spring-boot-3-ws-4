package com.example.service;

import com.example.model.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.BindingType;

@WebService(
    name = "UserService",
    targetNamespace = "http://example.com/user",
    serviceName = "UserService",
    portName = "UserServicePort"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
@BindingType(jakarta.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class UserService {

    @WebMethod(operationName = "getUser")
    @WebResult(name = "user")
    public User getUser(@WebParam(name = "userId") String userId) {
        // Simulate user retrieval
        User user = new User();
        user.setId(userId);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        return user;
    }

    @WebMethod(operationName = "createUser")
    @WebResult(name = "result")
    public String createUser(@WebParam(name = "user") User user) {
        // Simulate user creation
        return "User created successfully with ID: " + user.getId();
    }

    @WebMethod(operationName = "updateUser")
    @WebResult(name = "result")
    public String updateUser(@WebParam(name = "user") User user) {
        // Simulate user update
        return "User updated successfully with ID: " + user.getId();
    }

    @WebMethod(operationName = "deleteUser")
    @WebResult(name = "result")
    public String deleteUser(@WebParam(name = "userId") String userId) {
        // Simulate user deletion
        return "User deleted successfully with ID: " + userId;
    }

    @WebMethod(operationName = "getAllUsers")
    @WebResult(name = "users")
    public User[] getAllUsers() {
        // Simulate getting all users
        User user1 = new User();
        user1.setId("1");
        user1.setName("John Doe");
        user1.setEmail("john.doe@example.com");

        User user2 = new User();
        user2.setId("2");
        user2.setName("Jane Smith");
        user2.setEmail("jane.smith@example.com");

        return new User[]{user1, user2};
    }
}
