package com.example.demo;
import com.example.demo.controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MyControllerIntegrationTest {
    @Autowired
    private UserController mycontroller;

    @Test
    public void testMyEndpoint(){
        // Arrange (if needed, e.g., preparing test data in the database)

        // Act
//        String response = mycontroller.myEndpoint();

        // Assert
//        assertNotNull(response);
        // Add more assertions based on the expected behavior

    }


}
