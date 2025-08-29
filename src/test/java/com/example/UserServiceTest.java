package com.example;

import com.example.model.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = {
    "server.port=0"
})
public class UserServiceTest {

    @Test
    public void testUserService() {
        UserService userService = new UserService();
        
        // Test getUser
        User user = userService.getUser("123");
        assertNotNull(user);
        assertEquals("123", user.getId());
        assertEquals("John Doe", user.getName());
        assertEquals("john.doe@example.com", user.getEmail());
        
        // Test createUser
        User newUser = new User("456", "Jane Smith", "jane.smith@example.com");
        String result = userService.createUser(newUser);
        assertTrue(result.contains("User created successfully"));
        
        // Test getAllUsers
        User[] users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(2, users.length);
        assertEquals("1", users[0].getId());
        assertEquals("2", users[1].getId());
    }
}
