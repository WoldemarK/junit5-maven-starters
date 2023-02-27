package org.example.service;

import org.example.model.User;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class UserServiceTestLauncher {
    public static final User IVAN = User.of(1, "user1", "123");
    public static final User PETER = User.of(2, "user1", "123");
    private UserService userService;

    @BeforeAll
    static void init() {
        System.out.println("BeforeAll: ");
    }

    @BeforeEach
    void prepare() {
        System.out.println("BeforeEach: " + this);
        userService = new UserService();
    }

    @Test
    void usersEmptyIfNoUserAdded() {
        System.out.println("Test 1: " + this);
        List<User> users = userService.getAll();
        assertTrue(users.isEmpty());
    }

    @Test
    void loginSuccessIfUserExists() {
        userService.add(IVAN);
        Optional<User> user = userService.login(IVAN.getUsername(), IVAN.getPassword());
        assertTrue(user.isPresent());

        user.ifPresent(user1 -> assertEquals(IVAN, user1));
    }

    @Test
    void loginFailIfPasswordIsNotCorrect() {
        userService.add(IVAN);
        Optional<User>user = userService.login(IVAN.getUsername(), "123");

        assertTrue(user.isPresent());

    }

    @Test
    void usersSizeIfUserAdded() {
        System.out.println("Test 2: " + this);
        userService.add(IVAN);
        userService.add(PETER);

        List<User> users = userService.getAll();
        assertEquals(2, users.size());
    }

    @AfterEach
    void deleteDateFromDatabase() {
        System.out.println("AfterEach: " + this);
    }

    @AfterAll
    static void close() {
        System.out.println("After All: ");
    }
}

