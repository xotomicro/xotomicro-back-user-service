package com.boilerplate.xotomicro_back_user_service.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.boilerplate.xotomicro_back_user_service.model.User;
import com.boilerplate.xotomicro_back_user_service.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setUp() {
        List<User> userList = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            User user = new User();
            user.setId((long) i);
            user.setFullName("My name " + i);
            user.setUsername("Username" + i);
            user.setPassword("Password" + i);
            user.setScope("Scope " + i);
            userList.add(user);
        }
        when(userRepository.findAll()).thenReturn(userList);
        when(userRepository.findByUsername("Username1")).thenReturn(userList.get(0));
    }

    @DisplayName("Get All User")
    @Test
    void getAll() {
        assertEquals(5, userService.getAll().size());
        assertNotNull(userService.getAll());
    }

    @DisplayName("Get User By UserName")
    @Test
    public void getByProductName() {
        User result = userService.getByUsername("Username1");
        User result2 = userService.getByUsername("Username2");
        assertNotNull(result);
        assertNull(result2);
    }
}
