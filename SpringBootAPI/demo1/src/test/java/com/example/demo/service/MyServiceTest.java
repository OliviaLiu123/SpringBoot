package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private UserRepository myRepository;

    @InjectMocks
    private UserService myService;

    @Test
    public void testMyServiceMethod(){
//        //Arrange
//        String expected = "expected result";
//        when(myRepository.someMethod()).thenReturn(expected);
//        // Act
//        String actual = myService.myServiceMethod();
//
//        // Assert
//        assertEquals(expected, actual);
//        verify(myRepository).someMethod();

    }

}
